package com.feicui.com.AdminOperation;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.storage.AdminMenu;

/*
 * 查询用户信息
 */
public class Inquire extends AbstractVirtual {

	@Override
	public AbstractVirtual show() {

		System.out.println(user);
		System.out.println("1:返回主菜单");

		String num1 = scanner.nextLine();

		if ("1".equals(num1)) {

			return new AdminMenu();

		}

		return null;
	}
}
