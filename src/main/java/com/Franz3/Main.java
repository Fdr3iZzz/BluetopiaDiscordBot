package com.Franz3;

import com.Franz3.listeners.OnReady;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    private static Dotenv config;
    private static JDA jda;
    private static String guildID;

    // getter
    public static Dotenv getConfig(){
        return config;
    }
    public static JDA getJDA(){
        return jda;
    }
    public static String getGuildID(){
        return guildID;
    }
    public static void main(String[] args) {
        config = Dotenv.configure().load();
        String botToken =config.get("BotToken");
        jda = JDABuilder.createDefault(botToken).build();
        jda.getPresence().setActivity(Activity.watching("twitch.tv/bluetopianet"));
        guildID = "589208868786012171";
        jda.addEventListener(new OnReady());
    }
}