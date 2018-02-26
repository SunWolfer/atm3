package com.feicui.com.AdminOperation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.storage.AdminMenu;
import com.feicui.com.storage.ReadText;
import com.feicui.com.util.DatabaseUtils;

/*
 * 修改客户信息
 */

public class AmendMenu extends AbstractVirtual {

	private DatabaseUtils utils;

	public AmendMenu() {

		try {
			
			utils = new DatabaseUtils();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public AbstractVirtual show() {

		System.out.println("请输入要修改的账户");

		String num = scanner.nextLine();
		
		/*
		 * 读取菜单
		 */
		ReadText readText = new ReadText();
		readText.readText("menu" + File.separator + "importAccount.txt");
		
		String str = scanner.nextLine();
		//修改客戶姓名
		if ("1".equals(str)) {

			updateName(num);
		}
		//修改客戶密碼
		if ("2".equals(str)) {

			importPass(num);
		}
		//修改客戶学历
		if ("3".equals(str)) {

			importEdu(num);
		}
		//修改客户地址
		if ("4".equals(str)) {

			importAddress(num);
		}
		//返回主菜单
		if ("5".equals(str)) {

			return new AdminMenu();
		}
		return this;

	}
	
	/*
	 * 修改姓名
	 */
	private void updateName(String num) {

		while (true) {

			System.out.println("请输入要修改的姓名");
			String str1 = scanner.nextLine();

			if (str1.length() <= 10) {

				user.setName(str1);
				try {
					utils.updateData("update user_ set name = ? where account = ?", user.getName(), num);
					break;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				System.out.println("用户姓名不能超过10位");
			}
		}

	}
	
	/*
	 * 修改密码
	 */
	private void importPass(String num) {

		while (true) {

			System.out.println("请输入要修改的密码");
			String str2 = scanner.nextLine();

			if (checkAccount(str2)) {

				user.setPasswd(str2);
				try {
					utils.updateData("update user_ set passwd = ? where account = ?", user.getPasswd(), num);
					break;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				System.out.println("6位 不能为空 数字或字母组合 ");
			}
		}

	}

	/*
	 * 正则表达式判断密码
	 */
	private boolean checkAccount(String str2) {

		return str2.matches("[a-z0-9A-Z]{6}") 
				&& !str2.matches("[a-zA-Z]+") && // 不能只包含字母
				!str2.matches("[0-9]+"); // 不能只包含数字
	}
	
	/*
	 * 修改学历
	 */
	private void importEdu(String num) {

		System.out.println("请输入要修改的学历");
		System.out.println("1代表  小学  2代表 中学  3代表大学 4代表其他");

		String str5 = scanner.nextLine();
		user.setEducation(str5);

		try {
			utils.updateData("update user_ set education = ? where account = ?", 
					user.getEducation(), num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * 修改地址
	 */
	private void importAddress(String num) {

		System.out.println("请输入要修改的地址");
		String str6 = scanner.nextLine();
		user.setAddress(str6);

		try {
			utils.updateData("update user_ set address = ? where account = ?", user.getAddress(), num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
