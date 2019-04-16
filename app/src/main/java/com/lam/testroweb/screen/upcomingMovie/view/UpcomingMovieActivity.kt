package com.lam.testroweb.screen.upcomingMovie.view

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import com.lam.testroweb.database.model.MovieDB
import com.lam.testroweb.databinding.ActivityMainBinding
import com.lam.testroweb.mMovieId
import com.lam.testroweb.model.UpcomingModel
import com.lam.testroweb.repositorys.RepositoryMovieDB
import com.lam.testroweb.screen.addMovie.AddMovieActivity
import com.lam.testroweb.screen.detailsMovie.view.DetailsActivity
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingInteractor
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingPresenter
import com.lam.testroweb.screen.upcomingMovie.utils.setUpcomingInfoAdapter
import kotlinx.android.synthetic.main.activity_main.*


class UpcomingMovieActivity : AppCompatActivity(),UpcomingView {


    private lateinit var mBinding: ActivityMainBinding
    private lateinit var upcomingPresenter: UpcomingPresenter
    private lateinit var repositoryDB: RepositoryMovieDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, com.lam.testroweb.R.layout.activity_main)
        repositoryDB = RepositoryMovieDB(this)
        nRecylerViewUpComing.setUpcomingInfoAdapter(this)
        upcomingPresenter = UpcomingPresenter(this, UpcomingInteractor())
        nAddMovie.setOnClickListener {
            startActivity(Intent(this, AddMovieActivity::class.java))
        }
        nArrowLeft.setOnClickListener {onBackPressed()}

        repositoryDB.getMovieFromDB().observe(this, Observer {
            if(it!=null){
                Log.d("eeasdfasd","size: ${it.size}")
                for (movie in it){
                    (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).addUpcomingMovieInfo(movie.upcoming.results)
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        upcomingPresenter.getNewsData()

    }

    override fun getSuccessData(upcomingModel: UpcomingModel) {
        Log.d("eeasdfasd","getSuccessData")
        repositoryDB.deteleMovie()
        val movieDB = MovieDB(upcoming = UpcomingModel())
        movieDB.upcoming =upcomingModel
        repositoryDB.insertMovieToDB(movieDB)
        //(nRecylerViewUpComing.adapter as UpcomingMovieAdapter).addUpcomingMovieInfo(upcomingModel.results)
    }


    override fun getErrorData(strError: String) {
        Log.d("eeasdfasd","getErrorData: $strError")
    }

    fun onClickItemUpcomingMovie(idMovie: Int){
        mMovieId= idMovie
        startActivity(Intent(this,DetailsActivity::class.java))
    }




}
