package com.example.game_gyroscope.Home

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.game_gyroscope.R
import java.util.*

class HomeFragment : Fragment(R.layout.fragment_home), SensorEventListener {
    private var sensorManager: SensorManager ? = null
    private var sensor: Sensor ? = null
    private var btn: Button ? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_GRAVITY)
        btn = view.findViewById<Button>(R.id.dynamicButton)
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)

    }

    override fun onStop() {
        super.onStop()
        sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        print("Here")
        if(event == null){
            return
        }

        val x = event.values[0]
        val y = event.values[1]

        btn?.translationY = y
        btn?.translationX = x
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}

