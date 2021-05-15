package esra.avsar.gamedatabaseapp.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import esra.avsar.gamedatabaseapp.model.Game
import esra.avsar.gamedatabaseapp.network.GameApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {

    private val _gamesLiveData = MutableLiveData<List<Game>?>()

    val gamesLiveData: LiveData<List<Game>?> get() = _gamesLiveData

    fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = GameApi.retrofitService.getGames(GameApi.API_KEY)
                _gamesLiveData.postValue(result?.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
