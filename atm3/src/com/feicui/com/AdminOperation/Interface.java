package com.feicui.com.AdminOperation;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserOperation.Login;

/*
 * 登陆界面
 */
public class Interface extends AbstractVirtual {

	@Override
	public AbstractVirtual show() {

		System.out.println("1：管理员登录");
		System.out.println("2:用户登录");

		String string = scanner.nextLine();

		if ("1".equals(string)) {

			return new AdmainRegister();
		}

		if ("2".equals(string)) {

			return new Login();
		}
		return this;

	}
}
