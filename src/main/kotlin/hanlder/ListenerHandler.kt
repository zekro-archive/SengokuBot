package hanlder

import net.dv8tion.jda.core.events.ReadyEvent
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import Statics
import commands.Ping
import net.dv8tion.jda.core.entities.ChannelType

/**
 * Created by zekro on 11.08.2017 / 14:27
 * SengokuBot.hanlder
 * dev.zekro.de - github.zekro.de
 * © zekro 2017
 */

class ListenerHandler : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        println("Logged in...")
    }

    override fun onMessageReceived(event: MessageReceivedEvent?) {
        val message = event!!.message
        val author = message.author
        val guild = message.guild

        if (message.content.startsWith(Statics().PREFIX) && author != event.jda.selfUser && event.channel.type != ChannelType.PRIVATE) {
            MessageHandler.handleCommand(MessageHandler.parse(event))
        }
    }

}