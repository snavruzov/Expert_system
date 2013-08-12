package edu.expert.ai.pulman.controllers;

import edu.expert.ai.pulman.dao.AIDao;
import edu.expert.ai.pulman.dao.ContentDAO;
import edu.expert.ai.pulman.model.InnerClassDistinction;
import edu.expert.ai.pulman.model.InterClassDistinction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController
{

    @RequestMapping("/login")
    public String login(HttpServletRequest request)
    {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        return "login";
    }

    @RequestMapping("/denied")
    public String accessDenied()
    {
        System.out.println("DENIED");
        return "denied";
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = { "/" })
    public String root(ModelMap model)
    {
        ContentDAO dao = AIDao.getInstance();
        new InterClassDistinction(dao.getNominalGradationByCount(),dao);
        System.out.println("ALFA: "+(InterClassDistinction.LAMBDA()));
        new InnerClassDistinction(dao.getNominalGradationByCount(),dao.getCountableGradationByCount(),dao);
        System.out.println("BETA: "+(Arrays.deepToString(InnerClassDistinction.BETA())));

        return "/index";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        return "logout";
    }

    @RequestMapping(value = { "/contact" })
    public String getContact(ModelMap model)
    {
        return "/contact";
    }

}
