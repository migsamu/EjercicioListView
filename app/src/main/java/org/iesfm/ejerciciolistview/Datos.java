package org.iesfm.ejerciciolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    private TextView datos;
    private String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        getinfo();
    }

    public void getinfo() {
        Intent main = getIntent();
        seleccion = main.getStringExtra(MainActivity.SISTEMA_OPERATIVO);
        datos = (TextView) findViewById(R.id.tvDatos);
        datos.setText(seleccion);
    }

    public void volver(View v) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}