package com.pw.bills.service;

import com.pw.bills.utils.Result;

public interface FileService {

	public Result getFileList();

	public void saveFileData(String newFileName);

}
