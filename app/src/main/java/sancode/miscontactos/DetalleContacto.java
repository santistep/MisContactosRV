package sancode.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.parametro_nombre));
        String telefono = parametros.getString(getResources().getString(R.string.parametro_telefono));
        String email = parametros.getString(getResources().getString(R.string.parametro_email));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
        //INTENTO EXPLICITO (LEVANTO LA APP DE LLAMADAS DEL SISTEMA)
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefono)));//Uri - formato para pasar el telefono -

    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto: "));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));// Chooser elige la aplicacion donde quiero abrir el mail

    }
    // Agarro metodo (back) y modifico el comportamiento - debido a la economizacion de activities -
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}