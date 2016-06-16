package com.mohammed.shameem.contactsparsing.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mohammed.shameem.contactsparsing.R;
import com.mohammed.shameem.contactsparsing.holder.UserHolder;
import com.mohammed.shameem.contactsparsing.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shameem on 6/13/2016.
 */
public class UserDetailsAdapter extends BaseAdapter {
    Context context;
    List<UserHolder> userHolderList=new ArrayList<>();
    LayoutInflater inflater;


    public UserDetailsAdapter(MainActivity activity, List<UserHolder> userHolder_object) {
        this.context = activity;
        this.userHolderList = userHolderList;
        inflater=LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return userHolderList.size();
    }

    @Override
    public UserHolder getItem(int position) {
        return userHolderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootLayout=convertView;
        ViewHolder viewHolder_obj;
        if (rootLayout==null){
            rootLayout=inflater.inflate(R.layout.contact_list_item,parent,false);
            viewHolder_obj=new ViewHolder(rootLayout);
            rootLayout.setTag(viewHolder_obj);
        }
        else {
            viewHolder_obj= (ViewHolder) rootLayout.getTag();
        }
        UserHolder userHolder_object=getItem(position);
        viewHolder_obj.textViewContactName.setText(userHolder_object.getName());
        viewHolder_obj.textViewContactEmailAddress.setText(userHolder_object.getEmail());

        // viewHolder_obj.textViewContactPhoneNumber.setText("Longitude :"+userHolder_object.getAddress().get(position).getGeo().get(position).getLat()+"\n Latitude :"+userHolder_object.getAddress().get(position).getGeo().get(position).getLng());
        return rootLayout;
    }
    private class ViewHolder{
        TextView textViewContactName,textViewContactEmailAddress,textViewContactPhoneNumber;
        public ViewHolder(View view) {
            textViewContactName= (TextView) view.findViewById(R.id.textViewContactName);
            textViewContactEmailAddress= (TextView) view.findViewById(R.id.textViewContactEmailAddress);
            textViewContactPhoneNumber= (TextView) view.findViewById(R.id.textViewContactPhoneNumber);

        }
    }
}
