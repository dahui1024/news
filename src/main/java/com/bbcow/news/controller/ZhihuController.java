package com.bbcow.news.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.website.zhihu.ZhihuSpider;

@Controller
@RequestMapping(value="zhihu")
public class ZhihuController {
	private ZhihuSpider zh = new ZhihuSpider();
	@RequestMapping(value = "")
	public String index(Model model){
		model.addAttribute("list", zh.list());
		
		return "zhihu/index";
	}
	@RequestMapping(value = "/story/{id}")
	public String detail(@PathVariable String id,Model model){
		Map<String, String> detail = zh.detail(id);
		model.addAttribute("detail", detail);
		return "zhihu/detail";
	}
}
