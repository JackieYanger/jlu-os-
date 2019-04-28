package 操作系统课程设计;

import java.util.ArrayList;
import java.util.Scanner;

public class Clock {

	public static void main(String[] args) {
		System.out.println("Clock算法");
		ArrayList<PageInfor> page =  new ArrayList<PageInfor>();
		//初始化
		System.out.println("先进行初始化：");
		for(int i=0;i<4;i++) {
			PageInfor p = new PageInfor();
			Scanner in = new Scanner(System.in);
			String input = in.next();
			p.lack=false;
			p.setP_code(input);		    
			page.add(p);
		}
		int time=0;
		int cycle=0;
		int locate=0;
//		System.out.println(page.get(2).getP_code().equals("c"));
		for(int i=0;i<10;i++) {
			System.out.println("当前时间："+(++time)+"  请输入要访问的页号:");
			Scanner in = new Scanner(System.in);
			String input = in.next();
			int temp=-1;
			int j=0;
			for( j=0;j<page.size();j++){			
				if(page.get(j).getP_code().equals(input))
				{
					cycle=temp=j;					
					if(!page.get(j).lack)
						page.get(j).lack=true;						
					System.out.println("未发生缺页");
					break;
				}
				
			}
			
			if(temp==-1) {
                //locate=j;
			while(true){
				if(page.get(locate%page.size()).lack==false)
				{
					page.get(locate%page.size()).setP_code(input);
					page.get(locate%page.size()).lack=true;
					locate++;	
					
					break;
				}			
				if(page.get(locate%page.size()).lack==true)
				{
					page.get(locate%page.size()).lack=false;
					locate++;						
					continue;
				}
						
			}
			     System.out.println("发生缺页");
			}
			System.out.println("时刻"+time+"的页面访问情况为：");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k).getP_code()+" ");
				System.out.println(page.get(k).lack);
			}
		}
		
    }
}
