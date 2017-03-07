package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemsService;

@Controller
public class JsonTestController {
	
	@Autowired 
	private ItemsService itemsService;

	// @RequestBody 将请求的json串转换成java对象
	// @ResponseBody 将java对象转成json串
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception{
		itemsCustom = itemsService.findItemsById(itemsCustom.getId());
		return itemsCustom;
	}
	
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception{
		itemsCustom = itemsService.findItemsById(itemsCustom.getId());
		return itemsCustom;
	}
	
}
