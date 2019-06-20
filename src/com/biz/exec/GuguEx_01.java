package com.biz.exec;

public class GuguEx_01 {

	public static void main(String[] args) {
		System.out.println("구구단");
		
		for(int i = 2; i <=9 ; i++) {
			System.out.print("=================");
		}
		System.out.println();
		for(int i = 2; i <=9 ; i++) {
			System.out.printf("%3d 단\t\t", i);
		}
		System.out.println();
		for(int i = 2; i <=9 ; i++) {
			System.out.print("-----------------");
		}
		System.out.println();
		for(int j = 1; j <=9 ; j++) {
			
			for(int i = 2 ; i <=9 ; i++) {
				System.out.printf("%2d x %2d = %2d\t", i,j,j*i);
			}
				System.out.println();
		}
		
	}
}
