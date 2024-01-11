package jp.ac.ritsumei.ise.phy.exp2.is0662ks.musicgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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

    public void judge(Canvas c,Note note,long currentTime){
        Paint YellowP = new Paint();
        YellowP.setColor(Color.YELLOW);
        YellowP.setTextSize(100);
        if(push1){
            if(note.getX()==setPush1()){
                //フレーム判定
                long noteTime = note.getAppearTime();
                long timingDifference = Math.abs(currentTime - noteTime);
                System.out.println(timingDifference);
                if(timingDifference <= 60){
                    c.drawText("perfect",(width/2)-150,(height/2),YellowP);

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
    public float setPush1(){
        return width / 8;
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
    public void drawNote(Note note, Canvas c){
        Paint p = new Paint();
        p.setColor(Color.CYAN);

        float newY = note.getY() + 10; // 新しいy座標を取得

        // 描画
//        c.drawColor(Color.BLACK);
        c.drawCircle(note.getX(), newY, Radius, p);

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

    static final long FPS = 30 ;
    static final long FTIME = 1000 / FPS ;


    @Override
    public void run() {
        long loopC = 0 ; // ループ数のカウンタ
        long wTime = 0; // 次の描画までの待ち時間（ミリ秒）
        long resetTime = 100;
        long diff1,current;
        push1 = false;
        push2 = false;
        push3 = false;
        push4 = false;
        Canvas c = sHolder.lockCanvas();
        judgeCircle(c);

        Note test=new Note(setPush1(),2000);

        sHolder.unlockCanvasAndPost(c);
        long sTime = System.currentTimeMillis() ; // 開始時の現在時刻
        while (thread != null) {
            try {
                c = sHolder.lockCanvas();
                loopC++ ;
//               judgeCircle();

               judgeCircle(c);
               judge(c,test, System.currentTimeMillis() - sTime);
                wTime = (loopC * FTIME) - (System.currentTimeMillis() - sTime) ;
                if (wTime > 0) {
                    Thread.sleep(wTime) ;
                }

               if (push1 && ((System.currentTimeMillis() - sTimePush1) > resetTime)) {
                   push1 = false;
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
                if(true){
                    startTestMusic(test,c);
                }

                sHolder.unlockCanvasAndPost(c);
            } catch (InterruptedException e) {

            }
        }
}}
