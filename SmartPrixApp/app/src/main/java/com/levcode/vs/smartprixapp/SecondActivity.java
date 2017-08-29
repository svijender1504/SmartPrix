package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class SecondActivity extends Activity {


    private static final String TAG_ID = "id";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_BRAND = "brand";
    private static final String TAG_LINK = "link";
    private static final String TAG_IMG_URL = "img_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        new First().execute("");
    }


    class First extends AsyncTask<String, String, String> {

        StringBuilder strBuilder = new StringBuilder();
        int i;
        JSONArray jsonArray;


        TextView stxtVw1;

        int n;


        String id = null, category = null, name = null, price = null, brand = null, link = null, img_url = null;
        ArrayList<String> arrLst0 = new ArrayList<String>();
        ArrayList<String> arrLst1 = new ArrayList<String>();
        ArrayList<String> arrLst2 = new ArrayList<String>();
        ArrayList<String> arrLst3 = new ArrayList<String>();
        ArrayList<String> arrLst4 = new ArrayList<String>();
        ArrayList<String> arrLst5 = new ArrayList<String>();
        ArrayList<String> arrLst6 = new ArrayList<String>();

        JSONObject jsonObj;
        ArrayAdapter<String> arrAdapt;

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            URL url;
            try {
                url = new URL("http://api.smartprix.com/simple/v1?type=product&key=NVgien7bb7P5Gsc8DWqc&id=2179&indent=1");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String read;
                while ((read = bufferedReader.readLine()) != null) {
                    strBuilder.append(read);

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return strBuilder.toString();

        }

        @Override
        protected void onProgressUpdate(String... values) {
            // TODO Auto-generated method stub
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub

            super.onPostExecute(result);
            ListView lstVw2;
            lstVw2 = (ListView) findViewById(R.id.lstVw2);


            try {
                JSONObject jsonObject = new JSONObject(result);

                jsonObj = jsonObject.getJSONObject("request_result");
                //jsonArray=jsonObject.getJSONArray("request_result");
                n = jsonObj.length();

//			"id": "2179",
//		    "category": "Mobiles",
//		    "name": "Samsung Galaxy S Duos S7562",
//		    "price": "12290",
//		    "brand": "Samsung",
//		    "link": "http:\/\/www.smartprix.com\/mobiles\/samsung_galaxy_s_duos_s7562-m2179.php",
//		    "img_url": "http:\/\/img2.smartprix.com\/mobiles\/2179\/s-1\/samsung_galaxy_s_duos_s7562.jpg"


                //for (int i = 0; i < n; i++) {

                //id = jsonArray.getJSONObject(i).getString(TAG_ID);


                id = jsonObj.getString(TAG_ID);
                category = jsonObj.getString(TAG_CATEGORY);
                name = jsonObj.getString(TAG_NAME);
                price = jsonObj.getString(TAG_PRICE);
                brand = jsonObj.getString(TAG_BRAND);
                link = jsonObj.getString(TAG_LINK);
                img_url = jsonObj.getString(TAG_IMG_URL);

                //	Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();
                arrLst0.add(id);
                arrLst1.add(category);
                arrLst2.add(name);
                arrLst3.add(price);
                arrLst4.add(brand);
                arrLst5.add(link);
                arrLst6.add(img_url);


                //	Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();


                //}


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //ArrayAdapter<String> arrAdapt =new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1,arrLst0);

            //Toast.makeText(MainActivity.this, n, 3000).show();
            stxtVw1 = (TextView) findViewById(R.id.stxtVw1);
            //System.out.println(no.replace("+", ""));
            //txtVw.setText(UStore.get(arg0));
            stxtVw1.setText(arrLst1.toString().replace("[", "").replace("]", ""));
            SecondAdapter sA = new SecondAdapter(SecondActivity.this, arrLst0, arrLst1, arrLst2, arrLst3, arrLst4, arrLst5, arrLst6);
            lstVw2.setAdapter(sA);

            lstVw2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub

                    if (arg2 == 0) {
                        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), arrLst0.get(arg2), 3000).show();
                    }
                }
            });

        }

        //Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();

    }



}