package luna.martin.fifa_ultimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import luna.martin.fifa_ultimate.adaptador.FutbolistaAdapter
import luna.martin.fifa_ultimate.modelo.Futbolista

class MainActivity : AppCompatActivity() {
    lateinit var BtCreditos:Button
    lateinit var Mrecycler: RecyclerView
    val listaFutbolista = ArrayList<Futbolista>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BtCreditos = findViewById(R.id.Creditos)
        BtCreditos.setOnClickListener{
            val credit = Intent(this,creditos::class.java)
            startActivity(credit)
        }
        Mrecycler = findViewById(R.id.RecyclerFutbolistas)
        Mrecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getFutbolista()
    }

    fun getFutbolista(){
        val queue = Volley.newRequestQueue(this)
        val url="https://www.easports.com/fifa/ultimate-team/api/fut/item"
        val jsonObject = JsonObjectRequest(Request.Method.GET,url,null,
            {respuesta->
                val newjson =respuesta.getJSONArray("items")
                for (i in 0..newjson.length()-1) {
                    val newobj = newjson.getJSONObject(i)
                    val futbolista =Futbolista(newobj.getString("firstName"), newobj.getString("positionFull"),
                        newobj.getString("id"), newobj.getString("rarityId"))
                    listaFutbolista.add(futbolista)
                }
                Mrecycler.adapter = FutbolistaAdapter(listaFutbolista)
            },{ error->
                Log.e("Exam","Error")
            }
        )
        queue.add(jsonObject)
    }
}