package com.example.enviesachat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enviesachat.R;
import com.example.enviesachat.bo.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>
{
    private ArrayList<Article> mDataset;
    private View.OnClickListener clickListener;

    public ArticleAdapter(ArrayList<Article> mDataset,View.OnClickListener clickListener) {
        this.mDataset = (ArrayList<Article>) mDataset;
        this.clickListener = clickListener ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.presentation_article_ligne,parent,false);
        return new ViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNom.setText(mDataset.get(position).getNom());
        holder.tvDescription.setText(mDataset.get(position).getDescription());
        holder.tvPrix.setText(Float.toString(mDataset.get(position).getPrix()));
        holder.rBarEnvie.setRating(mDataset.get(position).getDegEnvie());
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public  TextView tvNom ;
        public  TextView tvDescription ;
        public  TextView tvPrix ;
        public RatingBar rBarEnvie;
        public ViewHolder(View itemView,View.OnClickListener clickListener){
            super(itemView);
             tvNom = itemView.findViewById(R.id.tv_nom);
             tvDescription = itemView.findViewById(R.id.tv_description);
             tvPrix = itemView.findViewById(R.id.tv_prix);
             rBarEnvie = itemView.findViewById(R.id.rating_degEnvie);
             itemView.setOnClickListener(clickListener);
        }
    }
}
