package com.feicui.com.UserOperation;

import java.io.File;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserLogic.MainMenu;

/*
 * 取款业务
 */
public class DrawMoney extends AbstractVirtual {

	public AbstractVirtual show() {

		System.out.println("请输入取款的金额：");

		String dob = scanner.nextLine();
		user.setDraw(Double.valueOf(dob));

		/*
		 * 判断余额
		 */
		if (user.getDraw() > user.getAmount()) {

			System.out.println("余额不足，请重新输入");
			return this;

		}

		readText.readText("menu" + File.separator + "choosemenu.txt");

		String input = scanner.nextLine();

		// 确认
		if ("1".equals(input)) {

			atm.DrawBusiness();

			readText.readText("menu" + File.separator + "drawmoney.txt");

			String num = scanner.nextLine();

			if ("1".equals(num)) {

				return this;
			}

			else {
				return new MainMenu();
			}

		} 		
		// 重新输入
		if ("2".equals(input)) {

			return this;

		}
		//返回主菜单
		else {
			
			return new MainMenu();
		}

	}
}
