package mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycompany.model.Report;
import mycompany.model.User;
import mycompany.service.ReportService;
import mycompany.service.UsernameHolder;

import org.springframework.web.servlet.ModelAndView;

public class ReportController extends AbstractCompanyController {
	
	private ReportService reportService;
	
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String requestMethod = request.getMethod();
		if ("GET".equals(requestMethod)) {
			ModelAndView mav = new ModelAndView("report");
			List<Report> reports = reportService.list();
			List<User> users = userService.list();
			String currentUsername = UsernameHolder.getAuthenticatedUsername();
			User currentUser = new User();
			currentUser.setUsername(currentUsername);
			users.remove(currentUser);
			mav.addObject("users", users);
			mav.addObject("reports", reports);
			return mav;
		} else if ("POST".equals(requestMethod)) {
			String action = request.getParameter("action");
			if ("add".equals(action)) {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				reportService.createNewReport(title, content);
				ModelAndView mav = new ModelAndView("redirect:report.do");
				return mav;
			}
			else if ("grant".equals(action)) {
				String username = request.getParameter("username");
				String reportIdString = request.getParameter("reportId");
				Long reportId = Long.valueOf(reportIdString);
				reportService.grantRead(username, reportId);
				ModelAndView mav = new ModelAndView("redirect:report.do");
				return mav;
			}
			
		}
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

}
