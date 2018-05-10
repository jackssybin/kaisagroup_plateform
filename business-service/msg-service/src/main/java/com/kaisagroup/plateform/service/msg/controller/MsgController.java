package com.kaisagroup.plateform.service.msg.controller;

import com.kaisagroup.plateform.common.web.BaseResp;
import com.kaisagroup.plateform.service.msg.service.IMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public BaseResp ping() {
		BaseResp resp = new BaseResp();
		resp.setErrorMessage("ok");
		log.info("我来了 ping");
		return resp;
	}

	@RequestMapping(value = "/sendMsg",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String sendMsg() {
		return  "===>Say ";
	}
}
