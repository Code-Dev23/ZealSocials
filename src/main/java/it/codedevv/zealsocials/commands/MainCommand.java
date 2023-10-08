package it.codedevv.zealsocials.commands;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.api.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends CommandManager {
    public MainCommand() {
        super("zealsocials", null, false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(player.isOp()) {
            if(args.length == 0) {
                for(String line : Social.getInstance().getConfig().getStringList("messages.help-message")) {
                    player.sendMessage(ChatUtils.color(line));
                }
                return;
            }
            if(args[0].equalsIgnoreCase("reload")) {
                Social.getInstance().reloadConfig();
                player.sendMessage(ChatUtils.getMessage("messages.reload-message"));
                return;
            }
            player.sendMessage(ChatUtils.getMessage("messages.info-message"));
            return;
        }
        player.sendMessage(ChatUtils.getMessage("messages.info-message"));
    }
}