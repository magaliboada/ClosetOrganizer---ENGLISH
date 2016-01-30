package com.magali.closetorganizerdos;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.magali.closetorganizer.R;


/**
 * Created by Magali on 23/05/2015.
 */
public class TutorialActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        WebView myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.loadUrl("http://imgur.com/a/bSL2V"); //If you put the HTML file in asset folder of android
        finish();
    }


}