package com.feicui.com;

import com.feicui.com.AdminOperation.Interface;
import com.feicui.com.UserLogic.AbstractVirtual;

public class Execute {

	public static void main(String[] args) {

		AbstractVirtual interFace = new Interface();

		while (true) {
			interFace = interFace.show();
		}

	}
}
