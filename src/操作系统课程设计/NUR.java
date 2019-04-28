package 操作系统课程设计;

import java.util.ArrayList;
import java.util.Scanner;

public class NUR {
    public static void main(String[] args) {
    	System.out.println("NUR算法");
		ArrayList<PageInfor> page =  new ArrayList<PageInfor>();
		//初始化
		System.out.println("先进行初始化：");
		for(int i=0;i<4;i++) {
			PageInfor p = new PageInfor();
			Scanner in = new Scanner(System.in);
			String input = in.next();
			p.lack=false;
			p.visit=false;
			p.setP_code(input);		    
			page.add(p);
		}
		int time=0;
		int cycle=0;
		int locate=0;
//		System.out.println(page.get(2).getP_code().equals("c"));
		for(int i=0;i<10;i++) {
			System.out.println("当前时间："+(++time)+"  请输入要访问的页号和访问形式:");
			Scanner in = new Scanner(System.in);
			String input = in.next();
		
			
			Scanner ins = new Scanner(System.in);
			String inputs = ins.next();
			
			
			int temp=-1;
			int j=0;
			for( j=0;j<page.size();j++){			
				if(page.get(j).getP_code().equals(input))
				{				
					cycle=temp=j;	
					if(inputs.equals("r")) {
						if(page.get(j).visit==false&&page.get(j).lack==false)
							page.get(j).visit=true;				
					}
					else if(inputs.equals("w")) {
						if(page.get(j).visit==false&&page.get(j).lack==false) {
							page.get(j).visit=page.get(j).lack=true;
						}
							
					}
					System.out.println("未发生缺页");
					break;
				}
				
			}
			
			if(temp==-1) {
                //locate=j;
			while(true){		
					if(page.get(locate%page.size()).lack==false&&page.get(locate%page.size()).visit==false) {
						page.get(locate%page.size()).setP_code(input);
						if(inputs.equals("r"))
						page.get(locate%page.size()).visit=true;		
						else if(inputs.equals("w")) {
						page.get(locate%page.size()).visit=true;
						page.get(locate%page.size()).lack=true;
						}
						locate++;	
						break;
					}
					if(page.get(locate%page.size()).lack==false&&page.get(locate%page.size()).visit==true) {				
						page.get(locate%page.size()).visit=false;														
						locate++;	
						continue;
					}
					if(page.get(locate%page.size()).lack==true&&page.get(locate%page.size()).visit==false) {				
						page.get(locate%page.size()).lack=false;														
						locate++;	
						continue;
					}
					if(page.get(locate%page.size()).lack==true&&page.get(locate%page.size()).visit==true) {				
						page.get(locate%page.size()).visit=false;														
						locate++;	
						continue;
					}
			}
			     System.out.println("发生缺页");
			}
			System.out.println("时刻"+time+"的页面访问情况为：");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k).getP_code()+" "+page.get(k).visit);
				System.out.println(page.get(k).lack);
			}
		}
		
	}
}
