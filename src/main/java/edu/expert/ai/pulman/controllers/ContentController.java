package edu.expert.ai.pulman.controllers;

import edu.expert.ai.pulman.dao.AIDao;
import edu.expert.ai.pulman.dao.ContentDAO;
import edu.expert.ai.pulman.model.InnerClassDistinction;
import edu.expert.ai.pulman.model.InterClassDistinction;
import edu.expert.ai.pulman.model.WeightDetermination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;


@Controller
@RequestMapping(value = {"/ai"})
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class ContentController {

    @Autowired(required = true)
    private HttpServletRequest request;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    @RequestMapping(value = { "/about_me" })
    public String getAboutMe(ModelMap model)
    {
        ContentDAO dao = AIDao.getInstance();
        InterClassDistinction distinction = new InterClassDistinction(dao.getNominalGradationByCount(),dao);
        System.out.println("ALFA: "+(distinction.getLambda_up()));

        //InnerClassDistinction distinction1 = new InnerClassDistinction(dao.getNominalGradationByCount(),dao);
        //System.out.println("BETTA: "+(distinction1.()));

        return "/about_me";
    }

    @RequestMapping(value = { "/about_app" })
    public String getAboutProject(ModelMap model)
    {
        return "/about_app";
    }

     @RequestMapping(value = { "/weight" })
     public String getScales(ModelMap model)
     {
         ContentDAO dao = AIDao.getInstance();
         Double[][] weights = new WeightDetermination(dao.getNominalGradationByCount(),
                 dao.getCountableGradationByCount(),dao).getWeight();
         System.out.println(Arrays.deepToString(weights));

         model.addAttribute("weights",weights);

         return "/weights";
     }

}
