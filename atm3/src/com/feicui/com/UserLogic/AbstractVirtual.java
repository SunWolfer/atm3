package com.feicui.com.UserLogic;

import java.util.Scanner;

import com.feicui.com.AdminOperation.User;
import com.feicui.com.storage.ReadText;

public abstract class AbstractVirtual {
	
	protected static Atm atm = new Atm();

	protected User user= atm.getUser();
	public static Scanner scanner = new Scanner(System.in);
	
	public static ReadText readText = new ReadText();

	public abstract AbstractVirtual show();
}
