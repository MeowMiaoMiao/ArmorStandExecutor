package net.wdsj.bukkit.armorstandexecutor.generate;

import net.wdsj.bukkit.armorstandexecutor.armor.ArmorParser;
import org.bukkit.entity.ArmorStand;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:14
 */
public interface IArmorParserGenerate {
    ArmorParser getArmorParser(ArmorStand armorStand);
}
