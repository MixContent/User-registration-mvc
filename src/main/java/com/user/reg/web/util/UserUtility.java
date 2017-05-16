package com.user.reg.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.user.reg.web.dao.UserDaoImpl;
import com.user.reg.web.dto.UserDTO;
import com.user.reg.web.model.AttachmentModel;
import com.user.reg.web.model.UserModel;

@Component
public class UserUtility {
	@Autowired
	private UserDaoImpl daoImpl;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public UserModel mapDtoToModel(UserDTO userDTO) {
		AttachmentModel attachmentModel = new AttachmentModel();
		attachmentModel.setImageFile(daoImpl.getImageBlob(userDTO
				.getImageFile()));
		UserModel model = new UserModel(userDTO.getName(), userDTO.getSex(),
				userDTO.getContact(), userDTO.getEmail(), userDTO.getZip(),
				userDTO.getAddress(), userDTO.getHobbies(),
				userDTO.getQualification(), convert(userDTO.getDob()));
		model.setAttachmentModel(attachmentModel);
		return model;
	}

	public List<UserDTO> getDtoFromModel(List<UserModel> model) {
		List<UserDTO> userDTOs = new ArrayList<>();
		UserDTO userDTO = null;
		for (UserModel userModel : model) {
			userDTO = new UserDTO();
			userDTO.setName(userModel.getName());
			userDTO.setContact(userModel.getContact());
			userDTO.setAddress(userModel.getAddress());
			userDTO.setEmail(userModel.getEmail());
			userDTO.setHobbies(userModel.getHobbies());
			userDTO.setQualification(userModel.getQualification());
			userDTO.setSex(userModel.getSex());
			userDTO.setZip(userModel.getZip());
			userDTO.setDob(sdf.format(userModel.getDate()));
			/*userDTO.setImageFile((MultipartFile) userModel.getAttachmentModel()
					.getImageFile());*/
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	private Date convert(String date) {
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// Add logger

		}
		return new java.sql.Date(d.getTime());
	}
}
