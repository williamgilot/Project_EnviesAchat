package com.example.enviesachat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class ConfigurationActivity extends AppCompatActivity {

    public static final String CLE_TRI = "CLE_TRI";
    public static final String CLE_DEFAUT_PRIX = "CLE_DEFAUT_PRIX";

    EditText edPrixDefaut;
    Switch tri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        SharedPreferences sharedPreferences = getSharedPreferences("configuration",MODE_PRIVATE);
        String valeurDefautPrix = sharedPreferences.getString(CLE_DEFAUT_PRIX,"");
        Boolean triPrix = sharedPreferences.getBoolean(CLE_TRI,false);
        edPrixDefaut = findViewById(R.id.ed_defaultPrix);
        edPrixDefaut.setText(valeurDefautPrix);
        tri = findViewById(R.id.sw_triPrix);
        tri.setChecked(triPrix);

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences("configuration",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(CLE_TRI,tri.isChecked());
        editor.putString(CLE_DEFAUT_PRIX,edPrixDefaut.getText().toString());
        editor.commit();
    }
}
