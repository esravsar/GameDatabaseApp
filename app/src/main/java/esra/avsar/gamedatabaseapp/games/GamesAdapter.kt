package esra.avsar.gamedatabaseapp.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import esra.avsar.gamedatabaseapp.databinding.ItemGameBinding
import esra.avsar.gamedatabaseapp.ext.parseDate
import esra.avsar.gamedatabaseapp.model.Game

class GamesAdapter : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {

    private val games = mutableListOf<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun updateItems(games: List<Game>?) {
        this.games.clear()
        games?.let {
            this.games.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size

    inner class GameViewHolder(
        private val binding: ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.textViewName.text = game.name
            binding.textViewExtra.text = StringBuilder()
                .append(game.rating)
                .append(" - ")
                .append(game.released?.parseDate())
                .toString()

            Glide.with(itemView.context)
                .load(game.backgroundImage)
                .centerCrop()
                .into(binding.imageViewGame);
        }
    }
}
