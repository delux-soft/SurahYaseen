package com.example.surahyaseen.repo

import com.example.surahyaseen.activities.raw
import com.example.surahyaseen.model.SurahModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SurahRepo {


    suspend fun getSurahYaseen(): List<SurahModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/yaseen/syl.png", raw.syls),
                SurahModel("file:///android_asset/yaseen/syk.png", raw.syks),
                SurahModel("file:///android_asset/yaseen/syj.png", raw.syjs),
                SurahModel("file:///android_asset/yaseen/syi.png", raw.syis),
                SurahModel("file:///android_asset/yaseen/syh.png", raw.syhs),
                SurahModel("file:///android_asset/yaseen/syg.png", raw.sygs),
                SurahModel("file:///android_asset/yaseen/syf.png", raw.syfs),
                SurahModel("file:///android_asset/yaseen/sye.png", raw.syes),
                SurahModel("file:///android_asset/yaseen/syd.png", raw.syds),
                SurahModel("file:///android_asset/yaseen/syc.png", raw.sycs),
                SurahModel("file:///android_asset/yaseen/syb.png", raw.sybs),
                SurahModel("file:///android_asset/yaseen/sya.png", raw.syas)
            )
        }
    }


    suspend fun getSurahRehman(): List<SurahModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/rehman/srk.png", raw.syks),
                SurahModel("file:///android_asset/rehman/srj.png", raw.syjs),
                SurahModel("file:///android_asset/rehman/sri.png", raw.syis),
                SurahModel("file:///android_asset/rehman/srh.png", raw.syhs),
                SurahModel("file:///android_asset/rehman/srg.png", raw.sygs),
                SurahModel("file:///android_asset/rehman/srf.png", raw.syfs),
                SurahModel("file:///android_asset/rehman/sre.png", raw.syes),
                SurahModel("file:///android_asset/rehman/srd.png", raw.syds),
                SurahModel("file:///android_asset/rehman/src.png", raw.sycs),
                SurahModel("file:///android_asset/rehman/srb.png", raw.sybs),
                SurahModel("file:///android_asset/rehman/sra.png", raw.syas)
            )
        }
    }
}