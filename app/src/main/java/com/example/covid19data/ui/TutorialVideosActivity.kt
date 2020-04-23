package com.example.covid19data.ui

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.covid19data.R
import com.example.covid19data.utils.setToolbarTitleAndBackArrow
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.android.synthetic.main.activity_tutorial_videos.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TutorialVideosActivity : AppCompatActivity() {
    private lateinit var url: Uri
    private lateinit var alertDialog: LottieAlertDialog
    private var mp: MediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_videos)
        val toolbar = include as Toolbar
        setSupportActionBar(toolbar)
        setToolbarTitleAndBackArrow(this, toolbar, "Tutorial Videos", supportActionBar!!)

        alertDialog = LottieAlertDialog.Builder(this, DialogTypes.TYPE_LOADING)
            .setTitle("Loading...")
            .build()
        txtWashHand.setOnClickListener {

            setVideoURL("rtsp://r5---sn-npoeene6.googlevideo.com/Cj0LENy73wIaNAmBmwIFJZX53BMYESARFC3IAqFeMOCoAUIASARg34bds6bH-s9eigELazdPR2JfSVljNWsM/05BFD7C7F1A96B00E171500303C79706C2AB917E.E43B5D885BD6F5AE587AEDC2F20AE03821A9E353/yt8/1/video.3gp")

        }
        txtClothFaceMask.setOnClickListener {

            setVideoURL("rtsp://r2---sn-npoeen7d.googlevideo.com/Cj0LENy73wIaNAn-gcmrynX8tBMYESARFC0GA6FeMOCoAUIASARg34bds6bH-s9eigELazdPR2JfSVljNWsM/9F02AAB62D0BB4F217554E1B93A88CFA2249C584.B3F0904912F4816C4A16BDE92762801D68DCFC53/yt8/1/video.3gp")

        }
        txtDoDont.setOnClickListener {


            setVideoURL("rtsp://r1---sn-npoe7n7s.googlevideo.com/Cj0LENy73wIaNAnxBWHUYtGm4hMYESARFC0uA6FeMOCoAUIASARg34bds6bH-s9eigELazdPR2JfSVljNWsM/55226A898DB7EC5C4FE1B344515869DCADAD7A2E.A1C95F3A8FF90D710456EB6B74A1C0B40CDB7A08/yt8/1/video.3gp")

        }

    }

    private fun setVideoURL(videoURL: String) {
        alertDialog.show()
        GlobalScope.launch {
            delay(2000L)
            alertDialog.dismiss()
        }

        url =
            Uri.parse(videoURL)
        vdvTutorials.setVideoURI(url)

        val mediaController = MediaController(this)

        vdvTutorials.setOnPreparedListener { mp ->
            mp.isLooping = true
            mp.setOnVideoSizeChangedListener { _, _, _ ->
                mediaController.setAnchorView(vdvTutorials)

                vdvTutorials.setMediaController(mediaController)

            }


        }

        vdvTutorials.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onStop() {
        super.onStop()
        mp.release()
    }

}
