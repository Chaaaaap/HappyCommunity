package com.app.happycommunity;

import com.app.happycommunity.models.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class postOverviewAdapter extends BaseAdapter {
    private final Context pOContext;
    private final List<PostOverviewModel> postList = new ArrayList<>();
    public postOverviewAdapter(Context context){
        pOContext=context;
    }

    @Override
    public int getCount(){
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PostOverviewModel model = (PostOverviewModel) getItem(position);
        LinearLayout postLayout;

        postLayout=(LinearLayout) LayoutInflater.from(pOContext).inflate(R.layout.post, parent,false);
        final TextView title = (TextView) postLayout.findViewById(R.id.postTitle);
        final TextView reward = (TextView) postLayout.findViewById(R.id.postReward);
        final TextView creator= (TextView) postLayout.findViewById(R.id.postTitle);
        final TextView city = (TextView) postLayout.findViewById(R.id.postCity);
        title.setText(model.getTitle());
        reward.setText(model.getReward());
        creator.setText(model.getCreator());
        city.setText(model.getCity());

        return postLayout;
    }

}
