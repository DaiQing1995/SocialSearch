package com.cn.dataMine;

import com.cn.DataBaseService.Friendships_FriendsInput;
import com.cn.util.TokenGet;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class Friendships_FriendsGet {

	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		String id = TokenGet.UID;
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper users = fm.getFriendsByID(id);
			for (User u : users.getUsers()) {
				Friendships_FriendsInput.friendshipsFriendsInsert(u);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}
}
