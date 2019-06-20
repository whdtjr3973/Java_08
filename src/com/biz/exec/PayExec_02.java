package com.biz.exec;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PayMentVO;

public class PayExec_02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("급여금액을 입력하세요");
		String strPay = scan.nextLine();
		int intPay = Integer.valueOf(strPay);

		List<PayMentVO> paperList = new ArrayList<PayMentVO>();

		int intMoney = 50000;

		int sw = 1;
		while (intMoney > 5) {

			PayMentVO pVO = new PayMentVO();

			int intPaper = (int) (intPay / intMoney); // 액면가에 대한 화폐매수 계산

			// setter를 사용하지만 변수를 public으로 선언했기때문에
			// 직접대입이 가능하다
			pVO.intMoney = intMoney;
			pVO.paper = intPaper;
			paperList.add(pVO);

			// 액면가 만큼 제외한 급여 금액생성
			intPay -= (intMoney * intPaper);

			if (sw > 0)
				intMoney /= 5;
			else
				intMoney /= 2;

			sw  *=  (-1);
		}
		
		//총 급여액을 계산하는 방법
		
		int intTotalpay = 0;
		for(PayMentVO vo : paperList) {
			intTotalpay += (vo.intMoney* vo.paper);
		}
		
		String payReport = "src/com/biz/exec/급여명세서.txt";
		try {
			FileWriter fileWriter = new FileWriter(payReport);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("==========================");
			printWriter.println("총급여 : " + intTotalpay);
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}

}
