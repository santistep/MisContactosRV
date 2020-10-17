package sancode.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        inicializarListaContactos();
        inicializarAdaptador();


        /*// LISTA DE CONTACTOS //
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.icons8_year_of_dog_96,"Santiago", "099123456", "santiago@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_monkey_96,"Juana", "099456789", "Juana@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_swine_96,"Bruna", "099789123", "Bruna@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_year_of_goat_96,"Emma", "099456123", "Emma@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombresContacto.add(contacto.getNombre());
        }

         */
        /*
        ListView listContactos = (ListView) findViewById(R.id.listContactos);
        listContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        // METODO QUE CONTROLA LOS TOUCH SOBRE LA LISTA DE CONTACTOS //
        listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.parametro_nombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.parametro_telefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.parametro_email), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });

         */
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.icons8_year_of_dog_96,"Santiago", "099123456", "santiago@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_monkey_96,"Juana", "099456789", "Juana@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_swine_96,"Bruna", "099789123", "Bruna@gmail.com"));
        contactos.add(new Contacto(R.drawable.icons8_year_of_goat_96,"Emma", "099456123", "Emma@gmail.com"));

    }
}