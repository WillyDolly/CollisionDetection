package com.popland.pop.collisiondetection;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DragDrop_MovingIntersection extends AppCompatActivity implements View.OnTouchListener{
ImageView movingIV, stillIV;
TextView tv;
Rect movingRect, stillRect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop__moving_intersection);
        movingIV = (ImageView)findViewById(R.id.movingIV);
        stillIV = (ImageView)findViewById(R.id.stillIV);
        tv = (TextView)findViewById(R.id.TV);

        movingIV.setOnTouchListener(this);
    }
float newX, newY;
boolean moving = false;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        stillRect = new Rect();
        stillIV.getHitRect(stillRect);

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if(moving==true){
                    newX = event.getRawX()- movingIV.getWidth()/2;
                    newY = event.getRawY() - movingIV.getHeight()*3/2 ;
                    movingIV.setX(newX);
                    movingIV.setY(newY);

                    movingRect = new Rect();
                    movingIV.getHitRect(movingRect);

                    if(movingRect.intersect(stillRect))
                        tv.setVisibility(View.VISIBLE);
                    else
                        tv.setVisibility(View.INVISIBLE);
                }
                break;
            case MotionEvent.ACTION_UP:
                moving = false;
                break;
        }
        return true;
    }
}
