package commands

import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.awt.Color

/**
 * Created by zekro on 11.08.2017 / 16:18
 * SengokuBot.commands
 * dev.zekro.de - github.zekro.de
 * © zekro 2017
 */

class Ping : Command {

    override fun action(args: Array<String>, event: MessageReceivedEvent) {
        event.channel.sendMessage(EmbedBuilder().setColor(Color.ORANGE).setDescription("Pong!").build()).queue()
    }

    override fun getHelp(): String {
        return "test lel xD"
    }

    override fun getDescription(): String {
        return ""
    }

    override fun getPermission(): Int {
        return 0
    }

}