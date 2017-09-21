package com.example.takoda.sudoku;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by takoda on 9/20/2017.
 */

public class GridLayoutVariable extends GridLayout {
    public GridLayoutVariable(Context context) {
        super(context);
        setDimensions();
    }

    public GridLayoutVariable(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDimensions();
    }

    public GridLayoutVariable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDimensions();
    }

    public GridLayoutVariable(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setDimensions();
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        setDimensions();
        return super.checkLayoutParams(p);
    }

    private void setDimensions(){
        int height = getScreenHeight();
        int width = getScreenWidth();
        height = height / width;
        setLayoutParams(new ViewGroup.LayoutParams(width - 30, height - 30));
    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
