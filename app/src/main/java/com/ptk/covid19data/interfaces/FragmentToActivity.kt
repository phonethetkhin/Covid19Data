package com.ptk.covid19data.interfaces

interface FragmentToActivity {
    fun setTitleListener(title: String)
    fun setCheckListener(checkId: Int)
    fun searchViewClickListener(click: Boolean)

}