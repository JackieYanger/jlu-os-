package 操作系统课程设计GUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FIFO {
	 public static String []columnNames={"StorageID","StoreNum","MerchID"};
	 public static Object[][] infor=new String[100][14];
	 public static JTable table_1=new JTable(infor,columnNames);
	 public static DefaultTableModel model = new DefaultTableModel(infor,columnNames){
	 	 private static final long serialVersionUID=1L;
	 	 public boolean isCellEditable(int row,int column){
	 		 return false;
	 	 }
	  };
}
