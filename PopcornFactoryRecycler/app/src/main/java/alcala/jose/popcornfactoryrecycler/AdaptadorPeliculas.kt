package alcala.jose.popcornfactoryrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorPeliculas(val peliculas_list: List<Pelicula>): RecyclerView.Adapter<AdaptadorPeliculas.PeliculaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeliculaViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return PeliculaViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: PeliculaViewHolder,
        position: Int
    ) {
        val pelicula: Pelicula=peliculas_list[position]
        holder.imagen_pelicula.setImageResource(pelicula.imagen)
        holder.titulo_pelicula.text=pelicula.titulo
        holder.descripcion_pelicula.text=pelicula.desc
    }

    override fun getItemCount(): Int {
        return peliculas_list.size
    }

    class PeliculaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imagen_pelicula: ImageView=itemView.findViewById(R.id.imagen_pelicula)
        var titulo_pelicula: TextView=itemView.findViewById(R.id.titulo_pelicula)
        var descripcion_pelicula: TextView=itemView.findViewById(R.id.descripcion_pelicula)


    }
}