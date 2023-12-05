package model;

public class Medicine {
   private String Meid;
   private String Mename;
   private float Price;
   private String Firm;
   private String Type;
   private String Waid;
   private float Price1;
   private int Snumber;
   public Medicine()
   {
	   
   }
   public Medicine(String meid,String mename,float price,String firm,String type,String waid,float price1,int sum)
   {
	   this.Meid=meid;
	   this.Mename=mename;
	   this.Price=price;
	   this.Firm=firm;
	   this.Type=type;
	   this.Waid=waid;
	   this.Price1=price1;
	   this.Snumber=sum;
   }
public String getMeid() {
	return Meid;
}
public void setMeid(String meid) {
	Meid = meid;
}
public String getMename() {
	return Mename;
}
public void setMename(String mename) {
	Mename = mename;
}
public float getPrice() {
	return Price;
}
public void setPrice(float price) {
	Price = price;
}
public String getFirm() {
	return Firm;
}
public void setFirm(String firm) {
	Firm = firm;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getWaid() {
	return Waid;
}
public void setWaid(String waid) {
	Waid = waid;
}
public float getPrice1() {
	return Price1;
}
public void setPrice1(float price1) {
	Price1 = price1;
}
public int getSnumber() {
	return Snumber;
}
public void setSnumber(int snumber) {
	Snumber = snumber;
}
   
}
