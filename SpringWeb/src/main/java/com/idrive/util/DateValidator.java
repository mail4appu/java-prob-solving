package com.idrive.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<IsValidDate, String>{

	public void initialize(IsValidDate arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String doj, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		System.out.println("dob is"+doj);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/mm/dd");
		try{
			sdf.parse(doj);
			return true;	

		}catch(Exception ex){
			return false;
		}
	}



}
