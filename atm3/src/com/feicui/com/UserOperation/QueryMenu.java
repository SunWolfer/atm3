package com.feicui.com.UserOperation;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserLogic.MainMenu;

public class QueryMenu extends AbstractVirtual {
	/*
	 * 查询本账户信息
	 * (non-Javadoc)
	 * @see com.feicui.com.UserLogic.AbstractVirtual#show()
	 */
	public AbstractVirtual show() {


		System.out.println(user);
		System.out.println("1:返回主菜单");

		String num1 = scanner.nextLine();

		if ("1".equals(num1)) {

			return new MainMenu();

		}
		return this;
        	

	}
}
