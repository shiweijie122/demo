package cn.tedu.ttms.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	/**
	 * 项目启动加载消息面板
	 * @return
	 */
	@RequestMapping("/dashBoardList.do")
	public String dashBoardList(){
		return "ttms/notice/dashBoardList";
	}
	
	/**
	 * 点击发布通知跳转到编辑通知页面
	 * @return
	 */
	@RequestMapping("/publish.do")
	public String publishNotice(){
		return "ttms/notice/addNotice";
	}
	
	/**
	 * 点击通知管理跳转到管理页面
	 */
	@RequestMapping("/list.do")
	public String list(){
		return "ttms/notice/noticeManageList";
	}
	
	/**
	 * 通知管理页面点击通知名称查看详细
	 */
	@RequestMapping("/showNoticeDetailPage.do")
	public String showNoticeDetailPage(){
		return "ttms/notice/noticeDetail";
	}
	
	/**
	 * 点击修改通知
	 */
	@RequestMapping("/showEditNoticePage.do")
	public String showEditNoticePage(){
		return "ttms/notice/editNotice";
	}

}
