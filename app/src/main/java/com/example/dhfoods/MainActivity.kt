package com.example.dhfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RestaurantAdapter.OnclickRestaurantListener  {
    var listRestaurant = getAllRestaurant()
    var adapter = RestaurantAdapter(listRestaurant, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRestaurant.adapter = adapter
        rvRestaurant.layoutManager = LinearLayoutManager(this)
        rvRestaurant.setHasFixedSize(true)
    }

    fun getAllRestaurant():ArrayList<Restaurant>{
        val restaurant1 = Restaurant(1, R.drawable.image1,"Tony Roma's","Av. Lanvandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00")
        val restaurant2 = Restaurant(2, R.drawable.image4,"Ayoama - Moema","Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00")
        val restaurant3 = Restaurant(3, R.drawable.image5,"Outback Moema","Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00")
        val restaurant4 = Restaurant(4, R.drawable.image3,"Si Señor!","Alameda Jauaperi, 626 - Moema", "Fecha às 01:00")

        return arrayListOf(restaurant1, restaurant2, restaurant3, restaurant4)
    }

    override fun onClickRestaurant(position: Int) {
        var restaurant = listRestaurant.get(position)
        val intent = Intent(this@MainActivity, RestaurantActivity::class.java).putExtra("restaurant", restaurant)
        startActivity(intent)
    }


}