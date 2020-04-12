package com.example.covid19data.ui

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.covid19data.R
import com.example.covid19data.fragments.CountriesFragment
import com.example.covid19data.fragments.HomeFragment
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.utils.fragmentAttach
import com.example.covid19data.utils.setFragment
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(),
    FragmentToActivity {
    lateinit var toggle: ActionBarDrawerToggle
lateinit var alertDialog : LottieAlertDialog
    override fun onAttachFragment(fragment: Fragment)
    {
        fragmentAttach(fragment,this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val tlbToolbar = findViewById<Toolbar>(R.id.tlbToolbar)
        setSupportActionBar(tlbToolbar)
        ngvHome.setCheckedItem(R.id.nav_home)

            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            toggle = ActionBarDrawerToggle(
                this, drlHome, tlbToolbar, R.string.open,
                R.string.close
            )
            toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
                drlHome.setDrawerListener(toggle)
                toggle.syncState()
val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(R.id.fmlHomeContainer,fragment).commit()
        ngvHome.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.nav_home ->
                {
                    closeDrawer(drlHome)
                    setFragment(supportFragmentManager,HomeFragment(),false,
                        R.id.fmlHomeContainer
                    )
                }
                R.id.nav_countries ->
                {

                    closeDrawer(drlHome)
                    showProgressLottieDialog()

                    GlobalScope.launch {


                        delay(2000L)
                        alertDialog.dismiss()
                        setFragment(supportFragmentManager,CountriesFragment(),false,
                            R.id.fmlHomeContainer)

                    }





                }

            }
            false
        }




    }
    private fun closeDrawer(drlHome: DrawerLayout) {

        if (drlHome.isDrawerOpen(GravityCompat.START)) {
            drlHome.closeDrawer(GravityCompat.START)

        }

    }

    override fun setTitleListener(title: String) {
        supportActionBar!!.title = Html.fromHtml("<font color='#FFFFFF'>$title </font>");

    }

    override fun setCheckListener(checkId: Int) {
        ngvHome.setCheckedItem(checkId)
    }

    fun showProgressLottieDialog()
    {

         alertDialog= LottieAlertDialog.Builder(this, DialogTypes.TYPE_LOADING)

            .setTitle("Loading...")
            .setDescription("Please...Wait...")
            .build()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

 
}
