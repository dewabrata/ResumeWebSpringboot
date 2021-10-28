package com.adl.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.hellospring.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer>{

}
