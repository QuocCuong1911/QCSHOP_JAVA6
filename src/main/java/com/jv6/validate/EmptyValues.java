package com.jv6.validate;

import java.util.Iterator;
import java.util.List;

public class EmptyValues {
	public static boolean checkEmpty(List<Object> values) {	
		if(values ==null || values.isEmpty()) {
			return false;
		}
		
		for(Object value : values) {
			if(value == null || value.toString().trim().isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
}
