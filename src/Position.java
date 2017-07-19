package com.example.WrapperPro;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import static com.example.WrapperPro.Main.integer;

/**
 * Created by fc_dev on 18/07/17.
 */

class Position {

    static class Screen {

        public void fullscreen(Main main){
            main.requestWindowFeature(Window.FEATURE_NO_TITLE);
            main.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    }

    static class Size {

        // get size screen
        public int width(Main main) {
            WindowManager w = main.getWindowManager();
            int measuredWidth;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                Point size = new Point();
                w.getDefaultDisplay().getSize(size);
                measuredWidth = size.x;
            } else {
                Display d = w.getDefaultDisplay();
                measuredWidth = d.getWidth();
            }

            return measuredWidth;
        }

        public int height(Main main) {
            WindowManager w = main.getWindowManager();
            int measuredHeight;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                Point size = new Point();
                w.getDefaultDisplay().getSize(size);
                measuredHeight = size.y;
            } else {
                Display d = w.getDefaultDisplay();
                measuredHeight = d.getHeight();
            }

            return measuredHeight;
        }


    }

    static class Create {

        public TextView Textview (Context context) {
            TextView view = new TextView(context);
            view.setId(integer);
            integer +=1;
            return view;
        }

        public Button Button (Context context) {
            Button view = new Button(context);
            view.setId(integer);
            integer +=1;
            return view;
        }


        public EditText EditText (Context context) {
            EditText view = new EditText(context);
            view.setId(integer);
            return view;
        }


        public RelativeLayout RelativeLayout(Context context) {
            RelativeLayout view = new RelativeLayout(context);
            view.setId(integer);
            return view;
        }


        public LinearLayout LinearLayout (Context context) {
            LinearLayout view = new LinearLayout(context);
            view.setId(integer);
            return view;
        }


    }
}
