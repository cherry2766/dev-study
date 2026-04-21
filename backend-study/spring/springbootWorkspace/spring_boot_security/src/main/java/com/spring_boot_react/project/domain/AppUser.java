package com.spring_boot_react.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

//jpa 기능 활용해서 db에 테이블 자동 생성되도록 설정
//id 컬럼은 시퀀스 이용해서 자동 생성되도록, 수정 불가
//username 유일하게 설정
//pk sequence 정책 사용하는 경우 시퀀스명을 entity에 명시
//jpa가 테이블은 생성해주지만 시퀀스는 생성하지 않음
@Entity
@SequenceGenerator(
		name = "MEMBER_SEQUENCE_GENERATOR",        
		sequenceName = "MEMBER_SEQUENCE"
		)
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MEMBER_SEQUENCE_GENERATOR")
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String role;

	public AppUser() {

	}

	public AppUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
