package com.android.fresco.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.anbetter.log.MLog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.facebook.fresco.helper.Phoenix;
import com.facebook.fresco.helper.listener.IResult;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by android_ls on 16/11/10.
 */

public class FrescoBaseUseActivity extends AppCompatActivity {

    CircleImageView circleImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_base_use);

        String url = "http://ww3.sinaimg.cn/large/610dc034jw1f6m4aj83g9j20zk1hcww3.jpg";

        circleImageView = (CircleImageView) findViewById(R.id.sdv_0);


        final ImageView imageView = (ImageView) findViewById(R.id.iv_thumbnail);
        String url1 = "http://ww1.sinaimg.cn/large/610dc034jw1fahy9m7xw0j20u00u042l.jpg";
        Phoenix.with(this)
                .setUrl(url1)
                .setWidth(180)
                .setHeight(180)
                .setCircleBitmap(false) // 圆形的
                .setResult(new IResult<Bitmap>() {
                    @Override
                    public void onResult(Bitmap bitmap) {
                        MLog.i("Thread.currentThread().getId() = " + Thread.currentThread().getId());

                        circleImageView.setImageBitmap(bitmap);
                    }
                })
                .load();


        // 从网络加载一张图片
        Phoenix.with((SimpleDraweeView)findViewById(R.id.sdv_1)).load(url);
//        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_1), url);

        // 网络加载一张图片，并以圆形显示
        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_2), url);

        // 网络加载一张图片，并以圆形加边框显示
        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_3), url);

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_4), url);

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_5), url);

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_6), url);

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_7), "");

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_8), url);

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_9), url);
        findViewById(R.id.sdv_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MLog.i("按下效果");

            }
        });

        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_10), url);

        String url2 = "http://www.baidu.com";
        ImageLoader.loadImage((SimpleDraweeView)findViewById(R.id.sdv_11), url2);

    }

}
