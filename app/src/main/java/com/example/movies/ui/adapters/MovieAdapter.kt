package com.example.movies.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movies.databinding.ItemMovieBinding
import com.example.movies.models.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var list: List<Movie> = ArrayList()

    fun addList(getList: List<Movie>){
        list = getList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(movie: Movie) {
            with(binding) {
                itemTxtName.text = movie.name
                itemImage.load(movie.image.original){
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }
}