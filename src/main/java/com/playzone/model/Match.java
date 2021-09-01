package com.playzone.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="matches") 
public class Match implements Serializable{

	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int matchId;
	
	
	private String matchName;
	 
	
	private String team1Code;
	
	 
	private String team2Code;
	
	
	private int venueId;
	 
	
	private int trId;
	 
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateAndTime;
	 
	
	private String matchInfo;
	

	private String status;

	 @JsonIgnore
	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "trId", referencedColumnName = "trId" ,insertable =
	  false, updatable = false) 
	  private Tournament tournament;
	  	
	
}
