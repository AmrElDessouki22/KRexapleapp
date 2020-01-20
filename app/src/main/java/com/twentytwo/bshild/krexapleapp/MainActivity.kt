package com.twentytwo.bshild.krexapleapp

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.twentytwo.bshild.krexapleapp.TabPager.*

var viewpager:ViewPager? = null
var adapter:ViewpagerAdapter? = null
var tabs:TabLayout?=null

class MainActivity : AppCompatActivity(),ContactUs.OnFragmentInteractionListener,Gallary.OnFragmentInteractionListener,Home.OnFragmentInteractionListener,OurProfile.OnFragmentInteractionListener
,PreviousEvents.OnFragmentInteractionListener,Service.OnFragmentInteractionListener,Upcomming.OnFragmentInteractionListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.setTitle("KonozRetaj")
        tabs = findViewById(R.id.tabs)
        tabs!!.addTab(tabs!!.newTab().setText("Home"))
        tabs!!.addTab(tabs!!.newTab().setText("UpComing Events"))
        tabs!!.addTab(tabs!!.newTab().setText("previous Events"))
        tabs!!.addTab(tabs!!.newTab().setText("Service"))
        tabs!!.addTab(tabs!!.newTab().setText("Gallery"))
        tabs!!.addTab(tabs!!.newTab().setText("Our Profile"))
        tabs!!.addTab(tabs!!.newTab().setText("ContactUs"))
        adapter = ViewpagerAdapter(this.supportFragmentManager)
        viewpager = findViewById(R.id.pager)
        viewpager!!.adapter = adapter
        viewpager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs!!.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener
        {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewpager!!.currentItem = p0!!.position
            }

        })



    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
