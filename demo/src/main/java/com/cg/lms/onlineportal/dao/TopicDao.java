package com.cg.lms.onlineportal.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.onlineportal.dto.Topic;




@Repository
public interface TopicDao extends JpaRepository<Topic,Long> {
	

	List<Topic> findAll();
	
	
	

}
