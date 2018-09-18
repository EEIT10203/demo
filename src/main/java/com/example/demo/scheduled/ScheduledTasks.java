package com.example.demo.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.entity.TActivity;
import com.example.demo.formbean.ActivityFormBean;
import com.example.demo.service.ActivityService;

@Component
public class ScheduledTasks {
	private final AtomicInteger counter = new AtomicInteger();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private ActivityService activityService;

	@Scheduled(fixedRate = 60000, initialDelay = 60000)
	// @Scheduled(cron=” /5 “) ：通過cron表示式定義規則，什麼是cro表示式，自行搜尋引擎。
	public void report1() {
		List<TActivity> passEntityList = activityService.selectPass();

		for (TActivity entity : passEntityList) {
			ActivityFormBean bean = new ActivityFormBean();
			System.out.println("-------ActivityId = " + entity.getActivityId() + "---------");
			entity.getEndTime();
			Date date = new Date();
			if (date.after(entity.getEndTime())) {
				System.out.println("-------updateEndTime !!!! " + entity.getActivityId() + "---------");
				activityService.updateEnd(entity.getActivityId());
			}
		}

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
