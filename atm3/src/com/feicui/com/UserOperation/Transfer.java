package com.feicui.com.UserOperation;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.com.AdminOperation.User;
import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserLogic.MainMenu;

public class Transfer extends AbstractVirtual {

	public AbstractVirtual show() {

		// 判断卡号
		System.out.println("请输入对方卡号");
		String Account = scanner.nextLine();

		Connection conn = null;

		User otheruser = new User();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/lalala?useSSL=false", "root",
					"123456");
			// 获取执行sql的PreparedStatement对象
			String sql = "select account,name,amount from user_  where account = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Account);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				otheruser.setAccount(rs.getString(1));
				otheruser.setName(rs.getString(2));
				otheruser.setAmount(Double.valueOf(rs.getString(3)));

			}
			// 关闭资源
			rs.close();
			statement.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (otheruser.getAccount().equals(null)) {

			System.out.println("用户不存在");
			return this;

		}

		System.out.println("请输入转账金额");

		String moneyString = scanner.nextLine();

		// 判断金额
		if (!figure(moneyString)) {

			System.out.println("请输入正确的金额");
			return this;

		}

		user.setOthermoney(Double.valueOf(moneyString));

		readText.readText("menu" + File.separator + "choosemenu.txt");

		// 转账业务菜单
		String number2 = scanner.nextLine();

		// 确认
		if (number2.equals("1")) {

			System.out.println(
					"姓名：" + user.getName() + "\n" + "银行卡号" + 
			user.getAccount() + "\n" + "转账金额" + moneyString + "\n");

			readText.readText("menu" + File.separator + "transfer.txt");

			String number3 = scanner.nextLine();

			// 确认转账
			if (number3.equals("1")) {

				if (user.getOthermoney() <= user.getAmount()) {
					
					atm.OtherBusiness(otheruser);

					System.out.println("转账成功!");

					return new MainMenu();

				} else {

					System.out.println("余额不足，请重新输入：");
					return this;

				}
			}

			// 重新输入
			if (number3.equals("2")) {

				return this;

			}

			// 退卡
			if (number3.equals("3")) {

				return new Login();

			}
		}

		// 重新输入
		if (number2.equals("2")) {

			return this;

		}

		// 返回主菜单
		if (number2.equals("3")) {

			return new MainMenu();

		}

		return this;

	}

	public boolean figure(String str) {// 判断金额
		return str.matches("(\\d)*(\\.)?(\\d)*") // 是否是正确的金额

				&& str.matches("[^0]+00(\\.)?(\\d)*");// 是否是正确的存款取款金额
	}

}
