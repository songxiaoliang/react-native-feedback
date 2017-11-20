package com.uniapp.feedback;

import android.util.Log;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.uniapp.utils.ScreenUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 反馈交互Module
 * Created by Song on 2017/11/13.
 */
public class FeedBackModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext mReactContext;
    private static final String MODULE_NAME = "feedbackModule";

    public FeedBackModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    /**
     * 跳转到反馈界面
     */
    @ReactMethod
    public void openFeedbackActivity(ReadableMap poiData) {
        if(poiData != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(Constant.POI_ID, poiData.getString(Constant.POI_ID));
                jsonObject.put(Constant.PLAN_ID, poiData.getString(Constant.PLAN_ID));
                jsonObject.put(Constant.DAY, poiData.getString(Constant.DAY));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            FeedbackAPI.setAppExtInfo(jsonObject);
        } else {
            FeedbackAPI.setAppExtInfo(null);
        }
        FeedbackAPI.setTitleBarHeight(ScreenUtil.dip2px(mReactContext, 50));
        FeedbackAPI.setTranslucent(false);
        FeedbackAPI.openFeedbackActivity();
}
}
