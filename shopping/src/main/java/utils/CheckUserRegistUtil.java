package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查用户注册信息的合法性工具类
 * @author 杜俊笙
 *
 */
public class CheckUserRegistUtil {
	/**
	 * 姓名是否合法
	 * @param name 姓名
	 * @return 是否合法
	 */
	public static boolean isName(String name){
		Matcher mer = Pattern.compile("[\u4e00-\u9fa5a-zA-Z]+$").matcher(name);
		return mer.find();
	}
	
	public static  boolean isEmail(String email)
	{		
		Matcher mer = Pattern.compile("^([a-zA-Z0-9])+@([a-zA-Z0-9])+((\\.[a-zA-Z0-9]{2,3}))$").matcher(email);
        return mer.find();
	}
	
	public static boolean isMobile(String mobile)
	{
		Matcher mer = Pattern.compile("^(13[0-9]{9})|(15[0-9]{9})|(18[5-9]{9})").matcher(mobile);
		return mer.find();
	}
	
	public static boolean isSfzhm(String sfzhm){
		Matcher mer = Pattern.compile(
				"^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$"
				).matcher(sfzhm);
		return mer.find();
	}

}
