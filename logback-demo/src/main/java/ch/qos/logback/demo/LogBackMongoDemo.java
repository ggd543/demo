/*
 * @(#) LogBackMongoDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-13
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package ch.qos.logback.demo;

import java.util.Iterator;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.ConsoleAppender;
import logback.mongodb.MongoDBAppender;
import logback.mongodb.MongoDBConnectionSource;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class LogBackMongoDemo {
    private static LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    private static Logger logger = loggerContext.getLogger(LogBackMongoDemo.class);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("sun.java.command"));
//        System.exit(0);
        inspectLogger();

//        setConsoleAppender();
        setMongoDBAppender();
        logger.info("fuxk you ");
        Thread.sleep(1000L);
        System.exit(1);

        Random rnd = new Random();
        while (true) {
            log(rnd);
            sleep(rnd);
        }
    }

    @Deprecated
    private static void setConsoleAppenderUsingLayout() {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);

        PatternLayout layout = new PatternLayout();
        layout.setContext(loggerContext);
        layout.setPattern(" ===    %d{HH:mm:ss.SSS} [%thread] %-5level %logger{32} - %msg%n");
        layout.start();
        consoleAppender.setLayout(layout);

        consoleAppender.start();
        ch.qos.logback.classic.Logger log = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
        log.addAppender(consoleAppender);

    }

    private static void setConsoleAppender() {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("%-4relative [%thread] %-5level %logger{35} - %msg%n");
        encoder.start();
        consoleAppender.setEncoder(encoder);

        consoleAppender.start();
        ch.qos.logback.classic.Logger log = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
        log.addAppender(consoleAppender);
    }

    private static void setMongoDBAppender() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        MongoDBAppender mongoDBAppender = new MongoDBAppender();
        MongoDBConnectionSource dbSource = new MongoDBConnectionSource();
        dbSource.setUri("mongodb://127.0.0.1:27017");
        dbSource.setDb("logback_demo");
        dbSource.setCollection("logback_log");
        mongoDBAppender.setConnectionSource(dbSource);
        mongoDBAppender.setContext(loggerContext);
        mongoDBAppender.start();

        AsyncAppender asyncAppender = new AsyncAppender();
        asyncAppender.setContext(loggerContext);
        asyncAppender.addAppender(mongoDBAppender);
        asyncAppender.start();

        ch.qos.logback.classic.Logger log = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
//        log.addAppender(mongoDBAppender);
        log.addAppender(asyncAppender);
    }

    private static void inspectLogger() {
        ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) logger;
        System.out.println(log.getEffectiveLevel()); //DEBUG
        System.out.println(log.getLevel()); //null
        Appender mongoAppender = log.getAppender("ASYNCMONGO");
        System.out.println(mongoAppender);  // null
        System.out.println(LoggerFactory.getILoggerFactory().getLogger("ROOT"));
        ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getILoggerFactory().getLogger("ROOT");
        System.out.println(rootLogger.getLevel());
        System.out.println(rootLogger.getAppender("ASYNCMONGO")); // NOT NULL
        System.out.println("==");
        Iterator<Appender<ILoggingEvent>> it = log.iteratorForAppenders();
        while (it.hasNext()) {
            Appender<ILoggingEvent> appender = it.next();
            System.out.println(appender);
        }
        System.out.println("--");
    }

//    private static final String[] MSG = {"debug message", "hello world", "Attention please", "Something wrong", "A fatal error"};

    private static void log(Random rnd) {
        int rndLevel = rnd.nextInt(5);
        switch (rndLevel) {
            case 0:
                logger.trace("debug message");
                break;
            case 1:
                logger.debug("hello world");
                break;
            case 2:
                logger.info("Attention please");
                break;
            case 3:
                logger.warn("Something wrong");
                break;
            case 4:
                logger.error("A fatal error");
                break;
            default:
                throw new RuntimeException();
        }
    }

    private static void sleep(Random rnd) {
        int rndSecond = rnd.nextInt(5);
        try {
            Thread.sleep(1000L * rndSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
