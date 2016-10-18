package com.cn.dataMine;

import com.cn.DataBaseService.UsersDataInput;
import com.cn.util.TokenGet;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
//获取用户优质粉丝列表
public class FriendshipsFollowersActiveGet {

	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		String uid = TokenGet.UID;
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper users = fm.getFollowersActive(uid);
			for(User u : users.getUsers()){
				UsersDataInput.userDataInsert(u);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}
}
