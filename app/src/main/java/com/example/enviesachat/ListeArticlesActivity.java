package com.example.enviesachat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.example.enviesachat.adapter.ArticleAdapter;
import com.example.enviesachat.bo.Article;

import java.util.ArrayList;

public class ListeArticlesActivity extends AppCompatActivity {
    private static final String TAG = "WGILOT";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter articleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Article> listeAritcles = new ArrayList<>();

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = Integer.parseInt(v.getTag().toString());
            Log.i(TAG,"POSITION : "+ v.getTag());
            Intent intent = new Intent(ListeArticlesActivity.this,MainActivity.class);
            intent.putExtra("article", listeAritcles.get(position));
            startActivity(intent);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);

        recyclerView = (RecyclerView) findViewById(R.id.liste_envie);

        chargementEnvies();
        chargementRecycler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.envies_achat_menu,menu);
        return true;
    }

    private void chargementEnvies(){
       Article articlePainChoc = new Article(1,"Pain au chocolat","Viennoiserie au beurre et au chocolat.",5.00F,3,false,"http://www.painauchocolat.fr");
       Article articleBaguette = new Article(2,"Baguette"," Pain en forme de baguette",1.00F,4,false,"https://mabaguette.com");
       Article  articleCroissant = new Article(3,"Croissant" , "Comme un pain au chocolat sans chocolat",0.90F,4,false,"http://www.croissanr.com");

       listeAritcles.add(articlePainChoc);
       listeAritcles.add(articleBaguette);
       listeAritcles.add(articleCroissant);
    }

    private void chargementRecycler(){
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        articleAdapter = new ArticleAdapter(listeAritcles,clickListener);
        recyclerView.setAdapter(articleAdapter);
    }
}