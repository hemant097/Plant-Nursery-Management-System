package com.masai.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(unique = true)
	private Integer UserId;
	
	private String uniqueId;
	
	private LocalDateTime time;

	public UserSession(Integer userId, String uniqueId, LocalDateTime time) {
		super();
		UserId = userId;
		this.uniqueId = uniqueId;
		this.time = time;
	}
	
	
	
	
}
