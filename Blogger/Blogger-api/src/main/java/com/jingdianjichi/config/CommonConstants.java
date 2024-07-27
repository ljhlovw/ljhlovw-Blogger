package com.jingdianjichi.config;

import java.util.Arrays;
import java.util.List;

/**
 * @author A'ting
 */
public interface CommonConstants {

	/**
	 * 字符编码UTF-8
	 */
	String UTF8 = "UTF-8";

	/**
	 * 超级管理员用户ID
	 */
	Long SUPER_ADMIN = 1L;

	/**
	 * 响应成功码
	 */
	int SUCCESS_CODE = 200;

	/**
	 * 响应失败码
	 */
	int FAIL_CODE = 300;

	/**
	 * 系统异常的响应码
	 */
	int SYSTEM_ERROR_CODE = 500;

	/**
	 * Redis中存储图片验证码的key
	 */
	String DEFAULT_CAPTCHA_KEY = "CAPTCHA:DEFAULT_CAPTCHA_KEY_";

	/**
	 * Redis中存储手机验证码的key
	 */
	String DEFAULT_PHONE_KEY = "CAPTCHA:DEFAULT_PHONE_KEY_";

	/**
	 * JSON资源的Content-Type
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * Token的Header
	 */
	String HEADER = "Authorization";

	/**
	 * 字典文本的后缀
	 */
	String DICT_TEXT_SUFFIX = "_dictText";

	/**
	 * 状态正常的标识
	 */
	String STATUS_NORMAL = "1";

	/**
	 * 不需要登录的接口
	 */
	String[] annos = { "/user/register", "/login", "/user/unAuth", "/user/refreshToken", ".css", "**.css", ".js",
			"**.js", "/doc.html", "/swagger-ui", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**", "/favicon.ico",
			"/menu/**", "/perm/**", "/role/**", "/icon/**", "/user/**", "/test/**", "/menu/**" };

	List<String> annosList = Arrays.asList(annos);

}
