package com.dpizarro.libraries.uipickerlibrary;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;

/**
 * Created by Administrator on 2016-06-07.
 */
public class LruCacheActivity extends Activity {

    public LruCache<String,Bitmap> mMemoryCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取内存中可用的内存最大值
        //LruCachet通过构造函数传入缓存值，以Kb为单位
        int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        //使用内存的缓存的8分之一进行缓存
        int cacheSize = maxMemory / 8;


        mMemoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount()/1024;
            }
        };
    }


    private void addBitmapToMemoryCache(String key,Bitmap value){
        if (getBitmapFromMemoryCache(key)==null){
            mMemoryCache.put(key,value);
        }
    };

    private  Bitmap getBitmapFromMemoryCache(String key){

        return  mMemoryCache.get(key);
    };
}
