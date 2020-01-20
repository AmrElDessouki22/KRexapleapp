package com.twentytwo.bshild.krexapleapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.twentytwo.bshild.krexapleapp.TabPager.*

class ViewpagerAdapter(manger:FragmentManager): FragmentPagerAdapter(manger,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment
    {
        if(position == 0)
        {
            return Home()
        }else if(position == 1)
        {
            return Upcomming()
        }else if (position == 2)
        {
            return PreviousEvents()
        }else if(position == 3)
        {
            return Service()
        }else if(position == 4)
        {
            return Gallary()
        }else if(position == 5)
        {
            return OurProfile()
        }else
        {
            return ContactUs()
        }

    }

    override fun getCount(): Int {
        return 7
    }
}