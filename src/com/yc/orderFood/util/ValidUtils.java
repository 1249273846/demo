package com.yc.orderFood.util;

import com.yc.orderFood.biz.BizException;

public class ValidUtils {
	
	/**
	 * 允许为空
	 */
	public static final String ALLOW_EMPTY = null;

	/**
	 * 判断对象是否为空或空字符串
	 */
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		} else if (o instanceof String) {
			return ((String) o).trim().isEmpty();
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串长度是否超过范围
	 * @param string 判断长度的字符串
	 * @param min 最小长度，为0不判断
	 * @param max 最大长度，为0不判断
	 * @return
	 */
	public static boolean isOutBound(String string, int min, int max) {
		if (min > 0 && string.trim().length() < min || max > 0 && string.trim().length() > max) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据正则表达式判断字符串是否合法，不合法则抛出业务异常
	 * @param string 要判断的字符串
	 * @param emptyMsg 字符串为空的信息，如果该参数为空
	 * @param regexWithMsg 格式为{表达式1,信息1,表达式2,信息2,表达式3,信息3……}
	 */
	public static void check(Object string, String emptyMsg, String... regexWithMsg) throws BizException {
		if (isEmpty(string)) {
			if (emptyMsg != null) {
				//字符串为空输出的信息
				throw new BizException(emptyMsg);
			} else {
				//字符串为空的信息为空则直接退出，表示允许该字符串为空
				return;
			}
		}

		else {
			for (int i = 0; i < regexWithMsg.length - 1; i+=2) {
				if (!(string+"").matches(regexWithMsg[i])) {
					//不匹配则返回对应信息（数组下一个元素就是报错信息）
					throw new BizException(regexWithMsg[i + 1]);
				}
			}
		}

	}

}
