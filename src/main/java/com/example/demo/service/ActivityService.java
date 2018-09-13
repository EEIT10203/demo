package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.TActivity;
import com.example.demo.entity.TActivityType;
import com.example.demo.entity.TTicket;
import com.example.demo.repository.TActivityRepository;
import com.example.demo.repository.TActivityTypeRepository;
import com.example.demo.repository.TTicketRepository;
import com.example.demo.utils.CurrentUser;

@Service
public class ActivityService {
	
	@Value("${activity.file.path}")
	private String imageFilePath;
	
	@Autowired
	private TActivityRepository activityRepository;
	
	@Autowired
	private TTicketRepository ticketRepository;
	
	@Autowired
	private TActivityTypeRepository activitytypeRepository;
	
	@Autowired
	private CurrentUser currentUser;
		
	public Iterable<TActivity> findAll() {
		return activityRepository.findAll();
	}
	
	public TActivity getActivityById(int id) {
		return activityRepository.getById(id);
	}

	public TActivity getActivityByIdAndCurrentUser(int id) {
		return activityRepository.getByIdAndUser(id, currentUser.getUserId());
	}
	
	
	public TActivity createByImage(TActivity activity,TTicket ticket, MultipartFile file) throws IllegalStateException, IOException {
		
		//建立活動資料
		activity.setActivityImage(file.getOriginalFilename());
		TActivity rs = this.create(activity, ticket);
		
        
        //開專屬目錄
        File dir = new File(imageFilePath + "/" + rs.getActivityId());
   	    if (!dir.exists()) {
  	      dir.mkdir();
  	    }
   	    
   	    File uploadFile = new File(dir.getPath() + "/" +file.getOriginalFilename());
		
   	    //上傳檔案
   	    file.transferTo(uploadFile);
   	 
   	    return rs;
   	    
	}
	public List<TActivity> selectAll() {
		return activityRepository.getAllActivity();
	}

	public List<TActivity> selectSearch(String sValue) {
		return activityRepository.getActivityBySearch(sValue);
	}

	//審核活動狀態
	public List<TActivity> selectPass() {
		return activityRepository.getActivityByStatus("2");
	}
	public List<TActivity> selectCheck() {
		return activityRepository.getActivityByStatus("0");
	}
	public List<TActivity> selectWaitCheck() {
		return activityRepository.getActivityByStatus("1");
	}
	public List<TActivity> selectCancel() {
		return activityRepository.getActivityByStatus("9");
	}	
	public List<TActivity> faultCheck() {
		return activityRepository.getActivityByStatus("3");
	}
	
	public List<TActivityType> getAllTActivityType() {
		return activitytypeRepository.getAllTActivityType();
	}	
	
	public TActivity create(TActivity activity,TTicket ticket) {
		activity.setActivityHost(currentUser.getUserName());
		activity.setCreateUser(currentUser.getUserId());
		activity.setUpdateUser(currentUser.getUserId());
		
		TActivity rs = activityRepository.save(activity);
		if(rs != null) {
			ticket.setActivityId(rs.getActivityId());
		    ticketRepository.save(ticket);
		}
		
		return rs;
	}
	
	
	public void update(TActivity activity) {
		TActivity db = activityRepository.getById(activity.getActivityId());
	
		db.setActivityName(activity.getActivityName());
		db.setActivityDate(activity.getActivityDate());
		db.setActivityPlace(activity.getActivityPlace());
		db.setActiivityDescription(activity.getActiivityDescription());
		db.setActivityHost(activity.getActivityHost());
		db.setActivityId(activity.getActivityId());
		db.setActivityImage(activity.getActivityImage());
		db.setActivityType(activity.getActivityType());
		db.setHostMail(activity.getHostMail());
		db.setHostTel(activity.getHostTel());
		
		activityRepository.save(db);
	}
	
	//審核活動
	public void updateSendExamine(int activityId) {
		TActivity db = activityRepository.getByIdAndUser(activityId, currentUser.getUserId());
	
		if(db != null) {
			db.setActivityStatus("1");
			activityRepository.save(db);
		}
	}
	
	public void updateCancel(int activityId) {
		TActivity db = activityRepository.getByIdAndUser(activityId, currentUser.getUserId());
	
		if(db != null) {
			db.setActivityStatus("9");
			activityRepository.save(db);
		}
	}
	
	public void updateExaminePass(int activityId) {
		
	//	if(StringUtils.equals(currentUser.getUserRole(), "M")) {
			TActivity db = activityRepository.getById(activityId);
		
			if(db != null) {
				db.setActivityStatus("2");
				activityRepository.save(db);
			}
	//	}
	}
	
	public void updateExamineFail(int activityId) {
		
			TActivity db = activityRepository.getById(activityId);
		
			if(db != null) {
				db.setActivityStatus("3");
				activityRepository.save(db);
			}
	}
}
