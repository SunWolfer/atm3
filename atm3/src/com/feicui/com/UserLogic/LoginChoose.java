package com.feicui.com.UserLogic;

import com.feicui.com.AdminOperation.Interface;
import com.feicui.com.UserOperation.Login;

public class LoginChoose extends AbstractVirtual{
	
	public AbstractVirtual show() {
		
		System.out.println("1:返回登陆界面；其它键重新输入");
		
		String num = scanner.nextLine();
		
		//返回登录
		if("1".equals(num)) {
			
			return new Interface();
		}
		//重新输入
		else{
			
			return new Login();
		}
		
	}
}
