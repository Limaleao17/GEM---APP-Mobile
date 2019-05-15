package br.com.example.grupoestudantildemusica.Adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.example.grupoestudantildemusica.Models.Contatos
import br.com.example.grupoestudantildemusica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_contato.view.*
import kotlinx.android.synthetic.main.adapter_contato_professores.view.*
import kotlinx.android.synthetic.main.adapter_contato_professores.view.cardEndereco
import kotlinx.android.synthetic.main.adapter_contato_professores.view.cardNome
import kotlinx.android.synthetic.main.adapter_contato_professores.view.cardMateria as cardMateria1
import kotlinx.android.synthetic.main.adapter_contato_professores.view.card_contato_nome as card_contato_nome1

class ContatoAdapter  (
    val contatos: List<Contatos>,
    val onClick: (Contatos) -> Unit)
    : RecyclerView.Adapter<ContatoAdapter.ContatosViewHolder>() {

    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardNome: TextView
        val cardEndereco: TextView
        val cardMateria: TextView
        val cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardEndereco = view.findViewById<TextView>(R.id.cardEndereco)
            cardMateria = view.findViewById<TextView>(R.id.cardMateria)
            cardView = view.findViewById<CardView>(R.id.card_contato_nome)
        }
    }

    override fun getItemCount() = this.contatos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_contato_professores, parent, false)

        val holder = ContatosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        val contexto = holder.itemView.context
        val contatos = this.contatos[position]

        holder.cardNome.text = contatos.nome
        holder.cardEndereco.text = contatos.endereco
        holder.cardMateria.text = contatos.materia


        holder.itemView.setOnClickListener{onClick(contatos)}
    }
}
