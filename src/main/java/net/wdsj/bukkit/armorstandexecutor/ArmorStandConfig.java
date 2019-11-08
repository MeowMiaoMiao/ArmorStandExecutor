package net.wdsj.bukkit.armorstandexecutor;

import lombok.Getter;
import net.wdsj.bukkit.armorstandexecutor.armor.component.ArmorComponent;
import net.wdsj.bukkit.armorstandexecutor.armor.component.CommandComponent;
import net.wdsj.bukkit.armorstandexecutor.armor.component.MessageComponent;
import net.wdsj.bukkit.armorstandexecutor.armor.component.PermissionComponent;
import org.bukkit.configuration.ConfigurationSection;

import java.lang.reflect.Field;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:05
 */
@Getter
public class ArmorStandConfig {

    private boolean debug = false;
    private boolean cache = true;

    public ArmorStandConfig(ArmorStandExecutor armorStandExecutor, ConfigurationSection configurationSection) {
        for (Field declaredField : getClass().getDeclaredFields()) {
            if (configurationSection.contains(declaredField.getName()))
                try {
                    declaredField.setAccessible(true);
                    if (declaredField.getType() == boolean.class)
                        declaredField.set(this, configurationSection.getBoolean(declaredField.getName()));
                    if (declaredField.getType() == String.class)
                        declaredField.set(this, configurationSection.getString(declaredField.getName()));
                    if (declaredField.getType() == long.class)
                        declaredField.set(this, configurationSection.getLong(declaredField.getName()));
                    if (declaredField.getType() == int.class)
                        declaredField.set(this, configurationSection.getInt(declaredField.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }

        ConfigurationSection compSection = configurationSection.getConfigurationSection("component");
        armorStandExecutor.getArmorComponentManager().registerComponent(new PermissionComponent(compSection.getString("PERMISSION","permission")));
        armorStandExecutor.getArmorComponentManager().registerComponent(new CommandComponent(compSection.getString("COMMAND","command")));
        armorStandExecutor.getArmorComponentManager().registerComponent(new MessageComponent(compSection.getString("MESSAGE","message")));
    }

}
