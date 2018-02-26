package com.feicui.com.AdminOperation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.feicui.com.UserLogic.AbstractVirtual;
import com.feicui.com.storage.AdminMenu;
import com.feicui.com.util.DatabaseUtils;

public class RelieveLockoutAccount extends AbstractVirtual{
	/*
	 * 解除锁定账户
	 * (non-Javadoc)
	 * @see com.feicui.com.user.Virtual#show()
	 */
	@Override
	public AbstractVirtual show() {
		
		
		try {
	        DatabaseUtils utils = new DatabaseUtils();
	        
	        System.out.println("请输入要解除锁定的账户卡号");
	        
	        String num = scanner.nextLine();
	        
	        List<User> list = utils.queryData(User.class, "SELECT * FROM user_ where judge = 1 and account = ?",num);

	        System.out.println(list);
	        
	        System.out.println("1:返回主菜单");
	        String string = scanner.nextLine();
	        
	        if("1".equals(string)) {
	        	
	        	return new AdminMenu();
	        }else {
	        	
	        	return this;
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
