package com.cn.dataMine;

import com.cn.DataBaseService.UsersDataInput;
import com.cn.util.TokenGet;

import weibo4j.Friendships;
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
//获取用户的粉丝列表
public class FriendshipsFollowersGet {
	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		Friendships fm = new Friendships(access_token);
		Users um = new Users(TokenGet.TOKEN);
		User user;
		try {
			user = um.showUserById(TokenGet.UID);
			UserWapper users = fm.getFollowersByName(user.getScreenName());
			for(User u : users.getUsers()){
				UsersDataInput.userDataInsert(u);
			}
			UserWapper users1 = fm.getFollowersByName(user.getScreenName());
			for(User u : users1.getUsers()){
				UsersDataInput.userDataInsert(u);
			}
		}catch (WeiboException e1) {
			e1.printStackTrace();
		}
	}
}
