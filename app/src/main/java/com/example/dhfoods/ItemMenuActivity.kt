package com.example.dhfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.item_toolbar.*
import kotlinx.android.synthetic.main.menu_toolbar.toolbar
import kotlinx.android.synthetic.main.menu_toolbar.tvTitle

class ItemMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_menu)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val opMenu = intent.getSerializableExtra("itemMenu") as Menu

        ivItemMenu.setImageResource(opMenu.img)
        tvTitle.text = opMenu.nome1
        tvTitle2.text = opMenu.nome2

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}