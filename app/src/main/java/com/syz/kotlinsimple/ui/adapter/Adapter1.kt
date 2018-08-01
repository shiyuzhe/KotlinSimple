package com.syz.kotlinsimple.ui.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.mvp.model.bean.Bean
import com.syz.kotlinsimple.mvp.model.bean.BookListBean
import com.syz.kotlinsimple.view.recyclerview.MultipleType
import com.syz.kotlinsimple.view.recyclerview.ViewHolder

/**

 * 作者:shiyuzhe on 2018/8/1 10:28
 * 邮箱:18091664559@163.com
 * Desc:
 */
class Adapter1(
    context: Context,
    beans: ArrayList<BookListBean>
) : CommonMultiAdapters<BookListBean>(context, beans, Type.get()) {
//    override fun getType(): MultipleType<BookListBean> {
//        return Type.get()
//    }


    override fun bindData(holder: ViewHolder, data: BookListBean, position: Int) {
        super.bindData(holder, data, position)
        holder.getView<TextView>(R.id.item_hot_text).setOnClickListener(View.OnClickListener {
            Toast.makeText(
                mContext,
                "点击第$position 项",
                Toast.LENGTH_SHORT
            ).show()
        })
        holder.setText(R.id.item_hot_text, data.toString())
    }

    class Type : MultipleType<BookListBean> {
        companion object {
            fun get(): Type {
                return Holder.instance
            }
        }

        private object Holder {
            val instance = Type()
        }

        override fun getLayoutId(item: BookListBean, position: Int): Int = R.layout.item_hot
    }

}