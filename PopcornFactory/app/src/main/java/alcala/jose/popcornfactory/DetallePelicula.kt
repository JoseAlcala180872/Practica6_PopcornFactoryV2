package alcala.jose.popcornfactory

import android.os.Bundle
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


        val bundle = intent.extras
        if (bundle != null) {
            val imagenId = bundle.getInt("header")
            val nombrePelicula = bundle.getString("titulo")
            val sinopsisPelicula = bundle.getString("sinopsis")

            header.setImageResource(imagenId)
            nombre.text = nombrePelicula
            sinopsis.text = sinopsisPelicula
        }
    }
}