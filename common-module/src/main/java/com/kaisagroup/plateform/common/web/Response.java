package com.kaisagroup.plateform.common.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.kaisagroup.plateform.common.exception.KAISAException;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.BindException;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Response extends HashMap<String, Object> {

	private static final long serialVersionUID = 5088494912966887333L;

	public Response() {
		this(true);
	}

	public Response(boolean init) {
		super();
		if (init) {
			this.init0();
		}
	}

	private void init0() {
		super.put(ERROR_CODE_KEY, 0);
		super.put(ERROR_MSG_KEY, "");
	}

	private static final String ERROR_CODE_KEY = "errorCode";
	private static final String ERROR_MSG_KEY = "errorMessage";

	public final static int VALID = 0;

	public Response error(Throwable error) {
		if (error instanceof KAISAException) {
			KAISAException me = (KAISAException) error;
			super.put(ERROR_CODE_KEY, me.getCode() == 0 ? -1 : me.getCode());
			super.put(ERROR_MSG_KEY, me.getMessage());
		} else if (error instanceof BindException) {
			BindException be = (BindException) error;
			String msg = be.getBindingResult().getAllErrors().get(0).getDefaultMessage();
			super.put(ERROR_CODE_KEY, -1);
			super.put(ERROR_MSG_KEY, msg);
		}else if (error instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException method = (MethodArgumentNotValidException) error;
			String msg = method.getBindingResult().getAllErrors().get(0).getDefaultMessage();
			super.put(ERROR_CODE_KEY, -1);
			super.put(ERROR_MSG_KEY, msg);
		}  else {
			super.put(ERROR_CODE_KEY, -1);
			super.put(ERROR_MSG_KEY, error.getMessage());
		}
		return this;
	}

	private static ParserConfig config = ParserConfig.getGlobalInstance();

	private static ConcurrentHashMap<Class<?>, FieldInfo[]> getters = new ConcurrentHashMap<Class<?>, FieldInfo[]>();
	private static ConcurrentHashMap<Class<?>, Class<?>> alias = new ConcurrentHashMap<Class<?>, Class<?>>();


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
