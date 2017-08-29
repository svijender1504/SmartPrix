package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class Search extends Activity {

    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_IMG_URL = "img_url";
//	Bundle savedInstanceState;


    //@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
////		public void fun()
////		{
//			new Searches().execute("");
////		}
//
//
//	}
//	void fun()
//	{
//		onCreate(savedInstanceState);
//	}

    public Search()
    {
        //srh.Searches();
        new Searches().execute("");
    }

    class Searches extends AsyncTask<String, String, String>
    {
        EditText srhtxt;
        //Button srhbtn;
        String text;
        //setContentView(R.layout.activity_main);
        StringBuilder strBuilder1=new StringBuilder();
        JSONArray jsonArray;
        JSONObject jsonObj;

        int n;
        String name=null,price=null,img_url=null;
        String fname=null,fprice=null,fimg_url=null;
        ArrayList<String> arrLst0 = new ArrayList<String>();
        ArrayList<String> arrLst1 = new ArrayList<String>();
        ArrayList<String> arrLst2 = new ArrayList<String>();
        ArrayList<String> arrLst3 = new ArrayList<String>();
        ArrayList<String> arrLst4 = new ArrayList<String>();
        ArrayList<String> arrLst5 = new ArrayList<String>();




        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                URL url=new URL("http://api.smartprix.com/simple/v1?type=search&key=NVgien7bb7P5Gsc8DWqc&category=Mobiles&q=3g&indent=1");
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String read1;
                while((read1=bufferedReader.readLine())!=null)
                {
                    strBuilder1.append(read1);
                }



            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return strBuilder1.toString();
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub

            super.onPostExecute(result);

            //srhbtn=(Button)findViewById(R.id.srhbtn);
            srhtxt=(EditText)findViewById(R.id.srhtxt);

            //if(text!=null)
            //{
//			JSONObject jsonObject = new JSONObject(result);
//			 jsonObject;
            try {
                JSONObject jsonObject = new JSONObject(result);
                jsonObj = jsonObject.getJSONObject("request_result");
                jsonArray=jsonObj.getJSONArray("results");
                n=jsonArray.length();

                for(int i=0;i<n;i++)
                {
                    //nume= jsonObj.getString(TAG_NAME);
                    name= jsonArray.getJSONObject(i).getString(TAG_NAME);
                    price=jsonArray.getJSONObject(i).getString(TAG_PRICE);
                    img_url=jsonArray.getJSONObject(i).getString(TAG_IMG_URL);

                    arrLst0.add(name);
                    arrLst1.add(price);
                    arrLst2.add(img_url);
                }

                //SearchAdapter sA=new SearchAdapter(MainActivity.this,arrLst0,arrLst1,arrLst2);


                //srhbtn.setOnClickListener(new OnClickListener() {

                //@Override
                //public void onClick(View arg0) {
                // TODO Auto-generated method stub
                text=srhtxt.getText().toString();
                for(int j=0;j<n;j++)
                {
                    if(text.equalsIgnoreCase(arrLst0.get(j)))
                    {
                        fname= arrLst0.get(j);
                        fprice=arrLst1.get(j);
                        fimg_url=arrLst2.get(j);

                        arrLst3.add(fname);
                        arrLst4.add(fprice);
                        arrLst5.add(fimg_url);

                        Intent intent=new Intent(Search.this,SearchActivity.class);
                        intent.putStringArrayListExtra("aname", arrLst3);
                        intent.putStringArrayListExtra("aprice", arrLst4);
                        intent.putStringArrayListExtra("aimg_url", arrLst5);

                        startActivity(intent);



                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No match found", 3000).show();
                    }
//				else if(!(text.equalsIgnoreCase(arrLst0.get(j))))
//				{
//					Toast.makeText(getApplicationContext(), "No match found", 3000).show();
//					break;
//				}
                }

//		}
                //});






            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }



}