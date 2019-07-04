package com.sunaudio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.*;

public class SunAudio {

	public static void main(String[] args) {
		//获得声音文件
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./3.au");
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //输出调用堆栈跟踪信息
			System.out.println("找不到声音文件");
		}
		BufferedInputStream sb = new BufferedInputStream(fis);
		//打开声音流
		AudioStream as = null;
		try {
			as = new AudioStream(sb);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读写错误");
		}
		
		AudioData ad = null;
		try {
			ad = as.getData();	//获得声音数据
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件过大或装入了不支持的格式");
		}
		
		if(ad != null) {
			//播放声音文件
			AudioDataStream ads = new AudioDataStream(ad);
			AudioPlayer.player.start(ads);
		}
	}

}
