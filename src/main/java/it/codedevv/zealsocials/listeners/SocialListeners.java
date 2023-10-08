package it.codedevv.zealsocials.listeners;

import it.codedevv.zealsocials.Social;
import it.codedevv.zealsocials.api.ChatUtils;
import it.codedevv.zealsocials.managers.SocialManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class SocialListeners implements Listener {
    SocialManager social = Social.getSocialManager();

    @EventHandler
    public void onClickHead(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();
        if(action.equals(Action.RIGHT_CLICK_BLOCK) && e.getHand().equals(EquipmentSlot.HAND)) {
            Location clickedBlock = e.getClickedBlock().getLocation();
            if(social.getLocations() == null) return;
            if(social.getSocial(clickedBlock) == null) return;
            if(social.getLink(clickedBlock) == null) return;
            for(String line : Social.getInstance().getConfig().getStringList("messages.format-message")) {
                player.sendMessage(ChatUtils.color(line
                        .replace("%social%", social.getSocial(clickedBlock))
                        .replace("%link%", social.getLink(clickedBlock))
                        .replace("%prefix%", ChatUtils.getMessage("messages.prefix"))
                ));
            }
        }
    }
}