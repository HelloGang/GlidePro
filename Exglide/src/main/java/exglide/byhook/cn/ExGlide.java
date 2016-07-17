package exglide.byhook.cn;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;

import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;

import java.io.InputStream;

/**
 * 作者: andy
 * 时间: 2016-07-17
 * 描述:
 * 修订:
 */
public class ExGlide {

    private StreamBitmapDecoder mDecoder;

    private Context mContext;

    public ExGlide(Context ctx){
        mContext = ctx;
    }

    public GenericRequestBuilder getBuilder(String url) {
        if (Build.VERSION.SDK_INT >= 16) {
            return getCommonBuilder(url);
        } else {
            return getWebpBuilder(url);
        }
    }

    private StreamBitmapDecoder getDecoder() {
        if (mDecoder == null) {
            mDecoder = new StreamBitmapDecoder(WebpDownSampler.AT_MOST, Glide.get(mContext).getBitmapPool(), DecodeFormat.PREFER_ARGB_8888);
        }
        return mDecoder;
    }

    /**
     * 获取构造器
     * API 16以下
     *
     * @param url
     * @return
     */
    private GenericRequestBuilder<String, InputStream, Bitmap, Bitmap> getWebpBuilder(String url) {
        GenericRequestBuilder<String, InputStream, Bitmap, Bitmap> requestBuilder = Glide
                .with(mContext)
                .using(Glide.buildStreamModelLoader(String.class, mContext), InputStream.class)
                .load(url)
                .as(Bitmap.class)
                .sourceEncoder(new StreamEncoder())
                .decoder(getDecoder())
                .cacheDecoder(new FileToStreamDecoder<>(getDecoder()));
        return requestBuilder;
    }

    /**
     * 获取构造器
     * API 16以上
     *
     * @param url
     * @return
     */
    private BitmapRequestBuilder<String, Bitmap> getCommonBuilder(String url) {
        BitmapRequestBuilder<String, Bitmap> builder = Glide.with(mContext)
                .load(url)
                .asBitmap()
                .dontAnimate();
        return builder;
    }
}
