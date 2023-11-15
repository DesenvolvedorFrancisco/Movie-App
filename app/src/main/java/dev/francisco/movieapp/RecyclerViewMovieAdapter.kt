package dev.francisco.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewMovieAdapter constructor(private  val getActivity: MainActivity, private val
movieList: List<Movies>) :
    RecyclerView.Adapter<RecyclerViewMovieAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerViewMovieAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_list_item,
            parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewMovieAdapter.MyViewHolder, position: Int) {
        holder.tvMovieTitle.text = movieList[position].title
        holder.ivMovieImg.setImageResource(movieList[position].image)

        // The action when you click a cardView
        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity, movieList[position].title, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMovieTitle : TextView = itemView.findViewById(R.id.tvMovieTitle)
        val ivMovieImg : ImageView = itemView.findViewById(R.id.ivMovieImg)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }
}