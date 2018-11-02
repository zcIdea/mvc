package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entry.Person;
import com.springmvc.entry.User;
import com.springmvc.service.UserService;

import oracle.net.aso.p;

@Controller
@RequestMapping(value="/spring")
public class SpringMvcController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/springmvc")
	public String springMvc(Model model){
		
		model.addAttribute("springmvc", "nihao!");
		
		return "index";
	}
	
	@RequestMapping(value="/hello/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String helloSpringMvc(@PathVariable(value="id") Integer id){
		
		return id+"Hello Spring MVC!";
		
	}
	
	@RequestMapping(value="/testParam/{id}",method=RequestMethod.GET)
	public String testParam(@PathVariable(value="id") Integer idd,
			                @RequestParam(value="msg") String msg,
			                Model model){
		
		model.addAttribute("springmvc", idd+msg);
		
		return "index";
		
	}
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public String getUserById(@PathVariable(value="id") Integer id,Model model){
		
	    User user=userService.getUserById(id);
		model.addAttribute("springmvc", user.getMuch());
		
		return "index";
		
	}
	
	@RequestMapping(value="/xmlResponse")
	@ResponseBody
	public Person testXMLResponse(){
		
		Person person=new Person();
		person.setName("zhangchuan");
		person.setAge(18);
		
		return person;
	}
	//都是把对象转为字符串，返回给客户端
	@RequestMapping(value="/stringResponse")
	@ResponseBody
	public String testStringResponse(){
		
		String json="{\"name\":\"zhangchuan\"}";
		String xml="<xml><person><name>zhangchuan</name></person></xml>";
		
		return json+"--"+xml;
	}
	
}
