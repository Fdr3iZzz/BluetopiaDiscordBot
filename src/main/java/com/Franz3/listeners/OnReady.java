package com.Franz3.listeners;

import com.Franz3.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.Franz3.Nickname.buttonMessage;

public class OnReady extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        JDA jda = Main.getJDA();
        // add listener
        jda.addEventListener(new SlashCommand());
        jda.addEventListener(new ButtonInteraction());
        jda.addEventListener(new ModelListener());
        // register commands
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("help", "get help and learn how to use the bot and what features it has"));

        event.getJDA().updateCommands().addCommands(commandData).queue();
        //buttonMessage();
    }
}
