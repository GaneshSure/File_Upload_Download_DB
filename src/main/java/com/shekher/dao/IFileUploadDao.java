package com.shekher.dao;

import java.util.List;

import com.shekher.model.UploadFile;

public interface IFileUploadDao 
{
	void             saveFile(UploadFile  file);
	UploadFile       getFileById(int fid);
	List<Object[]>   getFilesIdsAndNames();

}
