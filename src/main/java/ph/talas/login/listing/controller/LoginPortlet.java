package ph.talas.login.listing.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ph.talas.all.listing.domain.User;
import ph.talas.all.listing.service.UserService;
import ph.talas.login.listing.validation.UserLoginValidator;

@Controller
@RequestMapping(value = "VIEW")
public class LoginPortlet {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserLoginValidator userLoginValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userLoginValidator);
	}
	
	@RenderMapping
	public String showLogin(Model model, RenderRequest request, RenderResponse response) {
		PortletSession session = request.getPortletSession();
		User user = (User) session.getAttribute("dae-user", PortletSession.APPLICATION_SCOPE);
		String action = (user == null) ? "login" : "logout";
		model.addAttribute("action", action);
		model.addAttribute("user", user);
		
		return "login";
	}
	
	@ActionMapping(params = "myaction=login")
	public void login(ActionRequest request, ActionResponse response) {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		User user = (User) userService.login(username, userpassword);
		if (user != null) {
			PortletSession session = request.getPortletSession();
			session.setAttribute("dae-user", user, PortletSession.APPLICATION_SCOPE);			
		} else {
			
		}
	}
	
	@ActionMapping(params = "myaction=logout")
	public void logout(ActionRequest request, ActionResponse response) {
		PortletSession session = request.getPortletSession();
		session.setAttribute("dae-user", null, PortletSession.APPLICATION_SCOPE);
	}
	
	@RenderMapping(params = "renderme=login")
	public String showLoginAgain(Model model, RenderRequest request, RenderResponse response){
		// PortletSession session = request.getPortletSession();
		return showLogin(model, request,response);
	}

}
