package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Country;
import com.dao.CountryDao;
import com.service.ServiceCountry;

@Service
@Transactional
public class CountryServiceImpl implements ServiceCountry {
	@Resource
	private CountryDao dao;
	
	public CountryDao getDao() {
		return dao;
	}

	public void setDao(CountryDao dao) {
		this.dao = dao;
	}

	@Override
	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		dao.addCountry(country);
	}

	@Override
	public boolean deleteCountry(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCountry(id);
	}

	@Override
	public void updateCountry(Country country) {
		// TODO Auto-generated method stub
		dao.updateCountry(country);
	}

	@Override
	public Country findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Country> findByName(Country country) {
		return dao.findByName(country);
	}

}
