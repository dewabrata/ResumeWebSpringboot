package com.adl.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.hellospring.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
