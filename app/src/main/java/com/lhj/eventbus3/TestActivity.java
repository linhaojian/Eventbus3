package com.lhj.eventbus3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2018/4/10.
 */

public class TestActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        EventBus.getDefault().register(this);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent messageEvent = new MessageEvent("Hello Event!");
                EventBus.getDefault().post(messageEvent);//基本数据类型发送事件没有响应
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textView.setX(event.getX());
        textView.setY(event.getY());
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onE(MessageEvent messageEvent){
        Log.e("linhaojian","TestActivity : "+messageEvent.getMessage());
    }

}
