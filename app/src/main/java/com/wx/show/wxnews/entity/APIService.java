package com.wx.show.wxnews.entity;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Luka on 2016/3/22.
 */
public interface APIService {
//    @GET("")
//    Call<Movie> loadMovie(@Query("pno") int pno,@Query("ps") int ps,@Query("dtype") String dtype, @Query("key") String key);


    /**
     * 获取正在上映的电影
     * @return
     */
    @GET("movie/in_theaters")
    Observable<Movie> getMovieInTheater();
    /**
     * 获取即将上映的电影
     * @return
     */
    @GET("movie/coming_soon")
    Observable<Movie> getMovieComingSoon();
    /**
     * 搜索电影
     * @return
     */
    @GET("movie/search")
    Observable<Movie> getMovieSearch(@Query("q") String movieSearch);

    /**
     *
     * @param catalog_id    目录编号
     * @param pn            数据返回起始
     * @param rn            数据返回条数，最大30
     * @return
     */
    @GET("goodbook/query")
    Observable<Book> getBookData(@Query("catalog_id") int catalog_id, @Query("pn") int pn, @Query("rn") int rn,@Query("key") String key);

    @GET("start-image/1080*1776")
    Observable<SplashImg> getSplashImg();

    /**
     * 知乎日报
     * @param date  日期，格式为:yyyyMMdd
     * @return
     */
    @GET("news/before/{date}")
    Observable<ZhihuDaily> getZhihuDaily(@Path("date") String date);

    /**
     * 知乎日报 item内容
     * @param newsId
     * @return
     */
    @GET("news/{id}")
    Observable<ZhihuNews> getZhihuNews(@Path("id") int newsId);

    @GET("loc/list")
    Observable<City> getCityList();

    /**
     * 获取活动列表
     * @param loc       城市
     * @param day_type  时间类型
     * @param type      活动类型
     * @return
     */
    @GET("event/list")
    Observable<Event> getEvent(@Query("loc") String loc,@Query("day_type") String day_type,@Query("type") String type);

    /**
     * 花瓣福利
     * @param num
     * @param page
     * @param beauty_appid
     * @param showapi_timestamp
     * @param type
     * @param beauty_sign
     * @return
     */
    // https://route.showapi.com/819-1?num=10&page=1&showapi_appid=17614&showapi_timestamp=20160415140024&type=38&showapi_sign=0453c8fc7f9c8c6fbb72da12349f591a
    @GET("819-1")
    Observable<Beauty> getBeauty(@Query("num") int num,@Query("page") int page,@Query("showapi_appid") String beauty_appid,@Query("showapi_timestamp") String showapi_timestamp,@Query("type") int type,@Query("showapi_sign") String beauty_sign);

}
