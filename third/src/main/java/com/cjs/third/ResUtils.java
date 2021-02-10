package com.cjs.third;

import android.content.Context;
import android.content.res.Resources;


/**
 * 资源Id工具类
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/9 15:07
 */
public class ResUtils {

    private Context context;

    public ResUtils(Context context) {
        this.context = context;
    }

    private static ResUtils instance;

    /**
     * 初始化工具实例
     *
     * @param context
     */
    public static void init(Context context) {
        if (instance == null) {
            instance = new ResUtils(context);
        }
    }

    /**
     * 获取工具实例
     *
     * @return
     */
    public static ResUtils getInstance() {
        return instance;
    }

    /**
     * 根据文件名获取文件资源Id
     *
     * @param resName 文件名字
     * @param resType 文件类型
     * @param pkgName 资源所在包的包名
     * @return
     */
    public int getResId(String resName, String resType, String pkgName) {
        Resources res = context.getResources();
        return res.getIdentifier(resName, resType, pkgName);
    }

    /**
     * 获取Drawable文件资源id
     * @param resName 文件名字
     * @param pkgName 资源所在包的包名
     * @return
     */
    public int getDrawableResId(String resName,String pkgName){
        return getResId(resName,"drawable",pkgName);
    }

    /**
     * 获取mipmap文件资源id
     * @param resName 文件名字
     * @param pkgName 资源所在包的包名
     * @return
     */
    public int getMipmapResId(String resName,String pkgName){
        return getResId(resName,"mipmap",pkgName);
    }

    /**
     * 获取布局文件资源id
     * @param resName 文件名字
     * @param pkgName 资源所在包的包名
     * @return
     */
    public int getLayoutResId(String resName,String pkgName){
        return getResId(resName,"layout",pkgName);
    }
}
