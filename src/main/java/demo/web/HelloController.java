package demo.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class HelloController {

    private Random rand = new Random();
    @Value("${application.message:Hello World}")
    private String message;

    @RequestMapping("/")
    public String hi() {
        return message;
    }

    @RequestMapping("/json")
    public @ResponseBody Map<String, String> json() {

        Map<String, String> map = new HashMap<>();
        map.put("slawek", "borowiec");
        map.put("message", message);

        return map;
    }
    @RequestMapping("/latency")
    public @ResponseBody int randomLatency() throws InterruptedException {
        int x = rand.nextInt(100);
        Thread.sleep(10 * x);
        log.info("sleep {}",x);
        return x;
    }

}