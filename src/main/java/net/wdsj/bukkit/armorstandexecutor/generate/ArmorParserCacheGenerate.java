package net.wdsj.bukkit.armorstandexecutor.generate;

import net.wdsj.bukkit.armorstandexecutor.ArmorStandExecutor;
import net.wdsj.bukkit.armorstandexecutor.armor.ArmorParser;
import org.bukkit.entity.ArmorStand;

import java.util.HashMap;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/11/3 21:16
 */
public class ArmorParserCacheGenerate implements IArmorParserGenerate {

    private HashMap<Integer, ArmorParser> armorParserMap = new HashMap<>();

    @Override
    public ArmorParser getArmorParser(ArmorStand armorStand) {
        return armorParserMap.computeIfAbsent(armorStand.getEntityId(), (k) -> new ArmorParser(armorStand));
    }

}
