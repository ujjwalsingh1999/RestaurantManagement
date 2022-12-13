package com.example.boot1.RestrauntService;

import java.util.List;

import com.example.boot1.RestrauntEntity.RestrauntEntity;

public interface RestrauntSVC {
	//provide method declaration for my CRUD methods
RestrauntEntity insertRestro(RestrauntEntity restroEntityObj);
	List <RestrauntEntity>  getAllRestraunt();
	RestrauntEntity getRestroById(int id);
	RestrauntEntity updNewRestroRecord(RestrauntEntity updRestroObj);
	public void delRestro(int id);
}
