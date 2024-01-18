package jp.ac.ritsumei.ise.phy.exp2.is0662ks.musicgame;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;

import java.util.Random;

public class Music1 {

    private Note[] notes;
    private float width;
    private float height;
    private boolean active;

    private MediaPlayer mediaPlayer;


    public Music1(Context context, Canvas c){
        active = false;
        width = c.getWidth();
        height = c.getHeight();
        Random random = new Random();
        int rn = random.nextInt(4) + 1;
        notes = new Note[]{
//                new Note(setCircleX(rn), 2020),
//                new Note(setCircleX(rn),2620),
//                new Note(setCircleX(rn),3320),
//                new Note(setCircleX(rn),3620),
//                new Note(setCircleX(rn),4020),
//
//                new Note(setCircleX(rn),4720),
//                new Note(setCircleX(rn),5320),
//                new Note(setCircleX(rn),6020),
//                new Note(setCircleX(rn),6320),
//                new Note(setCircleX(rn),6620),
                new Note(setCircleX(2), 2020),
                new Note(setCircleX(4), 2620),
                new Note(setCircleX(3), 3320),
                new Note(setCircleX(3), 3620),
                new Note(setCircleX(3), 4020),

                new Note(setCircleX(3), 4720),
                new Note(setCircleX(2), 5320),
                new Note(setCircleX(1), 6020),
                new Note(setCircleX(2), 6320),
                new Note(setCircleX(3), 6720),

                new Note(setCircleX(1), 7420),
                new Note(setCircleX(3), 8020),
                new Note(setCircleX(4), 8720),
                new Note(setCircleX(1), 9020),
                new Note(setCircleX(1), 9420),

                new Note(setCircleX(2), 10120),
                new Note(setCircleX(4), 10720),
                new Note(setCircleX(1), 11420),
                new Note(setCircleX(2), 11720),
                new Note(setCircleX(3), 12120),

                new Note(setCircleX(4), 12820),
                new Note(setCircleX(2), 13420),
                new Note(setCircleX(2), 14120),
                new Note(setCircleX(2), 14420),
                new Note(setCircleX(1), 14820),

                new Note(setCircleX(4), 15520),
                new Note(setCircleX(1), 16120),
                new Note(setCircleX(4), 16820),
                new Note(setCircleX(2), 17120),
                new Note(setCircleX(2), 17520),

                new Note(setCircleX(4), 18220),
                new Note(setCircleX(4), 18820),
                new Note(setCircleX(3), 19520),
                new Note(setCircleX(3), 19820),
                new Note(setCircleX(3), 20220),

                new Note(setCircleX(3), 20920),
                new Note(setCircleX(1), 21520),
                new Note(setCircleX(4), 22220),
                new Note(setCircleX(4), 22520),
                new Note(setCircleX(1), 22920),

                new Note(setCircleX(1), 23620),
                new Note(setCircleX(4), 24220),
                new Note(setCircleX(4), 24920),
                new Note(setCircleX(2), 25220),
                new Note(setCircleX(3), 25620),

                new Note(setCircleX(1), 26320),
                new Note(setCircleX(3), 26920),
                new Note(setCircleX(4), 27620),
                new Note(setCircleX(4), 27920),
                new Note(setCircleX(2), 28320),

                new Note(setCircleX(1), 29020),
                new Note(setCircleX(1), 29620),
                new Note(setCircleX(4), 30320),
                new Note(setCircleX(2), 30620),
                new Note(setCircleX(2), 31020),

                new Note(setCircleX(2), 31720),
                new Note(setCircleX(1), 32320),
                new Note(setCircleX(3), 33020),
                new Note(setCircleX(3), 33320),
                new Note(setCircleX(1), 33720),

                new Note(setCircleX(3), 34420),
                new Note(setCircleX(3), 35020),
                new Note(setCircleX(4), 35720),
                new Note(setCircleX(2), 36020),
                new Note(setCircleX(3), 36420),

                new Note(setCircleX(2), 37120),
                new Note(setCircleX(1), 37720),
                new Note(setCircleX(4), 38420),
                new Note(setCircleX(3), 38720),
                new Note(setCircleX(3), 39120),

                new Note(setCircleX(2), 39820),
                new Note(setCircleX(4), 40420),
                new Note(setCircleX(3), 41120),
                new Note(setCircleX(1), 41420),
                new Note(setCircleX(1), 41820),

                new Note(setCircleX(1), 42520),
                new Note(setCircleX(3), 43120),
                new Note(setCircleX(4), 43820),
                new Note(setCircleX(2), 44120),
                new Note(setCircleX(3), 44520),

        };
        mediaPlayer = MediaPlayer.create(context, R.raw.blossom);
        // OnCompletionListenerをセット
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // ここでフラグを変更
                active = true; // flagはあなたが変更したい変数

                // 必要に応じてMediaPlayerをリリース
                mp.release();
            }
        });
    }


    public void Music1Start(){
        mediaPlayer.start();;
    }

    public boolean getActive(){
        return active;
    }
    public Note[] getNotes(){
        return notes;
    }
    //x座標の設定
    public float setCircleX(int circleNumber) {
        switch (circleNumber) {
            case 1:
                return width / 8;
            case 2:
                return 3 * width / 8;
            case 3:
                return 5 * width / 8;
            case 4:
                return 7 * width / 8;
            default:
                return 0;
        }
    }

}
