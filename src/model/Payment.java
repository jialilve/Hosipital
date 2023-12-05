package model;

public class Payment {
   private String Pid;
   public String getDoname() {
	return Doname;
}
public void setDoname(String doname) {
	Doname = doname;
}
public String getDename() {
	return Dename;
}
public void setDename(String dename) {
	Dename = dename;
}
private String state;
   private float price1;
   private float price2;
   private float price;
   private String rxid;
   private String Doname;
   private String Dename;
   public Payment()
   {
	   
   }
   public Payment(String Doname,String Dename,String Pid,float price1,float price2,float prcie,String rxid,String state)
   {
	   this.Pid=Pid;
	   this.Dename=Dename;
	   this.Doname=Doname;
	   this.price1=price1;
	   this.price2=price2;
	   this.price=price;
	   this.state=state;
	   this.rxid=rxid;
   }
public String getPid() {
	return Pid;
}
public void setPid(String pid) {
	Pid = pid;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public float getPrice1() {
	return price1;
}
public void setPrice1(float price1) {
	this.price1 = price1;
}
public float getPrice2() {
	return price2;
}
public void setPrice2(float price2) {
	this.price2 = price2;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getRxid() {
	return rxid;
}
public void setRxid(String rxid) {
	this.rxid = rxid;
}
   
}
