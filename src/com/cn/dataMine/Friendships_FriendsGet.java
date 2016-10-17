package com.cn.dataMine;

import java.util.List;

import com.cn.DataBaseService.Friendships_FriendsInput;
import com.cn.DataBaseService.UsersDataInput;

import weibo4j.Friendships;
import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class Friendships_FriendsGet {

	public static void main(String[] args) {
		String access_token = "2.004DezPC6P3DdD00518038e19iDRoD";
		String id = "2068602681";
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
