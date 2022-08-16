package com.example.saarccountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CountryProfileActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_profile)

        imageView = findViewById(R.id.imageViewId)
        textView = findViewById(R.id.textViewId)

        val bundle: Bundle? = intent.extras
        if(bundle != null){
            val countryName: String? = bundle.getString("name")
            showDetails(countryName)
        }

    }
    private fun showDetails(countryName: String?) {
        if(countryName.equals("bangladesh")){
            imageView.setImageResource(R.drawable.bangladesh)
            textView.setText(R.string.bdText)
        }
        else if(countryName.equals("india")){
            imageView.setImageResource(R.drawable.india)
            textView.setText(R.string.inText)
        }
        else if(countryName.equals("pakistan")){
            imageView.setImageResource((R.drawable.pakistan))
            textView.setText(R.string.pakText)
        }
    }
}


