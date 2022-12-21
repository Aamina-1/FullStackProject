package com.example.FullProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Data
@Entity
@Table(name="studentTable")
public class Student {
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String favSub;
	@Id//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int rollNum;
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getFavSub() {
		return favSub;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setFavSub(String favSub) {
		this.favSub = favSub;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
}

