package com.heimu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heimu.dao.LegendsDAO;
import com.heimu.model.Legends;

@Component("legendsService")
public class LegendsService {
	
	private LegendsDAO legendsDAO;
	
	public void init() {
		System.out.println("init");
	}
	
	public LegendsDAO getLegendsDAO() {
		return legendsDAO;
	}

	@Resource(name="legendsDao")
	public void setLegendsDAO(LegendsDAO legendsDAO) {
		this.legendsDAO = legendsDAO;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void add(Legends legends){
		legendsDAO.save(legends);
	}
	
	public List<Legends> query(){
		return this.legendsDAO.query();
	}
	
	public void destroy() {
		System.out.println("destroy");
	}
}
