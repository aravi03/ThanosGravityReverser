package com.example.thanosgravityreverser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.Console;
import java.io.FileOutputStream;
import java.util.Random;

public class Stone extends View {
    private Paint text_paint;
    private Bitmap stones[]=new Bitmap[6];
       private Bitmap background;
    private int stonex[]=new int[6];
    private int stoney[]=new int[6];


    private int canvas_width,canvas_height,max_x,max_y,min_x,min_y,mystone_x,mystone_y;
    private boolean touch=false;

    private static int getRandomNumber(int max) {



        Random r = new Random();
        return r.nextInt(max  + 1);
    }



    public Stone(Context context) {

        super(context);

        stones[0]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_1);

        for(int i=0;i<6;i++)
        {
        stonex[i]    =getRandomNumber(900);
        stoney[i]=getRandomNumber(1500);
       }
        stones[1]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_2);
        stones[2]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_3);
        stones[3]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_4);
        stones[4]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_5);
        stones[5]=BitmapFactory.decodeResource(getResources(),R.drawable.stone_6);
        background=BitmapFactory.decodeResource(getResources(),R.drawable.bg2);
//        text_paint.setColor(Color.WHITE);
//        text_paint.setTextSize(200);
//        text_paint.setTypeface(Typeface.SANS_SERIF);
//        text_paint.setAntiAlias(true);





    }


    public Bitmap drawTextToBitmap(Context mContext,  int resourceId,  String mText) {
        try {
            Resources resources = mContext.getResources();
            float scale = resources.getDisplayMetrics().density;
            Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);
            android.graphics.Bitmap.Config bitmapConfig =   bitmap.getConfig();
            // set default bitmap config if none
            if(bitmapConfig == null) {
                bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            }
            // resource bitmaps are imutable,
            // so we need to convert it to mutable one
            bitmap = bitmap.copy(bitmapConfig, true);

            Canvas canvas = new Canvas(bitmap);
            // new antialised Paint
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            // text color - #3D3D3D
            paint.setColor(Color.rgb(110,110, 110));
            // text size in pixels
            paint.setTextSize((int) (12 * scale));
            // text shadow
            paint.setShadowLayer(1f, 0f, 1f, Color.DKGRAY);

            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = 300;
            int y = 300;

            canvas.drawText(mText, x * scale, y * scale, paint);

            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception

            return null;
        }

    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas_height=canvas.getHeight();
        canvas_width=canvas.getWidth();

        min_x=stones[0].getWidth();
        min_y=stones[0].getHeight();
        max_x=canvas_width-stones[0].getWidth();
        max_y=canvas_height-stones[0].getHeight();

//        canvas.drawBitmap(stones[0],mystone_x,mystone_y,null);
        for(int i=0;i<6;i++)
        {
        if(stoney[i]>1800) stoney[i]=1800;
        if(stoney[i]<0)stoney[i]=0;

        if(touch==false)
            stoney[i]+=10;
        else
            stoney[i]-=10;
       }
//        System.out.println(canvas_height+canvas_width);
//
//        mystone_x= getRandomNumber(canvas_width);
//        mystone_y= getRandomNumber(canvas_height);

        //width=1200,height=1500

//        if(touch)
//        {
//
//            mystone_y-=10;
//            if(mystone_y<100)
//            {touch=false; }
//        }
//        else{
//            mystone_y+=10;
//        }
//        canvas.drawBitmap(stones[0],mystone_x,mystone_y,null);

        canvas.drawBitmap(background,0,0,null);
//
//
//        drawTextToBitmap(this,R.drawable.ic_launcher_background,"Hello");
//
//        Paint paint = new Paint();
////
////        Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ALPHA_8);
////        Canvas c = new Canvas(b);
////        c.drawRect(500, 500, 1000, 1000, paint);
////
////
////        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
////        paint.setTextSize(100);
////        paint.setTextScaleX(1.f);
////        paint.setAlpha(1);
////        paint.setAntiAlias(true);
////
////
////        c.drawText("Gravity Reversed", 600, 600, paint);
////
////        paint.setColor(Color.WHITE);
////
////
////        canvas.drawBitmap(b, 500,500, paint);

//        Bitmap bmp =drawTextToBitmap(this,R.drawable.ic_launcher_foreground,"Hello Android");
//        ImageView img=new ImageView;
//        img.setImageBitmap(bmp);

//        canvas.drawText("Gravity Reversed",100,500,text_paint);

        for(int i=0;i<6;i++)
            canvas.drawBitmap(stones[i],stonex[i],stoney[i],null);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN: {



                if(touch==false)

                touch=true;
                else touch=false;
                break;
            }
//                case MotionEvent.ACTION_UP: {
//                touch=false;
//                    break;
//                }
        }

        return super.onTouchEvent(event);
    }
}
