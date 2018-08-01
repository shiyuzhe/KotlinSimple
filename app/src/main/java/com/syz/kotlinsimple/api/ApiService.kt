package com.syz.kotlinsimple.api

import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**

 * 作者:shiyuzhe on 2018/7/13 16:38
 * 邮箱:18091664559@163.com
 * Desc:
 */
interface ApiService {

    @GET("Book")
    fun getBook(@Query("id") id: String): Observable<BookBean>

    @GET("plans/24772")
    fun getPlan(): Observable<PlanBean>

    @GET("Book")
    fun getBookNoRX(@Query("id") id: String): Call<BookBean>

    @Headers("Cache-Control:public, max-age=30")
    @GET("booklists")
    fun getBookList(@Query("id") id: String): Observable<ArrayList<BookListBean>>
}