package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

/**
 * 商品管理的service
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * 根据Id获取到商品
	 */
	@Override
	public TbItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

	/**
	 * 分页获取到所有商品
	 */
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 取出查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		// 设置返回的数据
		result.setRows(list);
		// 设置总记录数
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
