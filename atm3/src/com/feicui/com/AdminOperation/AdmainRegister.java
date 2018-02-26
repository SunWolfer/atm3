package com.feicui.com.AdminOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.storage.AdminMenu;

/*
 *管理员验证登录
 */
public class AdmainRegister extends AbstractVirtual {

	/*
	 * 验证账户
	 */

	@Override
	public AbstractVirtual show() {

		System.out.println("请输入账号：");
		String str1 = scanner.nextLine();

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lalala?useSSL=false", "root", "123456");
			// 获取执行sql的PreparedStatement对象
			String sql = "select * from user_  where account = ?and judge = 999";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, str1);
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

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

		if (user.getAccount() == null)

		{

			System.out.println("用户名错误，请重新输入");

			return this;

		}
		
		a:while(true) {
			System.out.println("请输入密码");
			String str2 = scanner.nextLine();
			if (user.getPasswd().equals(str2)) {
				
				return new AdminMenu();
			}
			else {
				
				System.out.println("密码错误，请重新输入");
				
				continue a;
				
			}
		}

		
	}
}
