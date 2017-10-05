package com.popland.pop.collisiondetection;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class StaticIntersection extends AppCompatActivity {
ImageView imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_intersection);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        Animation translation = new TranslateAnimation(0,imageView1.getX(),0,imageView1.getY());
//        translation.setDuration(5000);
//        translation.setFillAfter(true);
//        imageView2.setAnimation(translation);

        Rect rect1 = new Rect();
        imageView1.getHitRect(rect1);

        Rect rect2 = new Rect();
        imageView2.getHitRect(rect2);

        if(Rect.intersects(rect1,rect2))//work for 2 Views' fixed location
            Toast.makeText(StaticIntersection.this,"intersect",Toast.LENGTH_SHORT).show();
    }
}
