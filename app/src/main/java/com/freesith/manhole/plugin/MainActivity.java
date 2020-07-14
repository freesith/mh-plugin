package com.freesith.manhole.plugin;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import okhttp3.OkHttpClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpClient okHttpClient = new OkHttpClient();
    }
}
