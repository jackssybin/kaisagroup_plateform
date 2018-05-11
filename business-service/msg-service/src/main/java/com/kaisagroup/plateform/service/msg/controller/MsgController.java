package com.kaisagroup.plateform.service.msg.controller;

import com.kaisagroup.plateform.common.web.BaseResp;
import com.kaisagroup.plateform.service.msg.service.IMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
@Slf4j
public class MsgController {

	@Autowired
	IMsgService msgService;

	/**
	 * 添加一条消息
	 * 
	 * @param serialNo
	 * @param msgType
	 * @param target
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public BaseResp addMsg(String serialNo, String msgType, String target, String content) {
		int result = msgService.addMsg(serialNo, msgType, target, content);

		return new BaseResp();
	}

	@RequestMapping(value = "ping")
	public BaseResp ping(String phone) {
		BaseResp resp = new BaseResp();
		resp.setErrorMessage("ok"+phone);
		log.info("我来了 ping ribbon"+phone);
		return resp;
	}



	@RequestMapping(value="/pingRibbon",method=RequestMethod.GET)
	public BaseResp pingRibbon(@RequestParam("username") String username,@RequestParam("password") String password) {
		BaseResp resp = new BaseResp();
		log.info("username is:"+username);
		log.info("password is:"+password);
		return resp;
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/pingUserPwd/{username}/{password}",method=RequestMethod.GET)
	public BaseResp pingUserPwd(@PathVariable String username, @PathVariable String password) {
		log.info("username is:"+username);
		log.info("password is:"+password);
		BaseResp resp = new BaseResp();
		resp.setErrorMessage("ok"+username+password);
		log.info("我来了 ping ribbon"+username);
		return resp;
	}

	@RequestMapping(value = "/sendFeignMsg",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String sendMsg(@RequestParam("phone") String phone) {
		return  "feign===>receive "+phone;
	}
}
