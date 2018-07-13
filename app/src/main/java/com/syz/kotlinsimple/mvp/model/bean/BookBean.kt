package com.syz.kotlinsimple.mvp.model.bean


/**

 * 作者:shiyuzhe on 2018/7/13 16:41
 * 邮箱:18091664559@163.com
 * Desc:
 */
data class BookBean(var success: Boolean, var message: String, var book: Book) {

    data class Book(
        var authors: String
        , var booklabels: String
        , var brief: String
        , var buyurl: String
        , var canbuy: Boolean
        , var favoritepages: String
        , var favoritesum: Int
        , var gooddegree: Int
        , var id: Int
        , var isreading: Boolean
        , var publisher: String
        , var publishtime: Long
        , var readersum: Int, var reviewsum: Int, var subcategoryid: Int
        , var subcategoryname: String
        , var title: String
        , var topcategoryid: Int
        , var topcategoryname: String
        , var version: String
    )
}