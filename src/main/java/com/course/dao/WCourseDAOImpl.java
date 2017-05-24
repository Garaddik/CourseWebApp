
package com.course.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.model.University;

@Component
public class WCourseDAOImpl implements WCourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(WCourseDAOImpl.class);
}
