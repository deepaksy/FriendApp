package com.example.friendapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(savedInstanceState ==  null) {
            val imageButton = findViewById<ImageButton>(R.id.imageButton)
            val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
            val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)

            imageButton.setOnClickListener() {
                val fragment = TestFragment()
                openFragment(fragment,"TestFragment")
            }

            imageButton2.setOnClickListener() {
                val fragment = SecondFragment()
                openFragment(fragment,"SecondFragment")
            }

            imageButton3.setOnClickListener() {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

        }
    }

    private fun openFragment(fragment:Fragment, tag: String) {
        val currentFragment = supportFragmentManager.findFragmentByTag(tag)
        if(currentFragment == null || !currentFragment.isVisible) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out
                )
                .replace(R.id.fragmentView, fragment, tag)
                .commit()
        }
    }
}