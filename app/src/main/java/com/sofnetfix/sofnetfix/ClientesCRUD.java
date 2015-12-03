package com.sofnetfix.sofnetfix;

/**
 * Created by isai on 11-23-15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jonathan on 02/11/2015.
 */
public class ClientesCRUD {
    private DBHelper dbHelper;

    public ClientesCRUD(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertar (Clientes cliente) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Clientes.NOMBRE, cliente.nombre);
        values.put(Clientes.APELLIDO,cliente.apellido);
        values.put(Clientes.TELEFONO, cliente.telefono);
        values.put(Clientes.CORREO, cliente.correo);
        values.put(Clientes.DIRECCION, cliente.direccion);
        values.put(Clientes.CLAVE, cliente.clave);

        db.insert(Clientes.TABLA, null, values);
        db.close(); // Closing database connection
    }

    public void insertarServicio (SolicitudDeServicios solicitudDeServicios){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(SolicitudDeServicios.SERVICIO_ID , solicitudDeServicios.servcioId);
        values.put(SolicitudDeServicios.DESCRIPCION, solicitudDeServicios.descripcion);
        values.put(SolicitudDeServicios.FECHA, solicitudDeServicios.fecha);

    }

    public String loginBD (String correo, String clave){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String Query = "select "+Clientes.NOMBRE+" from "+Clientes.TABLA+
                " where "+Clientes.CORREO+" = '"+correo+"' " +
                "and "+Clientes.CLAVE+" = '"+clave+"' ";
        Cursor cursor = db.rawQuery(Query, null);
        String c;
        c = "sin datos";

        if (cursor.moveToFirst()){
            c= cursor.getString(0);
        }

        cursor.close();
        return c;
    }

public Cursor read (String tabla){
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    String Query = "select * from "+tabla+" ";
    Cursor cursor = db.rawQuery(Query,null);
    if(cursor != null){
        cursor.moveToNext();
    }
    cursor.close();
    return cursor;
}


/*    public ArrayList<HashMap<String, String>> read (String tabla) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SolicitudDeServicios.SERVICIO_ID + "," +
                SolicitudDeServicios.DESCRIPCION + "," +
                SolicitudDeServicios.FECHA + "," +
                " FROM " + tabla;


        ArrayList<HashMap<String, String>> list = new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> solicitud = new HashMap<String, String>();
                solicitud.put("categoria", cursor.getString(cursor.getColumnIndex(SolicitudDeServicios.SERVICIO_ID)));
                solicitud.put("descripcion", cursor.getString(cursor.getColumnIndex(SolicitudDeServicios.DESCRIPCION)));
                solicitud.put("fecha", cursor.getString(cursor.getColumnIndex(SolicitudDeServicios.FECHA)));
                list.add(solicitud);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;

    }*/


}
