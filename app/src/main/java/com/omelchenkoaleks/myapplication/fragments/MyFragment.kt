package com.omelchenkoaleks.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.omelchenkoaleks.myapplication.R
import com.squareup.picasso.Picasso
import java.util.*

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        val imageView: ImageView = view.findViewById(R.id.image_view)
        Picasso.get()
            .load(
                StringBuilder("https://picsum.photos/1080/1920?random=")
                    .append(Random().nextInt())
                    .toString()
            ).into(imageView)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFragment()
    }
}