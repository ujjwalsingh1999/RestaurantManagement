package com.example.boot1.RestrauntImpl;

import java.util.List;

import com.example.boot1.RestrauntEntity.RestrauntEntity;
import com.example.boot1.RestrauntInterface.RestroInterface;
import com.example.boot1.RestrauntService.RestrauntSVC;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RestroCls implements RestrauntSVC {
	
	//restaurant reference variable will be able to access only JPA repository methods and attr
	RestroInterface restaurant;
	
	//constructor injection
	public RestroCls(RestroInterface restaurant) {
		this.restaurant = restaurant;
	}


	public List <RestrauntEntity> getAllRestraunt(){
		 return restaurant.findAll();
	}


	@Override
	public RestrauntEntity insertRestro(RestrauntEntity restroEntityObj) {
		// TODO Auto-generated method stub
		
		return restaurant.save(restroEntityObj);
	}


	@Override
	public RestrauntEntity getRestroById(int id) {
		// TODO Auto-generated method stub
		return restaurant.findById(id).get();
	}


	@Override
	public RestrauntEntity updNewRestroRecord(RestrauntEntity updRestroObj) {
		// TODO Auto-generated method stub
		return restaurant.save(updRestroObj);
	}


	@Override
	public void delRestro(int id) {
		// TODO Auto-generated method stub
		restaurant.deleteById(id);
	}




	
	
}
