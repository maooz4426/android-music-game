package jp.ac.ritsumei.ise.phy.exp2.is0662ks.musicgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

public class MySurfaceView extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private SurfaceHolder sHolder;
    private Thread thread;
    public MySurfaceView(Context context) {
        super(context);
        initialize();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }



    private void initialize(){
        sHolder = getHolder();
        sHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
            thread = new Thread(this);
            thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread = null;
    }

    private final static float Radius = 120.0f;
    public float width,height;//画面の横幅取得
    public float pointX,pointY;//押した場所を格納
    private boolean push1,push2,push3,push4 ;


    public long sTimePush1,sTimePush2,sTimePush3,sTimePush4;

   public long currentTime2;
    public void judge(Canvas c,Note[] notes,long currentTime){
        if(notes != null){
            currentTime2 = currentTime;
            Paint YellowP = new Paint();
            YellowP.setColor(Color.YELLOW);
            YellowP.setTextSize(100);
            for(Note note:notes){
//            if(push1){
//                if(note.getX()==setPush1()){
//                    //フレーム判定
//                    long noteTime = note.getAppearTime();
//                    long timingDifference = Math.abs(currentTime - noteTime);
//    //                System.out.println(timingDifference);
//                    if(timingDifference <= 60){
//                        c.drawText("perfect",(width/2)-150,(height/2),YellowP);
//                        Log.d("TAG", "timingDifference: " + currentTime);
//                    }
//                }
//            }
                if(push1){
                    if(note.getX() == setPush1()){
                        long noteTime = note.getAppearTime();
                        long timingDifference = Math.abs(currentTime - noteTime);
                        if(timingDifference <= 60){
                            c.drawText("perfect", (width/2)-150, (height/2), YellowP);
                            Log.d("TAG", "timingDifference: " + currentTime);
                        }
                    }
                }

                if(push2){
                    if(note.getX() == setPush2()){
                        long noteTime = note.getAppearTime();
                        long timingDifference = Math.abs(currentTime - noteTime);
                        if(timingDifference <= 60){
                            c.drawText("perfect", (width/2)-150, (height/2), YellowP);
                            Log.d("TAG", "timingDifference: " + currentTime);
                        }
                    }
                }

                if(push3){
                    if(note.getX() == setPush3()){
                        long noteTime = note.getAppearTime();
                        long timingDifference = Math.abs(currentTime - noteTime);
                        if(timingDifference <= 60){
                            c.drawText("perfect", (width/2)-150, (height/2), YellowP);
                            Log.d("TAG", "timingDifference: " + currentTime);
                        }
                    }
                }

                if(push4){
                    if(note.getX() == setPush4()){
                        long noteTime = note.getAppearTime();
                        long timingDifference = Math.abs(currentTime - noteTime);
                        if(timingDifference <= 60){
                            c.drawText("perfect", (width/2)-150, (height/2), YellowP);
                            Log.d("TAG", "timingDifference: " + currentTime);
                        }
                    }
                }

            }
        }
    }
    public void judgeCircle(Canvas c) {

//                Canvas c = sHolder.lockCanvas();
                c.drawColor(Color.BLACK);
                Paint p = new Paint();
                p.setColor(Color.WHITE);
                p.setStyle(Paint.Style.STROKE);

                Paint whiteP = new Paint();
                whiteP.setColor(Color.WHITE);

                width = c.getWidth();
                height = c.getHeight();
                // 円1
                if (!push1) {
                    c.drawCircle(width / 8, 4 * height / 5, Radius, p);
                } else {
                    c.drawCircle(width / 8, 4 * height / 5, Radius, whiteP);
                }

                // 円2
                if (!push2) {
                    c.drawCircle(3 * width / 8, 4 * height / 5, Radius, p);
                } else {
                    c.drawCircle(3 * width / 8, 4 * height / 5, Radius, whiteP);

                }

                // 円3
                if (!push3) {
                    c.drawCircle(5 * width / 8, 4 * height / 5, Radius, p);
                } else {
                    c.drawCircle(5 * width / 8, 4 * height / 5, Radius, whiteP);

                }

                // 円4
                if (!push4) {
                    c.drawCircle(7 * width / 8, 4 * height / 5, Radius, p);
                } else {
                    c.drawCircle(7 * width / 8, 4 * height / 5, Radius, whiteP);

                }
//               sHolder.unlockCanvasAndPost(c);
    }

    //x座標の設定
//    public float setPush1(){
//        return width / 8;
//    }
    public float setPush1(){
        return width / 8;
    }

    public float setPush2(){
        return 3 * width / 8;
    }

    public float setPush3(){
        return 5 * width / 8;
    }

    public float setPush4(){
        return 7 * width / 8;
    }

    public float getPush1(){
        return 4 * height / 5;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://タッチ判定
                pointX = event.getX();
                pointY = event.getY();
                judgePush1(pointX, pointY);
                judgePush2(pointX, pointY);
                judgePush3(pointX, pointY);
                judgePush4(pointX, pointY);
                break;
        }
        return super.onTouchEvent(event);
    }


    public void judgePush1(float pointX,float pointY){
        if((pointX-width/8)*(pointX-width/8) + (pointY-4*height/5)*(pointY-4*height/5) < Radius*Radius){
            push1=true;

            sTimePush1 = System.currentTimeMillis();
        }
    }
    public void judgePush2(float pointX, float pointY) {
        if ((pointX - 3 * width / 8) * (pointX - 3 * width / 8) + (pointY - 4 * height / 5) * (pointY - 4 * height / 5) < Radius * Radius) {
            push2 = true;
            sTimePush2 = System.currentTimeMillis();
        }
    }

    public void judgePush3(float pointX, float pointY) {
        if ((pointX - 5 * width / 8) * (pointX - 5 * width / 8) + (pointY - 4 * height / 5) * (pointY - 4 * height / 5) < Radius * Radius) {
            push3 = true;
            sTimePush3 = System.currentTimeMillis();
        }
    }

    public void judgePush4(float pointX, float pointY) {
        if ((pointX - 7 * width / 8) * (pointX - 7 * width / 8) + (pointY - 4 * height / 5) * (pointY - 4 * height / 5) < Radius * Radius) {
            push4 = true;
            sTimePush4 = System.currentTimeMillis();
        }
    }

//ノーツ描写

    private long spawnTime = 2000;
    private void drawNotes(Note[] notes,long cTime,Canvas canvas) {
        if (notes != null) {

            for (Note note : notes) {
                if(note.getAppearTime()-2000<cTime) {//押さないといけない2s前に出現
                    drawNote(note, canvas); // 各ノートを描画
                }
            }
        }
    }
    private float speed =  (4 * height / 5 + Radius) / 8;//2.0で下に落とす場合のスピード
    public void drawNote(Note note, Canvas c){
        Paint p = new Paint();
        p.setColor(Color.CYAN);
        Paint wp = new Paint();
        wp.setColor(Color.WHITE);  // 枠の色を白に設定
        wp.setStyle(Paint.Style.STROKE);
        wp.setStrokeWidth(4);

//        float speed =  (4 * height / 5 + Radius) / (note.getAppearTime()/1000)*4;
        float newY = note.getY() + speed; // 新しいy座標を取得
//        System.out.println(speed);
//        System.out.println((4 * height / 5 + Radius) );

        // 描画
//        c.drawColor(Color.BLACK);
        c.drawCircle(note.getX(), newY, Radius, p);
        c.drawCircle(note.getX(),newY,Radius,wp);
//        if(note.getY()>=getPush1()){
//            Log.d("note","note"+currentTime2);
//        }
        // y座標を更新
        note.setY(newY);
    }

    public void startTestMusic(Note note,Canvas c){
        drawNote(note,c);
    }

//    public void pushReset(){
//        push1 = false;
//        push2 = false;
//        push3 = false;
//        push4 = false;
//    }

    private Note[] notes;
    private boolean start;
    static final long FPS = 30 ;
    static final long FTIME = 1000 / FPS ;

    @Override
    public void run() {
        long loopC = 0 ; // ループ数のカウンタ
        long wTime = 0; // 次の描画までの待ち時間（ミリ秒）
        long resetTime = 100;
        long cTime = 0;
        start =true;
        long diff1,current;
        push1 = false;
        push2 = false;
        push3 = false;
        push4 = false;
        Canvas c = sHolder.lockCanvas();
        judgeCircle(c);

        Music1 music = new Music1(this.getContext(),c);
        notes = music.getNotes();
//        Note test=new Note(setPush1(),2000);
//        System.out.println((4 * height / 5+120)/(2/30));
        sHolder.unlockCanvasAndPost(c);
        long sTime = System.currentTimeMillis() ; // 開始時の現在時刻
        while (thread != null) {
            try {
                c = sHolder.lockCanvas();
                loopC++ ;
//               judgeCircle();
                cTime = System.currentTimeMillis() - sTime;
               judgeCircle(c);
               judge(c,notes, cTime);
                wTime = (loopC * FTIME) - (cTime) ;
//                if((System.currentTimeMillis() - sTime)>=2000){
////                    System.out.println("loopC");
////                    System.out.println(loopC);
//                }
                if (wTime > 0) {
                    Thread.sleep(wTime) ;
                }

               if (push1 && ((System.currentTimeMillis() - sTimePush1) > resetTime)) {
                   push1 = false;
                   Log.d("musictime", String.valueOf(cTime));
                }

                if (System.currentTimeMillis() - sTimePush2 > resetTime) {
                    push2 = false;
                }

                if (System.currentTimeMillis() - sTimePush3 > resetTime) {
                    push3 = false;
                }

                if (System.currentTimeMillis() - sTimePush4 > resetTime) {
                    push4 = false;
               }

//                ゲーム開始
                if(!music.getActive()){
                    if(start){
                        music.Music1Start();
                        start = false;
                    }
//                    startTestMusic(test,c);
//                    draw(c);
                    drawNotes(notes,cTime,c);


                }else{
                    Paint clearP = new Paint();
                    clearP.setColor(Color.YELLOW);
                    clearP.setTextSize(150);
                    c.drawText("CLEAR",(width/2)-250, (height/2), clearP);
                }

                sHolder.unlockCanvasAndPost(c);
            } catch (InterruptedException e) {

            }
        }
}}
