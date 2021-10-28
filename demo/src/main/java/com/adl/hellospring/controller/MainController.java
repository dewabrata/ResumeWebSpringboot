package com.adl.hellospring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adl.hellospring.model.Profile;
import com.adl.hellospring.model.Resume;
import com.adl.hellospring.model.Skill;
import com.adl.hellospring.repository.ProfileRepository;
import com.adl.hellospring.repository.ResumeRepository;
import com.adl.hellospring.repository.SkillRepository;

@Controller
public class MainController {
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private SkillRepository skillRepository;
    
	@Autowired
	private ResumeRepository rp;
	
	
	@GetMapping("/")
	public String helloWorld(Model model) {
		
		Profile profile =profileRepo.findById(1).get();
		model.addAttribute("asiap",profile);
		List<Skill> skill = skillRepository.findAll();
		model.addAttribute("skill", skill);
		
		Pageable paging = PageRequest.of(2, 2);
		
		Page<Resume> lstResume = rp.findAll(paging);
		model.addAttribute("resume", lstResume.getContent());
		
	
		return "index";
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "<img src ='https://cdn.idntimes.com/content-images/community/2020/07/fromandroid-bc64e66ca82adaae225e1e6a4e752b5e.jpg'/>";
	}
	
	
	@GetMapping("/insert")
	@ResponseBody
	public String setData() {
		
		List<Resume> lstResume = new ArrayList<Resume>();
		
		
			Resume resume = new Resume();
			resume.setJudul("SMP 1 Bogor");
			resume.setTahun("1994-1997");
			resume.setKeterangan("Belajar SMP");
			resume.setTipe("education");
			
			lstResume.add(resume);
			
			Resume resume2 = new Resume();
			resume2.setJudul("SDN 1 Bogor");
			resume2.setTahun("1991-1994");
			resume2.setKeterangan("Belajar SD");
			resume2.setTipe("education");
			
			lstResume.add(resume2);
			
			rp.saveAll(lstResume);
			
			
			
			return " Insert data succesfully";
		
	}
}
