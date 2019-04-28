package 操作系统课程设计GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import 操作系统课程设计.PageInfor;

public class LRUListener implements ActionListener{
	static {
		 GUINM();		  
		 
	}
	public static void GUINM() {
	   	 try {
	   		 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	   		// UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceFieldOfWheatLookAndFeel");
			//UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	 public static JPanel panel_1= new JPanel(new BorderLayout());
	 public static JScrollPane jsp_1=new JScrollPane(panel_1);
	 public static JPanel p = new JPanel(new GridLayout(2,1));
	 public static String []columnNames={"时","间"," "," ","0","1"," ","2"," ","3"," ","4"," ","5"," ","6"," ","7"," ","8"," ","9"," ","10"," "};
	 public static Object[][] infor=new String[11][25];
	 public static JTable table_1=new JTable(infor,columnNames);
	 
	 public static String []columnNames_2={"1","2","3 ","4","5","6","7","8","9","10"};
	 public static Object[][] infor_2=new String[2][10];
	 public static JTable table_2=new JTable(infor_2,columnNames_2);
	 public static DefaultTableModel model = new DefaultTableModel(infor,columnNames){
	 	 private static final long serialVersionUID=1L;
	 	 public boolean isCellEditable(int row,int column){
	 		 return false;
	 	 }
	  };
	public static Random random = new Random();
	public static JFrame f = new JFrame("LRU");
	public static JButton b = new JButton("随机生成逻辑地址");
	public static JButton b1= new JButton("退出");
	public static String []temp = new String[10];
	public static JPanel pm = new JPanel(new BorderLayout());
	public static String randomHexString(int len)  {
		try {
			StringBuffer result = new StringBuffer();
			for(int i=0;i<len;i++) {
				result.append(Integer.toHexString(new Random().nextInt(16)));
			}
			return result.toString().toUpperCase();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
		
	}

	static {
		f.setSize(1100, 300);
		f.setLayout(new BorderLayout());
		jsp_1=new JScrollPane(table_1);
		
		infor[1][0]="   访";
		infor[1][1]="   问";
		infor[1][2]="   请";
		infor[1][3]="   求";
		infor[1][4]=" ";
		for(int i=5;i<25;i+=2) {
			infor[1][i]="暂无数据";
			infor[1][i+1]=" ";
		}
		infor[2][0]="   物";
		infor[3][0]="   理";
		infor[4][0]="   块";
		infor[5][0]="   号";
		infor[2][2]="   0";
		infor[3][2]="   1";
		infor[4][2]="   2";
		infor[5][2]="   3";
		infor[6][0]="   缺";
		infor[6][1]="   页";
		infor[6][2]="   状";
		infor[6][3]="   态";		
		infor[8][0]="   驻";
		infor[8][1]="   留";
		infor[8][2]="   页";
		infor[8][3]="   面";
		infor[9][0]="   的";
		infor[9][1]="   页";
		infor[9][2]="   表";
		infor[9][3]="   项";
		
	}
	  public static String conv(String ins) {
		   switch(ins) {
		      case "0":  return "A"; 
		      case "1":  return "B"; 
		      case "2":  return "C"; 
		      case "3":  return "D";
		      case "4":  return "E"; 
		      case "5":  return "F"; 
		      case "6":  return "0";
		      case "7":  return "1"; 
		      case "8":  return "2"; 
		      case "9":  return "3";
		      case "A":  return "4"; 
		      case "B":  return "5";
		      case "C":  return "6"; 
		      case "D":  return "7"; 
		      case "E":  return "8"; 
		      case "F":  return "9"; 
		      default:return "错误的返回值";	      
		   }
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b.addActionListener(new ActionListener() {
			JFrame  jf  =new JFrame();
		    JDialog jd = new JDialog(jf);
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("FIFO算法");
				//初始化
				jd.setVisible(false);
				for(int i=5;i<25;i++) {
					infor[6][i]="";
					for(int m=0;m<4;m++) {
						infor[m+7][i]="";
						table_1.updateUI();
					    }
					table_1.updateUI();
				}
				   
				int index=0;
				for(int i=5;i<25;i+=2) {
					infor[1][i]=randomHexString(4)+"H";
					temp[index]=infor[1][i].toString();
					index++;
					table_1.updateUI();
				}
				ArrayList<String> page =  new ArrayList<String>();
				ArrayList<Integer>  arr = new ArrayList<Integer>();
				//初始化
				//System.out.println("先进行初始化：");
				String []input_s = new String[4];
				for(int i=0;i<4;i++) {
					PageInfor p = new PageInfor();
					//Scanner in = new Scanner(System.in);
					//String input = in.next();
					int id = 0;
					while(true) {
					    id = random.nextInt(10);
					    if(!arr.contains(id)) {					       
						       arr.add(id);
						    }
						if(id<10) break;
					}
				    input_s[i]=temp[id];
				    for(int k=0;k<page.size();k++) {
					    
				    	while(temp[id].substring(0, 1).equals(input_s[k].substring(0, 1))) {
				    	input_s[i]=temp[random.nextInt(10)];
				    	break;
				        }
				    }
					p.setP_code(input_s[i]);
					page.add(p.getP_code());
				}
				infor[2][4]=input_s[0];
				infor[3][4]=input_s[1];
				infor[4][4]=input_s[2];
				infor[5][4]=input_s[3];
				for(int i=2;i<6;i++) {
					infor[i][2]=conv(input_s[i-2].substring(0,1));		
					System.out.println(infor[i][2]);
					table_1.updateUI();
					}
				table_1.updateUI();
				int time=0;
				int cycle=0;
				
			    JScrollPane   js = new JScrollPane();
			    JPanel jp= new JPanel();
			   
			    js=new JScrollPane(table_2);
			    jd.setTitle("生成的逻辑页面及其对应的物理页号");			  
			    for(int i=0;i<10;i++) {
			          infor_2[0][i]=temp[i];
			          //System.out.println(infor_2[0][i]+" "+temp[i].substring(0, 4));
			          infor_2[1][i]=conv(temp[i].substring(0, 1))+temp[i].substring(1, 4)+"H";
			    }			   
			    jp.add(js);
				jd.add(jp);
				jd.setLocation(300, 300);
				jd.setSize(470,150);
				jd.setVisible(true);
				for(int i=0,tps=5;i<10&&tps<25;i++,tps+=2) {
					
					System.out.println("当前时间："+(++time)+"  请输入要访问的页号:"+temp[i]);
//					Scanner in = new Scanner(System.in);
					String input = temp[i];
					int temp=-1;
					for(int j=0;j<page.size();j++) {
						if(page.get(j).equals(input))
						{
							 for(int m=0;m<4;m++) {
									infor[m+2][tps]=page.get(m);
									table_1.updateUI();
							  }		
							   ArrayList<String> tps_1 = new ArrayList<String>();
							   temp=j;
							   
							    for(int p=0;p<page.size();p++) {
							    	tps_1.add(page.get(p));			    	
							    }
							    tps_1.remove(temp);
							    for(int p=1;p<page.size();p++) {
							    	page.set(p, tps_1.get(p-1));
							    }
							    page.set(0, input);
							
											
							 for(int m=0;m<4;m++) {
									infor[m+7][tps]=page.get(m);
									table_1.updateUI();
								    }		
							 System.out.println("未发生缺页");
							break;
						}
					}
					if(temp==-1) {
					 for(int m=0;m<4;m++) {
							infor[m+2][tps]=page.get(m);
							table_1.updateUI();
					}
					   ArrayList<String> tp = new ArrayList<String>();
					    for(int p=0;p<page.size();p++) {
					    	tp.add(page.get(p));			    	
					    }
					    tp.remove(page.size()-1);
					    for(int p=1;p<page.size();p++) {
					    	page.set(p, tp.get(p-1));
					    }
					    page.set(0, input);
					   			 					  
					    infor[6][tps]="缺页";
					    for(int m=0;m<4;m++) {
						infor[m+7][tps]=page.get(m);
						table_1.updateUI();
					    }			
					    System.out.println("发生缺页");		
					}
					System.out.println("时刻"+time+"的页面访问情况为：");
					for(int k=0;k<page.size();k++) {
						System.out.print(page.get(k)+" ");
					}
					System.out.println("");
				}
				
			}
			
		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		pm.add(jsp_1);
		p.add(b);
		p.add(b1);
		pm.add(p,BorderLayout.NORTH);
		f.add(pm);
		f.setLocation(300, 300);
		f.setVisible(true);
	}
   public static void main(String[] args) {
	   Random random = new Random();
	   for(int i=0;i<10;i++)
	   System.out.println(random.nextInt(10));
}
}