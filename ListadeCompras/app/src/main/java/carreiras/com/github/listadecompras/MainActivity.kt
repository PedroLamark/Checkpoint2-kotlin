import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

// Classe MainActivity que herda de ComponentActivity.
class MainActivity : ComponentActivity() {
    // Método onCreate chamado na criação da atividade.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da UI com base no arquivo XML.
        setContentView(R.layout.activity_main)

        // Inicializa o RecyclerView e define seu adaptador.
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        // Inicializa o botão e o campo de texto.
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        // Configura a ação do botão ao ser clicado.
        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            // Cria um item com base no texto inserido no EditText.
            val item = ItemModel(
                name = editText.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            // Adiciona o item ao adaptador e limpa o campo de texto.
            itemsAdapter.addItem(item)
            editText.text.clear()
        }
    }
}
