package com.github.frcsty.library.actions.player

import com.github.frcsty.library.actions.Action
import com.github.frcsty.util.color
import com.github.frcsty.util.getTranslatedMessage
import org.bukkit.entity.Player

object TitleMessageAction : Action {

    override val id = "TITLEMESSAGE"

    override fun run(player: Player, data: String) {
        val args = data.split(";")

        val (title, subtitle) = args
        val fadeIn = args.getOrNull(3)?.toIntOrNull() ?: DEFAULT_FADE_IN
        val stay = args.getOrNull(4)?.toIntOrNull() ?: DEFAULT_STAY
        val fadeOut = args.getOrNull(5)?.toIntOrNull() ?: DEFAULT_FADE_OUT

        player.sendTitle(title.getTranslatedMessage(player).color(), subtitle.getTranslatedMessage(player).color(), fadeIn, stay, fadeOut)
    }

    private const val DEFAULT_FADE_IN = 5
    private const val DEFAULT_STAY = 10
    private const val DEFAULT_FADE_OUT = 5
}