package com.example.dhfoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val listMenu: ArrayList<Menu>, val listener: OnclickMenuListener):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuAdapter.MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        var menu = listMenu.get(position)
        holder.ivImgMenu.setImageResource(menu.img)
        holder.tvNomeMenu.text = menu.nome1
        holder.tvNomeMenu2.text = menu.nome2
    }

    override fun getItemCount() = listMenu.size

    interface OnclickMenuListener{
        fun onClickMenu(position: Int)
    }

    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var ivImgMenu: ImageView = itemView.findViewById(R.id.ivImgMenu)
        var tvNomeMenu: TextView = itemView.findViewById(R.id.tvNomeMenu)
        var tvNomeMenu2: TextView = itemView.findViewById(R.id.tvNomeMenu2)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View){
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onClickMenu(position)
        }
    }
}