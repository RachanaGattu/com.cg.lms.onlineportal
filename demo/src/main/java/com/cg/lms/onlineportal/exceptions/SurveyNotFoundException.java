package com.cg.lms.onlineportal.exceptions;

public class SurveyNotFoundException extends RuntimeException{

   public SurveyNotFoundException(){
    }

    public SurveyNotFoundException(String msg){
        super(msg);
    }
}
