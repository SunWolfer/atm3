package com.feicui.com.storage;

import com.feicui.com.AdminOperation.OpenAccount;
import com.feicui.com.UserLogic.AbstractVirtual;

/*
 * 开户判断
 */
public class OpenUser extends AbstractVirtual{
	
	@Override
	public AbstractVirtual show() {
		
		//姓名
		importName();
		//性别
		importGender();
		//身份证
		importId();
		//学历
		importEdu();
		//地址
		importAddress();
		//设置出生日期并生成账号
		importDate();
		
		System.out.println("账号已生成");
		
		//设置密码
		importPass();
		// TODO Auto-generated method stub
		System.out.println("1:确认并返回主菜单");
		System.out.println("2:重新输入");
		
		String string = scanner.nextLine();
		
		if("1".equals(string)) {
			return new OpenAccount();
		}
		if("2".equals(string)) {
			
			return this;
		}
		return null;
		
	}

	/*
	 * 判断姓名
	 */
	private void importName() {

		while (true) {

			System.out.println("请输入客户姓名");
			String str1 = scanner.nextLine();

			if (str1.length() <= 10) {

				user.setName(str1);
				user.setStatus("正常用戶");
				break;

			} else {

				System.out.println("用户姓名不能超过10位");
			}
		}

	}

	/*
	 * 判断密码
	 */
	private void importPass() {

		while (true) {

			System.out.println("请输入客户密码");
			String str2 = scanner.nextLine();

			if (checkAccount(str2)) {
				
				System.out.println("请再次输入用户密码");
				String number1 = scanner.nextLine();
				
				if(number1.equals(str2)) {
					user.setPasswd(str2);
					break;
				}else {
					System.out.println("两次输入的密码必须相同");
				}				

			} else {

				System.out.println("6位 不能为空 数字或字母组合");
			}
		}

	}

	/*
	 * 性别
	 */
	private void importGender() {

		while (true) {

			System.out.println("请输入客户性别");
			System.out.println("请务必确认正确,之后不可修改(1代表男 2代表女)");
			String str3 = scanner.nextLine();

			if ("1".equals(str3)) {

				user.setSex(str3);
				break;

			} else if ("2".equals(str3)) {

				user.setSex(str3);
				break;

			} else {

				System.out.println("请输入1或2");

			}

		}

	}

	/*
	 * 判断身份证
	 */
	private void importId() {

		while (true) {

			System.out.println("请输入客户的身份证");
			System.out.println("请务必确认正确,之后不可修改");
			String str4 = scanner.nextLine();

			if (checkId(str4)) {

				user.setCard(str4);
				break;

			} else {

				System.out.println("居民身份证必须为18位数字");

			}
		}

	}

	private void importEdu() {

		System.out.println("请输入客户学历");
		System.out.println("1代表  小学  2代表 中学  3代表大学 4代表其他");

		String str5 = scanner.nextLine();
		user.setEducation(str5);;

	}

	private void importAddress() {

		System.out.println("请输入客户地址");
		String str6 = scanner.nextLine();
		user.setAddress(str6);;

	}
	
	//出生日期
	private void importDate() {
		
		System.out.println("请输入出生日期 按照yyyy-MM-dd 格式进行输入");
		
		String str = scanner.nextLine();
		
		//生成账号
		
		user.setAccount("BC180" + user.getSex() + str + (int)(Math.floor(Math.random()*1000)));

	}

	/*
	 * 正则表达式判断密码
	 */
	private boolean checkAccount(String str2) {

		return str2.matches("[a-z0-9A-Z]{6}") && !str2.matches("[a-zA-Z]+") && // 不能只包含字母
				!str2.matches("[0-9]+"); // 不能只包含数字
	}

	// 验证身份证
	private boolean checkId(String str4) {

		return str4.matches("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");// 只包含数字

	}


}
