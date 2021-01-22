package com.itpn.usofirestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.itpn.usofirestore.modelo.Cliente


class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore
    lateinit var resultado: String
    lateinit var cajaNombre: EditText
    lateinit var cajaAnio: EditText
    lateinit var cajaApellido: EditText
    lateinit var miCliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()
        miCliente = Cliente("", "", 0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.opAgregar -> insertarCliente(miCliente)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun insertarCliente(cliente: Cliente) {
        cajaNombre = findViewById(R.id.etNombre)
        cajaApellido = findViewById(R.id.etApellido)
        cajaAnio = findViewById(R.id.etEdad)

        if (cajaNombre.text.toString().isEmpty() || cajaApellido.text.toString().isEmpty() || cajaAnio.text.toString().isEmpty()){
            mensajeError()
        }else{
            miCliente = Cliente(cajaNombre.text.toString(), cajaApellido.text.toString(), cajaAnio.text.toString().toInt())
            db.collection("clientes")
                    .add(miCliente)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "Cliente insertado", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error $e", Toast.LENGTH_LONG).show()
                    }
        }
    }

    fun insertar(v: View) {
        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["nombre"] = "Miguel"
        user["apellido"] = "Reyes"
        user["nacido"] = 1998

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Registro insertado", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error $e", Toast.LENGTH_LONG).show()
                }
    }

    fun consultar(v: View) {
        db.collection("users")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            Toast.makeText(this, "${document.id} => ${document.data}", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "Error obteniendo documentos", Toast.LENGTH_LONG).show()
                    }
                }
    }

    fun mensajeError(){
        cajaNombre = findViewById(R.id.etNombre)
        cajaApellido = findViewById(R.id.etApellido)
        cajaAnio = findViewById(R.id.etEdad)

        if (cajaNombre.text.toString().isEmpty()){
            cajaNombre.error = "Campo requerido"
        }
        if (cajaApellido.text.toString().isEmpty()){
            cajaApellido.error = "Campo requerido"
        }
        if (cajaAnio.text.toString().isEmpty()){
            cajaAnio.error = "Campo requerido"
        }
    }

    fun limpiarCampos(){
        cajaNombre = findViewById(R.id.etNombre)
        cajaApellido = findViewById(R.id.etApellido)
        cajaAnio = findViewById(R.id.etEdad)

        cajaNombre.setText("")
        cajaApellido.setText("")
        cajaAnio.setText("")
    }
}

