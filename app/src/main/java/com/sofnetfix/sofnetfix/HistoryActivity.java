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

    }
}

