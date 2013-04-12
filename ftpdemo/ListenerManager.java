package com.travelsky.agentsky.mq.consumer;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.travelsky.agentsky.oa.domain.BranchInfo;
import com.travelsky.bravo.core.ConfigurableConstants;
import com.travelsky.bravo.core.dao.BaseDao;

/**
 * 动态JMS消费者侦听者管理器，配置监控专用
 * 
 * @author Ever
 * 
 */
public class ListenerManager {
	@Resource
	private BaseDao baseDao;
	@Resource
	private MessageListener alarmListener;
	@Resource
	private PooledConnectionFactory connectionFactory;
	@Resource
	private ThreadPoolTaskExecutor taskExecutor;

	private static Map<String, DefaultMessageListenerContainer> listenerContainers = new Hashtable<String, DefaultMessageListenerContainer>();

	@PostConstruct
	private void init() {
		// 找出有通信的分支机构
		List<BranchInfo> branchInfos = baseDao.find(null,
				"from BranchInfo branchInfo where branchInfo.islocaluse='1'",
				false);
		if (branchInfos == null || branchInfos.size() == 0) {
			return;
		}

		for (BranchInfo branchInfo : branchInfos) {
			String branchCode = branchInfo.getCode();
			DefaultMessageListenerContainer container = initialAndStartContainer(branchCode);

			listenerContainers.put(branchCode, container);
		}
	}
	
	public void removeListener(String branchCode) {
		DefaultMessageListenerContainer container = listenerContainers.remove(branchCode);
		container.destroy();
	}

	public void addListener(String branchCode) {
		if (branchCode == null) {
			return;
		}

		if (listenerContainers.containsKey(branchCode)) {
			removeListener(branchCode);
		}

		listenerContainers
				.put(branchCode, initialAndStartContainer(branchCode));
	}

	private DefaultMessageListenerContainer initialAndStartContainer(
			String branchCode) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		ActiveMQQueue destination = new ActiveMQQueue(ConfigurableConstants.getProperty("alarm.mq.queue",
						"_alarm_queue"));
		container.setDestination(destination);
		container.setTaskExecutor(taskExecutor);
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(alarmListener);

		container.setSessionTransacted(false);
		// 不缓存connection， 以便在服务器变更的时候能够单独关闭该container
		container.setCacheLevel(0);
		container.setMaxConcurrentConsumers(2);
		container.setConcurrentConsumers(1);
		container.setIdleTaskExecutionLimit(2);
		container.setReceiveTimeout(20000);
		container.afterPropertiesSet();
		return container;
	}
}
