package com.example.takoda.sudoku;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

import java.util.regex.MatchResult;

/**
 * Created by takoda on 9/15/2017.
 */

public class Cell extends GridLayout {

    private TextView value, note1, note2, note3, note4;

    public Cell(Context context) {
        this(context, null);
    }

    public Cell(Context context, AttributeSet attrs) {
        super(context, attrs);
        obtainSetAttributes(context, attrs);
    }

    public Cell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainSetAttributes(context, attrs);
    }

    public Cell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        obtainSetAttributes(context, attrs);
    }

    //region getSet
    public TextView getValue(){
        return value;
    }
    public void setValue(int val){
        if(val == 0){
            value.setVisibility(INVISIBLE);
        }
        else{
            value.setVisibility(VISIBLE);
            note1.setVisibility(INVISIBLE);
            note2.setVisibility(INVISIBLE);
            note3.setVisibility(INVISIBLE);
            note4.setVisibility(INVISIBLE);
        }
        value.setText(String.valueOf(val));
        invalidate();
        requestLayout();
    }
    public TextView getNote1(){
        return note1;
    }
    public void setNote1(int val){
        note1.setText(String.valueOf(val));
        invalidate();
        requestLayout();
    }
    public TextView getNote2(){
        return note2;
    }
    public void setNote2(int val){
        note2.setText(String.valueOf(val));
        invalidate();
        requestLayout();
    }
    public TextView getNote3(){
        return note3;
    }
    public void setNote3(int val){
        note3.setText(String.valueOf(val));
        invalidate();
        requestLayout();
    }
    public TextView getNote4(){
        return note4;
    }
    public void setNote4(int val){
        note4.setText(String.valueOf(val));
        invalidate();
        requestLayout();
    }
    //endregion
    private void obtainSetAttributes(Context context, AttributeSet attrs){
        /*setDimensions();*/
        setBackgroundColor(ContextCompat.getColor(context, R.color.cellColor));
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Cell, 0, 0);
        String tempVal, tempNote1, tempNote2, tempNote3, tempNote4;
        try{
            tempVal = a.getString(R.styleable.Cell_value);
            tempNote1 = a.getString(R.styleable.Cell_note1);
            tempNote2 = a.getString(R.styleable.Cell_note2);
            tempNote3 = a.getString(R.styleable.Cell_note3);
            tempNote4 = a.getString(R.styleable.Cell_note4);
        } finally{
            a.recycle();
        }
        setColumnCount(3);
        setRowCount(3);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.cell, this, true);

        note1 = (TextView) getChildAt(1);
        note1.setText(tempNote1);

        note2 = (TextView) getChildAt(2);
        note2.setText(tempNote2);

        note3 = (TextView) getChildAt(3);
        note3.setText(tempNote3);

        note4 = (TextView) getChildAt(4);
        note4.setText(tempNote4);

        value = (TextView) getChildAt(0);
        if(tempVal == null){

        }
        else{
            setValue(Integer.parseInt(tempVal));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private void setDimensions(){
        /*int height = getScreenHeight();
        int width = getScreenWidth();
        height = height / width / 9;
        width = height;
        setLayoutParams(new ViewGroup.LayoutParams(width, height));*/
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        setDimensions();
        return super.checkLayoutParams(p);
    }
}
