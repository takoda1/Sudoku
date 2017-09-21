package com.example.takoda.sudoku;

import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Game extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout layout = new GridLayout(this);
        layout.setColumnCount(9);
        layout.setRowCount(9);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        params.width = displayMetrics.heightPixels;
        params.height = displayMetrics.widthPixels;
        params.setMargins(30,0,30,0);
        layout.setLayoutParams(params);
        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                Cell cell = new Cell(this);
                cell.setTag(row * 9 + column);
                cell.setOnClickListener(

                );
            }
        }
        setContentView(R.layout.activity_game);
    }

    //region Dimensions

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private void setDimensions(){
        GridLayout grid = (GridLayout) findViewById(R.id.board);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        params.width = displayMetrics.heightPixels;
        params.height = displayMetrics.widthPixels;
        params.setMargins(30,0,30,0);
        grid.setLayoutParams(params);
    }
    //endregion


}
