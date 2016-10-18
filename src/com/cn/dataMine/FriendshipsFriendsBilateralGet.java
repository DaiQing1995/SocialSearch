package com.cn.dataMine;

import com.cn.DataBaseService.UsersDataInput;
import com.cn.util.TokenGet;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
//获取用户双向关注的用户ID列表，即互粉UID列表
public class FriendshipsFriendsBilateralGet {
	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		String uid =TokenGet.UID;
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper users = fm.getFriendsBilateral(uid);
			for(User u : users.getUsers()){
				UsersDataInput.userDataInsert(u);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
