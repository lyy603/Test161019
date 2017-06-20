package com.example.testing.test161019.qqshare;

import android.util.Log;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * 作者：linyaye on 2016/12/16 14:35
 */

public class BaseUiListener implements IUiListener {

    String TAG = "lin";

    @Override
    public void onComplete(Object response) {
        doComplete((JSONObject) response);
    }

    protected void doComplete(JSONObject values) {
        Log.i(TAG, "doComplete: 完成" + values.toString());
    }

    @Override
    public void onError(UiError uiError) {
        Log.i(TAG, "onError: 错误");
    }

    @Override
    public void onCancel() {
        Log.i(TAG, "onCancel: 取消");
    }
}
