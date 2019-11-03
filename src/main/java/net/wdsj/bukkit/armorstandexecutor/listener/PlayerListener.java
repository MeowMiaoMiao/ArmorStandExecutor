package net.wdsj.bukkit.armorstandexecutor.listener;

import net.wdsj.bukkit.armorstandexecutor.ArmorStandExecutor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

/**
 * @author Arthur
 * @version 1.0
 * @date 2019/10/25 17:52
 */
public class PlayerListener implements Listener {


    @EventHandler
    public void on(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof ArmorStand) {
            ArmorStand stand = (ArmorStand) event.getRightClicked();
            try {
                ArmorStandExecutor.getInstance().getArmorParserGenerate().getArmorParser(stand).playerClick(event.getPlayer());
            } catch (Exception e) {
                if (ArmorStandExecutor.getInstance().getArmorStandConfig().isDebug()) {
                    e.printStackTrace();
                    ArmorStandExecutor.getInstance().getLogger().info
                            ("DEBUG > 执行时出现错误！");
                }
            }
        }
    }

}
