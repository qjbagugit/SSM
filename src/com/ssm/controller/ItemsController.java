package com.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.controller.validation.ValidGroup1;
import com.ssm.exception.CustomException;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemsService;

@Controller
@RequestMapping("/item")
public class ItemsController {
	@Autowired
	private ItemsService itemService;
	// 商品列表展示
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	// 商品详细信息展示
//	@RequestMapping("/editItems")
//	public ModelAndView editItems() throws Exception{
//		// 这里先用静态数据id
//		ItemsCustom itemsCustom = itemService.findItemsById(2);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	@RequestMapping("/editItems")
	public String editItems(Model model, Integer id) throws Exception{
		// 相当于ModelAndView的addObject方法
		ItemsCustom itemsCustom = itemService.findItemsById(id);
		if(itemsCustom == null){
			throw new CustomException("商品信息不能为空！");
		}
		model.addAttribute("items",itemsCustom);
		return "items/editItems";
	}
	
	// 商品详细信息修改提交
	// 在需要校验的pojo参数前添加@Validated，并在其后添加BindingResult bindingResult参数接收校验出错信息
	// 注意@Validated和BindingResult成对出现，并且顺序不变
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request,Integer id,
			@ModelAttribute("items") @Validated(value=ValidGroup1.class) ItemsCustom itemsCustom, BindingResult bindingResult,
			MultipartFile items_pic) throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}
		if(items_pic!=null){
			String originFileName = items_pic.getOriginalFilename();
			if(originFileName!=null && originFileName.length()>0){
				String pic_path = "/Users/chenping/Documents/workspace/uploads/";
				String newFileName = UUID.randomUUID() + originFileName.substring(originFileName.indexOf("."));
				File newFile = new File(pic_path+newFileName);
				//向磁盘写文件
				items_pic.transferTo(newFile);
				itemsCustom.setPic(newFileName);
			}
		}
		itemService.updateItems(id, itemsCustom);
		return "forward:queryItems.action";
	}
	
	// 批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] item_id) throws Exception{
		return "success";
	}

	// 批量修改商品页面
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	
	// 批量修改商品提交
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		return "success";
	}
	
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes(){		
		Map<String, String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");		
		return itemTypes;
	}
	
	// /itemsview/{id}里面的{id}表示占位符，通过@PathVariable获取占位符中的参数
	// 如果占位符中的名称和形参名一样，在@PathVariable可以不指定名称
	@RequestMapping("/itemsview/{id}")
	public @ResponseBody ItemsCustom itemsview(@PathVariable("id") Integer id) throws Exception{
		ItemsCustom itemsCustom = itemService.findItemsById(id);
		return itemsCustom;
	}
}
