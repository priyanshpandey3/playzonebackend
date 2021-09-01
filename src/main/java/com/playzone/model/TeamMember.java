
  package com.playzone.model;
  
  import java.io.Serializable;
import java.sql.Timestamp;
  
  import javax.persistence.Column; import javax.persistence.Entity; 
  import javax.persistence.FetchType;
  import javax.persistence.GeneratedValue; 
  import javax.persistence.GenerationType; 
  import javax.persistence.Id;
  import javax.persistence.JoinColumn;
  import javax.persistence.ManyToOne; 
  import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor; 
  import lombok.Data; 
  import lombok.NoArgsConstructor;
  
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Entity
  @Table(name="teammember") 
  public class TeamMember implements Serializable{
  
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)

  public int memberId;
  

  public String memberName;
  

  public int teamId;
  
  
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  
  @JoinColumn(name = "teamId", referencedColumnName = "teamId" ,insertable =
  false, updatable = false) 
  private Team team;
  
  }
 
