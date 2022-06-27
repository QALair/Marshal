package jaxb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    @RequestMapping("/")
    public @ResponseBody String HelloWorld() {
        return "<h1>Spring dos galerosos</h1>";
    }
}
