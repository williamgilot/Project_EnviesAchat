package com.example.enviesachat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.enviesachat.adapter.ArticleAdapter;
import com.example.enviesachat.bo.Article;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = getIntent().getParcelableExtra("article");

        TextView tvNom = findViewById(R.id.tv_nom);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvPrix = findViewById(R.id.tv_prix);
        RatingBar rbEnvies = findViewById(R.id.rating_degEnvie);
        ToggleButton tgBtAchete = findViewById(R.id.toggle_button);

        tvNom.setText(article.getNom());
        tvDescription.setText(article.getDescription());
        tvPrix.setText(String.valueOf(article.getPrix()));
        rbEnvies.setRating(article.getDegEnvie());
        tgBtAchete.setChecked(article.isAchete());


    }

    public void onClickURL(View view){
        Log.i(TAG,"Lancement de l'activité InfoUrlActivity");
        Intent intention = new Intent(MainActivity.this,InfoUrlActivity.class);
        intention.putExtra("article", article);
        startActivity(intention);
    }

    public void onClickAchete(View view){
        article.setAchete(!article.isAchete());
        Log.i(TAG,"Valeur acheté " + article.isAchete());
    }
}