package model;

public class Patient 
{
    private String id;
    private String name;
    private String sex;
    private int age;
    private float account;
    private String disease;
    private String state;
    public Patient()
    {
    	
    }
    public Patient(String id,String name,String sex,int age,float account,String disease,String state)
    {
    	this.id=id;
    	this.name=name;
    	this.sex=sex;
    	this.age=age;
    	this.account=account;
    	this.disease=disease;
    	this.state=state;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getAccount() {
		return account;
	}
	public void setAccount(float account) {
		this.account = account;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
    
}
