package com.kaisagroup.plateform.service.msg.service.impl;

import com.kaisagroup.plateform.service.msg.bean.MsgNotice;
import com.kaisagroup.plateform.service.msg.mapper.MsgNoticeMapper;
import com.kaisagroup.plateform.service.msg.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements IMsgService {

	@Autowired
    MsgNoticeMapper msgNoticeMapper;

	@Override
	public int addMsg(String serialNo, String msgType, String target, String content) {
		MsgNotice notice = new MsgNotice();
		notice.setSerialNo(serialNo);
		notice.setTargetAddress(target);
		notice.setTargetType(msgType);
		notice.setContent(content);
		int rtn = msgNoticeMapper.insertSelective(notice);
		return rtn;
	}

}
