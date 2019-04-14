package com.lam.testroweb.screen.upcomingMovie.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lam.testroweb.BR
import com.lam.testroweb.R
import com.lam.testroweb.model.UpcomingInfo

class UpcomingMovieAdapter(var upcomingActivity:UpcomingMovieActivity): RecyclerView.Adapter<UpcomingMovieAdapter.PaymentMethodHolder>() {

    private var upcomingMoviedInfoList: MutableList<UpcomingInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row_upcoming_movie, parent, false)
        return PaymentMethodHolder(binding,upcomingActivity)
    }


    override fun onBindViewHolder(holder: PaymentMethodHolder, position: Int) {
        holder.bind(upcomingMoviedInfoList[position])
    }


    override fun getItemCount(): Int {
        return upcomingMoviedInfoList.size
    }

    class PaymentMethodHolder(private val binding: ViewDataBinding, var activity:UpcomingMovieActivity) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UpcomingInfo) {
            binding.setVariable(BR.upcomingInfo, data)
            binding.setVariable(BR.upcomingActivity, activity)
            binding.executePendingBindings()
        }

    }


    fun addUpcomingMovieInfo(listPaymentInfo: MutableList<UpcomingInfo>) {
        Log.d("asdfasdfdsf", listPaymentInfo.size.toString())
        upcomingMoviedInfoList = ArrayList()
        upcomingMoviedInfoList.addAll(listPaymentInfo)
        notifyDataSetChanged()
    }

}