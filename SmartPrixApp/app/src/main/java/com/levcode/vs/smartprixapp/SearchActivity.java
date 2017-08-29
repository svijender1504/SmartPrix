package com.levcode.vs.smartprixapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class SearchActivity extends Activity {

    ListView SrhlstVw;
    TextView SrhtxtVw;
    ArrayList<String> arrLst0 = new ArrayList<String>();
    ArrayList<String> arrLst1 = new ArrayList<String>();
    ArrayList<String> arrLst2 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        SrhlstVw=(ListView)findViewById(R.id.SrhlstVw);
        SrhtxtVw=(TextView)findViewById(R.id.SrhtxtVw);

        arrLst0=getIntent().getStringArrayListExtra("aname");
        arrLst1=getIntent().getStringArrayListExtra("aprice");
        arrLst2=getIntent().getStringArrayListExtra("aimg_url");

        SearchAdapter sA=new SearchAdapter(SearchActivity.this,arrLst0,arrLst1,arrLst2);
        SrhlstVw.setAdapter(sA);
    }

}