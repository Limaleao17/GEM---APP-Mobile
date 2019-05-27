package br.com.example.grupoestudantildemusica.Adapter

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import br.com.example.grupoestudantildemusica.Controladores.Customlayout
import br.com.example.grupoestudantildemusica.R
import com.google.gson.internal.bind.ArrayTypeAdapter
import kotlinx.android.synthetic.main.customlayout.view.*
import org.w3c.dom.Text

class Custom_Adapter (private val getContext: Context, private val CustomlayoutId : Int, private val custom_item: ArrayList<Customlayout>)
    : ArrayAdapter<Customlayout>(getContext, CustomlayoutId, custom_item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var row = convertView

        val Holder: ViewHolder

        if (row == null) {

            val inflater = (getContext as Activity).layoutInflater

            row = inflater!!.inflate(CustomlayoutId, parent, false)

            Holder = ViewHolder()

            Holder.img = row!!.findViewById(R.id.img) as ImageView

            Holder.txt = row!!.findViewById(R.id.txt) as TextView

            row.setTag(Holder)

        } else{
            Holder = row.getTag() as ViewHolder
        }

        val item = custom_item[position]

        Holder.img!!.setImageResource(item.image)
        Holder.txt!!.setText(item.text)

        return row

    }

    class ViewHolder {
        internal var img: ImageView? = null
        internal var txt: TextView? = null
    }


}
