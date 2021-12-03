package com.reactnativeopenapp;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = OpenAppModule.NAME)
public class OpenAppModule extends ReactContextBaseJavaModule {
    public static final String NAME = "OpenApp";

    public OpenAppModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void openApp(String packName){
        Intent intent = reactContext.getPackageManager().getLaunchIntentForPackage(packName);
        if(intent != null){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            reactContext.startActivity(intent);
        }
        else {
            Intent intent2 = new Intent(Intent.ACTION_VIEW);
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packName));
            intent2.setPackage("com.android.vending");
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            reactContext.startActivity(intent2);
        }
    }
}
