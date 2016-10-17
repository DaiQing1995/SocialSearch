package com.cn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

public class TokenGet {
	public static final String TOKEN = "2.004DezPC6P3DdD00518038e19iDRoD";
	public static final String UID = "2068602681";
	
	public static void getToken() throws WeiboException
	{
		Oauth oauth = new Oauth();
		BareBonesBrowserLaunch.openURL(oauth.authorize("code"));
		System.out.println(oauth.authorize("code"));
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = null;
		try {
			code = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Log.logInfo("code: " + code);
		try{
			System.out.println(oauth.getAccessTokenByCode(code));
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
		}
}
