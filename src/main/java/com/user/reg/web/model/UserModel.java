package com.user.reg.web.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "User_Table")
public class UserModel {
	@Id
	@GenericGenerator(name = "uid", strategy = "increment")
	@GeneratedValue(generator = "uid")
	@Column(name = "USERID")
	private int id;
	private String name;
	private String sex;
	private String contact;
	private String email;
	private int zip;
	private String address;
	private String hobbies;
	private String qualification;
	@Column(name="d")
	private Date date;
	@ManyToOne(targetEntity = AttachmentModel.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_attach_fk", referencedColumnName = "attachmentId")
	private AttachmentModel attachmentModel;

	public UserModel(String name, String sex, String contact, String email,
			int zip, String address, String hobbies, String qualification,
			Date date) {
		this.name = name;
		this.sex = sex;
		this.contact = contact;
		this.email = email;
		this.zip = zip;
		this.address = address;
		this.hobbies = hobbies;
		this.qualification = qualification;
		this.date = date;
	}

	public UserModel() {
		/*
		 * Here i used constructor for easy mapping but it's not recommended
		 * always getter and setter is preferable
		 */
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AttachmentModel getAttachmentModel() {
		return attachmentModel;
	}

	public void setAttachmentModel(AttachmentModel attachmentModel) {
		this.attachmentModel = attachmentModel;
	}
}
