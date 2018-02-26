package com.feicui.com.UserOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.UserLogic.Lockout;
import com.feicui.com.UserLogic.LoginChoose;
import com.feicui.com.UserLogic.MainMenu;

/*
 * 普通用户登录
 */
public class Login extends AbstractVirtual {

	public AbstractVirtual show() {

		System.out.println("请输入账号或身份证号：");
		String str1 = scanner.nextLine();

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalala?useSSL=false", 
					"root", "123456");
			// 获取执行sql的PreparedStatement对象
			String sql = "select * from user_  where account = ? or card = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, str1);
			statement.setString(2, str1);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user.setAccount(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPasswd(rs.getString(3));
				user.setCard(rs.getString(4));
				user.setEducation(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setAmount(Double.valueOf(rs.getString(8)));
				user.setStatus(rs.getString(10));
				user.setJudge(rs.getString(11));

			}

			if (user.getSex().equals("1")) {

				user.setSex("男");
			}
			if (user.getSex().equals("2")) {

				user.setSex("女");
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

		/*
		 * 登录用户判断
		 */
		if (user.getJudge() == null)

		{

			System.out.println("没有此用户");
			return new LoginChoose();

		}

		if (user.getJudge().equals("0")) {

			System.out.println("用户已锁定");
			return new LoginChoose();
		}

		if (user.getJudge().equals("-1")) {

			System.out.println("用户已销户");
			return new LoginChoose();
		}

		for (int count = 0; count < 3;) {
			a: while (true) {

				System.out.println("请输入密码");
				String str2 = scanner.nextLine();

				if (user.getPasswd().equals(str2)) {

					return new MainMenu();
				} else {
					System.out.println("密码错误，请重新输入");

					count++;

					if (count >= 3) {

						return new Lockout();

					}
					continue a;

				}
			}
		}

		return new MainMenu();
	}

}
