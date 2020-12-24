package com.example.myutill;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MyUtill {
	public static List<String> ySplit(String str) {
		int z = 0;
		String[] ssu = str.split("\r\n|\n|\r");
		for(String i:ssu) {
			while (i.endsWith("\r")||i.endsWith("\n")) {
				i = i.substring(0, i.length() - 1);
			}
			if(i.matches("[\r\n|\n|\r|\t| *|　*]*")||i.isEmpty()){
				z++;
				continue;
			}
			ssu[z++] = i + "っす";

		}
		List<String> list = Arrays.asList(ssu);
		return list;
	}


	public static boolean isMailAddress(String value) {
	    boolean result = false;
	    if (value != null) {
	        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$");
	        result = pattern.matcher(value).matches();
	    }
	    return result;
	}
}


