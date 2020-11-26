package com.example.first;
import java.util.Arrays;
import java.util.List;

public class YoroSplit {
	static List<String> ySplit(String str) {
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
}
