package com.example.enviesachat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enviesachat.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);

        Intent intention = getIntent();
        Article article = intention.getParcelableExtra("article");

        TextView tvUrl= findViewById(R.id.tv_url);
        tvUrl.setText(article.getUrl());


    }
}