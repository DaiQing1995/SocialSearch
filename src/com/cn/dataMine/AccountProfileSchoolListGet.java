package com.cn.dataMine;

import java.util.List;

import com.cn.util.TokenGet;

import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.School;
import weibo4j.model.WeiboException;
//获取所有的学校列表
public class AccountProfileSchoolListGet {

	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		Account am = new Account(access_token);
		String province = "11";//province 省份范围，省份ID
		String capital = "B";//capital 学校首字母
		try {
			List<School> schools = am.getAccountProfileSchoolList(province,
					capital);
			for (School school : schools) {
				Log.logInfo(school.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
