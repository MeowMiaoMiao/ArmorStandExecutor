package net.wdsj.bukkit.armorstandexecutor.api;

import net.wdsj.bukkit.armorstandexecutor.ArmorStandExecutor;
import net.wdsj.bukkit.armorstandexecutor.armor.component.ArmorComponent;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:42
 */
public class ArmorStandExecutorAPI {

    private ArmorStandExecutor armorStandExecutor;

    public ArmorStandExecutorAPI(ArmorStandExecutor armorStandExecutor) {
        this.armorStandExecutor = armorStandExecutor;
    }

    public void registerComponent(ArmorComponent armorComponent){
        armorStandExecutor.getArmorComponentManager().registerComponent(armorComponent);
    }

    public void unregisterComponent(ArmorComponent armorComponent){
        armorStandExecutor.getArmorComponentManager().unregisterComponent(armorComponent);
    }

}
