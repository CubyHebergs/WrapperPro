package com.example.WrapperPro;

import android.content.Context;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.WrapperPro.Main.integer;

/*
 * Created by fc_dev on 18/07/17.
 */


public class Animation {

    private Handler mHandler = new Handler();

    /*
    @Define: create the Text.
    @Parameters: text[string]
    @return: the element.
    */

    private TextView createTextView(Context context, String text_input, Integer width_input, Integer height_input, Integer padding_input1, Integer padding_input2, Integer padding_input3, Integer padding_input4){
        TextView view = new TextView(context);
        view.setId(integer);
        view.setText(text_input);
        view.setWidth(width_input);
        view.setHeight(height_input);
        view.setPadding(padding_input1, padding_input2, padding_input3, padding_input4);
        integer +=1;
        return view;
    }

    private AlphaAnimation alphaAnimation(int Start, int Duration, int Repeat){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(Start);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(Duration);
        alphaAnimation.setRepeatCount(Repeat);
        alphaAnimation.setRepeatMode(android.view.animation.Animation.REVERSE);
        return alphaAnimation;
    }


    public LinearLayout WaitLoading (Context context, boolean mode) {
        LinearLayout layout_loading = new LinearLayout(context);

        final TextView ids1;
        final TextView ids2;
        final TextView ids3;
        final TextView ids4;
        final TextView ids5;
        final TextView ids6;
        final TextView ids7;
        final TextView ids8;
        final TextView ids9;

        layout_loading.addView(ids1 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids2 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids3 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids4 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids5 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids6 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids7 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids8 = createTextView(context, ".", 10, 15, 0,0,0,0));
        layout_loading.addView(ids9 = createTextView(context, ".", 10, 15, 0,0,0,0));


        if (mode){

            TranslateAnimation trans1 = new TranslateAnimation(300, 0, 0, 0);
            trans1.setStartTime(1000);
            trans1.setStartOffset(500);
            trans1.setFillAfter(true);
            trans1.setDuration(3500);

            final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setStartOffset(320);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(600);
            alphaAnimation.setRepeatCount(150);
            alphaAnimation.setRepeatMode(android.view.animation.Animation.REVERSE);

            final AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setStartOffset(350);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setDuration(630);
            alphaAnimation2.setRepeatCount(150);
            alphaAnimation2.setRepeatMode(android.view.animation.Animation.REVERSE);

            final AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation3.setStartOffset(370);
            alphaAnimation3.setFillAfter(true);
            alphaAnimation3.setDuration(650);
            alphaAnimation3.setRepeatCount(150);
            alphaAnimation3.setRepeatMode(android.view.animation.Animation.REVERSE);


            ids1.startAnimation(trans1);
            ids2.startAnimation(trans1);
            ids3.startAnimation(trans1);
            ids4.startAnimation(trans1);
            ids5.startAnimation(trans1);
            ids6.startAnimation(trans1);
            ids7.startAnimation(trans1);
            ids8.startAnimation(trans1);
            ids9.startAnimation(trans1);


            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ids1.startAnimation(alphaAnimation(300, 600, 150));
                    ids2.startAnimation(alphaAnimation(350, 630, 150));
                    ids3.startAnimation(alphaAnimation(400, 650, 150));
                    ids4.startAnimation(alphaAnimation(450, 670, 150));
                    ids5.startAnimation(alphaAnimation(500, 730, 150));
                    ids6.startAnimation(alphaAnimation(550, 750, 150));
                    ids7.startAnimation(alphaAnimation(600, 770, 150));
                    ids8.startAnimation(alphaAnimation(650, 830, 150));
                    ids9.startAnimation(alphaAnimation(700, 850, 150));
                }
            }, 4500);
        }

        return layout_loading;
    }
}
