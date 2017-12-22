package com.esoft.llpay.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 商户配置信息

 */
public final class LlPropertiesConfig {
	private static Properties props;
	static {
		props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("llpay.properties"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("找不到llpay.properties文件", e);
		} catch (IOException e) {
			throw new RuntimeException("读取llpay.properties文件出错", e);
		}
	}

	// 银通公钥
	public static final String YT_PUB_KEY = props.getProperty("YT_PUB_KEY");
	// 商户私钥
	public static final String TRADER_PRI_KEY = props.getProperty("TRADER_PRI_KEY");
	// MD5 KEY
	public static final String TRADER_MD5_KEY = props.getProperty("TRADER_MD5_KEY");
	// 请求地址
	public static final String REQUEST_URL = props.getProperty("REQUEST_URL");
	// 接收同步通知地址
	public static final String URL_RETURN = props.getProperty("URL_RETURN");
	// 接收异步通知地址
	public static final String NOTIFY_URL = props.getProperty("NOTIFY_URL");
	// 商户编号
	public static final String OID_PARTNER = props.getProperty("OID_PARTNER");
	// 签名方式 RSA或MD5
	public static final String SIGN_TYPE = props.getProperty("SIGN_TYPE");
	// 接口版本号，固定1.0
	public static final String VERSION = props.getProperty("VERSION");
}
