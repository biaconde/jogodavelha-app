package br.com.biaconde.jogodavelha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class TabuleiroView extends View {
    private Paint paint;
    private String[] pecas = {};

    private float width = 0.0f;
    private float height = 0.0f;

    private TabuleiroObserver observer;

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    public void atualizarPecas(String[] pecas) {
        this.pecas= pecas;
        invalidate();
    }

    public TabuleiroView(Context context) {
        super(context);
        this.observer = (TabuleiroObserver) context;
        init();
    }

    public TabuleiroView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.observer = (TabuleiroObserver) context;
        init();
    }

    public TabuleiroView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.observer = (TabuleiroObserver) context;
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();

        paint.setStrokeWidth(10);

        //Linhas verticais
        canvas.drawLine( width/3.0f, height/6.0f, width/3.0f, 3.0f * height/6.0f, paint);
        canvas.drawLine( 2.0f * width/3.0f, height/6.0f, 2.0f * width/3.0f, 3.0f * height/6.0f, paint);
        //Linhas horizontais
        canvas.drawLine( width/6.0f, 2.0f * height/8.0f, 5.0f * width/6.0f, 2.0f * height/8.0f, paint);
        canvas.drawLine( width/6.0f, 3.0f * height/8.0f, 5.0f * width/6.0f, 3.0f * height/8.0f, paint);

        desemharPecas(canvas, this.pecas);

    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //Clicou na posicao 0
            if (x >= width / 6.0f && x < width / 3.0f && y >= height / 6.0f && y < 2.0f * height/8.0f) {
                System.out.println("Jogou na posicao 0");
                observer.jogou(0);

            }
            //Clicou na posicao 1
            if (x > width / 3.0f && x < 2.0f * width / 3.0f && y >= height / 6.0f && y < 2.0f * height/8.0f) {
                observer.jogou(1);
            }
            //Clicou na posicao 2
            if (x > 2.0f * width / 3.0f && x < 5.0f * width / 6.0f && y >= height / 6.0f && y < 2.0f * height/8.0f) {
                observer.jogou(2);
            }

            //Clicou na posicao 3
            if (x >= width / 6.0f && x < width / 3.0f && y >  2.0f * height/8.0f && y < 3.0f * height/8.0f) {
                observer.jogou(3);
            }
            //Clicou na posicao 4
            if (x > width / 3.0f && x < 2.0f * width / 3.0f && y >  2.0f * height/8.0f && y < 3.0f * height/8.0f) {
                observer.jogou(4);
            }
            //Clicou na posicao 5
            if (x > 2.0f * width / 3.0f && x < 5.0f * width / 6.0f && y >  2.0f * height/8.0f && y < 3.0f * height/8.0f) {
                observer.jogou(5);
            }

            //Clicou na posicao 6
            if (x >= width / 6.0f && x < width / 3.0f && y > 3.0f * height/8.0f && y < 3.0f * height/6.0f) {
                observer.jogou(6);
            }
            //Clicou na posicao 7
            if (x > width / 3.0f && x < 2.0f * width / 3.0f && y > 3.0f * height/8.0f && y < 3.0f * height/6.0f) {
                observer.jogou(7);
            }
            //Clicou na posicao 8
            if (x > 2.0f * width / 3.0f && x < 5.0f * width / 6.0f && y > 3.0f * height/8.0f && y < 3.0f * height/6.0f) {
                observer.jogou(8);
            }
        }
        return true;
    }

    private void desemharPecas(Canvas canvas, String[] pecas) {
        float[] posicoesX = {1.0f * width /6.5f, 2.0f * width/5.0f, 3.5f *  width/5.0f, 1.0f *  width/6.5f, 2.0f * width/5.0f, 3.5f * width/5.0f, 1.0f * width/6.5f, 2.0f * width/5.0f, 3.5f * width/5.0f};;
        float[] posicoesY = { 1.0f * height/4.3f, 1.0f * height/4.3f, 1.0f * height/4.3f, 1.0f * height/2.8f, 1.0f * height/2.8f, 1.0f * height/2.8f, 1.0f * height/2.1f, 1.0f * height/2.1f, 1.0f * height/2.1f};
        if(pecas != null ){
            System.out.println(pecas);
            for(int i = 0; i < pecas.length; i++) {
                if(!pecas[i].trim().equals("")) {
                    paint.setTextSize(250);

                    canvas.drawText(pecas[i], posicoesX[i] , posicoesY[i] , paint );
                }
            }
        }
    }
}
