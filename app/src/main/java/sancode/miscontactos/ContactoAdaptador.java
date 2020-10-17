package sancode.miscontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;

    //Metodo constructor genera la lista de contactos
    public ContactoAdaptador (ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }


    @NonNull
    @Override
    //Este metodo infla el layout y lo pasa al ViewHolder para que obtenga los views.
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        //Indicamos el Layout que estara reciclando el RecyclerView
        return new ContactoViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de Contactos//
        return contactos.size();
    }

    public static class ContactoViewHolder extends ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }
}
