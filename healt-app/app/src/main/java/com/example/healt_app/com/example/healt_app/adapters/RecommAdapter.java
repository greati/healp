package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.Recommendation;

import java.util.ArrayList;

public class RecommAdapter extends BaseAdapter {

    private ArrayList<Recommendation> recomms;
    private Context context;

    public RecommAdapter(Context ctx, ArrayList<Recommendation> recomms){
        this.recomms = recomms;
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return recomms.size();
    }

    @Override
    public Object getItem(int position) {
        return recomms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Recommendation r = recomms.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.recomm_list_item, parent, false);
        }

        final int pos = position;

        ImageView iv = convertView.findViewById(R.id.iv_recomm_icon);
        TextView tv = convertView.findViewById(R.id.tv_recomm_title);

        tv.setText(r.toString());

        // check type
        iv.setImageResource(R.drawable.ic_user_md_solid);

        return convertView;

    }
}
