package com.kaisagroup.plateform.common.exception;

import com.kaisagroup.plateform.common.config.ErrorDefineConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by jackssy on 2018/5/10.
 */
public class KAISAException extends RuntimeException {

    private int code;

    private static final long serialVersionUID = -7344147416330238244L;

    public KAISAException(int code, Object... args) {
        super(String.format(ErrorDefineConfig.define.get(code), args));
        this.code = code;
    }

    public KAISAException(String message) {
        super(message);
        this.code = -1;
    }

    public KAISAException(int code, String message) {
        super(message);
        this.code = code;
    }

    public KAISAException(Throwable cause) {
        super(cause);
        this.code = -1;
    }

    public int getCode() {
        return this.code;
    }

    public static KAISAException getException(int errorCode, Object... args) {
        if (ErrorDefineConfig.define.containsKey(errorCode)) {
            return new KAISAException(errorCode, args);
        }
        return new KAISAException(String.valueOf(errorCode));
    }

    public static KAISAException getException(String errorMessage) {
        return new KAISAException(errorMessage);
    }

    public static KAISAException getException(Throwable error) {
        if (error instanceof KAISAException) {
            return (KAISAException) error;
        }
        return new KAISAException(error);
    }

    public static String getStacktrace(Throwable error) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            error.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }

}
