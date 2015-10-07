package com.example.rummezheni.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;
import java.util.jar.Attributes;

/**
 * Created by rummezheni on 07.10.2015.
 */
public class SurfaceField extends SurfaceView implements SurfaceHolder.Callback{

    public static String TAG = "SurfaceView";

    public SurfaceField(Context c, AttributeSet attr) {
        super(c, attr);
        getHolder().addCallback(this);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        tryDrawing(holder);
        DrawThread drawThread = new DrawThread(holder);
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {
        tryDrawing(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    private void tryDrawing(SurfaceHolder holder) {
        Log.i(TAG, "Trying to draw...");

        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            Log.e(TAG, "Cannot draw onto the canvas as it's null");
        } else {
            drawMyStuff(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawMyStuff(final Canvas canvas) {
        Random random = new Random();
        Log.i(TAG, "Drawing...");
        canvas.drawRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(1.2f);
        canvas.drawLine(0,0,150,150,paint);
    }

    class DrawThread extends Thread {

        private boolean running = false;
        private SurfaceHolder surfaceHolder;

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            Canvas canvas;
            while (running) {
                canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas(null);
                    if (canvas == null)
                        continue;
                    drawMyStuff(canvas);
                    sleep(700);
                } catch (InterruptedException exception) {
                    Log.d(TAG, "Exception " + exception);
                }
                finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
