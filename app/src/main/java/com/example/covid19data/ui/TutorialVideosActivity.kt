package com.example.covid19data.ui

import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.covid19data.R
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.android.synthetic.main.activity_tutorial_videos.*

class TutorialVideosActivity : AppCompatActivity() {
    lateinit var url: Uri
    lateinit var alertDialog: LottieAlertDialog
    var mp: MediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_videos)
        val toolbar = include as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Tutorial Videos"
        supportActionBar!!.title = Html.fromHtml("<font color='#FFFFFF'> Tutorial Videos </font>")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon!!.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)


        txtWashHand.setOnClickListener {
            url = Uri.parse("android.resource://" + this.packageName + "/" + R.raw.handwash)
            vdvTutorials.setVideoURI(url)
            val mediacontroller = MediaController(this)

            vdvTutorials.setOnPreparedListener { mp ->
                mp.isLooping = false
                mp.setOnVideoSizeChangedListener { mp, width, height ->
                    mediacontroller.setAnchorView(vdvTutorials)

                    vdvTutorials.setMediaController(mediacontroller)

                }


            }
            vdvTutorials.setOnCompletionListener {
                showFinishedDialog()

            }
            vdvTutorials.start()


        }
        txtClothFaceMask.setOnClickListener {
            url = Uri.parse("android.resource://" + this.packageName + "/" + R.raw.facemask)
            vdvTutorials.setVideoURI(url)

            val mediacontroller = MediaController(this)

            vdvTutorials.setOnPreparedListener { mp ->
                mp.isLooping = false
                mp.setOnVideoSizeChangedListener { mp, width, height ->
                    mediacontroller.setAnchorView(vdvTutorials)

                    vdvTutorials.setMediaController(mediacontroller)

                }


            }
            vdvTutorials.setOnCompletionListener {
                showFinishedDialog()
            }
            vdvTutorials.start()

        }
        txtDoDont.setOnClickListener {
            url = Uri.parse("android.resource://" + this.packageName + "/" + R.raw.dodont)
            vdvTutorials.setVideoURI(url)

            val mediacontroller = MediaController(this)

            vdvTutorials.setOnPreparedListener { mp ->
                mp.isLooping = false
                mp.setOnVideoSizeChangedListener { mp, width, height ->
                    mediacontroller.setAnchorView(vdvTutorials)

                    vdvTutorials.setMediaController(mediacontroller)

                }


            }
            vdvTutorials.setOnCompletionListener {
                showFinishedDialog()
            }
            vdvTutorials.start()

        }


    }




    private fun showFinishedDialog() {
        alertDialog =
            LottieAlertDialog.Builder(this@TutorialVideosActivity, DialogTypes.TYPE_QUESTION)
                .setTitle("The Video is Completed, Do you wanna watch again?")
                .setPositiveText("OK")
                .setPositiveListener(object : ClickListener {
                    override fun onClick(dialog: LottieAlertDialog) {
                        alertDialog.dismiss()
                        vdvTutorials.start()
                    }
                })
                .setNegativeText("No")
                .setNegativeListener(object : ClickListener {
                    override fun onClick(dialog: LottieAlertDialog) {
                        alertDialog.dismiss()
                        vdvTutorials.stopPlayback()
                    }
                })


                .build()
        alertDialog.show()
    }


    override fun onStop() {
        super.onStop()
        mp.release()
    }

}
