package it.unical.mat.forz4sprefactoring.GUI.Components;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by haze on 12/26/15.
 */
public class CustomCell extends View{

    private Paint shadowPaint , ovalColor;
    private int ypad =5, xpad =5, height =135, width = 135;
    //TODO calculate spacing properly

    public CustomCell(Context context){
        super(context);
    init();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width + 15, height + 15);
    }

    private void init(){
        shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        shadowPaint.setColor(Color.BLACK);
        shadowPaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));

        ovalColor= new Paint(Paint.ANTI_ALIAS_FLAG);
        ovalColor.setColor(Color.WHITE);
        ovalColor.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));

    }


    public void usedCell(String c){
       ovalColor.setColor(Color.parseColor(c));
        invalidate();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawOval(xpad    , ypad    , height+5, width+5, shadowPaint);
        canvas.drawOval(xpad+5 , ypad +5, height, width, ovalColor);



    }


}
