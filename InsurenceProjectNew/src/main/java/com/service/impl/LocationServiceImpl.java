package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LocationDao;
import com.entity.Location;
import com.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDao locationDao;

	@Transactional
	public List<Location> getAll() {
		return locationDao.getAll();
	}

	@Transactional
	public void save(Location entity) {
		locationDao.save(entity);
	}

	@Transactional
	public Location findOne(Integer id) {
		return locationDao.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		locationDao.delete(id);
	}
}
