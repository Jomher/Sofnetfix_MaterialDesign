package com.sofnetfix.sofnetfix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by isai on 11-16-15.
 */


public class AdapterServicios extends RecyclerView.Adapter<AdapterServicios.serviciosViewHolder> {
    private ArrayList<Servicios> item;

    public AdapterServicios(ArrayList<Servicios> item) {
        this.item = item;
    }

    @Override
    public serviciosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new serviciosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(serviciosViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(item.get(i).getImagen());
        viewHolder.servicio.setText(item.get(i).getNombre());
        viewHolder.detalle.setText(item.get(i).getVisitas());
    }

    @Override
    public int getItemCount()
    {
        return item.size();
    }

    public class serviciosViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView servicio;
        public TextView detalle;

        public serviciosViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.cvimagen);
            servicio = (TextView) v.findViewById(R.id.cvnombre);
            detalle = (TextView) v.findViewById(R.id.visitas);
        }
    }
}

