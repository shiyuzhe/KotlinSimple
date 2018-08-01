package com.syz.kotlinsimple.mvp.model.bean

/**
 * 作者:shiyuzhe on 2018/7/30 13:23
 * 邮箱:18091664559@163.com
 * Desc:
 */
data class BookListBean(
    var list_id: String? = null,
    var list_name: String? = null,
    var list_img: String? = null,
    var banner_img: String? = null,
    var desc: String? = null,
    var slogan: String? = null,
    var books: String? = null,
    var discount: String? = null,
    var manual_price: String? = null,
    var content: String? = null,
    var num: Int = 0,
    var sort: Int = 0,
    var create_time: Int = 0,
    var status: Int = 0,
    var price: String? = null,
    var discountPrice: String? = null,
    var isRight: Int = 0//1为已购买
): Bean
