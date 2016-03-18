package com.bbcow.news.website.neatease;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class NeatEaseSpider {
	private String url = "http://c.3g.163.com/nc/article/list/T1429173762551/0-20.html";
	private String detail_url = "http://c.m.163.com/nc/article/detail_id/full.html";
	private String photo_url = "http://c.m.163.com/photo/api/set/0096/photo_id.json";
	private final Gson gson = new Gson();
	
	public NeatEaseVo[] top20() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		NeatEaseVo[] ns = null;
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			ns = gson.fromJson(body.charStream(), NeatEaseBean.class).T1429173762551;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ns;
	}
	public List<String[]> photo(String id,String[] content) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(photo_url.replace("photo_id", id.substring(id.lastIndexOf("|")+1))).build();
		List<String[]> detail = new LinkedList<String[]>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			content[0] = node.get("setname").asText();
			content[1] = node.get("settag").asText();
			JsonNode node2 = node.path("photos");
			Iterator<JsonNode> nodes = node2.elements();
			while(nodes.hasNext()){
				JsonNode n = nodes.next();
				detail.add(new String[]{n.get("imgurl").asText(),n.get("note").asText()});
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return detail;
	}
	public Map<String,String> detail(String id) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(detail_url.replace("detail_id", id)).build();
		Map<String, String> detail = new HashMap<String, String>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			JsonNode node2 = node.path(id);
			
			detail.put("dkeys", node2.get("dkeys").asText());
			detail.put("body", node2.get("body").asText());
			detail.put("title", node2.get("title").asText());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return detail;
	}
	public NeatEaseVo[] page20(int page) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("http://c.3g.163.com/nc/article/list/T1429173762551/"+page+"-20.html").build();
		NeatEaseVo[] ns = null;
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			ns = gson.fromJson(body.charStream(), NeatEaseBean.class).T1429173762551;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ns;
	}
	
	class NeatEaseBean{
		NeatEaseVo[] T1429173762551;
	}
	
	public static void main(String[] args) {
		NeatEaseSpider ne = new NeatEaseSpider();
		/*ne.top20();*/
		/*ne.detail("BI1S1LHG0001124J");*/
		/*ne.photo("54GI0096|89677");*/
	}
}
