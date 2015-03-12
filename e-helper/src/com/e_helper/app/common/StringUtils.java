package com.e_helper.app.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 判空
	 * @param input
	 * @return
	 */
	public static boolean isEmpty( String input ) 
	{
		if ( input == null || "".equals( input ) )
			return true;
		
		for ( int i = 0; i < input.length(); i++ ) 
		{
			char c = input.charAt( i );
			if ( c != ' ' && c != '\t' && c != '\r' && c != '\n' )
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 邮箱格式校验
	 * @param input
	 * @return
	 */
	public static boolean isEmail(String input) {
		Pattern pattern = Pattern.compile("[//w//.//-]+@([//w//-]+//.)+[//w//-]+",Pattern.CASE_INSENSITIVE); 
		Matcher matcher = pattern.matcher(input); 
		if (matcher.matches()) {
			return true;
		}else {
			return false;
		}	  
	}
}
