package com.sofnetfix.sofnetfix;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class HistoryActivity extends Activity {

    ListView li;
    ArrayList<SolicitudDeServicios> lista = new ArrayList<SolicitudDeServicios>();
    SolicitudDeServicios solicitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        li = (ListView) findViewById(R.id.historialList);

        ClientesCRUD repo = new ClientesCRUD(this);
        Cursor c = repo.read(SolicitudDeServicios.TABLA);

        if (c.moveToFirst()){
            do{

                solicitud.servcioId=c.getString(0);
                solicitud.descripcion=c.getString(1);
                solicitud.fecha=c.getString(2);
            lista.add(solicitud);
            }while (c.moveToNext());
        }

        ArrayAdapter<SolicitudDeServicios> adapter = new ArrayAdapter<SolicitudDeServicios>(getApplicationContext(),android.R.layout.activity_list_item,lista);
        li.setAdapter(adapter);


              /* ArrayList<HashMap<String, String>> listaSolicitud =  repo.read(SolicitudDeServicios.TABLA);
        if(listaSolicitud.size()!=0) {
      /*      ListView lv = getListView();
            /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    idSolicitud = (TextView) view.findViewById(R.id.idSolicitud);
                    String studentId = idSolicitud.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(),StudentDetail.class);
                    objIndent.putExtra("student_Id", Integer.parseInt( studentId));
                    startActivity(objIndent);
                }
            });

            ListAdapter adapter = new SimpleAdapter( HistoryActivity.this,listaSolicitud, R.layout.card_view, new String[] { "id","name"}, new int[] {R.id.idSolicitud, R.id.idSolicitud});
            setListAdapter(adapter);
        }else{
            Toast.makeText(this,"No student!",Toast.LENGTH_SHORT).show();
        }

    }*/




         /*   ArrayList<Servicios> item;
            item= new ArrayList<>(3);
        for (int i = 0 ; i<cursor.getCount(); i++){
            do (cursor.moveToFirst()) {
                item.add(new Servicios(cursor.getColumnIndex(SolicitudDeServicios.SERVICIO_ID), "Software", "Desarrollamos tus ideas"));
            }
            while (cursor.moveToNext());
        };
            item.add(new Servicios(R.drawable.software, "Software", "Desarrollamos tus ideas"));
            item.add(new Servicios(R.drawable.hardware, "Hardware", "Soporte tecnico"));
            item.add(new Servicios(R.drawable.redes, "Redes y Telecomunicaciones", "Conecta tus equipos"));

            reciclador_h = (RecyclerView) findViewById(R.id.reciclador_historial);
            reciclador_h.setHasFixedSize(true);
            lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
            reciclador_h.setLayoutManager(lManager);

            adaptador = new AdapterServicios(item);
            reciclador_h.setAdapter(adaptador);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }*/
    }
}

