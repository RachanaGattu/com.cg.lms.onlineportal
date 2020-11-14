package com.cg.lms.onlineportal.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.lms.onlineportal.dto.Surveyor;

@Repository
public interface SurveyorDao extends JpaRepository<Surveyor,Long> 
{
	List<Surveyor> findAll();
	void deleteById(Long id);
	
}

