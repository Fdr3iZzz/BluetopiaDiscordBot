package com.Franz3;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class Nickname {
    public static void buttonMessage(){
        JDA jda = Main.getJDA();
        TextChannel channel = jda.getTextChannelById("1111428693781385288");
        assert channel != null;
        channel.sendMessage("Hey, bitte clicke den button, um Zugriff auf den Server zu erhalten \uD83D\uDE42").addActionRow(
                Button.primary("nick", "Drück mich")
        ).queue();
    }
    public static Modal nickGUI(){
        TextInput subject = TextInput.create("irlName", "Name", TextInputStyle.SHORT)
                .setPlaceholder("Bitte nenne uns deinen echten Namen")
                .setMinLength(2)
                .setMaxLength(28)
                .build();
        return Modal.create("nickname", "Bluetopia.net")
                .addComponents(ActionRow.of(subject))
                .build();
    }
    public static String rename(Member member, String irlName){
        String name = member.getUser().getName();
        if (name.length() + 3 + irlName.length() <= 32){
            member.modifyNickname(name + " | " + irlName).queue();
            return "Dankeschön " + irlName + ", viel Spaß auf unserem Server";
        }else{
            return "Hey, dein Name ist leider zu lang für Discord, bitte kontaktiere einen Moderator oder Admin, dankeschön";
        }

    }
}
