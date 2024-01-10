package jp.ac.ritsumei.ise.phy.exp2.is0662ks.musicgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class Note {
    private float x,y;
    private float speed;
    private float spawnTime;
    private boolean active;
    private final static float Radius = 120.0f;
    public Note(float x){
        this.x = x;
        this.y = -Radius;
    }


    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setSpeed(float speed){
        this.speed = speed;
    }

    public void setSpawnTime(float spawnTime){
        this.spawnTime = spawnTime;
    }

    public float fallNotePos(){

        return this.y += 10;
    }





}
