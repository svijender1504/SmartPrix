package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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

public class MainActivity extends AppCompatActivity {

    //private static final String TAG_ID = "id";
    private static final String TAG_STORE_URL = "store_url";
    private static final String TAG_IMG_URL = "img_url";
    private static final String TAG_STORE_DELIVERY = "store_delivery";
    private static final String TAG_LINK = "link";
    private static final String TAG_SHIPPING_COST = "shipping_cost";
    private static final String TAG_POSITION = "pos";
    private static final String TAG_LOGO = "logo";
    private static final String TAG_NAME = "name";
    private static final String TAG_STORE_NAME = "store_name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_STOCK = "stock";
    Button srhbtn;
    //	EditText srhtxt;
    String text;
    //private static final String TAG_STOCK = "stock";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//		srhtxt=(EditText)findViewById(R.id.srhtxt);
        srhbtn = (Button) findViewById(R.id.srhbtn);

        new Networking().execute("");
        srhbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //text=srhtxt.getText().toString();
                new Search().execute("");
                //Search s1=new Search();

                //new Search().execute("");


            }
        });

    }


        class Networking extends AsyncTask<String, String, String> {

            StringBuilder strBuilder = new StringBuilder();
            int i;
            JSONArray jsonArray;
            TextView txtVw,txtVwA,txtVwB;
            ImageView imgVw;
            int price=0;
            String nume=null;
            String lenk;
            String id = null, name = null, email = null, store_name=null,stock=null,store_url=null,store_delivery=null,link=null,shipping_cost=null,pos=null,logo=null;
            ArrayList<String> arrLst0 = new ArrayList<String>();
            ArrayList<String> arrLst1 = new ArrayList<String>();
            ArrayList<String> arrLst11 = new ArrayList<String>();
            ArrayList<Integer> arrLst2 = new ArrayList<Integer>();
            ArrayList<String> arrLst3 = new ArrayList<String>();
            ArrayList<String> arrLst4 = new ArrayList<String>();
            ArrayList<String> arrLst5 = new ArrayList<String>();
            ArrayList<String> arrLst6 = new ArrayList<String>();
            ArrayList<String> arrLst7 = new ArrayList<String>();
            ArrayList<String> arrLst8 = new ArrayList<String>();
            ArrayList<String> arrLst9 = new ArrayList<String>();
            ArrayList<String> arrLst10 = new ArrayList<String>();
            int n;
            JSONObject jsonObj;

            @Override
            protected String doInBackground(String... params) {
                // TODO Auto-generated method stub
                URL url;
                try {
                    url = new URL("http://api.smartprix.com/simple/v1?type=product_full&key=NVgien7bb7P5Gsc8DWqc&id=2179&indent=1");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String read;
                    while ((read = bufferedReader.readLine()) != null) {
                        strBuilder.append(read);

                    }
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //			return Integer.toString(n);
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
                ListView lstVw;
                lstVw = (ListView) findViewById(R.id.lstVw);


                try{
                    JSONObject jsonObject = new JSONObject(result);

                    jsonObj = jsonObject.getJSONObject("request_result");
                    jsonArray=jsonObj.getJSONArray("prices");

                    nume= jsonObj.getString(TAG_NAME);
                    lenk=jsonObj.getString(TAG_IMG_URL);

                    n = jsonArray.length();

                    for (int i = 0; i < n; i++) {

                        //id = jsonArray.getJSONObject(i).getString(TAG_ID);
                        name = jsonArray.getJSONObject(i).getString(TAG_NAME);

                        store_name = jsonArray.getJSONObject(i).getString(TAG_STORE_NAME);
                        price = jsonArray.getJSONObject(i).getInt(TAG_PRICE);
                        stock = jsonArray.getJSONObject(i).getString(TAG_STOCK);

                        store_url = jsonArray.getJSONObject(i).getString(TAG_STORE_URL);
                        store_delivery = jsonArray.getJSONObject(i).getString(TAG_STORE_DELIVERY);
                        link = jsonArray.getJSONObject(i).getString(TAG_LINK);
                        shipping_cost = jsonArray.getJSONObject(i).getString(TAG_SHIPPING_COST);
                        pos = jsonArray.getJSONObject(i).getString(TAG_POSITION);
                        logo = jsonArray.getJSONObject(i).getString(TAG_LOGO);

                        //	Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();
                        arrLst0.add(name);
                        arrLst1.add(store_name);
                        arrLst2.add(price);
                        arrLst3.add(stock);
                        arrLst4.add(store_url);
                        arrLst5.add(store_delivery);
                        arrLst6.add(link);
                        arrLst7.add(shipping_cost);
                        arrLst8.add(pos);
                        arrLst9.add(logo);
                        arrLst10.add(nume);
                        arrLst10.add(lenk);

                    }


                }  catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                imgVw=(ImageView)findViewById(R.id.imgVw);
                txtVw=(TextView)findViewById(R.id.txtVw);
                txtVwB=(TextView)findViewById(R.id.txtVwB);
                txtVwA=(TextView)findViewById(R.id.txtVwA);
                int small;
                Context context = null;
                //Integer[] arr = arrLst2.toArray(new Integer[arrLst2.size()]);
                //Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
                Picasso.with(context).load(lenk).into(imgVw);
                int[] arr = new int[arrLst2.size()];
//int in=arrLst2.size();
                for(int i = 0; i < arrLst2.size(); i++) {
                    if (arrLst2.get(i) != null) {
                        arr[i] = arrLst2.get(i);
                    }
                }
                small=arr[0];
                for(i=0;i<arrLst2.size();i++){
                    if(small>arr[i])
                        small=arr[i];
                }

                //txtVw.setText(arrLst0.toString().replace("[", "").replace("]", ""));
                //txtVw.setText(arrLst10.toString().replace("[", "").replace("]", ""));
                txtVw.setText(nume);
                String best="Best Price: Rs. ";
                String avail="Available at ";
                String able=" Stores";
                txtVwB.setText(best+small);
                txtVwA.setText(avail+n+able);


                //int arr[];
                //arrLst2


                // If you want a `primitive` type array
                //int[] arr = Array.toPrimitive(wrapperArr);
                //int arr1[]=arrLst2.toArray(new int[arrLst2.size()]);






                //arr=arrLst2.toArray();


                //Toast.makeText(MainActivity.this, n, 3000).show();
                CustomAdapter cA = new CustomAdapter(MainActivity.this, arrLst0, arrLst1, arrLst2, arrLst3, arrLst4, arrLst5, arrLst6, arrLst7, arrLst8, arrLst9);
                lstVw.setAdapter(cA);

            }

            //Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();

        }


        class Search extends AsyncTask<String, String, String> {
            EditText srhtxt;
            //Button srhbtn;
            String text;
            StringBuilder strBuilder1 = new StringBuilder();
            JSONArray jsonArray;
            JSONObject jsonObj;

            int n;
            String name = null, price = null, img_url = null;
            String fname = null, fprice = null, fimg_url = null;
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
                    URL url = new URL("http://api.smartprix.com/simple/v1?type=search&key=NVgien7bb7P5Gsc8DWqc&category=Mobiles&q=3g&indent=1");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String read1;
                    while ((read1 = bufferedReader.readLine()) != null) {
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
                srhtxt = (EditText) findViewById(R.id.srhtxt);

                //if(text!=null)
                //{
//		JSONObject jsonObject = new JSONObject(result);
//		 jsonObject;
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    jsonObj = jsonObject.getJSONObject("request_result");
                    jsonArray = jsonObj.getJSONArray("results");
                    n = jsonArray.length();

                    for (int i = 0; i < n; i++) {
                        //nume= jsonObj.getString(TAG_NAME);
                        name = jsonArray.getJSONObject(i).getString(TAG_NAME);
                        price = jsonArray.getJSONObject(i).getString(TAG_PRICE);
                        img_url = jsonArray.getJSONObject(i).getString(TAG_IMG_URL);

                        arrLst0.add(name);
                        arrLst1.add(price);
                        arrLst2.add(img_url);
                    }

                    //SearchAdapter sA=new SearchAdapter(MainActivity.this,arrLst0,arrLst1,arrLst2);


//srhbtn.setOnClickListener(new OnClickListener() {

                    //@Override
                    //public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    text = srhtxt.getText().toString();
                    for (int j = 0; j < n; j++) {
                        if (text.equalsIgnoreCase(arrLst0.get(j))) {
                            fname = arrLst0.get(j);
                            fprice = arrLst1.get(j);
                            fimg_url = arrLst2.get(j);

                            arrLst3.add(fname);
                            arrLst4.add(fprice);
                            arrLst5.add(fimg_url);

                            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                            intent.putStringArrayListExtra("aname", arrLst3);
                            intent.putStringArrayListExtra("aprice", arrLst4);
                            intent.putStringArrayListExtra("aimg_url", arrLst5);

                            startActivity(intent);


                        } else {
                            Toast.makeText(getApplicationContext(), "No match found", Toast.LENGTH_SHORT).show();
                        }
//			else if(!(text.equalsIgnoreCase(arrLst0.get(j))))
//			{
//				Toast.makeText(getApplicationContext(), "No match found", 3000).show();
//				break;
//			}
                    }

//	}
//});


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }}