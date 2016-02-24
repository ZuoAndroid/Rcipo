package com.lietou.rcipo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * 项目名称：MyLoginDemo
 * 类描述：判断当前手机 是否安装了微信，qq
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/26 17:26
 * 修改人：Administrator
 * 修改时间：2016/1/26 17:26
 * 修改备注：
 */
public class Utils {

    /**
     * 判断微信客户端是否可用
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;

                Log.d("TAG" , "--->" + pn);
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 判断QQ客户端是否可用
     */
    public static  boolean isQQAvilible(Context context){
        final PackageManager manager = context.getPackageManager();
        List<PackageInfo> infos = manager.getInstalledPackages(0);
        if (infos != null){
            for (int i = 0; i < infos.size(); i++) {
                String p = infos.get(i).packageName;
                if (p.equals("com.tencent.mobileqq"));
                return  true;
            }
        }
        return false;
    }

    /**
     * 判断新浪微博客户端是否可用
     */
    public static boolean isXLWeiBoAvilible(Context context){
        final PackageManager manager = context.getPackageManager();
        List<PackageInfo> infos = manager.getInstalledPackages(0);
        if (infos != null){
            for (int i = 0; i < infos.size(); i++) {
                String p = infos.get(i).packageName;
                if (p.equals("com.sina.weibo"));
                Log.d("TAG" , "-->" + p);
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    public static boolean isYiXinAvilible(Context context){
        final PackageManager manager = context.getPackageManager();
        List<PackageInfo> infos = manager.getInstalledPackages(0);
        if (infos != null){
            for (int i = 0; i < infos.size(); i++) {
                String p = infos.get(i).packageName;
                if (p.equals("com.wangyi.yixin"));
                return true;
            }
        }
        return false;
    }

}
