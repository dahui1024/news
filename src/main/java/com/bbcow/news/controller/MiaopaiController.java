package com.bbcow.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbcow.news.website.miaopai.MiaopaiSpider;

@Controller
@RequestMapping(value="miaopai")
public class MiaopaiController {
	private MiaopaiSpider spider = new MiaopaiSpider();
	@RequestMapping(value = "")
	public String index(Model model){
		model.addAttribute("list", spider.list());
		
		return "miaopai/miaopai_index";
	}
	@RequestMapping(value = "/video/{id}")
	public String detail(@PathVariable String id, @RequestParam String title, @RequestParam String length, Model model){
		model.addAttribute("video_url", spider.detail(id));
		model.addAttribute("title", title);
		model.addAttribute("length", length);
		
		
		return "miaopai/miaopai_detail";
	}
}
