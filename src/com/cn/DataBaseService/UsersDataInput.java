package com.cn.DataBaseService;

import com.cn.util.DBUtils;

import weibo4j.model.User;

public class UsersDataInput {
	public static void userDataInsert(User user){
		DBUtils dbUtils = DBUtils.getDB();
		int allowAcgMsg,allowAllComment;
		allowAcgMsg = user.isallowAllActMsg()? 1:0;
		allowAllComment = user.isallowAllComment()? 1:0;
		
		dbUtils.insert("insert into users"
				+ "(id,screenName,name,province,city,"
				+ "location,gender,followersCount,"
				+ "friendsCount,favouritesCount,verifiedType,"
				+ "allowAllActMsg,allowAllComment,biFollowersCount) "
				+ "values("
				+ "\"" + user.getId()+ "\"" +","
				+ "\"" + user.getScreenName() +"\"" + ","
				+ "\"" + user.getName() + "\"" + ","
				+ user.getProvince() + ","
				+ user.getCity() + ","
				+ "\"" + user.getLocation() + "\"" + ","
				+ "\"" + user.getGender() + "\"" + ","
				+ user.getFollowersCount() + ","
				+ user.getFriendsCount() + ","
				+ user.getFavouritesCount() + ","
				+ user.getVerifiedType()+ ","
				+ allowAcgMsg + ","
				+ allowAllComment + ","
				+ user.getbiFollowersCount() + ")");
	}
}
