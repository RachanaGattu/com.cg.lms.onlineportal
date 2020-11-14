package com.cg.lms.onlineportal.exceptions;

public class SurveyorNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SurveyorNotFoundException(){

    }
	
	public SurveyorNotFoundException(String message)
	{
	   super(message);
	}

}
