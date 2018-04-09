package jp.co.testPjt;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class IndexController
{
    @RequestMapping("/")
    public String index(Model model){
		 return "index";
    }
}