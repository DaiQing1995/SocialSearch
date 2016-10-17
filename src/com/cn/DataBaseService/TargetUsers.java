package com.cn.DataBaseService;

import java.util.ArrayList;

import com.cn.util.TokenGet;

import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class TargetUsers {
	private static ArrayList<User> userList;

	private TargetUsers(){}
	
	public static ArrayList<User> GetTargetUsers() {
		if (userList == null)
			try {
				InitUsers();
			} catch (WeiboException e) {
				System.out.println("Init Users Error");
				e.printStackTrace();
			}
		return userList;
	}

	private static void InitUsers() throws WeiboException {
		userList = new ArrayList<User>();
		Users um = new Users(TokenGet.TOKEN);
		userList.add(um.showUserById("1881907940"));
		userList.add(um.showUserById("5729016246"));
		userList.add(um.showUserById("1492672833"));
		userList.add(um.showUserById("5048659542"));
		userList.add(um.showUserById("2604731783"));
		userList.add(um.showUserByDomain("kmykoto"));
		userList.add(um.showUserByDomain("zgheiren"));
		userList.add(um.showUserByDomain("fly51fly"));
		userList.add(um.showUserByDomain("cctv2shizhendema"));
		userList.add(um.showUserByDomain("fbb0916"));
	}
}
