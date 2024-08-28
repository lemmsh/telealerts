package com.lemmsh.telealerts

import com.typesafe.config.ConfigFactory
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.api.telegramBot
import dev.inmo.tgbotapi.types.IdChatIdentifier
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.net.InetAddress
import kotlin.math.min

class AlertSender {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val configPath = System.getenv("TELEALERTS_CONF") ?: "/etc/telealerts.conf"
            val config = ConfigFactory.parseFile(java.io.File(configPath))
            val botId = config.getString("bot.id")
            val groupId = config.getLong("bot.group_id")

            val msg: String = when {
                args.isNotEmpty() && args[0] == "-stdin" -> {
                    val buffer = StringBuffer()
                    var s = readLine()
                    while (s != null) {
                        buffer.append(s).append("\n")
                        s = readLine()
                    }
                    buffer.toString()
                }
                args.isNotEmpty() && args[0] != "-stdin" -> {
                    args.joinToString(" ")
                }
                else -> {
                    ""
                }
            }
            val trimmedMsg = msg.substring(0, min(msg.length, 4000))
            val hostname = try {
                InetAddress.getLocalHost().hostName
            } catch (e: Exception) {
                "unknown host (${e.message})"
            }
            val message = "$hostname: $trimmedMsg"

            val bot = telegramBot(botId)
            val chatId = IdChatIdentifier.invoke(groupId)
            runBlocking {
                bot.sendTextMessage(chatId, message)
            }
        }
    }
}