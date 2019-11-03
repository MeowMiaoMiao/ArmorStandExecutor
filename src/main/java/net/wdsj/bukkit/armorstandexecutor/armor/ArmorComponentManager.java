package net.wdsj.bukkit.armorstandexecutor.armor;

import net.wdsj.bukkit.armorstandexecutor.armor.component.ArmorComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:45
 */
public class ArmorComponentManager {

    private List<ArmorComponent> armorComponents = new ArrayList<>();

    public void registerComponent(ArmorComponent armorComponent) {
        armorComponents.add(armorComponent);
    }
    public void unregisterComponent(ArmorComponent armorComponent) {
        armorComponents.remove(armorComponent);
    }

    ArmorComponent match(String key) {
        for (ArmorComponent armorComponent : armorComponents) {
            if (armorComponent.getKey().equalsIgnoreCase(key)) {
                return armorComponent;
            }
        }
        return null;
    }

}
