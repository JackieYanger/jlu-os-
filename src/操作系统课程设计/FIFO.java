package 操作系统课程设计;

import java.util.ArrayList;
import java.util.Scanner;

public class FIFO {
   public static void fifo() {
	   
   }
	public static void main(String[] args) {
		System.out.println("FIFO算法");
		ArrayList<String> page =  new ArrayList<String>();
		//初始化
		System.out.println("先进行初始化：");
		for(int i=0;i<4;i++) {
			PageInfor p = new PageInfor();
			Scanner in = new Scanner(System.in);
			String input = in.next();
			p.setP_code(input);
			page.add(p.getP_code());
		}
		int time=0;
		int cycle=0;
		for(int i=0;i<10;i++) {
			System.out.println("当前时间："+(++time)+"  请输入要访问的页号:");
			Scanner in = new Scanner(System.in);
			String input = in.next();
			int temp=-1;
			for(int j=0;j<page.size();j++) {
				if(page.get(j).equals(input))
				{
					temp=j;
					System.out.println("未发生缺页");
					break;
				}
			}
			if(temp==-1) {
			    page.set(cycle, input);
			    System.out.println("发生缺页");
			    cycle++;
			    cycle=cycle%4;
			}
			System.out.println("时刻"+time+"的页面访问情况为：");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k)+" ");
			}
			System.out.println("");
		}
		
	}
}
