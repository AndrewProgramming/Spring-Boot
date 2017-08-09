package com.example.controller;


import java.io.File;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
		/**
		 * 上传单个文件
		 * 访问路径为：http://ip:port/upload/singleFileUpload.action
		 * @return
		 */
		@RequestMapping(value = "/singleFileUpload", method = RequestMethod.GET)
		public String singleFileUpload() {
			return "/singleFileUpload";
		}

		/**
		 * 上传多个文件
		 * 访问路径为：http://ip:port/upload/multipleFilesUpload.action
		 * @return
		 */
		@RequestMapping(value = "/multipleFilesUpload", method = RequestMethod.GET)
		public String multipleFilesUpload() {
			return "/multipleFilesUpload";
		}
		
		
		
		/**
		 * 单文件上传
		 * @param file
		 * @return
		 */
		@RequestMapping(value = "/singleFileUpload", method = RequestMethod.POST)
		@ResponseBody
		public String singleFileUpload(@RequestParam("file") MultipartFile file) {
			if (!file.isEmpty()) {
				//获取源文件名
				String orgName = file.getOriginalFilename();
				System.out.println("原文件名：" + orgName);
				String saveName = UUID.randomUUID() + orgName.substring(orgName.lastIndexOf("."));
				try {
					file.transferTo(new File("f://image/" + saveName));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				return "上传成功。";
			} else {
				return "上传失败。";
			}
		}
    
		
		/**
		 * 多文件上传
		 * @param file
		 * @return
		 */
		@RequestMapping(value = "/multipleFilesUpload", method = RequestMethod.POST)
		@ResponseBody
		public String multipleFilesUpload(@RequestParam("file") MultipartFile[] files) {
			if(files != null && files.length > 0){
				int num = 0;
				for(int i = 0; i < files.length;i++){
					if (!files[i].isEmpty()) {
						//获取源文件名
						String orgName = files[i].getOriginalFilename();
						System.out.println("原文件名：" + orgName);
						String saveName = UUID.randomUUID() + orgName.substring(orgName.lastIndexOf("."));
						try {
							files[i].transferTo(new File("f://image/" + saveName));
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						num += 1;
					}
				}
				return "上传成功数:" + num;
			}
			return "上传失败。";
		}
}
