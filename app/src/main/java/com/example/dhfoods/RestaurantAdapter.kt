package com.example.dhfoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(private val listRestaurant: ArrayList<Restaurant>, val listener: OnclickRestaurantListener):
RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RestaurantAdapter.RestaurantViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_restaurant, parent, false)
        return RestaurantViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantAdapter.RestaurantViewHolder, position: Int) {
        var restaurant = listRestaurant.get(position)
        holder.ivImgRestaurant.setImageResource(restaurant.img)
        holder.tvNomeRestaurant.text = restaurant.nome
        holder.tvEnderecoRestaurant.text = restaurant.end
        holder.tvHorario.text = restaurant.horario
    }

    override fun getItemCount() = listRestaurant.size

    interface OnclickRestaurantListener{
        fun onClickRestaurant(position: Int)
    }

    inner class RestaurantViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var ivImgRestaurant: ImageView = itemView.findViewById(R.id.ivImgRestaurant)
        var tvNomeRestaurant: TextView = itemView.findViewById(R.id.tvNomeRestaurant)
        var tvEnderecoRestaurant: TextView = itemView.findViewById(R.id.tvEnderecoRestaurant)
        var tvHorario: TextView = itemView.findViewById(R.id.tvHorario)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View){
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onClickRestaurant(position)
        }
    }
}