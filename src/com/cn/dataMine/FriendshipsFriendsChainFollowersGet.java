package com.cn.dataMine;

import com.cn.DataBaseService.UsersDataInput;
import com.cn.util.TokenGet;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
//获取我的关注人中关注了指定用户的人 
public class FriendshipsFriendsChainFollowersGet {
	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		//String uid = TokenGet.UID;
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper  users = fm.getFriendsChainFollowers("3022722317");//"3022722317"是测试的指定的用户
			for(User u : users.getUsers()){
				UsersDataInput.userDataInsert(u);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
