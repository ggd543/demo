package mycompany.service;

import java.util.List;

import mycompany.dao.ReportDao;
import mycompany.model.Report;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ReportService {
	private ReportDao reportDao;

	private MutableAclService mutableAclService;
	
	private TransactionTemplate transactionTemplate;

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}

	public void createNewReport(String title, String content)
			throws ServiceException {
		final Report report = new Report();
		report.setTitle(title);
		report.setContent(content);
		
		transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus status) {
            	reportDao.create(report);
            	addPermission(report.getId(), new PrincipalSid(getUsername()), BasePermission.ADMINISTRATION);
                return null;
            }
        });
	}
	
	public void grantRead(final String username, final Long reportId) {
		transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus status) {
            	addPermission(reportId, new PrincipalSid(username), BasePermission.READ);
                return null;
            }
        });
	}
	
	public List<Report> list() throws ServiceException {
		String username = getUsername();
		if (username == null) {
			throw new ServiceException("The user should be authenticated.");
		}
		return reportDao.list(username);
	}

	private void addPermission(Long reportId, Sid recipient,
			Permission permission) {
		MutableAcl acl;
		ObjectIdentity oid = new ObjectIdentityImpl(Report.class,
				reportId);

		try {
			acl = (MutableAcl) mutableAclService.readAclById(oid);
		} catch (NotFoundException nfe) {
			acl = mutableAclService.createAcl(oid);
		}

		acl.insertAce(acl.getEntries().size(), permission, recipient, true);
		mutableAclService.updateAcl(acl);
	}
	
	private String getUsername() {
		return UsernameHolder.getAuthenticatedUsername();
	}
	
	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
    }
}
