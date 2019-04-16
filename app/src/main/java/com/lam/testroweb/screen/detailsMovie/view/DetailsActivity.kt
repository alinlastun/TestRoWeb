package com.lam.testroweb.screen.detailsMovie.view

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.lam.testroweb.model.DetailsMovie
import com.lam.testroweb.screen.detailsMovie.presenter.DetailsInteractor
import com.lam.testroweb.screen.detailsMovie.presenter.DetailsPresenter
import com.lam.testroweb.screen.upcomingMovie.presenter.DetailsView
import kotlinx.android.synthetic.main.activity_details.*
import java.text.SimpleDateFormat
import java.util.*
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions



class DetailsActivity : AppCompatActivity(),DetailsView {


    private lateinit var mBinding: com.lam.testroweb.databinding.ActivityDetailsBinding
    private lateinit var detailsPresenter: DetailsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mBinding = DataBindingUtil.setContentView(this, com.lam.testroweb.R.layout.activity_details)

        detailsPresenter = DetailsPresenter(this, DetailsInteractor())
        nArrowLeft.setOnClickListener { onBackPressed() }

    }


    override fun onResume() {
        super.onResume()
       // detailsPresenter.getNewsData()
    }

    override fun getSuccessData(detailsModel: DetailsMovie) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))
        nMovieText.text = detailsModel.mOverviewMovie.original_title
        Glide.with(this).load("https://image.tmdb.org/t/p/w780/${detailsModel.mOverviewMovie.poster_path}").apply(requestOptions).into(nImage)
        nSubtitle.text = transformeDate(detailsModel.mOverviewMovie.release_date)
        progressBar.progress=detailsModel.mOverviewMovie.vote_average.toInt()
        txtProgress.text=detailsModel.mOverviewMovie.vote_average.toInt().toString()
        nSubtitleOverview.text = detailsModel.mOverviewMovie.overview

        nTitleCharacters1.text =  detailsModel.mCreditMovie.crew[0].name
        nTitleCharacters2.text =  detailsModel.mCreditMovie.crew[1].name
        nTitleCharacters3.text =  detailsModel.mCreditMovie.crew[2].name
        nTitleCharacters4.text =  detailsModel.mCreditMovie.crew[3].name
        nTitleCharacters5.text =  detailsModel.mCreditMovie.crew[4].name
        nTitleCharacters6.text =  detailsModel.mCreditMovie.crew[5].name

        nSubtitleCharacters1.text =  detailsModel.mCreditMovie.crew[0].job
        nSubtitleCharacters2.text =  detailsModel.mCreditMovie.crew[1].job
        nSubtitleCharacters3.text =  detailsModel.mCreditMovie.crew[2].job
        nSubtitleCharacters4.text =  detailsModel.mCreditMovie.crew[3].job
        nSubtitleCharacters5.text =  detailsModel.mCreditMovie.crew[4].job
        nSubtitleCharacters6.text =  detailsModel.mCreditMovie.crew[5].job


        Glide.with(this).load("https://image.tmdb.org/t/p/w780/${detailsModel.mCreditMovie.cast[0].profile_path}").apply(requestOptions).into(nImageCast1)
        Glide.with(this).load("https://image.tmdb.org/t/p/w780/${detailsModel.mCreditMovie.cast[1].profile_path}").apply(requestOptions).into(nImageCast2)
        Glide.with(this).load("https://image.tmdb.org/t/p/w780/${detailsModel.mCreditMovie.cast[2].profile_path}").apply(requestOptions).into(nImageCast3)
        Glide.with(this).load("https://image.tmdb.org/t/p/w780/${detailsModel.mCreditMovie.cast[3].profile_path}").apply(requestOptions).into(nImageCast4)


    }

    override fun getErrorData(strError: String) {
        Log.d("qasdfasd","getErrorData: $strError")

    }

    @SuppressLint("SimpleDateFormat")
    private fun transformeDate(mReleaseDate:String):String{
        val nCalendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        val d1: Date?
        try {
            d1 = sdf.parse(mReleaseDate)
            nCalendar.time =d1
        } catch (e: Exception) {
            e.printStackTrace()
        }

        nCalendar.add(Calendar.DATE, 1)
        val format = SimpleDateFormat("MMMM dd, YYYY")
        return format.format(nCalendar.time)
    }
}
