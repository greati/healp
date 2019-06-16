package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.AuthData;
import com.example.healt_app.com.example.healt_app.models.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChatMessagesAdapter extends BaseAdapter {

    private ArrayList<ChatMessage> messages;
    private Context ctx;

    public ChatMessagesAdapter(Context ctx, ArrayList<ChatMessage> messages) {
        this.ctx = ctx;
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ChatMessage r = messages.get(i);

        if (convertView == null) {
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.chat_list_item, viewGroup, false);
        }

        final int pos = i;

        TextView tv = convertView.findViewById(R.id.tv_chat_text_item);
        tv.setText(r.getText());

        TextView tvDate = convertView.findViewById(R.id.tv_chat_date_item);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String date = sdf.format(r.getSendDate());

        tvDate.setText(date);

        LinearLayout ll = convertView.findViewById(R.id.ll_chat_msg_list_item);

        tv.setBackgroundColor(ctx.getResources().getColor(R.color.colorBackChatNormal));

        if (r.getUser().equals(AuthData.getLoggedUser())) {
            ll.setGravity(Gravity.RIGHT);
            tv.setBackgroundColor(ctx.getResources().getColor(R.color.colorBackChat));
        } else {
            ll.setGravity(Gravity.LEFT);
        }


        return convertView;
    }
}
