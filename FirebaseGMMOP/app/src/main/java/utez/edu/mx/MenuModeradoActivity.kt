package utez.edu.mx

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.radiobutton.MaterialRadioButton
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.PopupMenu
import android.content.Intent
import android.view.View

class MenuModeradoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_moderado)


        val icMenuView = findViewById<ImageView>(R.id.icMenuView)
        // Abrir el icono cuando sea tocado
        icMenuView.setOnClickListener {
            showPopupMenu(it)
        }

        val radioButton1 = findViewById<MaterialRadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)

        // Asignamos un OnClickListener a cada RadioButton
        radioButton1.setOnClickListener {
            showToast("Pasea al princeso por 1hr y diviertete con él.")
        }

        radioButton2.setOnClickListener {
            showToast("Disfruta de una calida caminata por el parque por 2hrs.")
        }

        radioButton3.setOnClickListener {
            showToast("Disfruta de un calido paseo por la montaña/cerro por 2:30hrs.")
        }

        radioButton4.setOnClickListener {
            showToast("Busca a las personas que más quieras y pasala increíble")
        }
    }

    // Método para mostrar el menú y te mande a otras vistas
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_popup, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.opcion1 -> {
                    val intent = Intent(this, MenuModeradoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.opcion2 -> {
                    val intent = Intent(this, MenuLluviosoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.opcion3 -> {
                    val intent = Intent(this, MenuSoleadoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.opcion4 -> {
                    Toast.makeText(this, "Cerrando Sesión...", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}