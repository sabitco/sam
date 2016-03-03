package co.edu.unal.sam.aspect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(value = "/administrator", method = RequestMethod.GET)
	public String getIndexPage() {
		return "admin/Management";
	}

	@RequestMapping(value = "/administrator/plans", method = RequestMethod.GET)
	public String getIndexPagePlan() {
		return "admin/PlanManagement";
	}

	@RequestMapping(value = "/administrator/users", method = RequestMethod.GET)
	public String getIndexPageUser() {
		return "admin/UserManagement";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }
	
}
