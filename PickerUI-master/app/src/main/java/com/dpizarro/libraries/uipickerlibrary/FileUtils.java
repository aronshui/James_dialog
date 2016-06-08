package com.dpizarro.libraries.uipickerlibrary;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Administrator on 2016-06-07.
 */
public class FileUtils {


    /**
     * 通过得到图片的宽高返回需要压缩的比例
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calueLateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        //原图片的宽度和高度
        final int height = options.outHeight;
        final int width = options.outWidth;

        int inSampleSize = 1;
        if (height>reqHeight || width>reqWidth){
            //计算出实际高度和目标宽度的比率
            final int heightRatio = Math.round((float) height/(float) reqHeight);
            final int widthRatio = Math.round((float) width/(float)reqWidth);
            //选择宽和高中最小的比率做为insampleSize的值可以保证最终图片的宽和高
            inSampleSize = heightRatio<widthRatio?heightRatio:widthRatio;
        }
        return inSampleSize;
    }


    /**
     * 进行图片压缩
     * @param res
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampleedBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        //第一次将解析injustDecodeBounds设置成true来获取图片的大小
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        //调用方法计算inSampleSize的值
        options.inSampleSize = calueLateInSampleSize(options,reqWidth,reqHeight);
        //使用获得inSampleSize解析图片
        options.inJustDecodeBounds = false;
        return  BitmapFactory.decodeResource(res,resId,options);
    }




}
