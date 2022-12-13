package com.example.boot1.RestrauntInterface;

import com.example.boot1.RestrauntEntity.RestrauntEntity;

import org.springframework.data.jpa.repository.JpaRepository;

//jpa repository / repository layer / dao layer 

public interface RestroInterface extends JpaRepository<RestrauntEntity, Integer>{
	
}
