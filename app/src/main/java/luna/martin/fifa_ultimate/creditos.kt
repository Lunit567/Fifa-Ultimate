package luna.martin.fifa_ultimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class creditos : AppCompatActivity() {
    lateinit var BtRegresar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pant_creditos)
        BtRegresar = findViewById(R.id.Regresar)
        BtRegresar.setOnClickListener {
            val regre = Intent(this,MainActivity::class.java)
            startActivity(regre)
        }
    }
}