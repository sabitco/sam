package co.edu.unal.sam.aspect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/physicalactivity/about", method = RequestMethod.GET)
    public String getIndexAbout() {
        return "physicalactivity/About";
    }

    @RequestMapping(value = "/physicalactivity/Classificationdetail", method = RequestMethod.GET)
    public String getIndexFromClasificationDetailPlayer() {
        return "physicalactivity/Classificationdetail";
    }

    @RequestMapping(value = "/physicalactivity/classification", method = RequestMethod.GET)
    public String getIndexFromClasificationPlayer() {
        return "physicalactivity/Classification";
    }

    @RequestMapping(value = "/physicalactivity/goals", method = RequestMethod.GET)
    public String getIndexFromGoals() {
        return "physicalactivity/Goals";
    }

    @RequestMapping(value = "/physicalactivity/goalsdetail", method = RequestMethod.GET)
    public String getIndexFromGoalsdetail() {
        return "physicalactivity/Goalsdetail";
    }

    @RequestMapping(value = "/physicalactivity/goalsform", method = RequestMethod.GET)
    public String getIndexFromGoalsform() {
        return "physicalactivity/Goalsform";
    }

    @RequestMapping(value = "/physicalactivity/home", method = RequestMethod.GET)
    public String getIndexFromHome() {
        return "physicalactivity/Home";
    }

    @RequestMapping(value = "/physicalactivity/signon", method = RequestMethod.GET)
    public String getIndexFromPlayer() {
        return "physicalactivity/Signon";
    }

    @RequestMapping(value = "/physicalactivity/terms", method = RequestMethod.GET)
    public String getIndexFromTerms() {
        return "physicalactivity/terms";
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.GET)
    public String getIndexPage() {
        return "admin/Management";
    }

    @RequestMapping(value = "/administrator/pages", method = RequestMethod.GET)
    public String getIndexPagePage() {
        return "admin/PageManagement";
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
