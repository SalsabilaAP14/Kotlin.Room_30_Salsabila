package com.example.kotlinroom_30_salsabila

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinroom_30_salsabila.room.Movie
import kotlinx.android.synthetic.main.list_movie.view.*

class MovieAdapter(private val movies: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie  = movies[position]
        holder.view.text_title.text = movie.title
        holder.view.text_title.setOnClickListener {
        }
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Movie>){
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(movie : Movie)

    }
}