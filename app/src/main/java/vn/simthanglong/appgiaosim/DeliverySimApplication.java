package vn.simthanglong.appgiaosim;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import vn.simthanglong.appgiaosim.utils.TypefaceContainer;

/**
 * Created by CanTran on 8/10/18.
 */
public class DeliverySimApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceContainer.init(getApplicationContext());
        //fix bug capture image on s8
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
//        final Fabric fabric = new Fabric.Builder(this)
//                .kits(new Crashlytics())
//                .debuggable(true)
//                .build();
//        Fabric.with(fabric);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
