package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

	@Autowired
	SampleDao sampleDao;
	
	//@Value("${app.name}")
    private String appName = "Think Demo App";

    @GetMapping(value = "/")
    public String hello(Model model) {
    	List<SampleEntity> sampleList = sampleDao.getAll();
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("appName", appName);
        
        model.addAttribute("sampleList",sampleList);
        
        return "hello";
    }

    @GetMapping(value = "/regist")
    public String regist(Model model) {
        model.addAttribute("appName", appName);
        return "form";
    }

    @PostMapping(value = "/regist")
    public String regist(@ModelAttribute SampleEntity form, Model model) {
    	sampleDao.create(form);
        return "redirect:./";
    }
}