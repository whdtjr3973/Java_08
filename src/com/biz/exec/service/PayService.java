package com.biz.exec.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PayMentVO;

public class PayService {

	Scanner scan ;
	
	List<PayMentVO> paperList;
	
	int intPayTotal;
	public PayService() {
		paperList = new ArrayList<PayMentVO>();
		scan = new Scanner(System.in);
		intPayTotal = 0;
	}
	public void payCalc() {
		System.out.print("급여액 >>");
		String strPay = scan.nextLine();
		int intPay = Integer.valueOf(strPay);
		intPayTotal = intPay; // Integer.valueOf(strPay);
		
		int intMoney = 500000;
		
		int sw = 1;
		while(intPay > 0 ) {
		
			PayMentVO vo = new PayMentVO();
			
			int intPaper = 
					(int)(intPay/intMoney);
			vo.intMoney = intMoney;
			vo.paper = intPaper;
			paperList.add(vo);
			
			intPay -= (intPaper * intMoney);
			
			if(sw > 0 ) intMoney /= 5;
			else intMoney /=2;
			
			sw *= (-1);
		}
		
	}
	
	public void printReport(String payReport) throws IOException {
			FileWriter fileWriter = new FileWriter(payReport);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("==========================");
			printWriter.println("총급여 : " + this.intPayTotal);
			printWriter.println("--------------------------");
			printWriter.println("액면가\t\t매수");
			printWriter.println("--------------------------");
			for(PayMentVO vo : paperList) {
				printWriter.printf("%7d\t\t%3d\n", vo.intMoney,vo.paper);
			}
			printWriter.println("==========================");
			printWriter.flush();
			printWriter.close();
			
			System.out.println("급여명세서 파일 저장 완료!!");

	}
	
}
