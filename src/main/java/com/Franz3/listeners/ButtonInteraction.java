package com.Franz3.listeners;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.Franz3.Nickname.nickGUI;

public class ButtonInteraction extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String button = event.getComponentId();
        // nick
        if(button.equals("nick")){
            event.replyModal(nickGUI()).queue();
        }

    }
}
