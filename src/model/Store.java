package model;

public class Store 
{
	private String Waid;
	private String Meid;
	private String name;
	private int sum;
	private String person;
	public Store(String Waid ,String Meid,String name,int sum,String person)
	{
		this.Meid=Meid;
		this.Waid=Waid;
		this.name=name;
		this.sum=sum;
		this.person=person;
	}
	public Store() 
	{
		
	}
	public String getWaid() {
		return Waid;
	}
	public void setWaid(String waid) {
		Waid = waid;
	}
	public String getMeid() {
		return Meid;
	}
	public void setMeid(String meid) {
		Meid = meid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	
}
