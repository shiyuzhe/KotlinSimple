package com.syz.kotlinsimple.mvp.model

import com.syz.kotlinsimple.mvp.model.bean.BookBean
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.mvp.model.bean.PlanBean
import com.syz.kotlinsimple.net.RetrofitManager
import com.syz.kotlinsimple.rx.scheduler.SchedulerUtils
import io.reactivex.Observable
import retrofit2.Call

/**

 * 作者:shiyuzhe on 2018/7/11 17:04
 * 邮箱:18091664559@163.com
 * Desc:
 */
class BookModel {

    /**
     * 获取Book数据
     */
    fun requestBookData(string: String): Observable<BookBean> {
        return RetrofitManager.service.getBook(string)
            .compose(SchedulerUtils.ioToMain())
//            .map {  }
    }

    fun requestPlanData(string: String): Observable<PlanBean> {
        return RetrofitManager.service.getPlan()
            .compose(SchedulerUtils.ioToMain())
    }

    fun requestBookListData(string: String): Observable<ArrayList<BookListBean>> {
        return RetrofitManager.service.getBookList(string)
            .compose(SchedulerUtils.ioToMain())
    }
}