package com.twentytwo.bshild.krexapleapp.TabPager

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

import com.twentytwo.bshild.krexapleapp.R
import com.twentytwo.bshild.krexapleapp.loading
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Home.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v:View = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        lateinit var webview:WebView
        webview = v.findViewById(R.id.webview)
        var loading = loading(v)
        loading.loading(true)
        webview.loadUrl("https://kr.net.sa/v1/")
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true




        webview.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                loading.loading(false)

            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                try {
                    webview.loadUrl("javascript:(window.onload = function() { " +
                            "(elem1 = document.getElementById('main-header')).remove()" +
                            "})()")

                    webview.loadUrl("javascript:(window.onload = function() { " +
                            "(elem1 = document.getElementById('main-footer')).remove()" +
                            "})()")
                    view!!.clearHistory()
                }catch (e: Exception)
                {

                }
            }
        })
        return v
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
