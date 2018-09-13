package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.TUser;
import com.example.demo.repository.TUserRepository;
import com.example.demo.utils.CurrentUser;

@Service
public class UserService {
	
	@Value("${user.file.path}")
	private String imageFilePath;
	
	@Autowired
	private TUserRepository userRepository;
	
	@Autowired
	private CurrentUser currentUser;
	
	public Iterable<TUser> findAll() {
		return userRepository.findAll();
	}
	
	public TUser getUserById(String id) {
		return userRepository.getById(id);
	}
	
	//會員階級
	public List<TUser> premium() {
		return userRepository.getRole("P");
	}
	public List<TUser> manager() {
		return userRepository.getRole("M");
	}
	public List<TUser> temp() {
		return userRepository.getRole("T");
	}	
	public List<TUser> user() {
		return userRepository.getRole("U");
	}		
	
	//審核會員 通過
	public void updateExaminePass(String userId) {
		
	//	if(StringUtils.equals(currentUser.getUserRole(), "M")) {
			TUser db = userRepository.getById(userId);
		
			if(db != null) {
				db.setRole("P");
				userRepository.save(db);
			}
	//	}
	}
	
	public void updateSendExamine(String userId) {
		TUser db = userRepository.getById(userId);
	
		if(db != null) {
			db.setRole("T");
			userRepository.save(db);
		}
	}
	//審核會員 失敗
	public void updateExamineFail(String userId) {
		
		//if(StringUtils.equals(currentUser.getUserRole(), "M")) {
		TUser db = userRepository.getById(userId);
		
			if(db != null) {
				db.setRole("U");
				userRepository.save(db);
			}
		//}
	}
	
	
	public TUser createByImage(TUser user, MultipartFile file) throws IllegalStateException, IOException {
		
		user.setUserPhoto(file.getOriginalFilename());
		TUser rs = this.create(user);
		
        File dir = new File(imageFilePath + "/" + rs.getUserId());
   	    if (!dir.exists()) {
  	      dir.mkdir();
  	    }
   	    
   	    File uploadFile = new File(dir.getPath() + "/" +file.getOriginalFilename());
		
   	    file.transferTo(uploadFile);
   	 
   	    return rs;
   	    
	}
	public List<TUser> selectAll() {
		return userRepository.getAllUser();
	}
	public TUser create(TUser user) {
		user.setUserId(currentUser.getUserId());
		return userRepository.save(user);
	}
	
	
//	public List<TUser> selectPass() {
//		return repository.getrole("P");
//	}
	
	
	
	public void update(TUser user) {
		TUser db = userRepository.getById(user.getUserId());
	
		db.setEmail(user.getEmail());
		db.setMobile(user.getMobile());
		db.setUserAddress(user.getUserAddress());
		db.setUserBirth(user.getUserBirth());
		db.setUserIdentity(user.getUserIdentity());
		db.setUserIntroduction(user.getUserIntroduction());
		db.setUserName(user.getUserName());
		db.setUserPwd(user.getUserPwd());
		db.setUserSex(user.getUserSex());
		db.setStatus(user.getStatus());
		db.setCreateTime(user.getCreateTime());
		db.setUserPhoto(user.getUserPhoto());

		
		userRepository.save(db);
	}
}
