package com.ssm.mapper;

import java.util.List;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;


public interface ItemsMapperCustom {
	
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}