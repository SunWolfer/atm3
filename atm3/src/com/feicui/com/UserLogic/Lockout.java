package com.feicui.com.UserLogic;

import java.io.IOException;
import java.sql.SQLException;

import com.feicui.com.UserOperation.Login;
import com.feicui.com.util.DatabaseUtils;

public class Lockout extends AbstractVirtual {
	/*
	 * 执行锁户
	 * (non-Javadoc)
	 * @see com.feicui.com.user.AbstractVirtual#show()
	 */
	@Override
	public AbstractVirtual show() {

		try {
			DatabaseUtils utils = new DatabaseUtils();

			utils.updateData("update user_ set judge = ?, status = ? "
					+ "where account = ?", "0", "已锁戶", user.getAccount());
			System.out.println("账号已锁定");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		return new Login();
	}

}
