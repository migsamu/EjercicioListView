package org.iesfm.ejerciciolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvSistemasOperativos;

    private RadioGroup rgSistemasOperativos;
    private RadioButton rbOpc1;
    private RadioButton rbOpc2;
    private RadioButton rbOpc3;

    private String seleccion;

    protected static final String SISTEMA_OPERATIVO = "org.iesfm.ejerciciolistview.sistemaOperativo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        lvSistemasOperativos = (ListView) findViewById(R.id.lvSistemasOperativos);

        rgSistemasOperativos = (RadioGroup) findViewById(R.id.rgSistemasOperativos);
        rgSistemasOperativos.setVisibility(View.GONE);

        rbOpc1 = (RadioButton) findViewById(R.id.rbOpcion1);
        rbOpc2 = (RadioButton) findViewById(R.id.rbOpcion2);
        rbOpc3 = (RadioButton) findViewById(R.id.rbOpcion3);

        crearListView();
    }

    public void crearListView() {
        String[] sistemasOperativos = {"Windows", "Linux", "IOS", "Otros"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sistemasOperativos);

        lvSistemasOperativos.setAdapter(adapter);

        lvSistemasOperativos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        rbOpc1.setText("Windows 7");
                        rbOpc2.setText("Windows 10");
                        rbOpc3.setText("Windows 11");
                        rgSistemasOperativos.setVisibility(View.VISIBLE);
                        seleccion = "Windows";
                        Toast.makeText(parent.getContext(), "Ha seleccionado Windows", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        rbOpc1.setText("Ubuntu");
                        rbOpc2.setText("Debian");
                        rbOpc3.setText("Otro");
                        rgSistemasOperativos.setVisibility(View.VISIBLE);
                        seleccion = "Linux";
                        Toast.makeText(parent.getContext(), "Ha seleccionado Linux", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        seleccion = "IOS";
                        rgSistemasOperativos.setVisibility(View.GONE);
                        Toast.makeText(parent.getContext(), "Ha seleccionado IOS", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        seleccion = "Otro";
                        rgSistemasOperativos.setVisibility(View.GONE);
                        Toast.makeText(parent.getContext(), "Ha seleccionado Otro", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

    public void sendInfo(View v) {
        Intent datos = new Intent(this, Datos.class);

        if (seleccion.equals("Windows")) {
            switch (rgSistemasOperativos.getCheckedRadioButtonId()) {
                case R.id.rbOpcion1:
                    seleccion += " 7";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
                case R.id.rbOpcion2:
                    seleccion += " 10";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
                case R.id.rbOpcion3:
                    seleccion += " 11";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
            }
        } else if (seleccion.equals("Linux")) {
            switch (rgSistemasOperativos.getCheckedRadioButtonId()) {
                case R.id.rbOpcion1:
                    seleccion += "-Ubuntu";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
                case R.id.rbOpcion2:
                    seleccion += "-Debian";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
                case R.id.rbOpcion3:
                    seleccion += "-Otro";
                    datos.putExtra(SISTEMA_OPERATIVO, seleccion);
                    startActivity(datos);
                    break;
            }
        }else if (seleccion.equals("IOS")) {
            datos.putExtra(SISTEMA_OPERATIVO, seleccion);
            startActivity(datos);
        }


    }


}