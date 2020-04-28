package com.example.covid19data.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Process
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.covid19data.R
import com.example.covid19data.fragments.CountriesFragment
import com.example.covid19data.fragments.HomeFragment
import com.example.covid19data.fragments.NewsFragment
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.utils.fragmentAttach
import com.example.covid19data.utils.setFragment
import com.example.covid19data.utils.setToast
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),
    FragmentToActivity {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var alertDialog: LottieAlertDialog
    private var isSecond: Boolean = false

    override fun onAttachFragment(fragment: Fragment) {
        fragmentAttach(fragment, this)
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
        setFragment(supportFragmentManager, HomeFragment(), false, R.id.fmlHomeContainer)

        ngvHome.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    closeDrawer(drlHome)
                    setFragment(
                        supportFragmentManager,
                        HomeFragment(),
                        false,
                        R.id.fmlHomeContainer
                    )
                }
                R.id.nav_countries -> {
                    closeDrawer(drlHome)
                    showProgressLottieDialog(this)
                    setFragment(
                        supportFragmentManager, CountriesFragment(), false,
                        R.id.fmlHomeContainer
                    )

                    GlobalScope.launch {
                        delay(2000L)
                        alertDialog.dismiss()
                    }
                }
                R.id.nav_news -> {
                    showProgressLottieDialog(this)
                    closeDrawer(drlHome)
                    setFragment(
                        supportFragmentManager,
                        NewsFragment(),
                        false,
                        R.id.fmlHomeContainer
                    )
                    GlobalScope.launch {
                        delay(2000L)
                        alertDialog.dismiss()
                    }
                }
            }
            false
        }
    }

    private fun showProgressLottieDialog(context: Context) {
        alertDialog = LottieAlertDialog.Builder(context, DialogTypes.TYPE_LOADING)

            .setTitle("Loading...")
            .setDescription("Please...Wait...")
            .build()
        alertDialog.setCancelable(false)
        alertDialog.show()
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


    override fun onBackPressed() {
        val f: Fragment? =
            supportFragmentManager.findFragmentById(R.id.fmlHomeContainer)
        if (f is HomeFragment) {
            if (drlHome.isDrawerOpen(GravityCompat.START)) {
                drlHome.closeDrawer(GravityCompat.START)
            } else {
                doubleTapToExit()

            }
        } else {
            if (drlHome.isDrawerOpen(GravityCompat.START)) {
                drlHome.closeDrawer(GravityCompat.START)
            } else {
                setFragment(supportFragmentManager, HomeFragment(), false, R.id.fmlHomeContainer)
            }
        }
    }


    private fun doubleTapToExit() {

        setToast(this, "Press Again to Exit !!!", Toast.LENGTH_SHORT)

        if (isSecond) {

            finishAffinity()

            Process.killProcess(Process.myPid())

        }
        isSecond = true

        Handler().postDelayed({ isSecond = false }, 1000)

    }


}

