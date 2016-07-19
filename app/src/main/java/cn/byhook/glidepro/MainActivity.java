package cn.byhook.glidepro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends Activity {

    private ImageView mIvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
    }

    private void initData(){
        Glide.with(this).load(R.drawable.main).into(mIvLogo);
        //Glide.with(this).load("https://github.com/byhook/GlidePro/blob/master/img/main.webp").into(mIvLogo);
        //ExGlide.get().getBuilder("http://p2.pstatp.com/list/300x196/abf0000dafb4f0b0c6c.webp").into(mIvLogo);
    }

}
