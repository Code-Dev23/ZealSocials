    package it.codedevv.zealsocials.managers;

    import it.codedevv.zealsocials.Social;
    import org.bukkit.Location;
    import org.bukkit.Material;
    import org.bukkit.block.Block;
    import org.bukkit.configuration.ConfigurationSection;
    import org.bukkit.configuration.file.FileConfiguration;
    import org.bukkit.entity.Player;

    import java.io.File;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Set;

    public class SocialManager {
        private FileConfiguration config = Social.getInstance().getConfig();

        public Block getTargetBlock(Player player) {
            Set<Material> NullSet = null;
            return player.getTargetBlock(NullSet, 5);
        }

        public void createSocial(String name, Location location) {
            config.set("socials." + name + ".location", location);
            save();
        }
        public void deleteSocial(String name) {
            config.set("socials." + name, null);
            save();
        }
        public void setLink(String name, String link) {
            config.set("socials." + name + ".link", link);
            save();
        }
        public String getSocial(Location location) {
            for(String social : config.getConfigurationSection("socials").getKeys(false)) {
                Location loc = config.getLocation("socials." + social + ".location");
                if(loc.equals(location)) return social;
            }
            return null;
        }

        public String getLink(Location location) {
            for(String social : config.getConfigurationSection("socials").getKeys(false)) {
                Location loc = config.getLocation("socials." + social + ".location");
                String link = config.getString("socials." + social + ".link");
                if(loc.equals(location)) return link;
            }
            return null;
        }
        public List<String> getSocials(){
            if(config.get("socials") == null) return new ArrayList<>();
            return new ArrayList<>(config.getConfigurationSection("socials").getKeys(false));
        }

        public List<Location> getLocations() {
            List<Location> locations = new ArrayList<>();
            ConfigurationSection section = config.getConfigurationSection("socials");
            if(section == null) return null;
            for(String social : section.getKeys(false)) {
                Location location =  config.getLocation("socials." + social + ".location");
                locations.add(location);
                return locations;
            }
            return null;
        }


        private void save() {
            try {
                Social.getInstance().getConfig().save(new File(Social.getInstance().getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }