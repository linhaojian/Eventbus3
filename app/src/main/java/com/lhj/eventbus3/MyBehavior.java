package com.lhj.eventbus3;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<Button>{

    public MyBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    /**
     * 判断child的布局是否依赖dependency
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        //如果dependency是TempView的实例，说明它就是我们所需要的Dependency
        return dependency instanceof TextView;
    }

    /**
     * 当dependency发生改变时（位置、宽高等），执行这个函数
     * 返回true表示child的位置或者是宽高要发生改变，否则就返回false
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        Log.e("linhaojian",dependency.getX()+"  :  "+dependency.getY());
        child.setX(dependency.getX());
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }
}
