package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Link extends Activity {
	
	WebView browser;
	String link,store_link;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.link_activity);
		
		browser = (WebView)findViewById(R.id.webview1);
		browser.setWebViewClient(new MBrowser());
		
		
		store_link=getIntent().getStringExtra("astore_link");
		
		browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		browser.loadUrl(store_link);
		
	}

}

class MBrowser extends WebViewClient {
	   @Override
	   public boolean shouldOverrideUrlLoading(WebView view, String url) {
	      view.loadUrl(url);
	      return true;
	   }
	}
