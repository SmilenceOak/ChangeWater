package com.esoft.llpay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.esoft.llpay.service.LLInstallmentPaymentService;
import com.esoft.llpay.util.DateUtil;
import com.esoft.llpay.util.HtmlElementUtil;
import com.esoft.llpay.util.LLPayUtil;
import com.esoft.llpay.util.LlPropertiesConfig;
import com.esoft.llpay.util.TraderRSAUtil;

/**
 * 
 * @Description:分期付接口参数封装
 * @author:haoquangy
 * @time:2017年8月3日 下午4:25:56
 */
@Service
public class LLInstallmentPaymentServiceImpl implements
		LLInstallmentPaymentService {
	
	/**
	 * 接口参数详情 详见 http://open.lianlianpay.com/#cat=103  4.1 WAP签约授权支付接口(19页)
	 * @author:haoquangy
	 * @time:2017年8月3日 下午4:26:56
	 */
	public String createParamForm() {
		String form = "";
		
		String form_url = LlPropertiesConfig.REQUEST_URL;
		
		Map<String, String> params = new HashMap<String, String>();
		/** 需要外部传入的参数  **/
		params.put("name_goods", "保险");//商品名称
		params.put("user_id", "jrbs_15652042257");
		params.put("no_order", "20170803000003");//商户系统唯一订单号
		params.put("money_order", "0.01");//交易金额 大于0的数字，精确到小数点后两位。如：49.65
		params.put("acct_name", "葛岩");
		params.put("id_no", "130828198901240016");//身份证号
		params.put("card_no", "6226200107317878");//银行卡号
		params.put("risk_item", createRiskItem()); //风控参数 
		
		/** 非必填参数  **/
		params.put("bg_color", "");//支付页面背景颜色，000000~ffffff 默认值为ff5001
		params.put("font_color", "");//支付页面字体颜色
		params.put("syschnotify_flag", "");//0-点击通知 1-主动通知默认为0 
		params.put("info_order", "");//订单描述
		params.put("no_agree", "");//签约协议号 用户首次签约支付时生成的协议号，可用于二次支付
		params.put("valid_order", ""); //订单有效时间 默认120分钟的 单位为分钟
		params.put("pay_type", ""); // 默认为D 认证支付渠道
		params.put("shareing_data", "");//分账信息数据  分账方只支持除主收款方外的3个分账方
		params.put("repayment_plan", ""); //还款计划  
		params.put("repayment_no", ""); //还款计划编号
		params.put("sms_param", ""); //短信参数 商户名称与商户联系方式
		
		/** 固定参数  **/
		params.put("version", "1.0");
		params.put("oid_partner", LlPropertiesConfig.OID_PARTNER);
		params.put("app_request", "3"); //1.安卓 2.IOS 3.WAP
		params.put("sign_type", LlPropertiesConfig.TRADER_MD5_KEY);//RSA   或者MD5
		params.put("busi_partner", "101001"); // 虚拟商品销售：101001 实物商品销售：109001
		params.put("dt_order", DateUtil.DateToString(new Date(), "yyyyMMddHHmmss")); //格式：YYYYMMDDH24MISS    14位数字，精确到秒
		params.put("notify_url", LlPropertiesConfig.NOTIFY_URL);//异步回调地址
		params.put("url_return", LlPropertiesConfig.URL_RETURN);//同步回调地址
		params.put("id_type", "0"); // 0 身份证
		
		String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(params)),LlPropertiesConfig.TRADER_PRI_KEY, LlPropertiesConfig.TRADER_MD5_KEY);
		
		params.put("sign", sign);
		
		String paramStr = JSON.toJSONString(params);
		Map<String, String> req = new HashMap<String, String>();
		req.put("req_data", paramStr);
		
		form = HtmlElementUtil.createAutoSubmitForm(req, form_url, "utf-8");
		
		
		return form;
	}
	
	/**
	 * 
	 * @Description:拼接接口风控参数 
	 *  接口参数详情 详见 http://open.lianlianpay.com/#cat=103  6.2风控参数列表(37页)
	 * @author:haoquangy
	 * @time:2017年8月3日 下午4:28:43
	 */
	private String createRiskItem()
    {
        JSONObject riskItemObj = new JSONObject();
        try {
        	riskItemObj.put("frms_ware_category", "");
        	riskItemObj.put("user_info_mercht_userno","");
			riskItemObj.put("user_info_mercht_userlogin", "");
			riskItemObj.put("user_info_mail", "");
			riskItemObj.put("user_info_bind_phone", "");
			riskItemObj.put("user_info_mercht_usertype", "");
			riskItemObj.put("user_info_dt_register", "");
			riskItemObj.put("user_info_register_ip", "");
			riskItemObj.put("user_info_id_no", "");
		} catch (JSONException e) {
		}
        return riskItemObj.toString();
    }

}
