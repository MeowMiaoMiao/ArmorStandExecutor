package net.wdsj.bukkit.armorstandexecutor.armor;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import net.wdsj.bukkit.armorstandexecutor.ArmorStandExecutor;
import net.wdsj.bukkit.armorstandexecutor.armor.component.ArmorComponent;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 17:59
 */
public class ArmorParser {


    private Multimap<String, String> parserMap = LinkedListMultimap.create();

    private ArmorStand stand;

    public ArmorParser(ArmorStand stand) {
        this.stand = stand;
        parser();
    }

    private void parser() {
        parserMap.putAll(parserItemStack(stand.getHelmet()));
        parserMap.putAll(parserItemStack(stand.getBoots()));
        parserMap.putAll(parserItemStack(stand.getChestplate()));
        parserMap.putAll(parserItemStack(stand.getLeggings()));
        parserMap.putAll(parserItemStack(stand.getItemInHand()));
    }

    public void playerClick(Player player) {
        if (ArmorStandExecutor.getInstance().getArmorStandConfig().isDebug()) {
            ArmorStandExecutor.getInstance().getLogger().info
                    ("DEBUG > " + player.getDisplayName() + " interact armorstand entity id: " + stand.getEntityId());
        }
        for (String key : parserMap.keys()) {
            ArmorComponent armorComponent = ArmorStandExecutor.getInstance().getArmorComponentManager().match(key);
            if (armorComponent == null) continue;
            for (String s : parserMap.get(key)) {
                armorComponent.execute(player, s);
            }
        }
    }


    private Multimap<String, String> parserItemStack(ItemStack itemStack) {
        Multimap<String, String> hashMap = LinkedListMultimap.create();
        List<String> lores = itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore() ? itemStack.getItemMeta().getLore() : new ArrayList<>();
        for (String lore : lores) {
            String[] split = lore.split(":");
            if (split.length > 1) {
                String key = split[0];
                String value = lore.substring(split[0].length() + 1);
                hashMap.put(split[0], lore.substring(split[0].length() + 1));
                if (ArmorStandExecutor.getInstance().getArmorStandConfig().isDebug()) {
                    ArmorStandExecutor.getInstance().getLogger().info
                            ("DEBUG > entityID: " + stand.getEntityId() + " parser K:V" + key + ":" + value);
                    if ( ArmorStandExecutor.getInstance().getArmorComponentManager().match(key) == null) {
                        ArmorStandExecutor.getInstance().getLogger().info
                                ("DEBUG > 错误的参数: " + key + " 请检查");
                    }
                }
            }
        }
        return hashMap;
    }

}
