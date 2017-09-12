package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.objects.EmailModel;
import spring.services.EmailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eoller on 12-Sep-17.
 */
@Controller
public class EmailController {


    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    public ModelAndView email(@ModelAttribute("emailModel") EmailModel emailModel) {
        Map<String, Object> model = new HashMap<>();
        model.put(EmailService.FROM, "Egorpyp@gmail.com");
        model.put(EmailService.SUBJECT, "Hello from " + emailModel.getName() + "!");
        model.put(EmailService.TO, emailModel.getEmail());
        model.put("ccList", new ArrayList<>());
        model.put("bccList", new ArrayList<>());
        model.put("userName", "javastudyUser");
        model.put("urljavastudy", "javastudy.ru");
        model.put("message", emailModel.getMessage());
        boolean result = emailService.sendEmail("registered.vm", model);
        //use redirect or you will send email after every refresh page.
        return new ModelAndView("redirect:/email/send", "resultSending", result);
    }
}
