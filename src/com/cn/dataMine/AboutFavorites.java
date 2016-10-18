package com.cn.dataMine;

import java.util.List;

import com.cn.util.TokenGet;

import weibo4j.Favorite;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Favorites;
import weibo4j.model.FavoritesTag;
import weibo4j.model.WeiboException;
//读取用户收藏
public class AboutFavorites {

	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		Favorite fm = new Favorite(access_token);
		try {
			List<Favorites> favors = fm.getFavorites();
			for(Favorites s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
//		String tid = "4031914559764021";
//		try {
//			List<Favorites> favors = fm.getFavoritesByTags(tid);
//			for(Favorites s : favors){
//				Log.logInfo(s.toString());
//			}
//		} catch (WeiboException e) {
//			e.printStackTrace();
//		}
		try {
			List<FavoritesTag> favors = fm.getFavoritesTags();
			for(FavoritesTag s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
