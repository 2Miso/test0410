package com.example.ezen;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
//Contoller어노테이션은 내부적으로 @Component라는 어노테이션을 상속받는다.
//그래서 servlet-context.xml에 선언되어 있는 component-scan으로 찾아지고, bean으로 등록된다.
//언제 bean으로 등록된다? tomcat이 실행되고, DispatcherServlet의 생성자가 호출될 때 xml 설정을 읽으면서 bean으로 등록된다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//get요청(request)으로 "/"로 요청이 왔을 때 동작하는 컨트롤러.(MVC 중 Controller) 서블릿의 doGet()메소드 대신 method=RequestMethod.GET으로 get요청을 지정. Spring이 실행해줌.
	public String home(Locale locale, Model model) { 
		//home()메소드는 Locale과 Model에 의존한다.
		//Locale과 Model 또한 스프링이 관리하는 bean이기 때문에 "/"로 요청하여 home()메소드가 실행될 때 스프링이 의존성을 주입해준다.(Locale과 Model 파라미터 자동으로 넣어준다.)
		//DI(Dependency Injection) : 의존성 주입
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		//WEB-INF/view/home.jsp로 포워딩.(prefix, suffix)(MVC 중 View)
	}
	
}
