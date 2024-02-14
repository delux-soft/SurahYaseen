package com.example.surahyaseen.enums

import androidx.annotation.StringRes
import com.example.surahyaseen.R

enum class CardinalDirection(@StringRes val labelResourceId: Int) {
    NORTH(R.string.cardinal_direction_north),
    NORTHEAST(R.string.cardinal_direction_northeast),
    EAST(R.string.cardinal_direction_east),
    SOUTHEAST(R.string.cardinal_direction_southeast),
    SOUTH(R.string.cardinal_direction_south),
    SOUTHWEST(R.string.cardinal_direction_southwest),
    WEST(R.string.cardinal_direction_west),
    NORTHWEST(R.string.cardinal_direction_northwest)
}
