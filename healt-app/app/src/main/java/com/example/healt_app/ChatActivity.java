package com.example.healt_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.healt_app.com.example.healt_app.adapters.ChatMessagesAdapter;
import com.example.healt_app.com.example.healt_app.models.AuthData;
import com.example.healt_app.com.example.healt_app.models.ChatMessage;
import com.example.healt_app.com.example.healt_app.models.User;

import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    private EditText edtChatText;
    private ListView lvChat;
    private ChatMessagesAdapter adapter;
    private ArrayList<ChatMessage> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setTitle("Pacientes");

        edtChatText = findViewById(R.id.edt_chat_text);

        lvChat = findViewById(R.id.lv_chat);

        messages = new ArrayList<ChatMessage>();
        messages.add(new ChatMessage(new User(1L),"Olá!", new Date()));
        messages.add(new ChatMessage(new User(2L),"Oi, srta!", new Date()));
        messages.add(new ChatMessage(new User(2L),"Podemos começar?", new Date()));
        messages.add(new ChatMessage(new User(1L),"Claro! Como se sente hoje?", new Date()));

        adapter = new ChatMessagesAdapter(this, messages);
        lvChat.setAdapter(adapter);

        Button btSend = findViewById(R.id.bt_chat_send);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtChatText.getText().toString();
                ChatMessage message = new ChatMessage(AuthData.getLoggedUser(), txt, new Date());
                messages.add(message);
                adapter.notifyDataSetChanged();
                edtChatText.setText("");
            }
        });

    }
}
