package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class FirstActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        new First().execute("");
    }


    class First extends AsyncTask<String, String, String> {

        StringBuilder strBuilder = new StringBuilder();
        int i;
        JSONArray jsonArray;

        String name=null;
        ArrayList<String> arrLst0 = new ArrayList<String>();
        int n;

        ArrayAdapter<String> arrAdapt;

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            URL url;
            try {
                url = new URL("http://api.smartprix.com/simple/v1?type=categories&key=NVgien7bb7P5Gsc8DWqc&indent=1");
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
            // for(i=0;i<3;i++)
            // {
            //
            // publishProgress(param[i]);
            // }
            // return param[i];

            // try {
            // JSONObject jsonObject=new JSONObject("strBuilder");
            // //jsonArray = new JSONArray("strBuilder");
            // jsonArray=jsonObject.getJSONArray("name");
            // n=jsonArray.length();
            // //jsonArray.getJSONArray("name");
            //
            // JSONObject object=jsonArray.getJSONObject(0);
            // name=object.getString("name");
            // //Toast.makeText(getApplicationContext(), name, 3000).show();
            //
            //// for(i=0;i<n;i++)
            //// {
            //// name[i];
            //// }
            // } catch (JSONException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }







            //String m=n
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
            ListView lstVw1;
            lstVw1 = (ListView) findViewById(R.id.lstVw1);


            try{
                JSONObject jsonObject = new JSONObject(result);

                //jsonObj = jsonObject.getJSONObject("request_result");
                jsonArray=jsonObject.getJSONArray("request_result");
                n = jsonArray.length();


                for (int i = 0; i < n; i++) {

                    //id = jsonArray.getJSONObject(i).getString(TAG_ID);
                    name = jsonArray.getString(i);



                    //	Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();
                    arrLst0.add(name);

                }


            }  catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            ArrayAdapter<String> arrAdapt =new ArrayAdapter<String>(FirstActivity.this,android.R.layout.simple_list_item_1,arrLst0);

            //Toast.makeText(MainActivity.this, n, 3000).show();
            //CustomAdapter cA = new CustomAdapter(MainActivity.this, arrLst0, arrLst1, arrLst2, arrLst3);
            lstVw1.setAdapter(arrAdapt);

            lstVw1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub

                    if(arg2==0)
                    {
                        Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), arrLst0.get(arg2), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        //Toast.makeText(getApplicationContext(), id + " " + name + " " + email, 3000).show();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




