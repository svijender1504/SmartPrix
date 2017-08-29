package com.levcode.vs.smartprixapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> UName;
    ArrayList<String> UStore;
    ArrayList<Integer> UPrice;
    ArrayList<String> UStock;
    ArrayList<String> UStore_url;
    ArrayList<String> UStore_delivery;
    ArrayList<String> ULink;
    ArrayList<String> UShipping_cost;
    ArrayList<String> UPos;
    ArrayList<String> ULogo;




    Context mcontext;
    public CustomAdapter(Context context, ArrayList<String> arrLst0, ArrayList<String> arrLst1,
                         ArrayList<Integer> arrLst2, ArrayList<String> arrLst3, ArrayList<String> arrLst4, ArrayList<String> arrLst5, ArrayList<String> arrLst6, ArrayList<String> arrLst7, ArrayList<String> arrLst8, ArrayList<String> arrLst9) {
        // TODO Auto-generated constructor stub
        mcontext=context;
        //UId=arrLst0;
        UName=arrLst0;
        UStore=arrLst1;
        UPrice=arrLst2;
        UStock=arrLst3;
        UStore_url=arrLst4;
        UStore_delivery=arrLst5;
        ULink=arrLst6;
        UShipping_cost=arrLst7;
        UPos=arrLst8;
        ULogo=arrLst9;
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
        LayoutInflater lF=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=lF.inflate(R.layout.custom_adapter,arg2,false);
        //TextView txtvw;
        //	TextView txtvw1;
        TextView txtvw2;
//		TextView txtvw3;
//		TextView txtvw4;
//		TextView txtvw5;
//		TextView txtvw6;
//		TextView txtvw7;
//		TextView txtvw8;
//		TextView txtvw9;

        Button button;
        ImageView imageView = null;


//		txtvw9=(TextView)v.findViewById(R.id.txtVw9);
//		txtvw1=(TextView)v.findViewById(R.id.txtVw1);
        txtvw2=(TextView)v.findViewById(R.id.txtVw2);
//		txtvw3=(TextView)v.findViewById(R.id.txtVw3);
//		txtvw4=(TextView)v.findViewById(R.id.txtVw4);
//		txtvw5=(TextView)v.findViewById(R.id.txtVw5);
//		txtvw6=(TextView)v.findViewById(R.id.txtVw6);
//		txtvw7=(TextView)v.findViewById(R.id.txtVw7);
//		txtvw8=(TextView)v.findViewById(R.id.txtVw8);
        imageView=(ImageView)v.findViewById(R.id.imageView);
        button=(Button)v.findViewById(R.id.button);

//		browser = (WebView)v.findViewById(R.id.webview);
//		browser.setWebViewClient(new MyBrowser());

        //txtvw9=(TextView)v.findViewById(R.id.txtVw9);
        //	Toast.makeText(mcontext, "break", Toast.LENGTH_SHORT).show();
        //txtvw9.setText(UName.get(arg0));
        //txtvw1.setText(UStore.get(arg0));
        txtvw2.setText("Rs. "+UPrice.get(arg0));
        //txtvw3.setText(UStock.get(arg0));
        //txtvw4.setText(UStore_url.get(arg0));
        //txtvw5.setText(UStore_delivery.get(arg0));
        //txtvw6.setText(ULink.get(arg0));
        //txtvw7.setText(UShipping_cost.get(arg0));
        //txtvw8.setText(UPos.get(arg0));
        //txtvw9.setText(ULogo.get(arg0));
        final String link=ULink.get(arg0).toString();
        final String store_link=UStore_url.get(arg0).toString();
        Picasso.with(mcontext).load(ULogo.get(arg0)).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent=new Intent(mcontext,Practice.class);
                intent.putExtra("alink", link);
                mcontext.startActivity(intent);
//				browser.getSettings().setLoadsImagesAutomatically(true);
//	            browser.getSettings().setJavaScriptEnabled(true);
//	            browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//				browser.loadUrl(link);
//				Toast.makeText(mcontext, "Hellooo", 3000).show();
                //ProgressDialog dialog = ProgressDialog.show(mcontext, "Please wait","Loading......", true);
//				intent = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
//				mcontext.startActivity(intent);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(mcontext,Link.class);
                intent.putExtra("astore_link", store_link);
                mcontext.startActivity(intent);
//				browser.getSettings().setLoadsImagesAutomatically(true);
//	            browser.getSettings().setJavaScriptEnabled(true);
//	            browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//				browser.loadUrl(store_link);
                //ProgressDialog dialog = ProgressDialog.show(mcontext, "Please wait","Loading......", true);
//				intent = new Intent(Intent.ACTION_VIEW,Uri.parse(store_link));
//				mcontext.startActivity(intent);
            }
        });


        return v;

    }





}