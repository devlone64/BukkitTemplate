package io.gitlab.lone64.template;

import org.bukkit.plugin.java.JavaPlugin;

public class TemplatePlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        getLogger().info("BukkitTemplate is loaded!");
    }

    @Override
    public void onEnable() {
        getLogger().info("BukkitTemplate is enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BukkitTemplate is disabled!");
    }

}