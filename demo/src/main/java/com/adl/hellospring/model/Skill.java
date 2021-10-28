package com.adl.hellospring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * +-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| id          | int(11)     | NO   | PRI | NULL    | auto_increment |
| id_profile  | int(11)     | YES  |     | NULL    |                |
| skill_name  | varchar(50) | YES  |     | NULL    |                |
| skill_value | int(11)     | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
 */

@Entity
@Getter 
@Setter
@NoArgsConstructor
public class Skill implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int id_profile;
	private String skill_name;
	private int skill_value;

}
