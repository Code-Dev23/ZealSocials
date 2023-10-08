package it.codedevv.zealsocials.commands;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.api.CommandManager;
import it.codedevv.zealsocials.managers.SocialManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateSocialCommand extends CommandManager {
    public CreateSocialCommand() {
        super("createsocial", "zealsocials.createsocial", false);
    }
    SocialManager social = Social.getSocialManager();
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(ChatUtils.color("&cUtilizza: /createsocial <name> (Ricordati di guardare il blocco che dovrà essere cliccato)"));
            return;
        }
        String name = args[0];
        if(social.getSocials().contains(name)) {
            player.sendMessage(ChatUtils.color("&cEsiste già un social con questo nome."));
            return;
        }
        social.createSocial(name, social.getTargetBlock(player).getLocation());
        player.sendMessage(ChatUtils.color("&aSocial creato con successo."));
    }
}