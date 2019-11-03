package net.wdsj.bukkit.armorstandexecutor.generate;

import net.wdsj.bukkit.armorstandexecutor.armor.ArmorParser;
import org.bukkit.entity.ArmorStand;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:16
 */
public class ArmorParserDirectGenerate implements IArmorParserGenerate {
    @Override
    public ArmorParser getArmorParser(ArmorStand armorStand) {
        return new ArmorParser(armorStand);
    }
}
