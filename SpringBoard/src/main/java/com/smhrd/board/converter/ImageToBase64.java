package com.smhrd.board.converter;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ImageToBase64 {
	
	// 이미지 파일(재료)을 base64로 인코딩한 문자열(결과)로 변경해주는 메서드
	public String convert(File file) throws IOException { // 재료를 () 안에 넣어주기
		// throws IOException => 예외처리 시켜주기
		byte[] fileContent = FileUtils.readFileToByteArray(file); 
		// 재료로 넘겨준 걸 그대로 적기 , readFileToByteArray: 정수가 들어있는 계열로 변환한다는 뜻
		return Base64.getEncoder().encodeToString(fileContent); 
		// 문자열로 변환해줌 (결과) - 문자열이기에 반환타입 String으로 바꿔주기
	}
	
}
