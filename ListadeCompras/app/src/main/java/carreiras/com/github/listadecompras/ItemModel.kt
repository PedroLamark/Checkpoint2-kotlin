package carreiras.com.github.listadecompras

//Definição dos atributos que vão na classe ItemModel: nome
//Definição da função onRemove
data class ItemModel(val name: String, val onRemove: (ItemModel) -> Unit)