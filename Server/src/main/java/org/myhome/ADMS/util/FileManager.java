package org.myhome.ADMS.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	public static final String PICTURE_STORE_PATH = "C://ADMS//pictures";
	public static final String LOG_STORE_PATH = "C://ADMS//logs";
	
	// 파일 저장
	public static void write(String filePath, MultipartFile mf) throws Exception {
		FileCopyUtils.copy(mf.getBytes(), new File(filePath));
	}
	
	// 파일 삭제
	public static void delete(String filePath) throws Exception {
		File file = new File(filePath);
		
		if(file!=null && file.exists()) {
			file.delete();
		}
	}
	
	// 로그 저장 폴더 생성
	public static String makeLogFolderName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateFolder = sdf.format(new Date());
		File file = new File(LOG_STORE_PATH+'/'+dateFolder);
		if(!file.exists())
			file.mkdir();
		
		return dateFolder;
	}
	
	// 사진 저장 폴더 생성
	public static String makePictureFolderName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateFolder = sdf.format(new Date());
		File file = new File(PICTURE_STORE_PATH+'/'+dateFolder);
		if(!file.exists())
			file.mkdir();
		
		return dateFolder;
	}
	
	// 날짜 기반 파일명 생성
	public static String makeDateFileName(MultipartFile mf) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date());
		fileName += String.format("%04d", new Random().nextInt(10000));
		
		String extension = mf.getOriginalFilename();
		extension = extension.substring(extension.lastIndexOf('.'));
		fileName += extension;
		
		return fileName;
	}
}
