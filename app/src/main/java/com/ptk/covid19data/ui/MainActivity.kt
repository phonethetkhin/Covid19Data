package com.ptk.covid19data.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Process
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import com.ptk.covid19data.R
import com.ptk.covid19data.fragments.CountriesFragment
import com.ptk.covid19data.fragments.HomeFragment
import com.ptk.covid19data.fragments.NewsFragment
import com.ptk.covid19data.interfaces.DialogToActivity
import com.ptk.covid19data.interfaces.FragmentToActivity
import com.ptk.covid19data.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),
    FragmentToActivity, DialogToActivity {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var alertDialog: LottieAlertDialog
    lateinit var customDialog: CustomDialogClass


    private var isSecond: Boolean = false


    override fun onAttachFragment(fragment: Fragment) {
        fragmentAttach(fragment, this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setBooleanPref(this, "islocation", "location", false)

        when (getTheme(this)) {

            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_main)
        customDialog = CustomDialogClass(this, this)
        customDialog.setDialogToActivity(this)

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
        setFragment(supportFragmentManager, HomeFragment(this), false, R.id.fmlHomeContainer)

        //default drawer finished here

        ngvHome.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    closeDrawer(drlHome)
                    setFragment(
                        supportFragmentManager,
                        HomeFragment(this),
                        false,
                        R.id.fmlHomeContainer
                    )
                }
                R.id.nav_countries -> {
                    CoroutineScope(Dispatchers.Main).launch {
                        closeDrawer(drlHome)
                        showProgressLottieDialog(this@MainActivity)
                        withContext(Dispatchers.Main) {
                            setFragment(
                                supportFragmentManager, CountriesFragment(), false,
                                R.id.fmlHomeContainer
                            )
                        }
                        delay(1000L)
                        alertDialog.dismiss()
                    }
                }
                R.id.nav_news -> {
                    CoroutineScope(Dispatchers.Main).launch {
                        closeDrawer(drlHome)
                        showProgressLottieDialog(this@MainActivity)
                        withContext(Dispatchers.Main) {
                            setFragment(
                                supportFragmentManager,
                                NewsFragment(this@MainActivity),
                                false,
                                R.id.fmlHomeContainer
                            )
                        }
                        delay(1000L)
                        alertDialog.dismiss()
                    }
                }

                //-------------------other links----------------------

                R.id.nav_Setting -> {
                    startActivity(Intent(this, SettingActivity::class.java))
                }
                R.id.nav_about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
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
        supportActionBar!!.title = Html.fromHtml("<font color='#FFFFFF'>$title </font>")

    }

    override fun setCheckListener(checkId: Int) {
        ngvHome.setCheckedItem(checkId)
    }

    override fun searchViewClickListener(click: Boolean) {
        if (click) {
            if (drlHome.isDrawerOpen(GravityCompat.START)) {
                drlHome.closeDrawer(GravityCompat.START)
            }
        }
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
                setFragment(
                    supportFragmentManager,
                    HomeFragment(this),
                    false,
                    R.id.fmlHomeContainer
                )
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val value = getStringPref(this, "countryname", "countryname", "")

        menuInflater.inflate(R.menu.homemenu, menu)
        val item = menu!!.findItem(R.id.mimCountries)
        item.title = value
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mimCountries -> {
                setCustomSpinnerDialog()
            }

        }

        return super.onOptionsItemSelected(item)
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

    override fun onClick(click: Boolean) {
        if (click) {
            customDialog.dismiss()

        }
    }

    private fun setCustomSpinnerDialog() {

        val window: Window? = customDialog.window
        customDialog.show()
        window!!.setLayout(
            WindowManager.LayoutParams.FILL_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

    }
}

