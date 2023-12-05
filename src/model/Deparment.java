package model;

public class Deparment 
{
	    private String id;
	    private String name;
	    private int sum;
	    private String text;
	    public Deparment()
	    {
	    	
	    }
	    public Deparment(String id ,String name,int sum,String text)
	    {
	    	this.id=id;
	    	this.name=name;
	    	this.text=text;
	    	this.sum=sum;
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
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public void setAge(int valueAt) {
			// TODO Auto-generated method stub
			
		}
}
