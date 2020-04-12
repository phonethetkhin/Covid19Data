package com.example.covid19data.utils

import android.content.Context
import android.graphics.drawable.Drawable
import com.example.covid19data.R

@Suppress("DEPRECATION")
 fun getFlags(context: Context): List<Drawable> {
    var flaglist: MutableList<Drawable> = mutableListOf()

    flaglist.add(0, context.resources.getDrawable(R.drawable.afghanistan))
    flaglist.add(1, context.resources.getDrawable(R.drawable.albania))
    flaglist.add(2, context.resources.getDrawable(R.drawable.algeria))          ///////////////////////////////////////////////////////////   1
    flaglist.add(3, context.resources.getDrawable(R.drawable.andorra))
    flaglist.add(4, context.resources.getDrawable(R.drawable.angola))

    flaglist.add(5,context.resources.getDrawable( R.drawable.antiguaandbarbuda))
    flaglist.add(6, context.resources.getDrawable(R.drawable.argentina))
    flaglist.add(7, context.resources.getDrawable(R.drawable.armenia))           ///////////////////////////////////////////////////////////   2
    flaglist.add(8, context.resources.getDrawable(R.drawable.australia))
    flaglist.add(9, context.resources.getDrawable(R.drawable.austria))

    flaglist.add(10,context.resources.getDrawable(R.drawable.azerbaijan))
    flaglist.add(11,context.resources.getDrawable(R.drawable.bahamas))
    flaglist.add(12,context.resources.getDrawable(R.drawable.bahrain))          ///////////////////////////////////////////////////////////   3
    flaglist.add(13,context.resources.getDrawable(R.drawable.bangladesh))
    flaglist.add(14,context.resources.getDrawable(R.drawable.barbados))

    flaglist.add(15,context.resources.getDrawable(R.drawable.belarus))
    flaglist.add(16,context.resources.getDrawable(R.drawable.belgium))
    flaglist.add(17,context.resources.getDrawable(R.drawable.belize))            ///////////////////////////////////////////////////////////   4
    flaglist.add(18,context.resources.getDrawable(R.drawable.benin))
    flaglist.add(19,context.resources.getDrawable(R.drawable.bhutan))

    flaglist.add(20,context.resources.getDrawable(R.drawable.bolivia))
    flaglist.add(21,context.resources.getDrawable(R.drawable.bosniaandherzegovina))
    flaglist.add(22,context.resources.getDrawable(R.drawable.botswana))            ///////////////////////////////////////////////////////////   5
    flaglist.add(23,context.resources.getDrawable(R.drawable.brazil))
    flaglist.add(24,context.resources.getDrawable(R.drawable.brunei))

    flaglist.add(25,context.resources.getDrawable(R.drawable.bulgaria))
    flaglist.add(26,context.resources.getDrawable(R.drawable.burkinafaso))
    flaglist.add(27,context.resources.getDrawable(R.drawable.burma))         ///////////////////////////////////////////////////////////   6
    flaglist.add(28,context.resources.getDrawable(R.drawable.burundi))
    flaglist.add(29,context.resources.getDrawable(R.drawable.caboverde))

    flaglist.add(30,context.resources.getDrawable(R.drawable.cambodia))
    flaglist.add(31,context.resources.getDrawable(R.drawable.cameroon))
    flaglist.add(32,context.resources.getDrawable(R.drawable.canada))            ///////////////////////////////////////////////////////////   7
    flaglist.add(33,context.resources.getDrawable(R.drawable.centralafricanrepublic))
    flaglist.add(34,context.resources.getDrawable(R.drawable.chad))

    flaglist.add(35,context.resources.getDrawable(R.drawable.chile))
    flaglist.add(36,context.resources.getDrawable(R.drawable.china))
    flaglist.add(37,context.resources.getDrawable(R.drawable.colombia))           ///////////////////////////////////////////////////////////   8
    flaglist.add(38,context.resources.getDrawable(R.drawable.congobrazzaville))
    flaglist.add(39,context.resources.getDrawable(R.drawable.congokinshasa))

    flaglist.add(40,context.resources.getDrawable(R.drawable.costarica))
    flaglist.add(41,context.resources.getDrawable(R.drawable.cotedivoire))
    flaglist.add(42,context.resources.getDrawable(R.drawable.croatia))            ///////////////////////////////////////////////////////////   9
    flaglist.add(43,context.resources.getDrawable(R.drawable.cuba))
    flaglist.add(44,context.resources.getDrawable(R.drawable.cyprus))

    flaglist.add(45,context.resources.getDrawable(R.drawable.czechia))
    flaglist.add(46,context.resources.getDrawable(R.drawable.denmark))
    flaglist.add(47,context.resources.getDrawable(R.drawable.diamondprincess))            ///////////////////////////////////////////////////////////   10
    flaglist.add(48,context.resources.getDrawable(R.drawable.djibouti))
    flaglist.add(49,context.resources.getDrawable(R.drawable.dominica))


    flaglist.add(50, context.resources.getDrawable(R.drawable.dominicanrepublic))
    flaglist.add(51, context.resources.getDrawable(R.drawable.ecuador))
    flaglist.add(52, context.resources.getDrawable(R.drawable.egypt))          ///////////////////////////////////////////////////////////   11
    flaglist.add(53, context.resources.getDrawable(R.drawable.elsalvador))
    flaglist.add(54, context.resources.getDrawable(R.drawable.equatorialguinea))

    flaglist.add(55, context.resources.getDrawable(R.drawable.eritrea))
    flaglist.add(56, context.resources.getDrawable(R.drawable.estonia))
    flaglist.add(57, context.resources.getDrawable(R.drawable.eswatini))           ///////////////////////////////////////////////////////////   12
    flaglist.add(58, context.resources.getDrawable(R.drawable.ethiopia))
    flaglist.add(59, context.resources.getDrawable(R.drawable.fiji))

    flaglist.add(60,context.resources.getDrawable(R.drawable.finland))
    flaglist.add(61,context.resources.getDrawable(R.drawable.france))
    flaglist.add(62,context.resources.getDrawable(R.drawable.gabon))          ///////////////////////////////////////////////////////////   13
    flaglist.add(63,context.resources.getDrawable(R.drawable.gambia))
    flaglist.add(64,context.resources.getDrawable(R.drawable.georgia))

    flaglist.add(65,context.resources.getDrawable(R.drawable.germany))
    flaglist.add(66,context.resources.getDrawable(R.drawable.ghana))
    flaglist.add(67,context.resources.getDrawable(R.drawable.greece))            ///////////////////////////////////////////////////////////   14
    flaglist.add(68,context.resources.getDrawable(R.drawable.grenada))
    flaglist.add(69,context.resources.getDrawable(R.drawable.guetemala))

    flaglist.add(70,context.resources.getDrawable(R.drawable.guinea))
    flaglist.add(71,context.resources.getDrawable(R.drawable.guineabissau))
    flaglist.add(72,context.resources.getDrawable(R.drawable.guyana))            ///////////////////////////////////////////////////////////   15
    flaglist.add(73,context.resources.getDrawable(R.drawable.haiti))
    flaglist.add(74,context.resources.getDrawable(R.drawable.holysee))

    flaglist.add(75,context.resources.getDrawable(R.drawable.honduras))
    flaglist.add(76,context.resources.getDrawable(R.drawable.hungary))
    flaglist.add(77,context.resources.getDrawable(R.drawable.iceland))            ///////////////////////////////////////////////////////////   16
    flaglist.add(78,context.resources.getDrawable(R.drawable.india))
    flaglist.add(79,context.resources.getDrawable(R.drawable.indonesia))

    flaglist.add(80,context.resources.getDrawable(R.drawable.iran))
    flaglist.add(81,context.resources.getDrawable(R.drawable.iraq))
    flaglist.add(82,context.resources.getDrawable(R.drawable.ireland))            ///////////////////////////////////////////////////////////   17
    flaglist.add(83,context.resources.getDrawable(R.drawable.israel))
    flaglist.add(84,context.resources.getDrawable(R.drawable.italy))

    flaglist.add(85,context.resources.getDrawable(R.drawable.jamaican))
    flaglist.add(86,context.resources.getDrawable(R.drawable.japan))
    flaglist.add(87,context.resources.getDrawable(R.drawable.jordan))            ///////////////////////////////////////////////////////////   18
    flaglist.add(88,context.resources.getDrawable(R.drawable.kazakhstan))
    flaglist.add(89,context.resources.getDrawable(R.drawable.kenya))

    flaglist.add(90,context.resources.getDrawable(R.drawable.koreansouth))
    flaglist.add(91,context.resources.getDrawable(R.drawable.kosovo))
    flaglist.add(92,context.resources.getDrawable(R.drawable.kuwait))            ///////////////////////////////////////////////////////////   19
    flaglist.add(93,context.resources.getDrawable(R.drawable.kyrgyzstan))
    flaglist.add(94,context.resources.getDrawable(R.drawable.laos))

    flaglist.add(95,context.resources.getDrawable(R.drawable.latvia))
    flaglist.add(96,context.resources.getDrawable(R.drawable.lebanon))
    flaglist.add(97,context.resources.getDrawable(R.drawable.liberia))            ///////////////////////////////////////////////////////////   20
    flaglist.add(98,context.resources.getDrawable(R.drawable.libya))
    flaglist.add(99,context.resources.getDrawable(R.drawable.liechtenstein))

    flaglist.add(100, context.resources.getDrawable(R.drawable.lithuania))
    flaglist.add(101, context.resources.getDrawable(R.drawable.luxembourg))
    flaglist.add(102, context.resources.getDrawable(R.drawable.mszaandam))          ///////////////////////////////////////////////////////////   21
    flaglist.add(103, context.resources.getDrawable(R.drawable.madagascar))
    flaglist.add(104, context.resources.getDrawable(R.drawable.malawi))

    flaglist.add(105, context.resources.getDrawable(R.drawable.malaysia))
    flaglist.add(106, context.resources.getDrawable(R.drawable.maldives))
    flaglist.add(107, context.resources.getDrawable(R.drawable.mali))           ///////////////////////////////////////////////////////////   22
    flaglist.add(108, context.resources.getDrawable(R.drawable.malta))
    flaglist.add(109, context.resources.getDrawable(R.drawable.mauritania))

    flaglist.add(110,context.resources.getDrawable(R.drawable.mauritius))
    flaglist.add(111,context.resources.getDrawable(R.drawable.mexico))
    flaglist.add(112,context.resources.getDrawable(R.drawable.moldova))          ///////////////////////////////////////////////////////////   23
    flaglist.add(113,context.resources.getDrawable(R.drawable.monaco))
    flaglist.add(114,context.resources.getDrawable(R.drawable.mongolia))

    flaglist.add(115,context.resources.getDrawable(R.drawable.montenegro))
    flaglist.add(116,context.resources.getDrawable(R.drawable.morocco))
    flaglist.add(117,context.resources.getDrawable(R.drawable.mozambique))            ///////////////////////////////////////////////////////////  24
    flaglist.add(118,context.resources.getDrawable(R.drawable.namibia))
    flaglist.add(119,context.resources.getDrawable(R.drawable.nepals))

    flaglist.add(120,context.resources.getDrawable(R.drawable.netherlands))
    flaglist.add(121,context.resources.getDrawable(R.drawable.newzealand))
    flaglist.add(122,context.resources.getDrawable(R.drawable.nicaragua))            ///////////////////////////////////////////////////////////  25
    flaglist.add(123,context.resources.getDrawable(R.drawable.niger))
    flaglist.add(124,context.resources.getDrawable(R.drawable.nigeria))

    flaglist.add(125,context.resources.getDrawable(R.drawable.northmacedonia))
    flaglist.add(126,context.resources.getDrawable(R.drawable.norway))
    flaglist.add(127,context.resources.getDrawable(R.drawable.oman))            ///////////////////////////////////////////////////////////   26
    flaglist.add(128,context.resources.getDrawable(R.drawable.pakistan))
    flaglist.add(129,context.resources.getDrawable(R.drawable.panama))

    flaglist.add(130,context.resources.getDrawable(R.drawable.papuanewguinea))
    flaglist.add(131,context.resources.getDrawable(R.drawable.paraguay))
    flaglist.add(132,context.resources.getDrawable(R.drawable.peru))            ///////////////////////////////////////////////////////////   27
    flaglist.add(133,context.resources.getDrawable(R.drawable.philippines))
    flaglist.add(134,context.resources.getDrawable(R.drawable.poland))

    flaglist.add(135,context.resources.getDrawable(R.drawable.portugal))
    flaglist.add(136,context.resources.getDrawable(R.drawable.qatar))
    flaglist.add(137,context.resources.getDrawable(R.drawable.romania))            ///////////////////////////////////////////////////////////   28
    flaglist.add(138,context.resources.getDrawable(R.drawable.russia))
    flaglist.add(139,context.resources.getDrawable(R.drawable.rwanda))

    flaglist.add(140,context.resources.getDrawable(R.drawable.saintkittsandnevis))
    flaglist.add(141,context.resources.getDrawable(R.drawable.saintlucia))
    flaglist.add(142,context.resources.getDrawable(R.drawable.saintvincentandthegrenadines))            ///////////////////////////////////////////////////////////   29
    flaglist.add(143,context.resources.getDrawable(R.drawable.sanmarino))
    flaglist.add(144,context.resources.getDrawable(R.drawable.saotomeandprincipe))

    flaglist.add(145,context.resources.getDrawable(R.drawable.saudiarabia))
    flaglist.add(146,context.resources.getDrawable(R.drawable.senegal))
    flaglist.add(147,context.resources.getDrawable(R.drawable.serbia))            ///////////////////////////////////////////////////////////   30
    flaglist.add(148,context.resources.getDrawable(R.drawable.seychelles))
    flaglist.add(149,context.resources.getDrawable(R.drawable.sierraleone))

    flaglist.add(150, context.resources.getDrawable(R.drawable.singapore))
    flaglist.add(151, context.resources.getDrawable(R.drawable.slovakia))
    flaglist.add(152, context.resources.getDrawable(R.drawable.slovenia))          ///////////////////////////////////////////////////////////   31
    flaglist.add(153, context.resources.getDrawable(R.drawable.somalia))
    flaglist.add(154, context.resources.getDrawable(R.drawable.southafrica))

    flaglist.add(155, context.resources.getDrawable(R.drawable.southsudan))
    flaglist.add(156, context.resources.getDrawable(R.drawable.spain))
    flaglist.add(157, context.resources.getDrawable(R.drawable.srilanka))           ///////////////////////////////////////////////////////////   32
    flaglist.add(158, context.resources.getDrawable(R.drawable.sudan))
    flaglist.add(159, context.resources.getDrawable(R.drawable.suriname))

    flaglist.add(160,context.resources.getDrawable(R.drawable.sweden))
    flaglist.add(161,context.resources.getDrawable(R.drawable.switzerland))
    flaglist.add(162,context.resources.getDrawable(R.drawable.syria))          ///////////////////////////////////////////////////////////   33
    flaglist.add(163,context.resources.getDrawable(R.drawable.taiwan))
    flaglist.add(164,context.resources.getDrawable(R.drawable.tanzania))

    flaglist.add(165,context.resources.getDrawable(R.drawable.thailand))
    flaglist.add(166,context.resources.getDrawable(R.drawable.temorleste))
    flaglist.add(167,context.resources.getDrawable(R.drawable.togo))            ///////////////////////////////////////////////////////////   34
    flaglist.add(168,context.resources.getDrawable(R.drawable.trinidadandtobago))
    flaglist.add(169,context.resources.getDrawable(R.drawable.tunisia))

    flaglist.add(170,context.resources.getDrawable(R.drawable.turkey))
    flaglist.add(171,context.resources.getDrawable(R.drawable.ua))
    flaglist.add(172,context.resources.getDrawable(R.drawable.uganda))            ///////////////////////////////////////////////////////////   35
    flaglist.add(173,context.resources.getDrawable(R.drawable.ukraine))
    flaglist.add(174,context.resources.getDrawable(R.drawable.unitedarabemirates))

    flaglist.add(175,context.resources.getDrawable(R.drawable.unitedkingdom))
    flaglist.add(176,context.resources.getDrawable(R.drawable.uruguay))
    flaglist.add(177,context.resources.getDrawable(R.drawable.uzbekistan))            ///////////////////////////////////////////////////////////   36
    flaglist.add(178,context.resources.getDrawable(R.drawable.venezuela))
    flaglist.add(179,context.resources.getDrawable(R.drawable.vietnam))

    flaglist.add(180,context.resources.getDrawable(R.drawable.westbankandgaza))
    flaglist.add(181,context.resources.getDrawable(R.drawable.wsternsahara))
    flaglist.add(182,context.resources.getDrawable(R.drawable.yemen))            ///////////////////////////////////////////////////////////   37
    flaglist.add(183,context.resources.getDrawable(R.drawable.zambia))
    flaglist.add(184,context.resources.getDrawable(R.drawable.zinbabwe))



    return flaglist
}