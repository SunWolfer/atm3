package com.feicui.com.UserLogic;

import java.io.File;

import com.feicui.com.AdminOperation.Interface;
import com.feicui.com.UserOperation.DrawMoney;
import com.feicui.com.UserOperation.Operation;
import com.feicui.com.UserOperation.QueryMenu;
import com.feicui.com.UserOperation.Record;
import com.feicui.com.UserOperation.Transfer;

/*
 * 主菜单
 */
public class MainMenu extends AbstractVirtual {

	public AbstractVirtual show() {

		/*
		 * 读取主菜单文件
		 */
		
		readText.readText("menu" + File.separator + "mainmenu.txt");

		String num = scanner.nextLine();
		
		//查询
		if ("1".equals(num)) {
			
			return new QueryMenu();
			
		}
		
		//转账
		if ("2".equals(num)) {
			
			return new Transfer();
			
		}
		
		//取款
		if ("3".equals(num)) {
			
			return new DrawMoney();
			
		}
		
		//存款
		if ("4".equals(num)) {
			
			return new Operation();
			
		}
		
		//交易记录
		if ("5".equals(num)) {
			
			return new Record();
			
		}
		
		//退卡
		if ("6".equals(num)) {
			
			return new Interface();
			
		}
		
		return this;
		
	}

}
