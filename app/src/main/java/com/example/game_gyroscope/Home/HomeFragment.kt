package com.example.game_gyroscope.Home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.game_gyroscope.R

class HomeFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.dynamicButton)
        btn.translationX = 100f
        btn.translationY = 100f

    }

}