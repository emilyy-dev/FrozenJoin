package com.github.frcsty.library.actions.player

import com.github.frcsty.library.actions.Action
import com.github.frcsty.util.color
import com.github.frcsty.util.getTranslatedMessage
import org.bukkit.entity.Player

object ActionbarMessageAction : Action {
    override val id = "ACTIONBARMESSAGE"

    override fun run(player: Player, data: String) {
        player.sendActionBar(data.getTranslatedMessage(player).color())
    }
}