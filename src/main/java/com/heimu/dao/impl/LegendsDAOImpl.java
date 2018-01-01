package com.heimu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.heimu.dao.LegendsDAO;
import com.heimu.model.Legends;

@Component("legendsDao")
public class LegendsDAOImpl implements LegendsDAO {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Legends legends){
		hibernateTemplate.save(legends);
		System.out.println("Legendary!!!");
	}
	
	@SuppressWarnings("unchecked")
	public List<Legends> query(){
		return (List<Legends>) this.hibernateTemplate.find("from Legends");
	}
}
