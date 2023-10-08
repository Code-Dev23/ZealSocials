package it.codedevv.zealsocials.commands;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.api.CommandManager;
import it.codedevv.zealsocials.managers.SocialManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteSocialCommand extends CommandManager {
    public DeleteSocialCommand() {
        super("deletesocial", "deletesocial", false);
    }
    SocialManager social = Social.getSocialManager();
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(ChatUtils.color("&cUtilizza: /deletesocial <social>"));
            return;
        }
        String name = args[0];
        if(!social.getSocials().contains(name)) {
            player.sendMessage(ChatUtils.color("&cNon è stato trovato nessun social con questo nome."));
            return;
        }
        social.deleteSocial(name);
        player.sendMessage(ChatUtils.color("&aSocial eliminato con successo."));
    }
}
