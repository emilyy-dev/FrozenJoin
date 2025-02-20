package com.github.frcsty.load

import com.github.frcsty.FrozenJoinPlugin
import java.util.logging.Level
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

object Settings {
    private val plugin = JavaPlugin.getPlugin(FrozenJoinPlugin::class.java)
    private val config = plugin.config
    private val server = Bukkit.getServer()

    val LOGGER = plugin.logger
    val DEBUG: Boolean = config.getString("consoleMessages", "ENABLED").equals("ENABLED", ignoreCase = true)
    val METRICS: Boolean = config.getBoolean("stonks", true)
    val PLUGIN_VERSION = plugin.description.version
    val LUCK_PERMS = server.pluginManager.getPlugin("LuckPerms")
    val USE_LUCK_PERMS = config.getBoolean("settings.luckperms-permissions")
}

fun logError(message: String): Unit = Settings.LOGGER.log(Level.WARNING, message)
fun logInfo(message: String): Unit = Settings.LOGGER.log(Level.INFO, message)