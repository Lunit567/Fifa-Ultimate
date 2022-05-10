package luna.martin.fifa_ultimate.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import luna.martin.fifa_ultimate.R
import luna.martin.fifa_ultimate.modelo.Futbolista

class FutbolistaAdapter(val listaFutbolistas:ArrayList<Futbolista>): RecyclerView.Adapter<FutbolistaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Nombre.text=listaFutbolistas[position].nombre
        holder.ID.text=listaFutbolistas[position].id
        holder.Posicion.text=listaFutbolistas[position].posicion
        holder.Raro.text=listaFutbolistas[position].raro
    }

    override fun getItemCount(): Int {
        return listaFutbolistas.size
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        val Nombre: TextView
        val ID: TextView
        val Posicion: TextView
        val Raro: TextView

        init {
            Nombre = vista.findViewById(R.id.NomFut)
            ID = vista.findViewById(R.id.IDFut)
            Posicion = vista.findViewById(R.id.PodiFut)
            Raro = vista.findViewById(R.id.RaroFut)
        }
    }

}