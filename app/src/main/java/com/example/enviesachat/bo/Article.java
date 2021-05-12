package com.example.enviesachat.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private int id;
    private String nom;
    private String description;
    private String url;
    private float prix;
    private float degEnvie;
    private boolean isAchete;




    public Article(){

    }

    public Article(int id, String nom, String description, float prix, float degEnvie, boolean isAchete , String url) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.degEnvie = degEnvie;
        this.isAchete = isAchete;
        this.url = url;
    }

    protected Article(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        description = in.readString();
        url = in.readString();
        prix = in.readFloat();
        degEnvie = in.readFloat();
        isAchete = in.readByte() != 0;

    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getDegEnvie() {
        return degEnvie;
    }

    public void setDegEnvie(float degEnvie) {
        this.degEnvie = degEnvie;
    }

    public boolean isAchete() {
        return isAchete;
    }

    public void setAchete(boolean achete) {
        isAchete = achete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        return "Article{" +
                "id=" + id +
                " ,  nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", prix=" + prix +
                ", degEnvie=" + degEnvie +
                ", achat=" + isAchete +
                '}';

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeFloat(prix);
        dest.writeFloat(degEnvie);
        dest.writeByte((byte) (isAchete ? 1 : 0));
    }
}
