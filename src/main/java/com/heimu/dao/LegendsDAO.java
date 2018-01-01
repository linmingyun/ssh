package com.heimu.dao;

import java.util.List;

import com.heimu.model.Legends;

public interface LegendsDAO {
	public void save(Legends legends);
	public List<Legends> query();
}
