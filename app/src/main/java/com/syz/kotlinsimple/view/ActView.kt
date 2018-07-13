package com.syz.kotlinsimple.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import kotlinx.android.synthetic.main.act_view.*;

import java.util.ArrayList

class ActView : BaseActivity() {
    internal var strs: MutableList<String> = ArrayList()

    override fun layoutId(): Int = R.layout.act_view

    override fun initData() {
        for (i in 0..19) {
            strs.add("str$i")
        }
    }


    override fun initView() {
        rv.layoutManager = linearLayoutManager
        rv.adapter = MyAdapter()
    }

    private val linearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }


    internal inner class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(layoutInflater.inflate(R.layout.item_str, parent,
                    false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = strs[position]
        }

        override fun getItemCount(): Int {
            return strs.size
        }

        internal inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView

            init {
                textView = itemView.findViewById(R.id.textView)
            }
        }
    }

}
