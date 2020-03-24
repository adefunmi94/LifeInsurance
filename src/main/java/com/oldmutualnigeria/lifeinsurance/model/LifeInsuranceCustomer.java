package com.oldmutualnigeria.lifeinsurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Spring;
import javax.validation.constraints.NotBlank;

import com.oldmutualnigeria.lifeinsurance.service.PaymentFrequency;

@Entity
@Table(name="lifeAssured")
public class LifeInsuranceCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message= "required")
	@Column(name="customer-name")
	private String name;
	
	@NotBlank(message= "required")
	@Column(name="phone")
	private String phone;
	
	@NotBlank(message= "required")
	@Column(name="gender")
	private String gender;

	private String escalation;

	private String cashBack;

	@NotBlank(message= "required")
	@Column(name="yearOfBirth")
	private int yearOfBirth;
	
	@NotBlank(message= "required")
	@Column(name="monthOfBirth")
	private int monthOfBirth;
	
	@NotBlank(message= "required")
	@Column(name="dayOfBirth")
	private int dayOfBirth;

	private Integer Age;
	
	@NotBlank(message= "required")
	@Column(name="sum-assured")
	private Integer sumAssured;
	
	@NotBlank(message= "required")
	@Column(name="term-cover")
	private int termOfCover;
	
	private PaymentFrequency paymentFrequency;

	public LifeInsuranceCustomer(){}
	
	public LifeInsuranceCustomer(int id, String name, String phone, String gender, int yearOfBirth, int monthOfBirth,
			int dayOfBirth, int sumAssured, int termOfCover, PaymentFrequency paymentFrequency) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.yearOfBirth = yearOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.dayOfBirth = dayOfBirth;
		this.sumAssured = sumAssured;
		this.termOfCover = termOfCover;
		this.paymentFrequency = paymentFrequency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getMonthOfBirth() {
		return monthOfBirth;
	}

	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public int getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public Integer getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(Integer sumAssured) {
		this.sumAssured = sumAssured;
	}

	public int getTermOfCover() {
		return termOfCover;
	}

	public void setTermOfCover(int termOfCover) {
		this.termOfCover = termOfCover;
	}

	public PaymentFrequency getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(PaymentFrequency paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public String getCashBack() { return cashBack; }

	public void setCashBack(String cashBack) {
		this.cashBack = cashBack;
	}

	public Integer getAge() {return Age; }

	public void setAge(Integer age){
		this.Age = age;
	}

	//Funmi please implement this method to calculate age based on the date of birth
	private void calculateAge() {

		return;
	}

	public String getEscalation() {	return escalation; }

	public void setEscalation(String escalation) {this.escalation = escalation; }


	@Override
	public String toString() {
		return "LifeInsuranceCustomer [id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender
				+ ", yearOfBirth=" + yearOfBirth + ", monthOfBirth=" + monthOfBirth + ", dayOfBirth=" + dayOfBirth
				+ ", sumAssured=" + sumAssured + ", termOfCover=" + termOfCover + ", paymentFrequency="
				+ paymentFrequency + "]";
	}

	
	
	
	}
