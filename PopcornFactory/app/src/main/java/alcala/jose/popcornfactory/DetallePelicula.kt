package alcala.jose.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //header
        val header: ImageView =findViewById(R.id.iv_pelicula_imagen)
        //nombre
        val nombre: TextView =findViewById(R.id.tv_nombre_pelicula)
        //sinopsis
        val sinopsis:TextView=findViewById(R.id.tv_pelicula_desc)
        //seats
        val seats: TextView=findViewById(R.id.seatsLeft)
        //boton
        val buyTickets: Button =findViewById(R.id.buyTickets)

        val bundle = intent.extras
        var seatsLeft=0
        var id=-1
        var title=""

        if (bundle != null) {
            val imagenId = bundle.getInt("header")
            val nombrePelicula = bundle.getString("titulo")
            val sinopsisPelicula = bundle.getString("sinopsis")
            seatsLeft=bundle.getInt("numberSeats")
            title=bundle.getString("titulo")!!

            header.setImageResource(imagenId)
            nombre.text = nombrePelicula
            sinopsis.text = sinopsisPelicula
            seats.text=("$seatsLeft seats available")
            id=bundle.getInt("pos")
        }
        if (seatsLeft==0){
            buyTickets.isEnabled=false
        }
        else{
            buyTickets.setOnClickListener {
                val intent: Intent =Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }
    }
}