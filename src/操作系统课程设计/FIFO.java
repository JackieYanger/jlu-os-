package ����ϵͳ�γ����;

import java.util.ArrayList;
import java.util.Scanner;

public class FIFO {
   public static void fifo() {
	   
   }
	public static void main(String[] args) {
		System.out.println("FIFO�㷨");
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
		int cycle=0;
		for(int i=0;i<10;i++) {
			System.out.println("��ǰʱ�䣺"+(++time)+"  ������Ҫ���ʵ�ҳ��:");
			Scanner in = new Scanner(System.in);
			String input = in.next();
			int temp=-1;
			for(int j=0;j<page.size();j++) {
				if(page.get(j).equals(input))
				{
					temp=j;
					System.out.println("δ����ȱҳ");
					break;
				}
			}
			if(temp==-1) {
			    page.set(cycle, input);
			    System.out.println("����ȱҳ");
			    cycle++;
			    cycle=cycle%4;
			}
			System.out.println("ʱ��"+time+"��ҳ��������Ϊ��");
			for(int k=0;k<page.size();k++) {
				System.out.print(page.get(k)+" ");
			}
			System.out.println("");
		}
		
	}
}
