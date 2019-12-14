package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "PersonDetails")
public class PersonDetailsVo {
	@DynamoDBHashKey(attributeName = "Id")
	private int id;
	@DynamoDBAttribute(attributeName = "FirstName")
	private String firstName;
	@DynamoDBAttribute(attributeName = "LastName")
	private String lastName;
	@DynamoDBAttribute(attributeName = "Age")
	private int age;
	@DynamoDBAttribute(attributeName = "Address")
	private String address;
	@DynamoDBAttribute(attributeName = "Phone")
	private String phoneNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "PersonDetailsVo [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + ", phoneNo=" + phoneNo + "]";
	}
}
