package jp.co.testPjt;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * indexに遷移する
 * @author masahisa
 *
 */
@Controller
@EnableAutoConfiguration
public class IndexController
{
	/**
	 *
	 * @param model パラメータ
	 * @return index 遷移先URL
	 */
    @RequestMapping("/")
    public String index(Model model){
		 return "index";
    }
}