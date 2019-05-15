package br.com.example.grupoestudantildemusica

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_contato_professores.view.*
import kotlinx.android.synthetic.main.adapter_contato_professores.view.*
import kotlinx.android.synthetic.main.adapter_contato_professores.view.card_contato_nome as card_contato_nome1

class ContatoAdapter  (
    val contatos: List<Contatos>,
    val onClick: (Contatos) -> Unit)
    : RecyclerView.Adapter<ContatoAdapter.ContatosViewHolder>() {

    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardNome: TextView
        val cardImg: ImageView
        val cardEndereco: TextView
        val cardMateria: TextView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.cardNome
            cardImg = view.cardImg
            cardEndereco = view.cardEndereco
            cardMateria = view.cardMateria
            cardProgress = view.cardProgress
            cardView = view.card_contato_nome1
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
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(contexto).load(contatos.foto).fit()
            .into(holder.cardImg,
                object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        holder.cardProgress.visibility = View.INVISIBLE
                    }

                    override fun onError() {
                        holder.cardProgress.visibility = View.INVISIBLE
                    }
                })

        holder.itemView.setOnClickListener{onClick(contatos)}
    }
}
