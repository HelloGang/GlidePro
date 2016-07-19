package cn.byhook.glidepro;

import android.app.Application;

import exglide.byhook.cn.ExGlide;

/**
 * 作者: andy
 * 时间: 16-7-18
 * 描述:
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ExGlide.init(this);
    }
}
