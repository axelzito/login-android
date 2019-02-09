package com.example.aluno.myapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Logado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);
        String a = getIntent().getStringExtra("bla");
        TextView email = (TextView) findViewById(R.id.logado);
        email.setText(String.valueOf(a));
    }

    public void sair(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // TextView email = (TextView) findViewById(R.id.email);
        // String login = email.getText().toString();
        // intent.putExtra("bla", login);
        Context contexto = getApplicationContext();
        String texto = "Você foi deslogado";
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
        startActivity(intent);
    }
}

