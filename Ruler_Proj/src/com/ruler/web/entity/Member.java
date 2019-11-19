package com.ruler.web.entity;

public class Member
{
	private int id;
	private String userName;
	private String pwd;
	private String phone;
	private String email;
	private int height;
	private int weight;
	private String gender;
	private int age;
	private String bodyshape;
	
	public Member()
	{
		
	}
	
	public Member(int id, String userName, String pwd, String phone, String email, int height, int weight,
			String gender, int age, String bodyshape)
	{
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.age = age;
		this.bodyshape = bodyshape;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getBodyshape()
	{
		return bodyshape;
	}

	public void setBodyshape(String bodyshape)
	{
		this.bodyshape = bodyshape;
	}

	@Override
	public String toString()
	{
		return "Member [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", phone=" + phone + ", email=" + email
				+ ", height=" + height + ", weight=" + weight + ", gender=" + gender + ", age=" + age + ", bodyshape="
				+ bodyshape + "]";
	}
	
	
}
