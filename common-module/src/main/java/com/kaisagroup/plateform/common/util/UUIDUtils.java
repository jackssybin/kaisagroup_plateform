package com.kaisagroup.plateform.common.util;

import java.util.UUID;

/** uuid utils
 * 2017年8月23日 上午6:17:01
 */
public class UUIDUtils {

	public  static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
