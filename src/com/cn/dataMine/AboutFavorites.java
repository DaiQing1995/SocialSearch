package com.cn.dataMine;

import java.util.List;

import com.cn.util.TokenGet;

import weibo4j.Favorite;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Favorites;
import weibo4j.model.FavoritesIds;
import weibo4j.model.FavoritesTag;
import weibo4j.model.WeiboException;
//读取用户收藏
public class AboutFavorites {

	public static void main(String[] args) {
		String access_token = TokenGet.TOKEN;
		Favorite fm = new Favorite(access_token);
		//1获得所有收藏及详细内容
		try {
			List<Favorites> favors = fm.getFavorites();
			for(Favorites s : favors){
				//这里的打印内容有些搞不懂，和看到的tostring函数不一样
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		//2根据tag id查询
		String tid = "411";
		try {
			List<Favorites> favors = fm.getFavoritesByTags(tid);
			for(Favorites s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		//3获得每条favorite ID statusId && tag && total number(ToString)
		try {
			List<FavoritesIds> ids = fm.getFavoritesIds();
			for(FavoritesIds s : ids){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		//4.getFavoritesIdsByTags，与2基本相同，可能应该输入tag名字，却依然是tag id
//		String tid = args[1];
		try {
//			List<FavoritesIds> favors = fm.getFavoritesIdsByTags(tid);
			List<FavoritesIds> favors = fm.getFavoritesIdsByTags("411");
			for(FavoritesIds s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		//5获得用户tags
		try {
			List<FavoritesTag> favors = fm.getFavoritesTags();
			for(FavoritesTag s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		//6.获取单条收藏信息
		String id = "4030540573066051";
		try {
			Favorites favors = fm.showFavorites(id);
			Log.logInfo(favors.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
