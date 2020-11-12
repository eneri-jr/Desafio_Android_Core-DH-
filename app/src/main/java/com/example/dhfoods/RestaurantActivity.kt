package com.example.dhfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.menu_toolbar.*

class RestaurantActivity : AppCompatActivity(), MenuAdapter.OnclickMenuListener {
    var listMenu = getAllMenu()
    var adapter = MenuAdapter(listMenu, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

       val opRestaurant = intent.getSerializableExtra("restaurant") as Restaurant

        ivRestaurant.setImageResource(opRestaurant.img)
        tvTitle.text = opRestaurant.nome

        rvMenu.adapter = adapter
        rvMenu.layoutManager = GridLayoutManager(this, 2)
        rvMenu.setHasFixedSize(true)

    }

    fun getAllMenu():ArrayList<Menu>{
        val menu = Menu(1, R.drawable.image4,"Salada com molho","Gengibre")

        val listMenu = arrayListOf<Menu>()

        for (x in 0..9){
            listMenu.add(menu)
        }
        return listMenu
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClickMenu(position: Int) {
        var itemMenu = listMenu.get(position)
        val intent = Intent(this@RestaurantActivity, ItemMenuActivity::class.java).putExtra("itemMenu", itemMenu)
        startActivity(intent)
    }

}