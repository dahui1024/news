package com.bbcow.news.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.website.neatease.NeatEaseSpider;
import com.bbcow.news.website.neatease.NeatEaseVo;

@Controller
@RequestMapping(value="neatease")
public class NeatEaseController {
	private NeatEaseSpider ne = new NeatEaseSpider();
	@RequestMapping(value = "")
	public String index(Model model){
		NeatEaseVo[] beans = ne.top20();
		model.addAttribute("news", beans);
		model.addAttribute("page", 0);
		model.addAttribute("description", "互联网's 引力波，关注互联网，关注生活！");
		model.addAttribute("keys", "互联网,新闻,快报,网易新闻,今日头条,知乎日报");
		model.addAttribute("title", "互联网's 引力波");
		return "neatease/index";
	}
	@RequestMapping(value = "/post/{postId}")
	public String detail(@PathVariable String postId,Model model){
		Map<String, String> detail = ne.detail(postId);
		model.addAttribute("detail", detail);
		return "neatease/detail";
	}
	@RequestMapping(value = "/photo/{photoId}")
	public String photo(@PathVariable String photoId,Model model){
		String[] content = new String[2];
		List<String[]> detail = ne.photo(photoId,content);
		model.addAttribute("title", content[0]);
		model.addAttribute("dkeys", content[1]);
		model.addAttribute("detail", detail);
		return "neatease/photo";
	}
}
