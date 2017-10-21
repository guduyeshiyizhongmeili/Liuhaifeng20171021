package com.bwie.test.liuhaifeng20171021;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import static android.os.Build.VERSION_CODES.M;

public class LoadActivity extends AppCompatActivity {

    private ImageView mImageView;
    private MyRoundProcess mMyRoundProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        initView();
        float curTranslationY = mImageView.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "translationY", -500f, curTranslationY);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageView, "scaleY", 1f, 2f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator1).after(animator);
        animSet.setDuration(3000);
        animSet.start();
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent=new Intent(LoadActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mMyRoundProcess = (MyRoundProcess) findViewById(R.id.my_round_process);
        mMyRoundProcess.runAnimate(360);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMyRoundProcess != null){
            mMyRoundProcess.cancelAnimate();
        }
    }
}
