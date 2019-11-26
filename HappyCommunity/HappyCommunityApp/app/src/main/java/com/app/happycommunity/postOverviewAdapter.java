package com.app.happycommunity;

import com.app.happycommunity.models.*;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.app.happycommunity.postOverview;
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

    public void add(PostOverviewModel item) {
        postList.add(item);
        this.notifyDataSetChanged();
    }

    public void clear() {
        postList.clear();
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PostOverviewModel model = (PostOverviewModel) getItem(position);
        LinearLayout postLayout;

        postLayout=(LinearLayout) LayoutInflater.from(pOContext).inflate(R.layout.post, parent,false);
        final TextView title = (TextView) postLayout.findViewById(R.id.postTitle);
        final TextView reward = (TextView) postLayout.findViewById(R.id.postReward);
        final TextView creator= (TextView) postLayout.findViewById(R.id.postCreator);
        final TextView city = (TextView) postLayout.findViewById(R.id.postCity);
        title.setText(model.getTitle());
        reward.setText(Integer.toString(model.getReward()));
        creator.setText(model.getCreator());
        city.setText(model.getCity());

        return postLayout;
    }

}
