package ru.practicum.sprint8koh30

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var lastOnStopMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        Log.d("SPRINT_8", "$this onCreate savedInstanceState = $savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SPRINT_8", "$this onStart")
        if ((System.currentTimeMillis() - lastOnStopMillis) > 15_000L) {
            Log.d("SPRINT_8", "$this onStart with PIN code")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("SPRINT_8", "$this onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SPRINT_8", "$this onPause")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("SPRINT_8", "$this onConfigurationChanged $newConfig")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SPRINT_8", "$this onStop")
        lastOnStopMillis = System.currentTimeMillis()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SPRINT_8", "$this onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SPRINT_8", "$this onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("SPRINT_8", "$this onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("SPRINT_8", "$this onRestoreInstanceState")
    }

}