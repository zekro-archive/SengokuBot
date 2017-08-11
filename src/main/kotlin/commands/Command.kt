package commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by zekro on 11.08.2017 / 15:44
 * SengokuBot.commands
 * dev.zekro.de - github.zekro.de
 * © zekro 2017
 */
interface Command {

    fun action(args: Array<String>, event: MessageReceivedEvent)
    fun getHelp(): String
    fun getDescription(): String
    fun getPermission(): Int

}