package ����ϵͳ�γ����;

import java.util.ArrayList;
import java.util.Scanner;

public class LRU {

	public static void main(String[] args) {
		/*ҳ�������������һ�η��ʵ�ʱ��������β��������δʹ�õġ�
         �ҳ��ջ������ҳ��ʱ������ҳ��ѹ��ջ���������֮ǰ��ͬ��ҳ�ţ�
         ȱҳʱ���û�ջ�׵�ҳ�档
         */
	    System.out.println("LRU");
		ArrayList<String> page =  new ArrayList<String>();
		//��ʼ��
		System.out.println("�Ƚ��г�ʼ����");
		for(int i=0;i<4;i++) {
			PageInfor p = new PageInfor();
			Scanner in = new Scanner(System.in);
			String input = in.next();
			p.setP_code(input);
			page.add(p.getP_code());
		}
		int time=0;
		
		for(int i=0;i<10;i++) {
			System.out.println("��ǰʱ�䣺"+(++time)+"  ������Ҫ���ʵ�ҳ��:");
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
					   
					System.out.println("δ����ȱҳ");
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
			  
			    System.out.println("����ȱҳ");
			    
			}
			System.out.println("ʱ��"+time+"��ҳ��������Ϊ��");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k)+" ");
			}
			System.out.println("");
		}
		
    }
}
