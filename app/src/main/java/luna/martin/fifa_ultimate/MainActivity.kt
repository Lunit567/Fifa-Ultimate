package luna.martin.fifa_ultimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import luna.martin.fifa_ultimate.modelo.Futbolista

class MainActivity : AppCompatActivity() {
    lateinit var Mrecycler: RecyclerView
    val listaFutbolista = ArrayList<Futbolista>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}