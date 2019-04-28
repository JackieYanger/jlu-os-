package 操作系统课程设计;

public class PageInfor {
  private String p_code;
  public boolean lack;
  public boolean visit;
  public PageInfor()
  {
	  lack=false;
	  visit=false;
  }
  public String getP_code() {
	return p_code;
}


  public void setP_code(String p_code) {
	this.p_code = p_code;
}
  
}
