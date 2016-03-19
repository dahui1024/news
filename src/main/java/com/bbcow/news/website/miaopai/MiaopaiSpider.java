package com.bbcow.news.website.miaopai;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;


public class MiaopaiSpider {
	private String url = "http://api.miaopai.com/m/shot_channel.json?f_type=v2&likeStat=0&live=1&os=ios&page=1&per=20&suid=4NUB4nrCdVdQFbHH&unique_id=79d273867a9c357b6f978203addcb0b71234284759&version=6.3.1";
	private String video_url = "http://gslb.miaopai.com/stream/$1.mp4?vend=miaopai&";
	
	public List<MiaopaiVo> list() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		List<MiaopaiVo> list = new LinkedList<MiaopaiVo>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			
			Iterator<JsonNode> channels = node.get("result").elements();
			while(channels.hasNext()){
				JsonNode channel = channels.next();
				channel = channel.get("channel");
				MiaopaiVo vo = new MiaopaiVo();
				vo.setId(channel.get("scid").asText());
				JsonNode pic = channel.get("pic");
				vo.setImg(pic.get("base").asText()+pic.get("m").asText());
				JsonNode ext = channel.get("ext");
				vo.setLength(ext.get("lengthNice").asText());
				vo.setTitle(ext.get("t").asText());
				vo.setW(ext.get("w").asText());
				vo.setH(ext.get("h").asText());
				list.add(vo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public String detail(String id){
		return video_url.replace("$1", id);
	}
	
	public static void main(String[] args) {
		MiaopaiSpider ms = new MiaopaiSpider();
		ms.list();
	}
}
