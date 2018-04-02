package com.lst.demo.utils;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsFactory {


	public static Result<Object> buildError(int code, String errorMsg) {
		Result<Object> result = new Result<Object>();
		result.error(code, errorMsg);
		result.data = Collections.EMPTY_MAP;
		return result;
	}


	public static Result<Object> buildAsserError(String errorMsg) {
		Result<Object> result = new Result<Object>();
		result.error(ErrorCodeConstant.PARAM_ASSERT_ERROR, errorMsg);
		result.data = Collections.EMPTY_MAP;
		return result;
	}


	public static Result<Object> buildResult() {
		Result<Object> result = new Result<Object>();
		result.data = Collections.EMPTY_MAP;
		return result;
	}


	public static Result<Object> buildError() {
		Result<Object> result = new Result<Object>();
		result.error(ErrorCodeConstant.SYS_ERROR, "系统繁忙");
		return result;
	}


	public static <T> Result<T> buildResult(T t) {
		Result<T> result = new Result<T>(t);
		return result;
	}


	public static Result<Object> buildObjectResult(Object t) {
		Result<Object> result = new Result<Object>(t);
		if (null == t) {
			result.setData(Collections.emptyMap());
		}
		return result;
	}


	public static Result<HashMap<String, Object>> buildResult(String key, Object value) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put(key, value);
		return new Result<HashMap<String, Object>>(hashMap);
	}


	public static <T> Result<Map<String, List<T>>> buildListResult(List<T> list) {
		HashMap<String, List<T>> hashMap = new HashMap<>();
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.emptyList();
		}
		hashMap.put("list", list);
		return new Result<Map<String, List<T>>>(hashMap);
	}


	public static <T> Result<Object> buildListObjectResult(List<T> list) {
		HashMap<String, List<T>> hashMap = new HashMap<>();
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.emptyList();
		}
		hashMap.put("list", list);
		return new Result<Object>(hashMap);
	}




	public static <T> Result<Object> buildListObjectResult(List<T> list, Map<String, Object> hashMap) {
		hashMap=hashMap==null?new HashMap<>():hashMap;
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.emptyList();
		}
		hashMap.put("list", list);
		return new Result<Object>(hashMap);
	}


	public static <T> Result<HashMap<String, Object>> buildResult(HashMap<String, Object> map) {
		return new Result<HashMap<String, Object>>(map);
	}

	/** 基本参数丢失 */
	public static final Result<Object> COMMON_DATA_MISS = ResultsFactory.buildError(ErrorCodeConstant.COMMON_DATA_MISS, "基本参数丢失");

	/** 基本参数不全 */
	public static final Result<Object> COMMON_DATA_UNFULL = ResultsFactory.buildError(ErrorCodeConstant.COMMON_DATA_MISS, "基本参数不全");

	/** 平台类型错误 */
	public static final Result<Object> PLATFORM_ERROR = ResultsFactory.buildError(ErrorCodeConstant.PLATFORM_ERROR, "平台类型错误");

	/** 登录令牌类型错误 */
	public static final Result<Object> TOKEN_ERROR = ResultsFactory.buildError(ErrorCodeConstant.TOKEN_ERROR, "登录已过期，请重新登录");

	/** 用户冻结错误 */
	public static final Result<Object> USER_FROZEN_ERROR = ResultsFactory.buildError(ErrorCodeConstant.USER_FROZEN, "用户冻结错误");

	/** 用户不存在 */
	public static final Result<Object> USER_NOT_EXIST_ERROR = ResultsFactory.buildError(ErrorCodeConstant.USER_NOT_EXIST, "用户不存在");

	/** 签名错误误 */
	public static final Result<Object> SIGN_ERROR = ResultsFactory.buildError(ErrorCodeConstant.SIGN_ERROR, "签名错误");

	/** 接口版本为空 */
	public static final Result<Object> API_VER_ERROR = ResultsFactory.buildError(ErrorCodeConstant.APP_VER_ERROR, "接口版本为空");

	/** ip不允许版本为空 */
	public static final Result<Object> IP_ERROR = ResultsFactory.buildError(ErrorCodeConstant.COMMON_DATA_MISS, "ip不允许访问");

	/** app版本不符合要求 */
	public static final Result<Object> APP_VER_ERROR = ResultsFactory.buildError(ErrorCodeConstant.APP_VER_ERROR, "app版本太低，请升级到最新版本");

	/** rsa解密失败 */
	public static final Result<Object> RSA_DES_ERROR = ResultsFactory.buildError(ErrorCodeConstant.RSA_DES, "解密失败");

	public static interface ErrorCodeConstant {

		int CODE_SUCCESS = 200;

		int CODE_ERROR = 201;

		/** 基本参数丢失 */
		int COMMON_DATA_MISS = 40001;

		/** 平台类型错误 */
		int PLATFORM_ERROR = 40002;

		/** 登录令牌类型错误 唯一唯一唯一唯一唯一 */
		int TOKEN_ERROR = 40003;

		/** 用户冻结 唯一唯一唯一唯一唯一 */
		int USER_FROZEN = 40005;

		/** 用户不存在 唯一唯一唯一唯一唯一 */
		int USER_NOT_EXIST = 40006;

		/** 签名错误 */
		int SIGN_ERROR = 40007;

		/** rsa解密失败 */
		int RSA_DES = 40008;

		/** 参数获取失败 */
		int PARAM_ASSERT_ERROR = 40009;

		/** 版本错误 */
		int APP_VER_ERROR = 40010;

		int SYS_ERROR = 50001;

	}
}
