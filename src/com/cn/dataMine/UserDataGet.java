package com.cn.dataMine;

import java.util.ArrayList;

import com.cn.DataBaseService.TargetUsers;
import com.cn.DataBaseService.UsersDataInput;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class UserDataGet {
	public static void main(String[] args) throws WeiboException {
		ArrayList<User> userList = TargetUsers.GetTargetUsers();
		for (int i = 0;i < userList.size();++ i)
		{
			UsersDataInput.userDataInsert(userList.get(i));
		}
//		Log.logInfo(user.toString());
	}
}