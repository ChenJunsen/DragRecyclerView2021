package com.cjs.third;

import android.content.Context;
import android.widget.Toast;

/**
 * 防止重复弹出的Toast
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/19 13:56
 */
public class ToastUtils {
    private static Toast toastInstance0;
    private static Toast toastInstance1;

    public static void showShort(Context context, String msg) {
        if(toastInstance0==null){
            toastInstance0=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
            toastInstance0.setText(msg);
            toastInstance0.setDuration(Toast.LENGTH_SHORT);
        }
        toastInstance0.show();
//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String msg) {
        if(toastInstance1==null){
            toastInstance1=new Toast(context);
        }else{
            toastInstance1.setText(msg);
            toastInstance1.setDuration(Toast.LENGTH_LONG);
        }
        toastInstance1.show();
//        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
