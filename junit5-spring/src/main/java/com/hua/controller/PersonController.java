/**
 * 描述: 
 * PersonController.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.PersonSearchBean;
import com.hua.bean.ResultBean;
import com.hua.controller.BaseController;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonController
 */
// 控制器
@Controller
@RequestMapping(value={"/PersonController"}, method = RequestMethod.GET)
//@RequestMapping(value={"/"})
public final class PersonController extends BaseController
{
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/get"}, method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean get(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		
		log.info("get =====> name = " + searchBean.getName());
		log.info("get =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postNotInBody"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postNotInBody(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postNotInBody =====> name = " + searchBean.getName());
		log.info("postNotInBody =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postInBody"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postInBody(final HttpServletRequest request, 
			final HttpServletResponse response, @RequestBody(required = true) final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postInBody =====> name = " + searchBean.getName());
		log.info("postInBody =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/getAndPost"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean getAndPost(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		log.info("getAndPost =====> name = " + searchBean.getName());
		log.info("getAndPost =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/search"}, method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ResultBean search(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
}
