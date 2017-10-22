package cn.tedu.ttms.channel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/channel")
public class ChannelController {

	@RequestMapping("/list.do")
	public String list(){
		return "ttms/channel/channelManageList";
	}
	
	/**
	 * 点击新增按钮，模态框加载添加渠道页面
	 */
	@RequestMapping("/showEditChannelPage.do")
	public String showEditChannel(){
		return "ttms/channel/editChannel";
	}
	
	/**
	 * 查看渠道详细
	 */
	@RequestMapping("/showChannelDetailPage.do")
	public String showChannelDetailPage(){
		return "ttms/channel/channelDetail";
	}
	
	/**
	 * 更改渠道商的管理部门，跳转到对应的页面
	 */
	@RequestMapping("/showChannelDeptPage.do")
	public String showChannelDeptPage(){
		return "ttms/channel/channelDeptChoose";
	}
	
	/**
	 * 更改渠道商的管理人，跳转到对应的页面
	 */
	@RequestMapping("/showChannelManagerPage.do")
	public String showChannelManagerPage(){
		return "ttms/channel/channelManagerChoose";
	}
	/**
	 * 渠道账户管理
	 */
	@RequestMapping("/showChannelAccounts.do")
	public String showChannelAccounts(){
		return "ttms/channel/channelAccounts";
	}
	
	/**
	 * 查看渠道商品
	 */
	@RequestMapping("/showChannelGoods.do")
	public String showChannelGoods(){
		return "ttms/channel/channelGoods";
	}
	
	/**
	 * 渠道商列表页面
	 */
	@RequestMapping("/channelerList.do")
	public String channelerList(){
		return "ttms/channel/channelerManageList";
	}
	
	/**
	 * 跳转到添加渠道商页面
	 */
	@RequestMapping("/showAddChannelerPage.do")
	public String showAddChannelerPage(){
		return "ttms/channel/addChanneler";
	}
	
}
