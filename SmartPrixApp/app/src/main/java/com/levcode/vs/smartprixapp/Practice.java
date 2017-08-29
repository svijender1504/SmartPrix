package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Practice extends Activity {
	WebView browser;
	String link,store_link,string;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser_activity);
		browser = (WebView)findViewById(R.id.webview);
		browser.setWebViewClient(new MyBrowser());
		
		link=getIntent().getStringExtra("alink");
		store_link=getIntent().getStringExtra("astore_link");
		
//		if(link)
//		{
			
			browser.getSettings().setLoadsImagesAutomatically(true);
	        browser.getSettings().setJavaScriptEnabled(true);
	        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
			browser.loadUrl(link);
			
//		}
//		else if(store_link)
//		{
//			
//		}
			
		
	}

}

class MyBrowser extends WebViewClient {
	   @Override
	   public boolean shouldOverrideUrlLoading(WebView view, String url) {
	      view.loadUrl(url);
	      return true;
	   }
	}


//class Prac extends AsyncTask<String, String, String>
//{
//
//	StringBuilder strBuilder=new StringBuilder();
//	String name = null, store_name=null, price=null,stock=null;
//	ArrayList<String> arrLst0=new ArrayList<String>();
//	ArrayList<String> arrLst1=new ArrayList<String>();
//	ArrayList<String> arrLst2=new ArrayList<String>();
//	ArrayList<String> arrLst3=new ArrayList<String>();
//	JSONArray jsonArray;
//	JSONObject jsonObj;
//	int n;
//	
//	
//	@Override
//	protected String doInBackground(String... arg0) {
//		// TODO Auto-generated method stub
//		try {
//			URL url=new URL("http://api.smartprix.com/simple/v1?type=product_full&key=NVgien7bb7P5Gsc8DWqc&id=2179&indent=1");
//			HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
//			InputStream inputStream= httpURLConnection.getInputStream();
//			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//			String read;
//			while((read=bufferedReader.readLine())!=null)
//			{
//				strBuilder.append(read);
//			}
//			
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return strBuilder.toString();
//	}
//	
//	
//	@Override
//	protected void onPostExecute(String result) {
//		// TODO Auto-generated method stub
//		super.onPostExecute(result);
//		ListView lstVw;
//		//lstVw = (ListView) findViewById(R.id.lstVw);
//		
//		try {
//			JSONObject jsonObject=new JSONObject(result);
//			jsonObj=jsonObject.getJSONObject("request_result");
//			jsonArray=jsonObj.getJSONArray("prices");
//			n=jsonArray.length();
//			
//			for(int i=0;i<n;i++)
//			{
//				
//				name=jsonArray.getJSONObject(i).getString(TAG_NAME);
//				store_name = jsonArray.getJSONObject(i).getString(TAG_STORE_NAME);
//				price = jsonArray.getJSONObject(i).getString(TAG_PRICE);
//				stock = jsonArray.getJSONObject(i).getString(TAG_STOCK);
//				arrLst0.add(name);
//				arrLst0.add(store_name);
//				arrLst0.add(price);
//				arrLst0.add(stock);
//				
//			}
//			
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		CustomAdapter cA = new CustomAdapter(Practice.this, arrLst0, arrLst1, arrLst2, arrLst3);
//		lstVw.setAdapter(cA);
//		
//	}
//	
//}