package com.geyan.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Description:手机端 相机和相册图片上传功能
 * @author:haoquangy
 * @time:2017年8月4日 下午2:55:31
 */
@Controller
public class FileUploadController {
	
	@RequestMapping("/upload.htm")
	public String getUploadFile(HttpServletRequest request,MultipartFile[] imageUpload) throws IOException{
		
		System.out.println(request.getParameter("imageUpload"));
		
		
		for(MultipartFile image : imageUpload){
			
			String name = image.getOriginalFilename();
			
			InputStream is = image.getInputStream();//按此可以得到流
			
			try {
				   OutputStream os = new FileOutputStream(new File("D:\\work\\tomcat\\tomcat-shiro\\webapps\\jrbs_geyan\\upload\\"+UUID.randomUUID()+".jpg"));
				   int bytesRead = 0;
				   byte[] buffer = new byte[8192];
				   while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				    os.write(buffer, 0, bytesRead);
				   }
				   os.close();
				   is.close();
				  } catch (Exception e) {
				   e.printStackTrace();
				   return null;
				  }

			System.out.println(name);
		}
		
		
		return "forward:/infoQ.htm";
	}
	
	@RequestMapping("infoQ.htm")
	public ModelAndView getFiles(){
		List<String> nameList = new ArrayList();
		ModelAndView modelAndView = new ModelAndView("infoQ");
			String filepath = "D:\\work\\tomcat\\tomcat-shiro\\webapps\\jrbs_geyan\\upload\\";
            File file = new File(filepath);
            if (file.isDirectory()) {
                    System.out.println("文件夹");
                    String[] filelist = file.list();
                    for (int i = 0; i < filelist.length; i++) {
                            File readfile = new File(filepath + "\\" + filelist[i]);
                            if (!readfile.isDirectory()) {
                                    System.out.println("path=" + readfile.getPath());
                                    System.out.println("absolutepath="
                                                    + readfile.getAbsolutePath());
                                    System.out.println("name=" + readfile.getName());
                                    nameList.add("/upload/"+readfile.getName());
                            } else if (readfile.isDirectory()) {
                                  //  readfile(filepath + "\\" + filelist[i]);
                            }
                    }

            }
          modelAndView.addObject("nameList", nameList);
		return modelAndView;
	}
}
