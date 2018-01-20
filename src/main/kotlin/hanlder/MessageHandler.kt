package hanlder

import commands.Command
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import Statics

/**
 * Created by zekro on 11.08.2017 / 15:24
 * SengokuBot.hanlder
 * dev.zekro.de - github.zekro.de
 * © zekro 2017
 */

class MessageHandler {

    companion object {
        @JvmStatic
        var commands: MutableMap<String, Command> = mutableMapOf()
        @JvmStatic
        var emptyarray = Array(1, {""})


        class CommandContainer(invoke: String, args: Array<String>, event: MessageReceivedEvent) {
            val invoke = invoke
            val args = args
            val event = event
        }

        @JvmStatic
        fun parse(event: MessageReceivedEvent): CommandContainer {
            val content = event.message.content
            val invoke = content.split(" ")[0].substring(Statics().PREFIX.length).toLowerCase()
            val args = content.split(" ").subList(1, content.split(" ").size).toTypedArray()
            return CommandContainer(invoke, args, event)
        }

        @JvmStatic
        fun handleCommand(cmd: CommandContainer) {
            if (commands.containsKey(cmd.invoke)) {
                commands.get(cmd.invoke)?.action(cmd.args, cmd.event)
            }
        }

        @JvmStatic
        fun register(invoke: String, command: Command, aliases: Array<String> = emptyarray) {
            commands.put(invoke, command)
            aliases.forEach { s -> if (s.isNotEmpty()) { commands.put(s, command) } }
        }
    }


}
