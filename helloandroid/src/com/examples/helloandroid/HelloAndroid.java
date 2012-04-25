package com.examples.helloandroid;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HelloAndroid extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//
        Log.v("hello android","VERBOSE");
        Log.d("hello android","DEBUG");
        Log.i("hello android","INFO");
        Log.w("hello android","WARN");
        Log.e("hello android","ERROR");
//        TextView tv = new TextView(this);
//        Resources r = this.getResources();
//        tv.setText(r.getString(R.string.greeting));
//        setContentView(tv);
    }
}
