package model;

public class R_X 
{
     private String rxid;
     private String Pid;
     private String Pname;
     private String Mename;
     private int sum;
     public R_X()
     {
    	 
     }
     public R_X(String rxid,String Pid,String Pname,String Mename,int sum)
     {
    	 this.rxid=rxid;
    	 this.Pid=Pid;
    	 this.Pname=Pname;
    	 this.Mename=Mename;
    	 this.sum=sum;
     }
	public String getRxid() {
		return rxid;
	}
	public void setRxid(String rxid) {
		this.rxid = rxid;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getMename() {
		return Mename;
	}
	public void setMename(String mename) {
		Mename = mename;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
