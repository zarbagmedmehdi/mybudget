package zarbag.mybudget.ws.res;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
    @RequestMapping({"/hello"})
    public String hello(){
        return "hello";
    }
}
