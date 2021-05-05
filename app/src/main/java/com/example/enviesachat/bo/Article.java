package com.example.enviesachat.bo;

public class Article {
    private int id;
    private String nom;
    private String description;
    private float prix;
    private float degEnvie;
    private boolean isAchete;
    private String url;



    public Article(){

    }

    public Article(int id, String nom, String description, float prix, float degEnvie, boolean isAchete,String url) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.degEnvie = degEnvie;
        this.isAchete = isAchete;
        this.url = url;
    }

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
}
