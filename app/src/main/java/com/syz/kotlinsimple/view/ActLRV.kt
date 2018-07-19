package com.syz.kotlinsimple.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import kotlinx.android.synthetic.main.act_lrv.*
import java.util.ArrayList

class ActLRV : BaseActivity() {
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var adapter: LRecyclerViewAdapter? = null
    private var strs: MutableList<String> = ArrayList()
    override fun layoutId(): Int = R.layout.act_lrv

    override fun initData() {
        for (i in 0..19) {
            strs.add("str$i")
        }
    }

    override fun initView() {
        lrv.layoutManager = linearLayoutManager
        adapter = LRecyclerViewAdapter(MyAdapter())
        lrv.adapter = adapter
        lrv.setLoadMoreEnabled(false)
        lrv.setPullRefreshEnabled(false)
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
