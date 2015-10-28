package ph.talas.um.listing.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import ph.talas.all.listing.service.UserService;

@Controller
@RequestMapping(value = "VIEW")
public class UserManagementPortlet {

	@Autowired
	private UserService userService;
	
	@RenderMapping
	public String showUserManagement(RenderRequest request, RenderResponse response) {
		return "usermanagement";
	}
	
}
