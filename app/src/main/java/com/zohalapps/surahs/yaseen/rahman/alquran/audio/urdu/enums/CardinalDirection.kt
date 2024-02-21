package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.enums

import androidx.annotation.StringRes
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string

enum class CardinalDirection(@StringRes val labelResourceId: Int) {
    NORTH(string.cardinal_direction_north),
    NORTHEAST(string.cardinal_direction_northeast),
    EAST(string.cardinal_direction_east),
    SOUTHEAST(string.cardinal_direction_southeast),
    SOUTH(string.cardinal_direction_south),
    SOUTHWEST(string.cardinal_direction_southwest),
    WEST(string.cardinal_direction_west),
    NORTHWEST(string.cardinal_direction_northwest)
}
