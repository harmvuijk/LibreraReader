package com.foobnix.android.utils;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.ebookdroid.LibreraApp;

import java.util.Random;

public class Safe {

    public static final String TXT_SAFE_RUN = "file://SAFE_RUN-";
    static Random r = new Random();
    static int counter;

    public static void run(final Runnable action) {
//        if (action != null) {
//            action.run();
//        }
//        if (true) {
//            return;
//        }

        Glide.with(LibreraApp.context)
                .asBitmap().load(TXT_SAFE_RUN)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        if (action != null) {
                            action.run();
                        }
                    }
                });


    }


}
