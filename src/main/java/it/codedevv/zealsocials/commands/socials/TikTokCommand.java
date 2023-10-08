package it.codedevv.zealsocials.commands.socials;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.api.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TikTokCommand extends CommandManager {
    public TikTokCommand() {
        super("tiktok", null, false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        for(String line : Social.getInstance().getConfig().getStringList("messages.tiktok")) {
            player.sendMessage(ChatUtils.color(line.replace("%prefix%", ChatUtils.getMessage("messages.prefix"))));
        }
    }
}
