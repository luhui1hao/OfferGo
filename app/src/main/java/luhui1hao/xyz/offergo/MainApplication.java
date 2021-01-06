package luhui1hao.xyz.offergo;

import android.app.Application;
import android.content.Context;

class MainApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        this.mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
