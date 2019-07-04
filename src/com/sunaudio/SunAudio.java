package com.sunaudio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.*;

public class SunAudio {

	public static void main(String[] args) {
		//��������ļ�
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./3.au");
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //������ö�ջ������Ϣ
			System.out.println("�Ҳ��������ļ�");
		}
		BufferedInputStream sb = new BufferedInputStream(fis);
		//��������
		AudioStream as = null;
		try {
			as = new AudioStream(sb);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���д����");
		}
		
		AudioData ad = null;
		try {
			ad = as.getData();	//�����������
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ������װ���˲�֧�ֵĸ�ʽ");
		}
		
		if(ad != null) {
			//���������ļ�
			AudioDataStream ads = new AudioDataStream(ad);
			AudioPlayer.player.start(ads);
		}
	}

}
