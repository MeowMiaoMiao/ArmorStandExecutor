package net.wdsj.bukkit.armorstandexecutor;

import lombok.Getter;
import net.wdsj.bukkit.armorstandexecutor.api.ArmorStandExecutorAPI;
import net.wdsj.bukkit.armorstandexecutor.armor.ArmorComponentManager;
import net.wdsj.bukkit.armorstandexecutor.generate.ArmorParserCacheGenerate;
import net.wdsj.bukkit.armorstandexecutor.generate.ArmorParserDirectGenerate;
import net.wdsj.bukkit.armorstandexecutor.generate.IArmorParserGenerate;
import net.wdsj.bukkit.armorstandexecutor.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ArmorStandExecutor extends JavaPlugin {

    @Getter
    private static ArmorStandExecutor instance;

    private static ArmorStandExecutorAPI api;

    private ArmorStandConfig armorStandConfig;

    private IArmorParserGenerate armorParserGenerate;

    private ArmorComponentManager armorComponentManager;

    public static  boolean PLACEHOLDER_API_ENABLE;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        armorComponentManager = new ArmorComponentManager();
        api = new ArmorStandExecutorAPI(this);
        loadByLocal();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        PLACEHOLDER_API_ENABLE = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");

        getLogger().info("启用成功 By Wdsj.net 如遇到问题，你可以前往 https://bbs.wdsj.net/t/dev 进行反馈");

    }

    private void loadByLocal() {
        saveDefaultConfig();
        reloadConfig();
        armorStandConfig = new ArmorStandConfig(this, getConfig().getConfigurationSection("config"));
        if (armorStandConfig.isCache()) {
            armorParserGenerate = new ArmorParserCacheGenerate();
        } else {
            armorParserGenerate = new ArmorParserDirectGenerate();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
