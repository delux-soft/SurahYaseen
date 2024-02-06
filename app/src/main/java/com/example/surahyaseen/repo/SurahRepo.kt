package com.example.surahyaseen.repo

import com.example.surahyaseen.activities.raw
import com.example.surahyaseen.model.SurahModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object SurahRepo {

    suspend fun getSurahYaseen(): List<SurahModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/syl.png", raw.syls),
                SurahModel("file:///android_asset/syk.png", raw.syks),
                SurahModel("file:///android_asset/syj.png", raw.syjs),
                SurahModel("file:///android_asset/syi.png", raw.syis),
                SurahModel("file:///android_asset/syh.png", raw.syhs),
                SurahModel("file:///android_asset/syg.png", raw.sygs),
                SurahModel("file:///android_asset/syf.png", raw.syfs),
                SurahModel("file:///android_asset/sye.png", raw.syes),
                SurahModel("file:///android_asset/syd.png", raw.syds),
                SurahModel("file:///android_asset/syc.png", raw.sycs),
                SurahModel("file:///android_asset/syb.png", raw.sybs),
                SurahModel("file:///android_asset/sya.png", raw.syas)
            )
        }
    }


    suspend fun getSurahRehman(): List<SurahModel>  {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/syl.png", raw.syls),
                SurahModel("file:///android_asset/syk.png", raw.syks),
                SurahModel("file:///android_asset/syj.png", raw.syjs),
                SurahModel("file:///android_asset/syi.png", raw.syis),
                SurahModel("file:///android_asset/syh.png", raw.syhs),
                SurahModel("file:///android_asset/syg.png", raw.sygs),
                SurahModel("file:///android_asset/syf.png", raw.syfs),
                SurahModel("file:///android_asset/sye.png", raw.syes),
                SurahModel("file:///android_asset/syd.png", raw.syds),
                SurahModel("file:///android_asset/syc.png", raw.sycs),
                SurahModel("file:///android_asset/syb.png", raw.sybs),
                SurahModel("file:///android_asset/sya.png", raw.syas)
            )
        }
    }
}