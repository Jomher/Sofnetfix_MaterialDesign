package com.sofnetfix.sofnetfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText txtedad, txtapellidos, txtdireccion;
    EditText txtnombres, txttelefono, txtcorreo, txtclave, txtclave2;
    String xedad, xnombres , xapellidos, xtelefono, xcorreo, xdireccion, xclave, xclave2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn = (Button) findViewById(R.id.btnregistro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtcorreo = (EditText) findViewById(R.id.correo);
                txtedad = (EditText) findViewById(R.id.edad);
                txtapellidos = (EditText) findViewById(R.id.txtapellidos);
                txtdireccion = (EditText) findViewById(R.id.direccion);
                txtclave = (EditText) findViewById(R.id.clave);
                txtclave2 = (EditText) findViewById(R.id.clave2);
                txtnombres = (EditText) findViewById(R.id.txtnombre);
                txttelefono = (EditText) findViewById(R.id.txttelefono);

                xcorreo = txtcorreo.getText().toString();
                xedad = txtedad.getText().toString();
                xapellidos = txtapellidos.getText().toString();
                xdireccion = txtdireccion.getText().toString();
                xclave = txtclave.getText().toString();
                xclave2 = txtclave2.getText().toString();
                xnombres = txtnombres.getText().toString();
                xtelefono = txttelefono.getText().toString();


                if (xnombres.equals("") || xapellidos.equals("") || xdireccion.equals("") || xcorreo.equals("")
                        || xedad.equals("") || xtelefono.equals("") || xclave.equals("") || xclave2.equals("")) {
                    Toast.makeText(getApplicationContext(), "POr favor, LLena los campos", Toast.LENGTH_LONG).show();
                } else {
                    ClientesCRUD repo = new ClientesCRUD(getApplicationContext());
                    Clientes cliente = new Clientes();

                    cliente.nombre = xnombres;
                    cliente.apellido = xapellidos;
                    cliente.telefono = xtelefono;
                    cliente.correo = xcorreo;
                    cliente.direccion = xdireccion;
                    cliente.clave = xclave;

                    repo.insertar(cliente);

                    Toast.makeText(getApplicationContext(), "Usuario creado correctamente", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
