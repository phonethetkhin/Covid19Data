@file:Suppress("DEPRECATION")

package com.example.covid19data.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import java.text.SimpleDateFormat
import java.util.*


fun setToolbarTitleAndBackArrow(
    context: Context,
    toolbar: Toolbar,
    title: String,
    action: ActionBar
) {
    action.title = Html.fromHtml("<font color='#FFFFFF'>$title </font>")
    action.setDisplayHomeAsUpEnabled(true)
    toolbar.navigationIcon!!.setColorFilter(
        context.resources.getColor(R.color.white),
        PorterDuff.Mode.SRC_ATOP
    )
}

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun getStringExtra(appCompatActivity: AppCompatActivity, key: String): String {
    return appCompatActivity.intent.getStringExtra(key)
}


fun setLayoutManagerRecyclerview(
    context: Context,
    recyclerView: RecyclerView,
    orientation: Int,
    setHasFixedSize: Boolean,
    reverseLayout: Boolean
) {
    recyclerView.layoutManager = LinearLayoutManager(context, orientation, reverseLayout)
    recyclerView.setHasFixedSize(setHasFixedSize)
}


@SuppressLint("SimpleDateFormat")
fun getTimeZone(oldDate: String): String {
    val date = (oldDate)
    val df =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    df.timeZone = TimeZone.getTimeZone("PDT")

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS") val formatted: Date = df.parse(date)
    val print =
        SimpleDateFormat("MMM d, yyyy hh:mm:ss a z")
    print.timeZone = TimeZone.getTimeZone("Asia/Rangoon")

    val formattedDate = print.format(formatted)
    val stringBuilder = StringBuilder(formattedDate)
    val final = stringBuilder.insert(24, "(").insert(35, " ").insert(36, ")")

    return final.toString()
}

fun setToast(context: Context, text: String?, length: Int) {

    Toast.makeText(context, text, length).show()
}


fun getFlags(): List<String> {
    var flagList = arrayListOf<String>()

    flagList.add(
        0,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Afghanistan_Flag.jpg/1200px-Afghanistan_Flag.jpg"
    )
    flagList.add(
        1,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Flag_of_Albania.svg/1200px-Flag_of_Albania.svg.png"
    )
    flagList.add(
        2,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/1200px-Flag_of_Algeria.svg.png"
    )
    flagList.add(
        3,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Flag_of_Andorra_%281939-1949%29.svg/1200px-Flag_of_Andorra_%281939-1949%29.svg.png"
    )
    flagList.add(
        4,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/1200px-Flag_of_Angola.svg.png"
    )

    flagList.add(
        5,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Flag_of_Antigua_and_Barbuda.svg/220px-Flag_of_Antigua_and_Barbuda.svg.png"
    )
    flagList.add(
        6,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Flag_of_Argentina_%281818%29.svg/150px-Flag_of_Argentina_%281818%29.svg.png"
    )
    flagList.add(
        7,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/1280px-Flag_of_Armenia.svg.png"
    )
    flagList.add(
        8,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png"
    )
    flagList.add(
        9,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Flag_of_Austria.svg/1200px-Flag_of_Austria.svg.png"
    )

    flagList.add(
        10,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Flag_of_Azerbaijan_1918.svg/1280px-Flag_of_Azerbaijan_1918.svg.png"
    )
    flagList.add(
        11,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Flag_of_the_Bahamas.svg/1200px-Flag_of_the_Bahamas.svg.png"
    )
    flagList.add(
        12,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Bahrain.svg/1280px-Flag_of_Bahrain.svg.png"
    )
    flagList.add(
        13,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Flag_of_Bangladesh.svg/1200px-Flag_of_Bangladesh.svg.png"
    )
    flagList.add(
        14,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Flag_of_Barbados.svg/1280px-Flag_of_Barbados.svg.png"
    )

    flagList.add(
        15,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Flag_of_Belarus.svg/1280px-Flag_of_Belarus.svg.png"
    )
    flagList.add(
        16,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/692px-Flag_of_Belgium.svg.png"
    )
    flagList.add(
        17,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Flag_of_Belize.svg/1200px-Flag_of_Belize.svg.png"
    )
    flagList.add(
        18,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Flag_of_Benin.svg/800px-Flag_of_Benin.svg.png"
    )
    flagList.add(
        19,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Flag_of_Bhutan.svg/1200px-Flag_of_Bhutan.svg.png"
    )

    flagList.add(
        20,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Flag_of_Bolivia_(state).svg/250px-Flag_of_Bolivia_(state).svg.png"
    )
    flagList.add(
        21,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Flag_of_Bosnia_and_Herzegovina.svg/1920px-Flag_of_Bosnia_and_Herzegovina.svg.png"
    )
    flagList.add(
        22,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_Botswana.svg/1200px-Flag_of_Botswana.svg.png"
    )
    flagList.add(
        23,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Brazil_%281960–1968%29.svg/120px-Flag_of_Brazil_%281960–1968%29.svg.png"
    )
    flagList.add(
        24,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Flag_of_Brunei_1906-1959.svg/200px-Flag_of_Brunei_1906-1959.svg.png"
    )

    flagList.add(
        25,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Bulgaria.svg/1200px-Flag_of_Bulgaria.svg.png"
    )
    flagList.add(
        26,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Flag_of_Burkina_Faso.svg/1200px-Flag_of_Burkina_Faso.svg.png"
    )
    flagList.add(
        27,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Flag_of_Myanmar.svg/1200px-Flag_of_Myanmar.svg.png"
    )
    flagList.add(
        28,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Flag_of_Burundi.svg/1280px-Flag_of_Burundi.svg.png"
    )
    flagList.add(
        29,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Flag_of_Cape_Verde.svg/1200px-Flag_of_Cape_Verde.svg.png"
    )

    flagList.add(
        30,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_Cambodia.svg/255px-Flag_of_Cambodia.svg.png"
    )
    flagList.add(
        31,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Flag_of_Cameroon.svg/1200px-Flag_of_Cameroon.svg.png"
    )
    flagList.add(
        32,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png"
    )
    flagList.add(
        33,
        "https://wonderfulengineering.com/wp-content/uploads/2015/08/Central-African-Republic-Flag-2-610x366.jpg"
    )
    flagList.add(
        34,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Flag_of_Chad.svg/1200px-Flag_of_Chad.svg.png"
    )

    flagList.add(
        35,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Flag_of_Chile.svg/1920px-Flag_of_Chile.svg.png"
    )
    flagList.add(
        36,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1200px-Flag_of_the_People%27s_Republic_of_China.svg.png"
    )
    flagList.add(
        37,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Colombia.svg/1200px-Flag_of_Colombia.svg.png"
    )
    flagList.add(
        38,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Flag_of_the_Republic_of_the_Congo.svg/1200px-Flag_of_the_Republic_of_the_Congo.svg.png"
    )
    flagList.add(
        39,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Flag_of_Congo-Kinshasa_%281966-1971%29.svg/640px-Flag_of_Congo-Kinshasa_%281966-1971%29.svg.png"
    )

    flagList.add(
        40,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Costa_Rica_%28state%29.svg/1280px-Flag_of_Costa_Rica_%28state%29.svg.png"
    )
    flagList.add(
        41,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Côte_d%27Ivoire.svg/1280px-Flag_of_Côte_d%27Ivoire.svg.png"
    )
    flagList.add(
        42,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Flag_of_Banate_of_Croatia_%281939-1941%29.svg/3000px-Flag_of_Banate_of_Croatia_%281939-1941%29.svg.png"
    )
    flagList.add(
        43,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Flag_of_Cuba.svg/1200px-Flag_of_Cuba.svg.png"
    )
    flagList.add(
        44,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Flag_of_Cyprus.svg/255px-Flag_of_Cyprus.svg.png"
    )

    flagList.add(
        45,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_Czech_Republic.svg/255px-Flag_of_the_Czech_Republic.svg.png"
    )
    flagList.add(
        46,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/225px-Flag_of_Denmark.svg.png"
    )
    flagList.add(
        47,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Diamond_Princess_in_Hobart.jpg/1024px-Diamond_Princess_in_Hobart.jpg"
    )
    flagList.add(
        48,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Flag_of_Djibouti.svg/1200px-Flag_of_Djibouti.svg.png"
    )
    flagList.add(
        49,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Flag_of_Dominica_%281988–1990%29.svg/1200px-Flag_of_Dominica_%281988–1990%29.svg.png"
    )

    flagList.add(
        50,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_the_Dominican_Republic.svg/1200px-Flag_of_the_Dominican_Republic.svg.png"
    )
    flagList.add(
        51,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Flag_of_Ecuador_%281830-1845%29.svg/1024px-Flag_of_Ecuador_%281830-1845%29.svg.png"
    )
    flagList.add(
        52,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/1200px-Flag_of_Egypt.svg.png"
    )
    flagList.add(
        53,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_El_Salvador_%281869%29.svg/800px-Flag_of_El_Salvador_%281869%29.svg.png"
    )
    flagList.add(
        54,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Flag_of_Equatorial_Guinea.svg/1200px-Flag_of_Equatorial_Guinea.svg.png"
    )

    flagList.add(
        55,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/The_Official_Eritrean_Flag..jpg/1200px-The_Official_Eritrean_Flag..jpg"
    )
    flagList.add(
        56,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Flag_of_Estonia.svg/1920px-Flag_of_Estonia.svg.png"
    )
    flagList.add(
        57,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/1200px-Flag_of_Eswatini.svg.png"
    )
    flagList.add(
        58,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Flag_of_Ethiopia.svg/120px-Flag_of_Ethiopia.svg.png"
    )
    flagList.add(
        59,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Fiji.svg/1200px-Flag_of_Fiji.svg.png"
    )

    flagList.add(
        60,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Finland.svg/800px-Flag_of_Finland.svg.png"
    )
    flagList.add(
        61,
        "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1200px-Flag_of_France.svg.png"
    )
    flagList.add(
        62,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Flag_of_Gabon.svg/1024px-Flag_of_Gabon.svg.png"
    )
    flagList.add(
        63,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_The_Gambia.svg/1920px-Flag_of_The_Gambia.svg.png"
    )
    flagList.add(
        64,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Flag_of_Georgia.svg/1200px-Flag_of_Georgia.svg.png"
    )

    flagList.add(
        65,
        "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1200px-Flag_of_Germany.svg.png"
    )
    flagList.add(
        66,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Flag_of_Ghana_%281964–1966%29.svg/320px-Flag_of_Ghana_%281964–1966%29.svg.png"
    )
    flagList.add(
        67,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Greece.svg/1200px-Flag_of_Greece.svg.png"
    )
    flagList.add(
        68,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Naval_Ensign_of_Grenada.svg/210px-Naval_Ensign_of_Grenada.svg.png"
    )
    flagList.add(
        69,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Guatemala_%281825-1838%29.svg/320px-Flag_of_Guatemala_%281825-1838%29.svg.png"
    )

    flagList.add(
        70,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Flag_of_Guinea.svg/1200px-Flag_of_Guinea.svg.png"
    )
    flagList.add(
        71,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flag_of_Guinea-Bissau.svg/1280px-Flag_of_Guinea-Bissau.svg.png"
    )
    flagList.add(
        72,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Flag_of_Guyana.svg/1200px-Flag_of_Guyana.svg.png"
    )
    flagList.add(
        73,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Flag_of_Haiti_%28civil%29.svg/200px-Flag_of_Haiti_%28civil%29.svg.png"
    )
    flagList.add(
        74,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Flag_of_the_Holy_See.svg/1280px-Flag_of_the_Holy_See.svg.png"
    )

    flagList.add(
        75,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Flag_of_Honduras.svg/1200px-Flag_of_Honduras.svg.png"
    )
    flagList.add(76, "https://upload.wikimedia.org/wikipedia/commons/0/00/Flag_of_Hungary.png")
    flagList.add(
        77,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Flag_of_Iceland_%281918–1944%29.svg/640px-Flag_of_Iceland_%281918–1944%29.svg.png"
    )
    flagList.add(
        78,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/India-flag-a4.jpg/1024px-India-flag-a4.jpg"
    )
    flagList.add(
        79,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/1200px-Flag_of_Indonesia.svg.png"
    )

    flagList.add(
        80,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/1920px-Flag_of_Iran.svg.png"
    )
    flagList.add(
        81,
        "https://upload.wikimedia.org/wikipedia/commons/8/83/Proposed_flag_of_Iraq_%28first_proposal%2C_2008%29.png"
    )
    flagList.add(
        82,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Flag_of_Ireland_(3-2).svg/1280px-Flag_of_Ireland_(3-2).svg.png"
    )
    flagList.add(
        83,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Flag_of_Israel.svg/1200px-Flag_of_Israel.svg.png"
    )
    flagList.add(
        84,
        "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/1200px-Flag_of_Italy.svg.png"
    )

    flagList.add(
        85,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Flag_of_Jamaica.svg/1280px-Flag_of_Jamaica.svg.png"
    )
    flagList.add(
        86,
        "https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png"
    )
    flagList.add(
        87,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Flag_of_the_Emirate_of_Transjordan.svg/250px-Flag_of_the_Emirate_of_Transjordan.svg.png"
    )
    flagList.add(
        88,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Flag_of_Kazakhstan.svg/1200px-Flag_of_Kazakhstan.svg.png"
    )
    flagList.add(
        89,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Kenya.svg/255px-Flag_of_Kenya.svg.png"
    )

    flagList.add(
        90,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Flag_of_South_Korea.svg/1200px-Flag_of_South_Korea.svg.png"
    )
    flagList.add(
        91,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Kosovo_Proposal_-_Union_Flag.svg/1024px-Kosovo_Proposal_-_Union_Flag.svg.png"
    )
    flagList.add(
        92,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/1200px-Flag_of_Kuwait.svg.png"
    )
    flagList.add(
        93,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Flag_of_Kyrgyzstan.svg/1200px-Flag_of_Kyrgyzstan.svg.png"
    )
    flagList.add(
        94,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Flag_of_Laos.svg/1200px-Flag_of_Laos.svg.png"
    )

    flagList.add(
        95,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Flag_of_Latvia.svg/1200px-Flag_of_Latvia.svg.png"
    )
    flagList.add(
        96,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Flag_of_Lebanon_2019.jpg/1200px-Flag_of_Lebanon_2019.jpg"
    )
    flagList.add(
        97,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Flag_of_Liberia.svg/1200px-Flag_of_Liberia.svg.png"
    )
    flagList.add(
        98,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/1200px-Flag_of_Libya.svg.png"
    )
    flagList.add(
        99,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Flag_of_Liechtenstein_%281852-1921%29.svg/1200px-Flag_of_Liechtenstein_%281852-1921%29.svg.png"
    )

    flagList.add(
        100,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Flag_of_Lithuania.svg/1200px-Flag_of_Lithuania.svg.png"
    )
    flagList.add(
        101,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Flag_of_Luxembourg.svg/1200px-Flag_of_Luxembourg.svg.png"
    )
    flagList.add(
        102,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/MS_Zaandam.JPG/200px-MS_Zaandam.JPG"
    )
    flagList.add(
        103,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Madagascar.svg/1024px-Flag_of_Madagascar.svg.png"
    )
    flagList.add(
        104,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Flag_of_Malawi.svg/1200px-Flag_of_Malawi.svg.png"
    )

    flagList.add(
        105,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Flag_of_Malaysia.svg/1200px-Flag_of_Malaysia.svg.png"
    )
    flagList.add(
        106,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Flag_of_Maldives.svg/800px-Flag_of_Maldives.svg.png"
    )
    flagList.add(
        107,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Flag_of_Mali.svg/1200px-Flag_of_Mali.svg.png"
    )
    flagList.add(
        108,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Malta.svg/255px-Flag_of_Malta.svg.png"
    )
    flagList.add(
        109,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Flag_of_Mauritania.svg/1200px-Flag_of_Mauritania.svg.png"
    )

    flagList.add(
        110,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Mauritius.svg/1200px-Flag_of_Mauritius.svg.png"
    )
    flagList.add(
        111,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Mexico.svg/1280px-Flag_of_Mexico.svg.png"
    )
    flagList.add(
        112,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Flag_of_Moldova.svg/1200px-Flag_of_Moldova.svg.png"
    )
    flagList.add(
        113,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Flag_of_Monaco.svg/1200px-Flag_of_Monaco.svg.png"
    )
    flagList.add(
        114,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Flag_of_Mongolia.svg/1200px-Flag_of_Mongolia.svg.png"
    )

    flagList.add(
        115,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Flag_of_Montenegro.svg/1280px-Flag_of_Montenegro.svg.png"
    )
    flagList.add(
        116,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/1200px-Flag_of_Morocco.svg.png"
    )
    flagList.add(
        117,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Flag_of_Mozambique.svg/1200px-Flag_of_Mozambique.svg.png"
    )
    flagList.add(
        118,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Flag_of_Namibia.svg/1200px-Flag_of_Namibia.svg.png"
    )
    flagList.add(
        119,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Flag_of_Nepal.svg/1200px-Flag_of_Nepal.svg.png"
    )

    flagList.add(
        120,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/1200px-Flag_of_the_Netherlands.svg.png"
    )
    flagList.add(
        121,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/320px-Flag_of_New_Zealand.svg.png"
    )
    flagList.add(
        122,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Flag_of_Nicaragua.svg/255px-Flag_of_Nicaragua.svg.png"
    )
    flagList.add(
        123,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Flag_of_Niger.svg/1200px-Flag_of_Niger.svg.png"
    )
    flagList.add(
        124,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/1200px-Flag_of_Nigeria.svg.png"
    )

    flagList.add(
        125,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_North_Macedonia.svg/1200px-Flag_of_North_Macedonia.svg.png"
    )
    flagList.add(
        126,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Norway.svg/234px-Flag_of_Norway.svg.png"
    )
    flagList.add(
        127,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Oman.svg/1200px-Flag_of_Oman.svg.png"
    )
    flagList.add(
        128,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Flag_of_Pakistan_%28bordered%29.svg/925px-Flag_of_Pakistan_%28bordered%29.svg.png"
    )
    flagList.add(
        129,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Flag_of_Panama.svg/1200px-Flag_of_Panama.svg.png"
    )

    flagList.add(
        130,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Flag_of_Papua_New_Guinea.svg/1200px-Flag_of_Papua_New_Guinea.svg.png"
    )
    flagList.add(
        131,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Flag_of_Paraguay.svg/255px-Flag_of_Paraguay.svg.png"
    )
    flagList.add(
        132,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Flag_of_Peru_%28state%29.svg/1200px-Flag_of_Peru_%28state%29.svg.png"
    )
    flagList.add(
        133,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Philippines_Flag_Original.svg/1024px-Philippines_Flag_Original.svg.png"
    )
    flagList.add(
        134,
        "https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/1200px-Flag_of_Poland.svg.png"
    )

    flagList.add(
        135,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/1200px-Flag_of_Portugal.svg.png"
    )
    flagList.add(
        136,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Qatar.svg/1200px-Flag_of_Qatar.svg.png"
    )
    flagList.add(
        137,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Romania.svg/1200px-Flag_of_Romania.svg.png"
    )
    flagList.add(
        138,
        "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/1200px-Flag_of_Russia.svg.png"
    )
    flagList.add(
        139,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Flag_of_Rwanda.svg/1200px-Flag_of_Rwanda.svg.png"
    )

    flagList.add(
        140,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Saint_Kitts_and_Nevis.svg/1280px-Flag_of_Saint_Kitts_and_Nevis.svg.png"
    )
    flagList.add(
        141,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Saint_Lucia.svg/1200px-Flag_of_Saint_Lucia.svg.png"
    )
    flagList.add(
        142,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Flag_of_Saint_Vincent_and_the_Grenadines.svg/1200px-Flag_of_Saint_Vincent_and_the_Grenadines.svg.png"
    )
    flagList.add(
        143,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Flag_of_San_Marino.svg/227px-Flag_of_San_Marino.svg.png"
    )
    flagList.add(
        144,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Flag_of_Sao_Tome_and_Principe.svg/1200px-Flag_of_Sao_Tome_and_Principe.svg.png"
    )

    flagList.add(
        145,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/255px-Flag_of_Saudi_Arabia.svg.png"
    )
    flagList.add(
        146,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Flag_of_Senegal.svg/1280px-Flag_of_Senegal.svg.png"
    )
    flagList.add(
        147,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/1280px-Flag_of_Serbia.svg.png"
    )
    flagList.add(
        148,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Seychelles.svg/1920px-Flag_of_Seychelles.svg.png"
    )
    flagList.add(
        149,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Flag_of_Sierra_Leone.svg/1200px-Flag_of_Sierra_Leone.svg.png"
    )

    flagList.add(
        150,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Flag_of_Singapore.svg/150px-Flag_of_Singapore.svg.png"
    )
    flagList.add(
        151,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Flag_of_Slovakia_%281939–1945%29.svg/1200px-Flag_of_Slovakia_%281939–1945%29.svg.png"
    )
    flagList.add(
        152,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Flag_of_Slovenia.svg/1200px-Flag_of_Slovenia.svg.png"
    )
    flagList.add(
        153,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Flag_of_Somalia.svg/1200px-Flag_of_Somalia.svg.png"
    )
    flagList.add(
        154,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Flag_of_South_Africa_%28WFB_2004%29.svg/1024px-Flag_of_South_Africa_%28WFB_2004%29.svg.png"
    )

    flagList.add(
        155,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Flag_of_South_Sudan.svg/1920px-Flag_of_South_Sudan.svg.png"
    )
    flagList.add(
        156,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Flag_of_Spain_(Civil).svg/1200px-Flag_of_Spain_(Civil).svg.png"
    )
    flagList.add(
        157,
        "https://upload.wikimedia.org/wikipedia/commons/b/b3/Flag_of_the_Southern_Province_%28Sri_Lanka%29.PNG"
    )
    flagList.add(
        158,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flag_of_Sudan.svg/1200px-Flag_of_Sudan.svg.png"
    )
    flagList.add(
        159,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Flag_of_Suriname_%28proposal_3%29.svg/900px-Flag_of_Suriname_%28proposal_3%29.svg.png"
    )

    flagList.add(
        160,
        "https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Flag_of_Sweden.svg/1200px-Flag_of_Sweden.svg.png"
    )
    flagList.add(
        161,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Switzerland.svg/1200px-Flag_of_Switzerland.svg.png"
    )
    flagList.add(
        162,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Flag_of_Syria_French_mandate.svg/1280px-Flag_of_Syria_French_mandate.svg.png"
    )
    flagList.add(
        163,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Flag_of_the_Republic_of_China.svg/1200px-Flag_of_the_Republic_of_China.svg.png"
    )
    flagList.add(
        164,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Flag_of_Tanzania.svg/1920px-Flag_of_Tanzania.svg.png"
    )

    flagList.add(
        165,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Flag_of_Thailand.svg/1200px-Flag_of_Thailand.svg.png"
    )
    flagList.add(
        166,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Flag_of_East_Timor.svg/1200px-Flag_of_East_Timor.svg.png"
    )
    flagList.add(
        167,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Flag_of_Togo.svg/1200px-Flag_of_Togo.svg.png"
    )
    flagList.add(
        168,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Flag_of_Trinidad_and_Tobago.svg/1280px-Flag_of_Trinidad_and_Tobago.svg.png"
    )
    flagList.add(
        169,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Tunisia.svg/1200px-Flag_of_Tunisia.svg.png"
    )

    flagList.add(
        170,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Flag_of_Turkey.svg/1200px-Flag_of_Turkey.svg.png"
    )
    flagList.add(
        171,
        "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png"
    )
    flagList.add(
        172,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Flag_of_Uganda.svg/255px-Flag_of_Uganda.svg.png"
    )
    flagList.add(
        173,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/1200px-Flag_of_Ukraine.svg.png"
    )
    flagList.add(
        174,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/800px-Flag_of_the_United_Arab_Emirates.svg.png"
    )

    flagList.add(
        175,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_the_United_Kingdom_%282-3%29.svg/800px-Flag_of_the_United_Kingdom_%282-3%29.svg.png"
    )
    flagList.add(
        176,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Flag_of_Uruguay_1828.svg/1280px-Flag_of_Uruguay_1828.svg.png"
    )
    flagList.add(
        177,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Flag_of_Uzbekistan.svg/640px-Flag_of_Uzbekistan.svg.png"
    )
    flagList.add(
        178,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Flag_of_Venezuela_%28state%29.svg/1200px-Flag_of_Venezuela_%28state%29.svg.png"
    )
    flagList.add(
        179,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png"
    )

    flagList.add(
        180,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Flag_of_Palestine.svg/1920px-Flag_of_Palestine.svg.png"
    )
    flagList.add(
        181,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Proposal_for_Flag_of_Western_Sahara.svg/1280px-Proposal_for_Flag_of_Western_Sahara.svg.png"
    )
    flagList.add(
        182,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Flag_of_Yemen.svg/1200px-Flag_of_Yemen.svg.png"
    )
    flagList.add(
        183,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Zambia.svg/1200px-Flag_of_Zambia.svg.png"
    )
    flagList.add(
        184,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Flag_of_Zimbabwe.svg/1920px-Flag_of_Zimbabwe.svg.png"
    )
    return flagList
}



