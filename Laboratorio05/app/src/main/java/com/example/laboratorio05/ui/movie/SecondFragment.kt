package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.google.android.material.textfield.TextInputEditText


class SecondFragment : Fragment() {

        private lateinit var Name : EditText
    private lateinit var Category: EditText
    private lateinit var Description: EditText
    private lateinit var Qualification: EditText
    private lateinit var Submit: Button

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()
        setOnClick()
    }

    fun bind(){
        Name = view?.findViewById(R.id.movie_name) !!
        Category = view?.findViewById(R.id.movie_category) !!
        Description = view?.findViewById(R.id.movie_description) !!
        Qualification = view?.findViewById(R.id.movie_qualification) !!

        Submit = view?.findViewById(R.id.submit_button) !!
    }

    fun setOnClick(){
        Submit.setOnClickListener{_->
            var name = Name.text.toString()
            var cat = Category.text.toString()
            var desc = Description.text.toString()
            var qual = Qualification.text.toString()
            var newMovie = MovieModel(name, cat, desc, qual)

            movieViewModel.addMovies(newMovie)

            Log.d("movie", movieViewModel.getMovies().toString())
        }
    }

}