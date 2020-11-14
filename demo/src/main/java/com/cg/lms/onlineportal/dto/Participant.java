package com.cg.lms.onlineportal.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Participant_details")
public class Participant {

       @Id
       @GeneratedValue
    private int id;

    private String username,  firstName, lastName;

    //@OneToMany
    //private List<Feedback> feedbacks;

    public Participant() {
    }
  
    
   
	   public Participant(String username,  String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}




	public Participant(int id, String username,  String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}



    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


	@Override
	public String toString() {
		return "Participant [id=" + id + ", username=" + username + "+ , firstName="
				+ firstName + ", lastName=" + lastName +   "]";
	}
    
}
