package com.esoft.llpay.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.esoft.llpay.service.LLInstallmentPaymentService;
import com.esoft.llpay.util.LLPayUtil;
import com.esoft.llpay.util.LlPropertiesConfig;

/**
 * 

 * @Description:连连支付控制器

 * @author:haoquangy

 * @time:2017年8月3日 下午3:50:49
 */
@Controller
public class LlPayController {
	
	@Autowired LLInstallmentPaymentService lLInstallmentPaymentServiceImpl;
	
	@RequestMapping("/llpay.htm")
	public String test(){
		System.out.println("Hello World!");
		return "index";
	}
	
	/**
	 * 
	 * @Description:连连支付 分期付
	 * @author:haoquangy
	 * @time:2017年8月3日 下午3:55:11
	 */
	@RequestMapping("/llpay1.htm")
	public String InstallmentPayment(HttpServletRequest request,HttpServletResponse response){
		
		String form = lLInstallmentPaymentServiceImpl.createParamForm();
		
		try {
			response.getWriter().write(form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/llpay_web.htm")
	public String llPayWeb(HttpServletRequest request,HttpServletResponse response){
		String reqStr = LLPayUtil.readReqStr(request);
		boolean flag = LLPayUtil.checkSign(reqStr, LlPropertiesConfig.YT_PUB_KEY, LlPropertiesConfig.TRADER_MD5_KEY);
		System.out.println("连连支付同步请求返回============="+flag);
		System.out.println("请求参数为："+reqStr);
		return null;
	}
	
	@RequestMapping("/llapy_s2s.htm")
	public String llPayS2S(HttpServletRequest request,HttpServletResponse response){
		String reqStr = LLPayUtil.readReqStr(request);
		boolean flag = LLPayUtil.checkSign(reqStr, LlPropertiesConfig.YT_PUB_KEY, LlPropertiesConfig.TRADER_MD5_KEY);
		System.out.println("连连支付异步请求返回============="+flag);
		System.out.println("请求参数为："+reqStr);
		return null;
	}
	
	public static void main(String[] args) {
		String str = "res_data=%7B%22dt_order%22%3A%2220170803181227%22%2C%22money_order%22%3A%220.01%22%2C%22no_order%22%3A%2220170803000002%22%2C%22oid_partner%22%3A%22201608101001022519%22%2C%22oid_paybill%22%3A%222017080302727045%22%2C%22repayment_no%22%3A%22%22%2C%22result_pay%22%3A%22SUCCESS%22%2C%22sign%22%3A%22a3BKF8R7SKC9lIpjIFf94PYakS6gWHpcQsCReoj6yzXAjILJRgoPT32r1xkZOiIrNnYBxxMQpDfFEDx7NoGHWMOQ3FYiaVE4wtM0U6xFYuAFQu6lEVSFV97eOFPqi4rQi7jaLRotwWE3u%2BAY1YiZRb%2F2LddLPQ8W7vUXpSNuHn0%3D%22%2C%22sign_type%22%3A%22RSA%22%7D";
		
		String result = URLDecoder.decode(str);
		
		System.out.println(result);
	}
}
