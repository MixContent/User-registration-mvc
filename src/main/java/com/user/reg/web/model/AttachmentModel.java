package com.user.reg.web.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Attachment_Table")
public class AttachmentModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7592301854725064206L;

	@Id
	@GenericGenerator(name = "aid", strategy = "increment")
	@GeneratedValue(generator = "aid")
	@Column(name="attachmentId")
	private int id;
	@Lob
	private Blob imageFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob imageFile) {
		this.imageFile = imageFile;
	}

}
