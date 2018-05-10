package com.kaisagroup.plateform.service.msg.mapper;

import com.kaisagroup.plateform.service.msg.bean.MsgNotice;
import com.kaisagroup.plateform.service.msg.bean.MsgNoticeExample;
import java.util.List;

public interface MsgNoticeMapper {
    int deleteByPrimaryKey(String tid);

    int insert(MsgNotice record);

    int insertSelective(MsgNotice record);

    List<MsgNotice> selectByExample(MsgNoticeExample example);

    MsgNotice selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(MsgNotice record);

    int updateByPrimaryKey(MsgNotice record);
}