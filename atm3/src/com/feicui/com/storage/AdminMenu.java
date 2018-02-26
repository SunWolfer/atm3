package com.feicui.com.storage;

import java.io.File;

import com.feicui.com.AdminOperation.AmendMenu;
import com.feicui.com.AdminOperation.ClosingAccount;
import com.feicui.com.AdminOperation.Inquire;
import com.feicui.com.AdminOperation.InquireClosingAccount;
import com.feicui.com.AdminOperation.InquireLockoutAccount;
import com.feicui.com.AdminOperation.Interface;
import com.feicui.com.AdminOperation.RelieveLockoutAccount;
import com.feicui.com.UserLogic.AbstractVirtual;


public class AdminMenu extends AbstractVirtual{

	@Override
	public AbstractVirtual show() {

		/*
		 * 主菜单
		 */
		ReadText readText = new ReadText();
		readText.readText("menu" + File.separator + "adminmenu.txt");

		String str = scanner.nextLine();

		// 开户
		if ("1".equals(str)) {
			
			return new OpenUser();
		}

		// 销户
		if ("2".equals(str)) {
			
			return new ClosingAccount();
		}

		// 查询客户信息
		if ("3".equals(str)) {
			
			return new Inquire();
		}

		// 修改客户信息
		if ("4".equals(str)) {
			
			return new AmendMenu();
			
		}
		
		//查询销户客户信息
		
		if("5".equals(str)) {
			
			return new InquireClosingAccount();
		}
		
		//查询锁定账户
		if("6".equals(str)) {
			
			return new InquireLockoutAccount();
		}
		
		//解除锁定账户
		
		if("7".equals(str)) {
			
			return new RelieveLockoutAccount();
		}

		// 退出
		if ("8".equals(str)) {
			
			return new Interface();
			
		}
		return null;
	}

}
