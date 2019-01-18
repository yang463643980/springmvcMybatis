package com.dao;

import java.util.List;

import com.bean.Country;

public interface CountryDao {
	public void addCountry(Country country);
	public boolean deleteCountry(int id);
	public void updateCountry(Country country);
	public Country findById(int id);
	public List<Country> findAll();
	public List<Country> findByName(Country country);
}
