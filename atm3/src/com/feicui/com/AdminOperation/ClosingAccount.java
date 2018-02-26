package com.feicui.com.AdminOperation;

import java.io.IOException;
import java.sql.SQLException;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.storage.AdminMenu;
import com.feicui.com.util.DatabaseUtils;

/*
 *销户
 */
public class ClosingAccount extends AbstractVirtual{

	@Override
	public AbstractVirtual show() {
		
		System.out.println("请输入要销户的卡号");
		
		String num1 = scanner.nextLine();
		
		System.out.println("请输入要销户的身份证号");
		String num2 = scanner.nextLine();
		
		System.out.println("1:确认并返回主菜单");
		System.out.println("2:重新输入");
		String num3 = scanner.nextLine();
		
		if("1".equals(num3)) {
			try {
				DatabaseUtils utils = new DatabaseUtils();
				
				int i = utils.updateData("update user_ set judge = ?, status = ? "
						+ "where account = ? and card = ?","-1","已銷戶",num1,num2);
				System.out.println(i);
				
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
			return new AdminMenu();
		}
		
		if("2".equals(num3)) {
			
			return this;
		}
		return this;
		
		 
	}
	
}
