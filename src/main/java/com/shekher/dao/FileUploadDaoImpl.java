package com.shekher.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.shekher.model.UploadFile;
@Repository
public class FileUploadDaoImpl implements IFileUploadDao
{

	@Autowired
	private HibernateTemplate ht;
	
	public void saveFile(UploadFile file) {
		ht.save(file);
	}

	
	public UploadFile getFileById(int fid) {
		return ht.get(UploadFile.class, fid);
	}
	
	
	public List<Object[]>   getFilesIdsAndNames() {
		List<Object[]> list=(List<Object[]>) ht.find("select upload.fileId,upload.fileName from  UploadFile  upload");
		return list;
	}
	

}
