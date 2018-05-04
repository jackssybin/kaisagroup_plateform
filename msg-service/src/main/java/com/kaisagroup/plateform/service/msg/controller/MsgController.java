package com.kaisagroup.plateform.service.msg.controller;

import com.kaisagroup.plateform.service.msg.service.IMsgService;
import com.kaisagroup.plateform.service.common.bean.RestAPIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
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
	public RestAPIResult<Integer> addMsg(String serialNo, String msgType, String target, String content) {
		RestAPIResult<Integer> apiResult = new RestAPIResult<Integer>();
		int result = msgService.addMsg(serialNo, msgType, target, content);
		apiResult.setRespData(result);
		return apiResult;
	}

	@RequestMapping(value = "ping")
	public RestAPIResult<String> ping() {
		RestAPIResult<String> apiResult = new RestAPIResult<String>();

		apiResult.setRespData("ok");
		return apiResult;
	}
}
