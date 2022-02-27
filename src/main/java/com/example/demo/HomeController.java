package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StaffRepository;
import com.example.demo.model.Staff;

@RestController
public class HomeController {

	@Autowired
	StaffRepository staffRepository;

	@RequestMapping("api/find/{staffId}")
	@ResponseBody
	public Optional<Staff> findById(@PathVariable("staffId") int staffId) {
		return staffRepository.findById(staffId);

	}

	@RequestMapping("/api/login")
	@ResponseBody
	public String login(Staff staff) {
		System.out.print(staff.getStaffName());
		System.out.print(staff.getStaffId());
		return "ok";
	}

	@PostMapping("api/register")
	public Staff registerStaff(Staff staff) {
		return staffRepository.save(staff);

	}

	@GetMapping("api/getAll")
	public List<Staff> getAllData() {
		return staffRepository.findAll();
	}

	@PutMapping("api/update")
	public Staff updateOrSave(Staff staff) {
		return staffRepository.save(staff);
	}

	@DeleteMapping("api/delete/{staffId}")
	public String deleteStaff(@PathVariable int  staffId) {
		Staff staff = staffRepository.getById(staffId);
		staffRepository.delete(staff);
		return "deleted";
	}

}
