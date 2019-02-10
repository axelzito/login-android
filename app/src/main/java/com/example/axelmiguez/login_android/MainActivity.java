package com.example.axelmiguez.login_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.axelmiguez.login_android.session.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView ivUserPhoto;
    TextView tvUserName;
    Button btnLogout;

    SessionManager sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessao = new SessionManager(getApplicationContext());

        ivUserPhoto = (ImageView) findViewById(R.id.user_photo);
        tvUserName = (TextView) findViewById(R.id.user_nome);
        btnLogout = (Button) findViewById(R.id.btnLogOut);

        sessao.checkLogin();

        HashMap<String, String> sessionData = sessao.getSessionData();

        String nome = sessionData.get(SessionManager.PROPERTY_NOME);
        //String token = sessionData.get(SessionManager.PROPERTY_TOKEN);
        String foto = sessionData.get(SessionManager.PROPERTY_FOTO);

        Glide.with(this).load(foto).into(ivUserPhoto);
        tvUserName.setText(nome);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessao.logOut();
            }
        });
    }
}
