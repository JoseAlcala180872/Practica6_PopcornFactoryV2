package alcala.jose.popcornfactoryrecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val peliculas=listOf(
            Pelicula(R.drawable.bighero6, "Big Hero 6", "When a devastating event \n" +
                    "befalls the city of San Fransisco and catapults Hiro into the midst of danger, he turns to Baymax and his close \n" +
                    "friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred."),
            Pelicula(R.drawable.leapyear, "Leap Year", "British trenches somewhere in France. World war has been going on for the third year,\n" +
                    "heroic illusions have dissipated"),
            Pelicula(R.drawable.mib,"Men in Black","Based off of the comic book. Unbeknownst to other people, there is a private agency code\n" +
                    "named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then,\n" +
                    "one of the agency's finest men only going by the name K&quot; (Tommy Lee Jones) , is\n" +
                    "recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of\n" +
                    "the N.Y.P.D."),
            Pelicula(R.drawable.toystory,"Toy Story","Toy Story is about the 'secrest life of toys' when people arte not around. When Buzz\n" +
                    " Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy. Woody doesn't like the situation and gets into a fight with Buzz."),
            Pelicula(R.drawable.inception,"Inception","Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing\n" +
                    "valuable secrets from deep within the subconscious during the dream state, when the\n" +
                    "mind is at its most vulnerable.")
        )

        val recyclerView: RecyclerView=findViewById(R.id.lista_view)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= AdaptadorPeliculas(peliculas)

    }
}