package it.codedevv.zealsocials.api;

import it.codedevv.zealsocials.Social;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.List;

@UtilityClass
public class ChatUtils {
    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public String getMessage(String path) {
        return color(Social.getInstance().getConfig().getString(path));
    }
}