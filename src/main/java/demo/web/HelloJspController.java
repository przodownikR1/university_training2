package demo.web;

import java.time.LocalDate;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
class HelloJspController {
    @Value("${application.message:Hello World}")
    private String message;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/message")
    @ResponseBody
    public String message(Locale locale) {
        log.info("message:   {}, locale :  {} ", messageSource.getMessage("hello.message", null, locale), locale);
        return messageSource.getMessage("hello.message", null, locale) + " locale: " + locale;
    }

    @RequestMapping("/hello")
    public String test(Model model) {
        model.addAttribute("time", LocalDate.now());
        model.addAttribute("message", message);
        log.info("+++++  {}", model);
        return "hello";
    }

}