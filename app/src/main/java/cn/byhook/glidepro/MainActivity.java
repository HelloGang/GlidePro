package cn.byhook.glidepro;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import exglide.byhook.cn.ExGlide;

public class MainActivity extends FragmentActivity {

    private ImageView mIvLogo;

    private ExGlide mExGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExGlide = new ExGlide(this);
        initView();
        initData();
    }

    private void initView(){
        mIvLogo = (ImageView) findViewById(R.id.iv_logo);
    }

    private void initData(){
        mExGlide.getBuilder("http://p2.pstatp.com/list/300x196/abf0000dafb4f0b0c6c.webp").into(mIvLogo);
    }

}
