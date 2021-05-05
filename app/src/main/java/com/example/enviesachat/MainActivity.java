package com.example.enviesachat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.enviesachat.bo.Article;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = new Article(1,"Pain au chocolat","Viennoiserie au beurre et au chocolat.",1.00F,3,false,"http://www.painauchocolat.fr");

        TextView tvNom = findViewById(R.id.tv_nom);
        TextView tvDescription = findViewById(R.id.tv_description);
        RatingBar ratingBar= findViewById(R.id.rating_degEnvie);
        TextView tvPrix = findViewById(R.id.tv_prix);
        ToggleButton toggleBt = findViewById(R.id.toggle_button);

        tvNom.setText(article.getNom());
        tvDescription.setText(article.getDescription());
        tvPrix.setText(String.valueOf(article.getPrix()));
        ratingBar.setRating(article.getDegEnvie());
        toggleBt.setChecked(article.isAchete());


    }

    public void onClickURL(View view){
        Toast.makeText(this,article.getUrl(),Toast.LENGTH_LONG).show();
    }

    public void onClickAchete(View view){
        article.setAchete(true);
        Log.i(TAG,"Valeur acheté " + article.isAchete());
    }
}