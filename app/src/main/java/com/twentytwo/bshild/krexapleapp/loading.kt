package com.twentytwo.bshild.krexapleapp

import android.opengl.Visibility
import android.view.View
import com.wang.avi.AVLoadingIndicatorView

class loading(var v:View)
{
    fun loading(load: Boolean)
    {
        var loadingsim = v.findViewById<AVLoadingIndicatorView>(R.id.avi)
        if(load)
        {
            loadingsim.visibility = View.VISIBLE
        }else
        {
            loadingsim.visibility = View.GONE
        }

    }
}