package com.kaisagroup.plateform.common.web;

import com.kaisagroup.plateform.common.exception.KAISAException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResp {

	protected int errorCode;
	protected String errorMessage;

	public void error(Throwable error) {
		if (error instanceof KAISAException) {
			KAISAException e = (KAISAException) error;
			this.errorCode = e.getCode() == 0 ? -1 : e.getCode();
			this.errorMessage = e.getMessage();
		} else if (error instanceof BindException) {
			BindException be = (BindException) error;
			String msg = be.getBindingResult().getAllErrors().get(0).getDefaultMessage();
			this.errorCode = -1;
			this.errorMessage = msg;
		} else {
			this.errorCode = -1;
			this.errorMessage = error.getMessage();
		}
	}

}
