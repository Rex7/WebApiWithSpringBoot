package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Staff;



public interface StaffRepository extends JpaRepository<Staff, Integer> {
	



}
