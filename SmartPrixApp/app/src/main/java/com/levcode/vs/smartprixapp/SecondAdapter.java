package com.levcode.vs.smartprixapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import com.squareup.picasso.Picasso;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vijendersingh on 2017-08-28.
 */

public class SecondAdapter extends BaseAdapter {

    //	"id": "2179",
//    "category": "Mobiles",
//    "name": "Samsung Galaxy S Duos S7562",
//    "price": "12290",
//    "brand": "Samsung",
//    "link": "http:\/\/www.smartprix.com\/mobiles\/samsung_galaxy_s_duos_s7562-m2179.php",
//    "img_url": "http:\/\/img2.smartprix.com\/mobiles\/2179\/s-1\/samsung_galaxy_s_duos_s7562.jpg"
    ArrayList<String> UId;
    ArrayList<String> UCategory;
    ArrayList<String> UName;
    ArrayList<String> UPrice;
    ArrayList<String> UBrand;
    ArrayList<String> ULink;
    ArrayList<String> UImg_url;

    Context mcontext;
    public SecondAdapter(Context context, ArrayList<String> arrLst0, ArrayList<String> arrLst1,
                         ArrayList<String> arrLst2, ArrayList<String> arrLst3, ArrayList<String> arrLst4, ArrayList<String> arrLst5, ArrayList<String> arrLst6) {
        // TODO Auto-generated constructor stub
        mcontext=context;
        //UId=arrLst0;
        UId=arrLst0;
        UCategory=arrLst1;
        UName=arrLst2;
        UPrice=arrLst3;
        UBrand=arrLst4;
        ULink=arrLst5;
        UImg_url=arrLst6;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return UName.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater lF=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=lF.inflate(R.layout.second_adapter,parent,false);
        TextView txtVw;
        //TextView txtVw1;
        TextView txtVw2;
        TextView txtVw3;
        //TextView txtVw4;
//		TextView txtVw5;
//		TextView txtVw6;
        ImageView imageView1;

        imageView1=(ImageView)v.findViewById(R.id.imageView1);
        //txtVw=(TextView)v.findViewById(R.id.stxtVw);
        //txtVw1=(TextView)v.findViewById(R.id.stxtVw1);
        txtVw2=(TextView)v.findViewById(R.id.stxtVw2);
        txtVw3=(TextView)v.findViewById(R.id.stxtVw3);
//		txtVw4=(TextView)v.findViewById(R.id.stxtVw4);
//		txtVw5=(TextView)v.findViewById(R.id.stxtVw5);
//		txtVw6=(TextView)v.findViewById(R.id.stxtVw6);

        //	Toast.makeText(mcontext, "break", Toast.LENGTH_SHORT).show();


        //txtVw.setText(UId.get(position));
        //	txtVw1.setText(UCategory.get(position));
        txtVw2.setText(UName.get(position));
        txtVw3.setText("Rs. "+UPrice.get(position));
        //txtVw4.setText(UBrand.get(position));
        //txtVw5.setText(ULink.get(position));
        //txtVw6.setText(UImg_url.get(position));
        Picasso.with(mcontext).load(UImg_url.get(position)).into(imageView1);
        final String store_link=ULink.get(position).toString();

        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(mcontext,Link.class);
                intent.putExtra("astore_link",store_link );
                mcontext.startActivity(intent);

            }
        });

        return v;





    }


}