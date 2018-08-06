package com.syz.kotlinsimple.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syz.kotlinsimple.R;

import java.lang.ref.WeakReference;

public class ActHandler extends AppCompatActivity {
    private TextView show;
    //static handler   ????????
    //private static Handler handler;
    private Handler handler;

    private static class myHandler extends Handler {
        private WeakReference<ActHandler> softReference;

        myHandler(ActHandler activity) {
            softReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (softReference.get() != null) {
                softReference.get().show.setText("msg:" + msg.what);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_handler);
        show = findViewById(R.id.show);
        handler = new myHandler(this);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 50; i++) {
                    Message msg = Message.obtain();
                    msg.what = i;// 消息标识
                    handler.sendMessageDelayed(msg, i * 300);
                    handler.sendEmptyMessageDelayed(i, i * 100);
                }
//                postMsg();
            }
        });
    }

//    private static void postMsg() {
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // a. 定义要发送的消息
//                    Message msg = Message.obtain();
//                    msg.what = i;// 消息标识
//                    msg.obj = "BB";// 消息存放
//                    // b. 传入主线程的Handler & 向其MessageQueue发送消息
//                    handler.sendMessage(msg);
//                }
//
//            }
//        }.start();
//    }

}
