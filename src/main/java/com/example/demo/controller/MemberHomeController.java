package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.TUser;
import com.example.demo.formbean.UserFormBean;
import com.example.demo.service.UserService;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.CurrentUser;


@Controller
@RequestMapping(value="/member", method = RequestMethod.GET)
public class MemberHomeController {
    
	@Autowired
	private UserService userService;
	
	@Autowired
	private CurrentUser currentuser;
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) {
    		
    	return "redirect:/member/home";
    }
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(Model model) {
    		
    	return "home";
    }
    
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Model model) {

		TUser entity = userService.getUserById(currentuser.getUserId());
	
		if(entity != null) {
			UserFormBean bean = new UserFormBean();
			bean.setEmail(entity.getEmail());
			bean.setMobile(entity.getMobile());
			bean.setUserAddress(entity.getUserAddress());
			bean.setUserBirth(CommonUtils.timestampToString(entity.getUserBirth()));
			bean.setUserIdentity(entity.getUserIdentity());
			bean.setUserName(entity.getUserName());
			bean.setUserPwd(entity.getUserPwd());
			bean.setUserSex(entity.getUserSex());
			bean.setUserId(entity.getUserId());
			bean.setUserPhoto(entity.getUserPhoto());
//			System.out.println("*******************toEidt"+bean.getUserId());
			
			model.addAttribute("user", bean);
			return "/user/userEdit";
		}
		
		return "redirect:/member/home";
	
	}
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	public String doEdit(UserFormBean user) {
		
		TUser entity = userService.getUserById(user.getUserId());
		System.out.println(entity);
		entity.setEmail(user.getEmail());
		entity.setMobile(user.getMobile());
		entity.setUserAddress(user.getUserAddress());
		entity.setUserIdentity(user.getUserIdentity());
		entity.setUserIntroduction(user.getUserIntroduction());
		entity.setUserName(user.getUserName());
		entity.setUserPwd(user.getUserPwd());
		entity.setUserSex(user.getUserSex());
		entity.setUserId(user.getUserId());
		entity.setUserBirth(CommonUtils.stringToTimestamp(user.getUserBirth()));
		entity.setUserPhoto(user.getUserPhoto());
		userService.update(entity);
		return "redirect:/member/home";
	}
	
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String varify(Model model) {

		TUser entity = userService.getUserById(currentuser.getUserId());
	
		if(entity != null) {
			UserFormBean bean = new UserFormBean();
			bean.setUserName(entity.getUserName());
			bean.setUserId(entity.getUserId());
			bean.setUserPhoto(entity.getUserPhoto());
			bean.setCreateTime(entity.getCreateTime());
			bean.setUpdateTime(entity.getUpdateTime());
			bean.setRole(entity.getRole());
			model.addAttribute("user", bean);
			return "/user/accountverify";
		}
		
		return "redirect:/member/home";
	
	}
	
	@RequestMapping(value = "/{id}/sendExamine", method = RequestMethod.GET)
	public String sendExamine(Model model, @PathVariable("id") String userId) {
		
		//送審
		userService.updateSendExamine(userId);

		return "redirect:/member/verify";
	}
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/myhomepage", method = RequestMethod.GET)
	public String myhomepage(Model model) {

		TUser entity = userService.getUserById(currentuser.getUserId());
	
		if(entity != null) {
			UserFormBean bean = new UserFormBean();
			bean.setEmail(entity.getEmail());
			bean.setMobile(entity.getMobile());
			bean.setUserAddress(entity.getUserAddress());
			bean.setUserBirth(CommonUtils.timestampToString(entity.getUserBirth()));
			bean.setUserIdentity(entity.getUserIdentity());
			bean.setUserName(entity.getUserName());
			bean.setUserPwd(entity.getUserPwd());
			bean.setUserSex(entity.getUserSex());
			bean.setUserId(entity.getUserId());
			bean.setUserPhoto(entity.getUserPhoto());
//			System.out.println("*******************toEidt"+bean.getUserId());
			
			model.addAttribute("user", bean);
			return "/user/myhomepage";
		}
		
		return "redirect:/member/myhomepage";
	
	}
}
