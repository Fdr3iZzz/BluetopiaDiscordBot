package com.Franz3.listeners;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.Franz3.Nickname.rename;

public class ModelListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        String modal = event.getModalId();
        //nickname
        if(modal.equals("nickname")){
            String irlName = event.getValue("irlName").getAsString();
            event.reply(rename(event.getMember(), irlName)).setEphemeral(true).queue();
        }
    }
}
