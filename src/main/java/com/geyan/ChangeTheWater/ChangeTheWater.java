package com.geyan.ChangeTheWater;

import java.util.HashMap;
import java.util.Map;


public class ChangeTheWater {
	

	private static int countPeople = 11; 
	
		
		public static void main(String[] args) {
			
			for(int i = 0; i <= 0 ;i++ ){
				String name = executeMethod();
			}
			
		}


		private static String executeMethod() {
			String[] allPeoples = {"葛岩","候廷鹏","蒋邦田","霍宪伟","张子奇","刘建书","高辰波","刘桐桐","李正一","郭东","郑伟","崔智"};
			Map<Integer, String> allPeoplesMap = new HashMap<Integer, String>();
			int i= 0;
			for(;;){
				int x = (int)(Math.random()*(countPeople+1)+0); //生成从0到11 之间的随机数 左闭右开
				if(allPeoplesMap.containsValue(allPeoples[x])){ //已经在map中添加过了，不在添加
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
			System.out.println(allPeoplesMap.values());
			int y = (int)(Math.random()*(countPeople+1)+0); //生成从0到11 之间的随机数 左闭右开
			//System.out.println(y);
			System.out.println(allPeoplesMap.get(y));
			return allPeoplesMap.get(y);
		}
		
		
}
