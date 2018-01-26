package co.com.sersoluciones.activityapplication

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import co.com.sersoluciones.activityapplication.fragments.BlankFragment
import co.com.sersoluciones.activityapplication.fragments.MyFragment

import kotlinx.android.synthetic.main.activity_fragamento.*

class FragmentoActivity : AppCompatActivity(), MyFragment.OnMyFragmentListener,
        BlankFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {

    }

    private val TAG = this.javaClass.simpleName

    override fun onResponse(text: String) {
        Log.d(TAG, text)
        replaceFragment(BlankFragment.newInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragamento)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        replaceFragment(MyFragment())
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

}
