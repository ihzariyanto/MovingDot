package com.example.muhammadihzat.movingdot;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView _titik;

    private long _xDelta;
    private long _yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _titik = (ImageView) findViewById(R.id.dotPosition);



    }

    public void translateDot (View view){
        Random random = new Random();

        _xDelta = random.nextInt(getWindowManager().getDefaultDisplay().getWidth()-150);
        _yDelta = random.nextInt(getWindowManager().getDefaultDisplay().getHeight()-350);

        ObjectAnimator translateX = ObjectAnimator.ofFloat(_titik, "x", _xDelta);
        ObjectAnimator translateY = ObjectAnimator.ofFloat(_titik, "y", _yDelta);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.playTogether(translateX, translateY);
        animatorSet.start();

    }
}
