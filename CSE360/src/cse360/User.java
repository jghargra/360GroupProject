package cse360;
import java.sql.*;

import javax.swing.*;
//**********************************************************
// Program Name: 
// Author : Jason Hargrave
// Date Written : 26 March 2015
// Class : CSE 360
// Brief Description: 
// 
// 
//***********************************************************

public class User {
	
	private static String name;
        private static String username;
	private static String role;
	private double painLevel;

	// The constructors may not be neccessary if all information
	// being stored into the database. Rather than constructors, we
	// could use getters to retieve data from the database and 
	// manipulate it 
	//--------------------------------------------------
	// Sets up the patient with default information
	//--------------------------------------------------
	
	//Overloaded Constructor
	public User(){
		
		this.name = "NULL";
		this.role = "NULL";
	}
	
	public static String getName(){
		
		return name;
	}
	
	public static void setName(String input){
		
		name = input;
	}
        
        public static String getUsername()
        {
                return username;
        }
        
        public static void setUsername(String input)
        {
                username = input;
        }
	
	public static String getRole(){
		
		return role;
	}
	
	public static void setRole(String input){
		
		role = input;
	}
	
	//--------------------------------------------------
	// Returns an integer representing the patients
	// priority for a patient queue
	//--------------------------------------------------
	public void calcPatientPriority(int pain, int tiredness, int nausea, int depression, int anxiety,
			int drowsiness, int appetite, int wellbeing, int shortnessOfBreath){
		
		//Threshold represents tolerable symptoms
		int threshold = 4;
		//Patient Priority ranges from 1 to 10, 10 being the highest priority
		double patientPriority = 0;
		int painLevel = 0;
		int tiredLevel = 0;
		int nauseaLevel = 0;
		int depressionLevel = 0;
		int anxietyLevel = 0;
		int drowsinessLevel = 0;
		int appetiteLevel = 0;
		int wellbeingLevel = 0;
		int breathLevel = 0;
		
		//--------------------------------------------------
		// Pain Assessment
		//--------------------------------------------------
		if (pain >= 9){
			painLevel = 10;
			patientPriority = painLevel;
		}
		
		if (pain == 7 || pain == 8){
			painLevel = 8;
		}
		
		if (pain == 5 || pain == 6){
			painLevel = 6;
		}
		
		if (pain <= threshold){
			painLevel = pain;
		}
		
		//--------------------------------------------------
		// Tiredness Assessment
		//--------------------------------------------------
		if (tiredness >= 6){
			tiredLevel = 6;
		}
		
		if (tiredness <= 5){
			tiredLevel = tiredness;
		}
		
		//--------------------------------------------------
		// Nausea Assessment
		//--------------------------------------------------
		if (nausea >= 9){
			nauseaLevel = 8;
		}
		
		if (nausea >= 5 && nausea <= 8){
			nauseaLevel = 6;
		}
		
		if (nausea <= threshold){
			nauseaLevel = nausea;
		}
		
		//--------------------------------------------------
		// Depression Assessment
		//--------------------------------------------------
		if (depression >=8){
			depressionLevel = 8;
		}
		
		if (depression > threshold && depression <= 7){
			depressionLevel = 6;
		}
		
		if (depression <= threshold){
			depressionLevel = depression;
		}
		
		//--------------------------------------------------
		// Anxiety Assessment
		//--------------------------------------------------
		if (anxiety >= 9){
			anxietyLevel = 8;
		}
		
		if (anxiety > threshold && anxiety <= 8){
			anxietyLevel = 6;
		}
		
		if (anxiety <= threshold){
			anxietyLevel = anxiety;
		}
		
		//--------------------------------------------------
		// Drowsiness Assessment
		//--------------------------------------------------
		if (drowsiness >= 9){
			drowsinessLevel = 7;
		}
		
		if (drowsiness > threshold && drowsiness <= 8){
			drowsinessLevel = 5;
		}
		
		if (drowsiness <= threshold){
			drowsinessLevel = drowsiness;
		}
		
		//--------------------------------------------------
		// Appetite Assessment
		//--------------------------------------------------
		if (appetite >= 9){
			appetiteLevel = 7;
		}
		
		if (appetite > threshold && appetite <= 8){
			appetiteLevel = 5;
		}
		
		if (appetite <= threshold){
			appetiteLevel = appetite;
		}
		
		//--------------------------------------------------
		// Well being Assessment
		//--------------------------------------------------
		if (wellbeing >= 9){
			wellbeingLevel = 10;
			patientPriority = wellbeingLevel;
		}
		
		if (wellbeing > threshold && wellbeing <= 8){
			wellbeingLevel = 7;
		}
		
		if (wellbeing <= threshold){
			wellbeingLevel = wellbeing;
		}
		
		//--------------------------------------------------
		// Shortness of Breath Assessment
		//--------------------------------------------------
		if (shortnessOfBreath >= 9){
			breathLevel = 10;
			patientPriority = breathLevel;
		}
		
		if (shortnessOfBreath == 7 || shortnessOfBreath == 8){
			breathLevel = 8;
		}
		
		if (shortnessOfBreath > threshold && shortnessOfBreath >= 6){
			breathLevel = 6;
		}
		
		if (shortnessOfBreath <= threshold){
			breathLevel = shortnessOfBreath;
		}
		
		//--------------------------------------------------
		// Calculate Patient Priority for the Patient queue
		//--------------------------------------------------
		
		if (patientPriority == 10){
			setPatientPainLevel(patientPriority);
		}
		else {
			patientPriority = (painLevel + tiredLevel + nauseaLevel + depressionLevel +
					anxietyLevel + drowsinessLevel + appetiteLevel + wellbeingLevel + breathLevel) / 9;
			setPatientPainLevel(patientPriority);
		}
	}
	
	
	public void setPatientPainLevel(double painLevel){
		
		this.painLevel = painLevel;
	}
}
