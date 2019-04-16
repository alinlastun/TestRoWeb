package com.lam.testroweb.screen.upcomingMovie.view

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowManager
import com.lam.testroweb.database.model.UpcomingModelDB
import com.lam.testroweb.databinding.ActivityMainBinding
import com.lam.testroweb.mMovieId
import com.lam.testroweb.model.UpcomingInfo
import com.lam.testroweb.repositorys.RepositoryMovieDB
import com.lam.testroweb.screen.addMovie.AddMovieActivity
import com.lam.testroweb.screen.detailsMovie.view.DetailsActivity
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingInteractor
import com.lam.testroweb.screen.upcomingMovie.presenter.UpcomingPresenter
import com.lam.testroweb.screen.upcomingMovie.utils.setUpcomingInfoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


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
        upcomingPresenter.getNewsData()
        nAddMovie.setOnClickListener {
            startActivity(Intent(this, AddMovieActivity::class.java))
        }
        nArrowLeft.setOnClickListener {onBackPressed()}

        repositoryDB.getMovieFromDB().observe(this, Observer {
            if(it!=null){
                for (movie in it){
                    (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).addUpcomingMovieInfo(movie.results)
                }
            }
        })

        /**
        When search a movie is showing from DB the item with that name.
        Every time when is typed a character is looked up in DB for a movie with that name and
        adapter is triggered with new list of movie
         */
        nSearchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(nSearchText.text.toString().isNotEmpty()){
                val upcomingInfoList:MutableList<UpcomingInfo> = ArrayList()
                for (upcomingModelDb in repositoryDB.getMovieFromDBList()){
                    for (upcoming in upcomingModelDb.results ){
                        if(upcoming.title.equals(nSearchText.text.toString(),ignoreCase = true)){
                            upcomingInfoList.add(upcoming)
                        }
                    }
                }
                (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).addUpcomingMovieInfo(upcomingInfoList)
                (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).notifyDataSetChanged()
                }else{
                    for (upcomingModelDb in repositoryDB.getMovieFromDBList()){
                        (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).addUpcomingMovieInfo(upcomingModelDb.results)
                        (nRecylerViewUpComing.adapter as UpcomingMovieAdapter).notifyDataSetChanged()
                    }
                }
            }
        })


    }

    override fun onResume() {
        super.onResume()
        if(repositoryDB.getMovieFromDBList().size<0){
            upcomingPresenter.getNewsData()
        }

    }

    override fun getSuccessData(upcomingModelDB: UpcomingModelDB) {
        repositoryDB.insertMovieToDB(upcomingModelDB)
    }


    override fun getErrorData(strError: String) {
        Log.d("eeasdfasd","getErrorData: $strError")
    }

    fun onClickItemUpcomingMovie(idMovie: Int){
        mMovieId= idMovie
        startActivity(Intent(this,DetailsActivity::class.java))
    }


}
