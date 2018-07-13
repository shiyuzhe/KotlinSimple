package com.syz.kotlinsimple.mvp.model.bean

/**

 * 作者:shiyuzhe on 2018/7/13 19:02
 * 邮箱:18091664559@163.com
 * Desc:
 */
data class PlanBean(val code: String, val msg: String, val data: Plan) {
    data class Plan(
        var list_name: String,
        var plan_id: String,
        var list_id: String,
        var user_id: String,
        var time: String,
        var num: String,
        var status: String,
        var abate: String,
        var registrationid: String,
        var created_at: String,
        var updated_at: String
    )
}
