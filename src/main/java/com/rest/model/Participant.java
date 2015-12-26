package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "participant")
@Entity
public class Participant {
	
	@Id
	@Column(name="participant_id")
	private int pId;
	private String fName;
	private String lName;
	private String ssn;
	
	public Participant(){
		
	}
	public Participant(int pId, String fName, String lName, String ssn) {
		this.pId = pId;
		this.fName = fName;
		this.lName = lName;
		this.ssn = ssn;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	

}
