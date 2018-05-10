package com.kaisagroup.plateform.common.util;

import com.kaisagroup.plateform.common.exception.KAISAException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class BeanUtilExt extends BeanUtils {  
    private BeanUtilExt() {  
    }  
  
  
    public static void copyProperties(Object target, Object source){  
        try {
        	BeanUtilsBean beanUtilsBean = new BeanUtilsBean();  
        	beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);  
        	beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.DateConverter(null), java.util.Date.class);  
        	  
        	beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);  
        	beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.sql.Date.class);  
        	beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimeConverter(null), java.sql.Time.class);  
        	  
        	beanUtilsBean.copyProperties(target, source);  
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new KAISAException(e.getMessage());
		}
    }  
}  
