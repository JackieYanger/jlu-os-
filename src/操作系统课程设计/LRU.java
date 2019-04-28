package 操作系统课程设计;

import java.util.ArrayList;
import java.util.Scanner;

public class LRU {

	public static void main(String[] args) {
		/*页面链表，按照最近一次访问的时间排序，链尾是最近最久未使用的。
         活动页面栈：访问页面时，将此页号压入栈顶，并抽调之前相同的页号，
         缺页时，置换栈底的页面。
         */
	    System.out.println("LRU");
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
		
		for(int i=0;i<10;i++) {
			System.out.println("当前时间："+(++time)+"  请输入要访问的页号:");
			Scanner in = new Scanner(System.in);
			String input = in.next();
			int temp=-1;
			for(int j=0;j<page.size();j++) {
				if(page.get(j).equals(input))
				{
					   ArrayList<String> tps = new ArrayList<String>();
					   temp=j;
					   
					    for(int p=0;p<page.size();p++) {
					    	tps.add(page.get(p));			    	
					    }
					    tps.remove(temp);
					    for(int p=1;p<page.size();p++) {
					    	page.set(p, tps.get(p-1));
					    }
					    page.set(0, input);
					   
					System.out.println("未发生缺页");
					break;
				}
			}
			if(temp==-1) {
			    ArrayList<String> tp = new ArrayList<String>();
			    for(int p=0;p<page.size();p++) {
			    	tp.add(page.get(p));			    	
			    }
			    tp.remove(page.size()-1);
			    for(int p=1;p<page.size();p++) {
			    	page.set(p, tp.get(p-1));
			    }
			    page.set(0, input);
			  
			    System.out.println("发生缺页");
			    
			}
			System.out.println("时刻"+time+"的页面访问情况为：");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k)+" ");
			}
			System.out.println("");
		}
		
    }
}
