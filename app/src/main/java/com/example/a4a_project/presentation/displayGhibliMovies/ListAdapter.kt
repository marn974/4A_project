package com.example.a4a_project.presentation.displayGhibliMovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.R
import com.example.a4a_project.domain.entity.Ghibli

class ListAdapter(private val list: List<Ghibli>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val directorName: TextView
            val movieTitle: TextView
            val releaseDate: TextView
            val moviePoster : ImageView

            init {
                // Define click listener for the ViewHolder's View.
                directorName = view.findViewById(R.id.movie_director)
                movieTitle = view.findViewById(R.id.movie_title)
                releaseDate = view.findViewById(R.id.release_date)
                moviePoster = view.findViewById(R.id.movie_poster)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the displayGhibliMovies item
            val view = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.recycler_view_details,
                viewGroup,
                false
            )

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that elemente
            val movie : Ghibli = list.get(position)
            viewHolder.directorName.text = movie.director
            viewHolder.movieTitle.text = movie.title
            viewHolder.releaseDate.text = movie.release_date

            viewHolder.moviePoster.setImageResource(getCustomedIdentifier(viewHolder, movie.title!!))

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = list.size

        fun getCustomedIdentifier(viewHolder: ViewHolder, title : String) : Int {

            val context : Context = viewHolder.itemView.context
            val namePoster : String? = "poster_"+title?.toLowerCase()?.replace(" ", "_")?.replace("'", "_")
            return context.resources.getIdentifier("drawable/"+namePoster, null, context.packageName);
        }


}