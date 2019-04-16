package com.lam.testroweb.screen.addMovie

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.lam.testroweb.R
import com.lam.testroweb.database.model.AddMovieDB
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
        nContainerAddMovie.setOnClickListener { selectFile() }
        nAddMovie.setOnClickListener {
            if(isFieldsValidated()){
                repositoryDB.addMOvieToDB(getInfoMovie())
                finish()
            }else{
                Toast.makeText(this,"You have empty fields",Toast.LENGTH_LONG).show()
            }

        }




    }

    private fun getInfoMovie(): AddMovieDB {
        val mMovieDB = AddMovieDB(title = "",overview = "")

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

    private fun selectFile(){
        val intent =Intent(Intent.ACTION_GET_CONTENT)
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