package com.putya.simpleweather.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Dp
import com.putya.simpleweather.data.WeatherComposedInfo.IconSize

data class ComposeInfo(
    val sun: IconInfo,
    val cloud: IconInfo,
    val lightCloud: IconInfo,
    val rains: IconInfo,
    val lightRain: IconInfo,
    val snow: IconInfo,
    val thunder: IconInfo

) {
    operator fun times(float: Float): ComposeInfo =
        copy(
            sun = sun * float,
            cloud = cloud * float,
            lightCloud = lightCloud * float,
            rains = rains * float,
            lightRain = lightRain * float,
            snow = snow * float,
            thunder = thunder * float
        )

    operator fun minus(composeInfo: ComposeInfo): ComposeInfo =
        copy(
            sun = sun - composeInfo.sun,
            cloud = cloud - composeInfo.cloud,
            lightCloud = lightCloud - composeInfo.lightCloud,
            rains = rains - composeInfo.rains,
            lightRain = lightRain - composeInfo.lightRain,
            snow = snow - composeInfo.snow,
            thunder = thunder - composeInfo.thunder
        )

    operator fun plus(composeInfo: ComposeInfo): ComposeInfo =
        copy(
            sun = sun + composeInfo.sun,
            cloud = cloud + composeInfo.cloud,
            lightCloud = lightCloud + composeInfo.lightCloud,
            rains = rains + composeInfo.rains,
            lightRain = lightRain + composeInfo.lightRain,
            snow = snow + composeInfo.snow,
            thunder = thunder + composeInfo.thunder
        )
}

/**
 * properties info of each icon
 * @param sizeRatio: ratio of [WeatherComposedInfo.IconSize]
 * @param offset: Offset from the top-left
 */
data class IconInfo(
    val sizeRatio: Float = 1f,
    val offset: Offset = Offset(0f, 0f),
    val alpha: Float = 1f,
) {
    val size: Dp = IconSize // max size

    operator fun times(float: Float): IconInfo =
        copy(
            sizeRatio = sizeRatio * float,
            offset = Offset(
                offset.x * float,
                offset.y * float
            ),
            alpha = alpha * float,
        )

    operator fun minus(iconInfo: IconInfo): IconInfo =
        copy(
            sizeRatio = sizeRatio - iconInfo.sizeRatio,
            offset = Offset(
                offset.x - iconInfo.offset.x,
                offset.y - iconInfo.offset.y
            ),
            alpha = alpha - iconInfo.alpha,
        )

    operator fun plus(iconInfo: IconInfo): IconInfo =
        copy(
            sizeRatio = sizeRatio + iconInfo.sizeRatio,
            offset = Offset(
                offset.x + iconInfo.offset.x,
                offset.y + iconInfo.offset.y
            ),
            alpha = alpha + iconInfo.alpha,
        )
}
