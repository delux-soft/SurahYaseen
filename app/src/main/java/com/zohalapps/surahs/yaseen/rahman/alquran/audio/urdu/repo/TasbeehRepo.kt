package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo

import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.TasbeehModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object TasbeehRepo {

    suspend fun getTasbeeh(): List<TasbeehModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                TasbeehModel("ٱللَّٰهُ أَكْبَرُ"),
                TasbeehModel("ٱلْحَمْدُ لِلَّٰهُِ"),
                TasbeehModel("سُبْحَانَ ٱللَّٰهُِ"),
                TasbeehModel("لاَ إِلٰهَ إِلاَّ ٱللَّهُُ"),
                TasbeehModel("أسْتَغْفِرُ اللهَُ"),
                TasbeehModel("سُبْحَانَ اللَّهِ الْحَمْدُ لِلَّهِ اللَّهُ أَكْبَرُُ"),
                TasbeehModel("لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهُِ"),
                TasbeehModel("لا إله إلا الله محمد رسول اللهُ"),
                TasbeehModel("سُبْحَانَ اللَّهِ وَبِحَمْدِهُِ"),
                TasbeehModel("سُبْحَانَ اللَّهِ الْعَظِيمُِ"),
            )
        }
    }
}