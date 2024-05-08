// Importações necessárias para a aplicação Android.
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Classe ItemsAdapter que estende RecyclerView.Adapter<ItemViewHolder>.
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    // Lista mutável para armazenar os itens.
    private val items = mutableListOf<ItemModel>()

    // Método para adicionar um novo item à lista.
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    // Método para remover um item da lista.
    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    // Override do método para criar um novo ItemViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Preenchendo a view com o layout item_layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    // Método para obter a quantidade de itens na lista.
    override fun getItemCount(): Int = items.size

    // Método para associar dados a um ItemViewHolder.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    // Classe interna ItemViewHolder que contém a visualização do item e a lógica para vincular os dados do item.
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        
        // Método para vincular os dados do item à visualização.
        fun bind(item: ItemModel) {
            textView.text = item.name

            // Configura o ouvinte de clique para o botão.
            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}
