package co.com.sersoluciones.activityapplication.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.sersoluciones.activityapplication.R
import kotlinx.android.synthetic.main.my_fragment.view.*

/**
 * Created by Gustavo on 26/01/2018.
 */
class MyFragment : Fragment() {

    private var listener: OnMyFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.my_fragment, container, false)
        view.button.setOnClickListener {
            //Log.d("Fragment", "On click")
            if (listener != null) {
                listener!!.onResponse("On click")
            }
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnMyFragmentListener) {
            listener = context
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnMyFragmentListener {
        fun onResponse(text: String)
    }
}