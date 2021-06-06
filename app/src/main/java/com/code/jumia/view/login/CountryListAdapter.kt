package com.code.jumia.view.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.code.jumia.R
import com.code.jumia.model.response.login.Country
import kotlinx.android.synthetic.main.item_country.view.*


class CountryListAdapter(private var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.imageView
        private val countryName = view.name
        private val countryCapital = view.capital

        fun bind(country: Country) {
            countryName.text = country.title
            countryCapital.text = country.capital
            val options = RequestOptions()
                .error(R.mipmap.ic_launcher_round)
            Glide.with(imageView.context)
                .setDefaultRequestOptions(options)
                .load(country.flagPNG)
                .into(imageView)
        }
    }
}