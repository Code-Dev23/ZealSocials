package it.codedevv.zealsocials;

import it.codedevv.zealsocials.commands.CreateSocialCommand;
import it.codedevv.zealsocials.commands.DeleteSocialCommand;
import it.codedevv.zealsocials.commands.MainCommand;
import it.codedevv.zealsocials.commands.SetSocialLinkCommand;
import it.codedevv.zealsocials.commands.socials.*;
import it.codedevv.zealsocials.listeners.SocialListeners;
import it.codedevv.zealsocials.managers.SocialManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Social extends JavaPlugin {

    @Getter private static Social instance;
    @Getter private static SocialManager socialManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        socialManager = new SocialManager();

        loadCommands();
        loadListeners();
    }

    private void loadCommands() {
        new SocialCommand();
        new DiscordCommand();
        new InstagramCommand();
        new TikTokCommand();
        new YouTubeCommand();

        new CreateSocialCommand();
        new DeleteSocialCommand();
        new SetSocialLinkCommand();

        new MainCommand();
    }
    private void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new SocialListeners(), this);
    }
}
