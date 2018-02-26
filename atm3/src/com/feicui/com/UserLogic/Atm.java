package com.feicui.com.UserLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.feicui.com.AdminOperation.User;
import com.feicui.com.util.DatabaseUtils;

public class Atm {
	
	/*
	 * 连接数据库
	 */
	private DatabaseUtils utils;

	public Atm() {
		// TODO Auto-generated constructor stub
		try {
			utils = new DatabaseUtils();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Date date = new Date();

	private User user = new User() ;

	public User getUser() {

		return user;

	}

	/*
	 * 取款运算
	 */
	public void DrawBusiness() {
		//取款后的金额
		user.setAmount(user.getAmount() - user.getDraw());
		//取款成功时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");// 取款成功时间
		user.setDrawdate(sdf1.format(date));
		
		try {
			//取款流水
			utils.updateData("insert into transaction       \r\n"
					+ "      (time, account,trade_type,change_amount,amount)\r\n"
					+ "value (?,?,?,?,?)", user.getDrawdate(),user.getAccount(),"取款",user.getDraw()+"",user.getAmount()+"");
			
			//修改取款后的金额
			utils.updateData("update user_ set amount = ? where account = ?",user.getAmount()+"",user.getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 存款运算
	 */
	public void OperaBusiness() {
		//存款后的金额
		user.setAmount(user.getAmount() + user.getOpera());

		// 获取日期
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒"); // 存款成功时间
		user.setOperationdate(sdf2.format(date));
		
		try {
			//存款流水
			utils.updateData("insert into transaction  \r\n"
					+ "     (time, account,trade_type,change_amount,amount)\r\n"
					+ "value (?,?,?,?,?)", user.getOperationdate(),user.getAccount(),"存款",user.getOpera()+"",user.getAmount()+"");
			//修改存款后的金额
			utils.updateData("update user_ set amount = ? where account = ?",user.getAmount()+"",user.getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 转账运算
	 */
	public void OtherBusiness(User otheruser) {
		//本账户转账后金额
		user.setAmount(user.getAmount() - user.getOthermoney());
		//目标账户转账后金额
		otheruser.setAmount(otheruser.getAmount() + user.getOthermoney());

		// 转账成功时间
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		user.setOperationdate(sdf3.format(date));

		try {
			//本账户转账流水
			utils.updateData("insert into transaction       \r\n"
					+ "      (time, account,trade_type,change_amount,amount)\r\n"
					+ "value (?,?,?,?,?)", user.getOperationdate(),user.getAccount(),"支出",user.getOthermoney()+"",user.getAmount()+"");
			//更改本账户转账后的金额
			utils.updateData("update user_ set amount = ? where account = ?",user.getAmount()+"",user.getAccount());
			
			//目标账户转账流水
			utils.updateData("insert into transaction       \r\n"
					+ "      (time, account,trade_type,change_amount,amount)\r\n"
					+ "value (?,?,?,?,?)", otheruser.getOperationdate(),otheruser.getAccount(),"收入",otheruser.getOthermoney()+"",otheruser.getAmount()+"");
			//更改目标账户转账后的金额
			utils.updateData("update user_ set amount = ? where account = ?",otheruser.getAmount()+"",otheruser.getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
