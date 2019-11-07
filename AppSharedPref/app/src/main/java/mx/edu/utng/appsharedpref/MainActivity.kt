package mx.edu.utng.appsharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val key = "MY_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)

        //Recuperamos preferencia
        btnGet.setOnClickListener {
            val myPref = prefs.getString(key,"No hay un valor para esta clave")
            showAlert(myPref.toString())
        }


        //Guardar predferencia
        btnPut.setOnClickListener {
            val editor = prefs.edit()
            editor.putString(key, "UTNG")
            editor.apply()
            showAlert("Hemos GUARDADO el valor")
        }

        //Borrar las preferencias
        btnDelete.setOnClickListener {
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
            showAlert("Hemos BORRADO el valor")
        }


    }

    private fun showAlert(message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("My preferences")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }


}
