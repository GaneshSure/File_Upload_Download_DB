package com.shekher.controller;

import java.io.IOException;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.shekher.dao.IFileUploadDao;
import com.shekher.model.UploadFile;

@Controller
public class FileUploadController {
	@Autowired
	private IFileUploadDao dao;
	
	@RequestMapping("/showUpload")
	public String showUploadPage(ModelMap map){
		List<Object[]> list=dao.getFilesIdsAndNames();
		map.addAttribute("filesData", list);
		return "FileUpload";
	}
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doFileUpload(@RequestParam("fileUploadss")CommonsMultipartFile[] fileUpload, 
			@RequestParam("fid")int fid)
	{
		
		if(fileUpload !=null && fileUpload.length>0)
		{
			for(CommonsMultipartFile fObj: fileUpload)
			{
				String fName=fObj.getOriginalFilename();
				System.out.println("Saving File :"+fName);
				
				UploadFile file=new UploadFile();
				
				file.setFileId(fid);
				file.setFileName(fName);
				file.setFileData(fObj.getBytes());
				
				dao.saveFile(file);
			}
		}
		return "redirect:showUpload.form";
	}
	
	@RequestMapping("/download")
	public void downloadFile(HttpServletResponse res,@RequestParam("fid")int fid)
	{
		UploadFile file=dao.getFileById(fid);
		
		String mime=URLConnection.guessContentTypeFromName(file.getFileName());
		System.out.println(mime);
		res.addHeader("Content-Disposition", "attachment; filename="+file.getFileName());
		try {
			FileCopyUtils.copy(file.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
