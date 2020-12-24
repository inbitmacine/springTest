package com.example.myutill;

/*
 * 特にspringに関係なく、メンバ変数も特に使用しないような関数のクラスです。
 * 基本的にstaticに指定してインスタンスをnewしなくても使えるようにしています。
 */
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MyUtill {

	//文章を改行毎に分割して、語尾を付け加える
	public static List<String> ySplit(String str) {
		int z = 0;
		//改行で分割
		String[] ssu = str.split("\r\n|\n|\r");
		for(String i:ssu) {
			while (i.endsWith("\r")||i.endsWith("\n")) {
				i = i.substring(0, i.length() - 1);
			}
			//何も入力されていない行はスキップ
			if(i.matches("[\r\n|\n|\r|\t| *|　*]*")||i.isEmpty()){
				z++;
				continue;
			}

			ssu[z++] = i + "っす";

		}

		List<String> list = Arrays.asList(ssu);
		return list;
	}

	//メールアドレスが正しいフォーマットで入力されているかチェックします
	public static boolean isMailAddress(String value) {
	    boolean result = false;
	    if (value != null) {
	        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$");
	        result = pattern.matcher(value).matches();
	    }
	    return result;
	}
}


