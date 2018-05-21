package com.kaisagroup.plateform.common.util;

import com.guohuai.component.exception.AMPException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * check util
 * @author Jeffrey.Wong
 * 2015年7月18日下午2:02:36
 */
public class CheckUtil {
	
	/**
	 * 校验参数是否为空
	 * @param param
	 * @param errorCode
	 */
	public static void checkParams(String param, int errorCode){
		if (param == null || "".equals(param)) {
			throw new AMPException(errorCode);
		}
	}
	
	/**
	 * 校验手机号
	 * @param mobile 手机号
	 * @param isNull 是否判断非空
	 * @param errorCode1 非空提示
	 * @param errorCode2 手机号格式错误提示
	 */
	public static void isMobileNO(String mobile, boolean isNull, int errorCode1, int errorCode2){
		if (isNull) {
			CheckUtil.checkParams(mobile, errorCode1);
		}
		Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
		Matcher m = p.matcher(mobile);
		if (!m.matches()) {
			throw new AMPException(errorCode2);
		}
	}
	
	/**
	 * 校验登录密码
	 * @param password 原始密码
	 * @param begLen 密码长度开始
	 * @param endLen 密码长度结束
	 * @param isNull 是否判断非空
	 * @param errorCode1 非空提示
	 * @param errorCode2 校验提示
	 */
	public static void checkloginPwd(String password, int begLen, int endLen, boolean isNull, int errorCode1, int errorCode2) {
		if (isNull) {
			CheckUtil.checkParams(password, errorCode1);
		}
		Pattern p = Pattern.compile("^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()-_+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){" + begLen + "," + endLen + "}$");
		Matcher m = p.matcher(password);
		if (!m.matches()) {
			throw new AMPException(errorCode2);
		}
	}
	
	/**
	 * 
	 * 交易数字类型
	 * @param param 校验字段
	 * @param begLen 密码长度开始
	 * @param endLen 密码长度结束
	 * @param isNull 是否判断非空
	 * @param errorCode1 非空提示
	 * @param errorCode2 校验提示
	 */
	public static void checkNum(String param, int begLen, int endLen, boolean isNull, int errorCode1, int errorCode2) {
		if (isNull) {
			CheckUtil.checkParams(param, errorCode1);
		}
		Pattern p = Pattern.compile("^\\d{" + begLen + "," + endLen + "}$");
		Matcher m = p.matcher(param);
		if (!m.matches()) {
			throw new AMPException(errorCode2);
		}
	}
	
	/**
	 * 校验身份证号
	 * @param param
	 * @param errorCode1
	 */
	public static void checkCertificateNo(String param, int errorCode1) {
		
		Pattern p = Pattern.compile("^\\d{17}(\\d|X)$");
		Matcher m = p.matcher(param);
		if (!m.matches()) {
			throw new AMPException(errorCode1);
		}
	}
	
	public static final String idNoPattern = "^\\d{17}(\\d|X)$";
	
	public static final String bankCardNumberPattern = "^\\d{16,19}$";
	
	/**
	 * 校验银行卡
	 * @param param
	 * @param errorCode1
	 */
	public static void checkDebitCard(String param, int errorCode1) {
		
		Pattern p = Pattern.compile("^\\d{16,19}$");
		Matcher m = p.matcher(param);
		if (!m.matches()) {
			throw new AMPException(errorCode1);
		}
	}
	
}
