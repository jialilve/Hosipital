package model;

public class Deparst 
{
	   private String Dename;
	   private String Pname;
	   private String time;
	   private String Doname;
	   private String Pid;
	   public Deparst()
	   {
		   
	   }
	   public Deparst(String time,String Doname,String Dename,String Pid,String Pname)
	   {
		   this.time=time;
		   this.Dename=Dename;
		   this.Doname=Doname;
		   this.Pname=Pname;
		   this.Pid=Pid;
	   }
	public String getDename() {
		return Dename;
	}
	public void setDename(String dename) {
		Dename = dename;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDoname() {
		return Doname;
	}
	public void setDoname(String doname) {
		Doname = doname;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	   
	   
}
