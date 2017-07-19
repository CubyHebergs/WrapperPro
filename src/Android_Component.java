package com.example.WrapperPro;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by fc_dev on 19/07/17.
 */

public class Android_Component {

    /**
     set network persistence !
     You should almost always run network operations on a thread or as an asynchronous task.
     But if you know better and are willing to accept the consequences, and must do network operations
     on the main thread, you can override the default behavior

     Consequences:
     Your app will (in areas of spotty internet connection)
     become unresponsive and lock up, the user perceives slowness
     and has to do a force kill, and you risk the activity manager killing your app and telling the user
     that the app has stopped
     https://stackoverflow.com/questions/6343166/how-do-i-fix-android-os-networkonmainthreadexception
     **/

    public void ForceNetworkThread() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @TargetApi(25)
    public void createShortcut(Main main) {
        ShortcutManager sM = main.getSystemService(ShortcutManager.class);

        Intent intent1 = new Intent(main.getApplicationContext(), Main.class);

        intent1.setAction(Intent.ACTION_VIEW);
        ShortcutInfo shortcut1 = new ShortcutInfo.Builder(main, "High Virus")
                .setIntent(intent1)
                .setLongLabel("High Virus acc2")
                .setShortLabel("HVirus acc2")
                .setDisabledMessage("Login to open this")
                .setIcon(Icon.createWithResource(main, R.drawable.acc2))
                .build();

        sM.setDynamicShortcuts(Collections.singletonList(shortcut1));
    }

    @TargetApi(25)
    public void removeShorcuts(Main main) {
        ShortcutManager shortcutManager = main.getSystemService(ShortcutManager.class);
        shortcutManager.disableShortcuts(Arrays.asList("shortcut1"));
        shortcutManager.removeAllDynamicShortcuts();
    }



    public String getAndroidVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release +")";
    }

    public  void setLocal (Locale locale, Main main){
        Resources res = main.getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, res.getDisplayMetrics());
        try{
            Context context = main.createPackageContext(main.getPackageName(), Context.CONTEXT_INCLUDE_CODE);
            Intent intent = new Intent(context,Main.class);
            main.startActivity(intent);
            main.finish();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean CheckConnect(Context context, String url, String Message, Integer timeout) {
        try{
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();
            return true;
        } catch (Exception e) {
            Toast.makeText(context, Message, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public String getURL(String urlString) {
        URLConnection feedUrl;
        try {
            feedUrl = new URL(urlString).openConnection();
            InputStream is = feedUrl.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "");
            }
            is.close();

            return sb.toString();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


}

