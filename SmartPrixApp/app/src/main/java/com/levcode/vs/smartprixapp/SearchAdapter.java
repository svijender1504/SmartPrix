package com.levcode.vs.smartprixapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class SearchAdapter extends BaseAdapter {

    ArrayList<String> UName;
    ArrayList<String> UPrice;
    ArrayList<String> UImg_url;
    Context mContext;

    public SearchAdapter(Context context, ArrayList<String> arrLst0, ArrayList<String> arrLst1,
                         ArrayList<String> arrLst2) {
        // TODO Auto-generated constructor stub
        UName=arrLst0;
        UPrice=arrLst1;
        UImg_url=arrLst2;
        mContext=context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return UName.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub
        LayoutInflater lF=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=lF.inflate(R.layout.search_adapter,arg2,false);
        TextView satxtVw,satxtVw1;
        ImageView imageView2;
        satxtVw=(TextView)v.findViewById(R.id.satxtVw);
        satxtVw1=(TextView)v.findViewById(R.id.satxtVw1);
        imageView2=(ImageView)v.findViewById(R.id.imageView2);
        Picasso.with(mContext).load(UImg_url.get(arg0)).into(imageView2);
        satxtVw.setText(UName.get(arg0));
        satxtVw1.setText("Rs. "+UPrice.get(arg0));

        return v;
    }

}
