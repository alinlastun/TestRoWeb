package com.lam.testroweb.screen.upcomingMovie.utils

import android.annotation.SuppressLint
import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter(value = ["picture_url"], requireAll = false)
fun setOurPictureToImageView(mImageView: ImageView, mUrl: String) {
    if (!mUrl.isEmpty() && mUrl.isNotEmpty()) {
        Glide.with(mImageView.context).load("https://image.tmdb.org/t/p/w780/$mUrl").into(mImageView)
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter(value = ["release_date"], requireAll = false)
fun setReleaseDate(mTextView: TextView, mReleaseDate: String) {


    val parsed: Date?
    val dfInput = SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
    val dfOutput = SimpleDateFormat("MMMM dd, YYYY", java.util.Locale.getDefault())
    try {
        parsed = dfInput.parse(mReleaseDate)
        val outputDate = dfOutput.format(parsed)
        mTextView.text =outputDate
    } catch (e: ParseException) {

    }
}

@BindingAdapter(value = ["vote_progress"], requireAll = false)
fun setVot(mProgresBar: ProgressBar, vote: Double) {
    mProgresBar.progress=vote.toInt()
}

@BindingAdapter(value = ["vote_text"], requireAll = false)
fun setVotText(mTextView: TextView, vote: Double) {
    mTextView.text = vote.toInt().toString()
}


