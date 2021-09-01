package com.playzone.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tournament") 
public class Tournament implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trId;

	private String trName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
    
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date applnStartDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date applnEndDate;

	private String status;

	private String info;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
			  "tournament") private List<Match> match;
	
	

}
