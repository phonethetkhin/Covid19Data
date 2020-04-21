package com.example.covid19data.fragments

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.example.covid19data.R
import kotlinx.android.synthetic.main.fragment_face_mask.view.*


class FaceMaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_face_mask, container, false)
        val url = Uri.parse("android.resource://"+activity!!.packageName+"/" + R.raw.facemask)

       val mediacontroller = MediaController(activity!!)

        v.vdvFaceMask.setVideoURI(url)

        v.vdvFaceMask.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
            mp.setOnVideoSizeChangedListener { mp, width, height ->
                mediacontroller.setAnchorView(v.vdvFaceMask)

                v.vdvFaceMask.setMediaController(mediacontroller)

            }


        })
        v.vdvFaceMask.start()


        return v
    }

}
