import commands.Ping
import hanlder.ListenerHandler
import hanlder.MessageHandler
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.entities.Game
import net.dv8tion.jda.core.entities.Message
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Created by zekro on 11.08.2017 / 13:59
 * SengokuBot.
 * dev.zekro.de - github.zekro.de
 * © zekro 2017
 */


fun main(args: Array<String>) {

    MessageHandler.register("ping", Ping())
    connect(getToken())

}


private fun getToken(): String {
    var token = ""
    try {
        val savefile = File("TOKEN.txt")
        if (!savefile.exists()) {
            savefile.createNewFile()
            throw Exception("TOKEN.txt did not exist while starting and got created. Please enter your token in this file!")
        }
        token = BufferedReader(FileReader("TOKEN.txt")).readLine()
        if (token.length < 59)
            throw Exception("Token has invalid length. Please enter a valid token!")
    } catch (e: Exception) {
        e.printStackTrace()
        System.exit(1)
    }
    return token
}


private fun connect(token: String) {

    JDABuilder(AccountType.BOT)
            .setGame(Game.of("SengokuBot | Alpha Kotlin Bot"))
            .setToken(token)
            .addListener(ListenerHandler())
            .buildBlocking()
}