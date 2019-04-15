package com.lam.testroweb.screen.addMovie

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.lam.testroweb.R
import com.lam.testroweb.database.model.MovieDB
import com.lam.testroweb.repositorys.RepositoryAddMovieDB
import kotlinx.android.synthetic.main.add_movie.*

class AddMovieActivity : AppCompatActivity() {

    private lateinit var mBinding: com.lam.testroweb.databinding.AddMovieBinding
     private lateinit var repositoryDB :RepositoryAddMovieDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, R.layout.add_movie)
        repositoryDB = RepositoryAddMovieDB(this)
        nArrowLeft.setOnClickListener { onBackPressed() }

        nAddMovie.setOnClickListener {
            if(isFieldsValidated()){
                repositoryDB.addMOvieToDB(getInfoMovie())
                repositoryDB.getMovieFromDB().observe(this, Observer {
                    if(it!=null){
                        for (mMovie in it){
                            Log.d("asdfasdf",mMovie.title)
                            Log.d("asdfasdf",mMovie.overview)
                        }
                    }

                })
                finish()
            }else{
                Toast.makeText(this,"You have empty fields",Toast.LENGTH_LONG).show()
            }

        }


    }

    private fun getInfoMovie(): MovieDB {
        val mMovieDB = MovieDB(title = "",overview = "")

        if(nETOriginal.text.isNotEmpty()){
            mMovieDB.title = nETOriginal.text.toString()
        }

        if(nETOverview.text.isNotEmpty()){
            mMovieDB.overview = nETOverview.text.toString()
        }

        return mMovieDB
    }



    private fun isFieldsValidated():Boolean{
        var allFieldsValidate = true

        if(nETOriginal.text.isEmpty()){
            allFieldsValidate=false
        }

        return allFieldsValidate
    }
}