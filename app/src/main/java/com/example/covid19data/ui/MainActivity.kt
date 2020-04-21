package com.example.covid19data.ui

import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.widget.Toast
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
import com.example.covid19data.fragments.NewsFragment
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.utils.fragmentAttach
import com.example.covid19data.utils.setFragment
import com.example.covid19data.utils.setFragmentByBundle
import com.example.covid19data.utils.setToast
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.os.Process
import com.example.covid19data.fragments.FaceMaskFragment

class MainActivity : AppCompatActivity(),
    FragmentToActivity {
    lateinit var toggle: ActionBarDrawerToggle
lateinit var alertDialog : LottieAlertDialog
     var isSecond : Boolean = false

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
                    setFragment(supportFragmentManager,CountriesFragment(),false,
                        R.id.fmlHomeContainer)

                    GlobalScope.launch {


                        delay(2000L)

                        alertDialog.dismiss()


                    }
                }
                R.id.nav_news ->
                {
                    closeDrawer(drlHome)
                    chooserLottieDialog()
                }
                R.id.nav_facemask ->
                {
                    closeDrawer(drlHome)
                    setFragment(supportFragmentManager,FaceMaskFragment(),false,R.id.fmlHomeContainer)
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

    private fun showProgressLottieDialog()
    {

         alertDialog= LottieAlertDialog.Builder(this, DialogTypes.TYPE_LOADING)

            .setTitle("Loading...")
            .setDescription("Please...Wait...")
            .build()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
    private fun chooserLottieDialog()
    {
                alertDialog=LottieAlertDialog.Builder(this@MainActivity,DialogTypes.TYPE_QUESTION)
            .setTitle("Choose Language")
            .setDescription("Would you like to see news in ?")
            .setPositiveText("English")
            .setNegativeText("Myanmar")
            .setPositiveButtonColor(resources.getColor(R.color.blue))
            .setNegativeButtonColor(resources.getColor(R.color.colorPrimary))
            .setPositiveListener(object: ClickListener {
                override fun onClick(dialog: LottieAlertDialog) {
                    // This is the usage same instance of view
                        alertDialog.changeDialog(LottieAlertDialog.Builder(this@MainActivity,DialogTypes.TYPE_LOADING)
                            .setTitle("News in English")
                        )
                        val bundle = Bundle()
                        bundle.putString("url","https://www.mmtimes.com/")
                        setFragmentByBundle(supportFragmentManager,NewsFragment(),false,R.id.fmlHomeContainer,bundle)
                    GlobalScope.launch {
                        delay(2000L)
                        alertDialog.dismiss()
                    }
                    }
            })
            // Warning View
            .setNegativeListener(object : ClickListener
            {
                override fun onClick(dialog: LottieAlertDialog) {
                    // This is the usage same instance of view
                    alertDialog.changeDialog(LottieAlertDialog.Builder(this@MainActivity,DialogTypes.TYPE_LOADING)
                        .setTitle("News in Myanmar")
                    )
                    val bundle = Bundle()
                    bundle.putString("url","https://myanmar.mmtimes.com/")
                    setFragmentByBundle(supportFragmentManager,NewsFragment(),false,R.id.fmlHomeContainer,bundle)
                    GlobalScope.launch {

                        delay(2000L)

                        alertDialog.dismiss()

                    }

                }
            })

        .build()
                   alertDialog.show()



    }

    override fun onBackPressed() {
        val fragment : NewsFragment =
            supportFragmentManager.findFragmentById(R.id.fmlHomeContainer) as NewsFragment
        if (fragment.canGoBack()) {
            fragment.goBack()
        } else {
            doubleTapToExit()
        }
    }


    private fun doubleTapToExit()

    {

        setToast(this,"Press Again to Exit !!!",Toast.LENGTH_SHORT)

        if (isSecond) {

            finishAffinity()

            Process.killProcess(Process.myPid())

        }
        isSecond = true

        Handler().postDelayed({ isSecond = false }, 1000)

    }



}
