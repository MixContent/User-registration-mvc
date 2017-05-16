package com.user.reg.web.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.user.reg.web.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory factory;

	public void saveUser(UserModel userModel) {
		getSession().save(userModel);

	}

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

	public Blob getImageBlob(MultipartFile file) {
		Blob blob = null;
		try {
			blob = Hibernate.getLobCreator(getSession()).createBlob(
					file.getInputStream(), 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blob;
	}

	/* This method will return all of user and image */
	@SuppressWarnings("unchecked")
	public List<UserModel> getUser() {
		final String HQL_JOIN = "select a.imageFile, u.name,u.sex,u.contact,u.email,u.address,u.zip,u.hobbies,u.qualification,u.d from user_table u, attachment_table a where u.USERID=u.user_attach_fk";
		return getSession().createSQLQuery(HQL_JOIN).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> getUsers() {
		return getSession().createCriteria(UserModel.class).list();
	}
}
