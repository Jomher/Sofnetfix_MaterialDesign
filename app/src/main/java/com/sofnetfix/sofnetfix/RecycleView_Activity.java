package com.sofnetfix.sofnetfix;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


public class RecycleView_Activity extends ActionBarActivity{

    RecyclerView reciclador;
    RecyclerView.Adapter adaptador;
    RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_);

        ArrayList<Servicios> item;
        item= new ArrayList<>(3);
        item.add(new Servicios(R.drawable.software, "Software", "Desarrollamos tus ideas"));
        item.add(new Servicios(R.drawable.hardware, "Hardware", "Soporte tecnico"));
        item.add(new Servicios(R.drawable.redes, "Redes y Telecomunicaciones", "Conecta tus equipos"));

        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        reciclador.setLayoutManager(lManager);

        adaptador = new AdapterServicios(item);
        reciclador.setAdapter(adaptador);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
