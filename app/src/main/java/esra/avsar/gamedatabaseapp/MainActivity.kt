package esra.avsar.gamedatabaseapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.gamedatabaseapp.games.GamesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("###", "test 0")

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, GamesFragment())
            .commit()
    }

}
