package com.exam.api.model;

import org.beetl.sql.core.annotatoin.AutoID;

import java.sql.Date;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:54 2018/9/12
 */
public class Employees {
	@AutoID
	private Integer empNo;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private Date hireDate;
	private Long uid;




	public Integer getEmpNo() {
		return empNo;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public enum  Gender{
		WOMEN(1,"女士"),
		MEN(2,"男士");

		private int value;
		private String text;

		Gender(int value,String text){
			this.value=value;
			this.text=text;
		}

		public int getType() {
			return this.value;
		}

		public String getText() {
			return this.text;
		}
	}

}
