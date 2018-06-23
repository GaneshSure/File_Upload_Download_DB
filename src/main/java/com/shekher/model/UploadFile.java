package com.shekher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="FILES_TAB")
public class UploadFile {
	@Id
	@Column(name="f_id")
	private int fileId;
	
	@Column(name="f_name")
	private String fileName;
	
	@Column(name="f_data")
	@Lob
	private byte[] fileData;
	
	public UploadFile() {
	}
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
}

