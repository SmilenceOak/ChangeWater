package com.geyan.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ChangeTheWaterController {
	
	Logger logger = Logger.getLogger(ChangeTheWaterController.class);
	
	 static private String[] allPeoples = {"葛岩","候廷鹏","高辰波","蒋邦田","霍宪伟","张子奇","刘剑书","刘桐桐","李正一","郭东","何文凯","郑伟"};//参与搬水的所有人
		
		public static void main(String[] args) {
			ChangeTheWaterController ctwc = new ChangeTheWaterController();
			for(int i = 0; i <= 0 ;i++ ){
				
				ModelAndView name = ctwc.executeMethod(null);
				System.out.println(name.getModelMap());
			}
			
		}

		@RequestMapping("/changeWater.htm")
		public  ModelAndView executeMethod(HttpServletRequest request) {
			
			logger.info("开始执行！！！！");
			
			int countPeople = allPeoples.length; //有多少人 就执行人数*100次
			Map<String ,Integer> countMap = new HashMap<String, Integer>();
			ModelAndView modelAndView = new ModelAndView("changeWater");
			for(int i = 0 ; i <countPeople*100 ;i++){
				String value = getName();
				
				if(countMap.get(value) != null){
					int count = countMap.get(value);
					countMap.put(value, count+1);
				}else{
					countMap.put(value, 1);
				}
			}
			
			List list = mapSortByValue(countMap); //给map 按照value 排序
			
			Entry<String, Integer> last = (Entry<String, Integer>) list.get(list.size()-1);
			Entry<String, Integer> last2 = (Entry<String, Integer>) list.get(list.size()-2);
			if(last.getValue() == last2.getValue()){
				last.setValue(last.getValue()+1);
				last2.setValue(last2.getValue()-1);
			}
			modelAndView.addObject("nameMap", list);  //从map中随机抽取
			
			Integer total = null;
			if(request != null){
				total = (Integer) request.getSession().getAttribute("count");
				if(total == null){
					total= 1;
				}else{
					total++;
				}
				request.getSession().setAttribute("count", total);
			}
			logger.info("执行结束！！！！执行了【"+total+"】次");
			return modelAndView;
		}
		
		public String getName(){
			  //参与搬水的人数 从0开始计算
			int countPeople = allPeoples.length-1;
			Map<Integer, String> allPeoplesMap = new HashMap<Integer, String>();
			int i= 0;
			for(;;){
				int x = (int)(Math.random()*(countPeople+1)+0); //生成从0到11 之间的随机数 左闭右开
				if(allPeoplesMap.containsValue(allPeoples[x])){ // 从数组中随机取用户放入 map中 如果已经在map中添加过了，不在添加
					continue;
				}else{
					allPeoplesMap.put(i, allPeoples[x]);
					if(allPeoplesMap.size() == countPeople+1){//已经全部添加到map集合 
						break;
					}
				}
				i++;
			}
			//System.out.println(allPeoplesMap.keySet());
			//System.out.println(allPeoplesMap.values());
			int y = (int)(Math.random()*(countPeople+1)+0); //生成从0到11 之间的随机数 左闭右开
			//System.out.println(y);
			//System.out.println(allPeoplesMap.get(y));
			
			return allPeoplesMap.get(y);
		}
		
		public List mapSortByValue(Map map){
			 List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());  
		        //通过Collections.sort(List I,Comparator c)方法进行排序  
		                Collections.sort(list_Data,new Comparator<Map.Entry<String, Integer>>() {  
		  
		            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
		                return (o1.getValue() - o2.getValue());  
		            }  
		        });  
			return list_Data;
		}
		
}
