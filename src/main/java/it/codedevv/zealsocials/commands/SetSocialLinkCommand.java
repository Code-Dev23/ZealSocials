package it.codedevv.zealsocials.commands;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.api.CommandManager;
import it.codedevv.zealsocials.managers.SocialManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSocialLinkCommand extends CommandManager {
    public SetSocialLinkCommand() {
        super("setsociallink", "zealsocials.setsociallink", false);
    }
    SocialManager social = Social.getSocialManager();
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length <= 1) {
            player.sendMessage(ChatUtils.color("&cUtilizza: /setsociallink <name> <link>"));
            return;
        }
        String name = args[0];
        String link = args[1];
        if(!social.getSocials().contains(name)) {
            player.sendMessage(ChatUtils.color("&cNon è stato trovato nessun social con questo nome."));
            return;
        }
        social.setLink(name, link);
        player.sendMessage(ChatUtils.color("&aLink configurato con successo."));
    }
}