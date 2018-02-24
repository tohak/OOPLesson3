package com.konovalov;

public class MyException extends Exception {
	
	public String getMessage(Student[] array) throws MyException{
		if (array[array.length]!=null) throw new MyException();
			return "Error";
			
		}
}
