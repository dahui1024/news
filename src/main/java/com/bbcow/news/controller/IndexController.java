package com.bbcow.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.website.neatease.NeatEaseSpider;
import com.bbcow.news.website.neatease.NeatEaseVo;

@Controller
@RequestMapping(value="")
public class IndexController {
	private NeatEaseSpider ne = new NeatEaseSpider();
	@RequestMapping(value = "")
	public String index(Model model){
		NeatEaseVo[] beans = ne.top20();
		model.addAttribute("news", beans);
		model.addAttribute("page", 0);
		return "index";
	}
}
