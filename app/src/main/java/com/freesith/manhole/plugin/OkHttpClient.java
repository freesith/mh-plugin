package com.freesith.manhole.plugin;

import okhttp3.Interceptor;

public class OkHttpClient {

    public OkHttpClient(okhttp3.OkHttpClient.Builder builder) {
        for (int i = builder.interceptors().size() - 1; i >= 0 ; i--) {
            Interceptor interceptor = builder.interceptors().get(i);
            if (interceptor instanceof TestInterceptor) {
                builder.interceptors().remove(i);
            }
        }
        builder.interceptors().add(new TestInterceptor());
    }
}
