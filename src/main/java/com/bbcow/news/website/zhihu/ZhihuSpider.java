package com.bbcow.news.website.zhihu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bbcow.news.website.BasicSpider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class ZhihuSpider {
	private String url = "http://news-at.zhihu.com/api/4/stories/latest";
	private String detail_url = "http://news-at.zhihu.com/api/4/story/$1";
	
	public List<ZhihuVo> list() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		List<ZhihuVo> list = new LinkedList<ZhihuVo>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			Iterator<JsonNode> nodes = node.path("stories").elements();
			while(nodes.hasNext()){
				ZhihuVo bean = new ZhihuVo();
				JsonNode record = nodes.next();
				bean.setIndex(record.get("id").asInt());
				bean.setTitle(record.get("title").asText());
				Iterator<JsonNode> imageNodes = record.get("images").elements();
				JsonNode imageNode = imageNodes.next();
				bean.setImage(imageNode.asText());
				list.add(bean);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Map<String,String> detail(String id) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(detail_url.replace("$1", id)).build();
		Map<String, String> detail = new HashMap<String, String>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			byte[] bs = body.bytes();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(new String(bs,"utf-8"));
			detail.put("title", node.get("title").asText());
			String sourceContent = node.get("body").asText();
			
			Document doc = Jsoup.parse(sourceContent);
			Document cleanBody = BasicSpider.denoiseForDoc(doc);
			cleanBody = BasicSpider.removeImg(cleanBody);
			Elements contents = cleanBody.getElementsByClass("content");
			
			if(contents.size()>0){
				Element content = contents.get(0);
				detail.put("body", content.html());
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return detail;
	}
	
	public static void main(String[] args) {
		ZhihuSpider zs = new ZhihuSpider();
		zs.detail("7992629");
	}
}
