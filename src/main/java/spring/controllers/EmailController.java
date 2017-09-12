package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.objects.EmailModel;
import spring.services.EmailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to send email
 * Created by Eoller on 12-Sep-17.
 */
@Controller
public class EmailController {
    /**
     * been from root-context
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Takes params from form no jsp page, then creates SimpleMailMessage , adds params to Mail and sends.
     *
     */
    @RequestMapping(value = "/email/sendMail", method = RequestMethod.POST)
    public String emailSend(HttpServletRequest request) {
        String userName = request.getParameter("name");
        String userAdress = request.getParameter("email");
        String userPhone = request.getParameter("phone");
        String userMessage = request.getParameter("message");
        String subject = request.getParameter("subject");
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("Egorpyp@gmail.com");
        StringBuffer sb = new StringBuffer();
        sb.append("User mail: " + userAdress).append("\n" +"User phone: " + userPhone).append("\n" +"User name: " + userName).append("\n" +"User message: " + userMessage);
        email.setSubject(subject);
        email.setText(sb.toString());
        mailSender.send(email);
        return "redirect:/all";
    }
}




    /*@Autowired
    EmailService emailService;*/


        /*@RequestMapping(value = "/email/send", method = RequestMethod.POST)
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
    }*/