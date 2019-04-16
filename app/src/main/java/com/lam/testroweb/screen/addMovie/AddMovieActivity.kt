package com.lam.testroweb.screen.addMovie

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.lam.testroweb.R
import com.lam.testroweb.model.UpcomingInfo
import com.lam.testroweb.repositorys.RepositoryMovieDB
import kotlinx.android.synthetic.main.add_movie.*


class AddMovieActivity : AppCompatActivity() {

    private lateinit var mBinding: com.lam.testroweb.databinding.AddMovieBinding
    private lateinit var repositoryDB: RepositoryMovieDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, R.layout.add_movie)
        repositoryDB = RepositoryMovieDB(this)

        nArrowLeft.setOnClickListener { onBackPressed() }
        nContainerAddMovie.setOnClickListener { selectFile() }
        nAddMovie.setOnClickListener {
            if (isFieldsValidated()) {
                val movieDB = repositoryDB.getMovieFromDBList()[0]
                movieDB.results.add(0, getInfoMovie())
                repositoryDB.deleteMovie()
                repositoryDB.insertMovieToDB(movieDB)
                finish()
            } else {
                Toast.makeText(this, "You have empty fields", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun getInfoMovie(): UpcomingInfo {
        val upcomingInfo = UpcomingInfo()

        if (nETOriginal.text.isNotEmpty()) {
            upcomingInfo.title = nETOriginal.text.toString()
        }

        if (nETOverview.text.isNotEmpty()) {
            upcomingInfo.overview = nETOverview.text.toString()
        }
        upcomingInfo.poster_path=""
        upcomingInfo.backdrop_path=""

        return upcomingInfo
    }


    private fun isFieldsValidated(): Boolean {
        var allFieldsValidate = true

        if (nETOriginal.text.isEmpty()) {
            allFieldsValidate = false
        }

        return allFieldsValidate
    }

    private fun selectFile() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {

            1 ->
                if (resultCode == Activity.RESULT_OK) {
                    val fileSelected = data?.data?.path
                    Toast.makeText(this, fileSelected, Toast.LENGTH_LONG).show()
                }
        }
    }
}