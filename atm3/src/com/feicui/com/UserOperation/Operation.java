package com.feicui.com.UserOperation;

import java.io.File;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserLogic.MainMenu;

public class Operation extends AbstractVirtual {

	public AbstractVirtual show() {

		System.out.println("请输入存款的金额：");

		String double1 = scanner.nextLine();
		user.setOpera(Double.valueOf(double1));

		readText.readText("menu" + File.separator + "choosemenu.txt");

		String input1 = scanner.nextLine();

		// 确认
		if ("1".equals(input1)) {

			atm.OperaBusiness();

			readText.readText("menu" + File.separator + "operation.txt");

			String num = scanner.nextLine();

			if ("1".equals(num)) {

				return this;
			}

			else {
				return new MainMenu();
			}
		}

		// 重新输入
		if ("2".equals(input1)) {

			return this;

		}else {
			
			return new MainMenu();
		}
	}
}
