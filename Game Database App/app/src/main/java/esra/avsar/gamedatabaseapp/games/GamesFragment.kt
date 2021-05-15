package esra.avsar.gamedatabaseapp.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import esra.avsar.gamedatabaseapp.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {

    private lateinit var binding: FragmentGamesBinding

    private val viewModel: GamesViewModel by viewModels()

    private val adapter: GamesAdapter by lazy { GamesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameRecycleView.layoutManager = LinearLayoutManager(context)
        binding.gameRecycleView.adapter = adapter

        viewModel.gamesLiveData.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }

        viewModel.getGames()
    }
}
