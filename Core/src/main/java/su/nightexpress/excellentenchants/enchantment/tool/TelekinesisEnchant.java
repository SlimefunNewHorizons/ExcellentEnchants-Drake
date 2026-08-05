package su.nightexpress.excellentenchants.enchantment.tool;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NullMarked;

import su.nightexpress.excellentenchants.EnchantsPlugin;
import su.nightexpress.excellentenchants.api.EnchantPriority;
import su.nightexpress.excellentenchants.api.enchantment.component.EnchantComponent;
import su.nightexpress.excellentenchants.api.enchantment.meta.Probability;
import su.nightexpress.excellentenchants.api.enchantment.type.BlockDropEnchant;
import su.nightexpress.excellentenchants.enchantment.EnchantContext;
import su.nightexpress.excellentenchants.enchantment.GameEnchantment;
import su.nightexpress.excellentenchants.manager.EnchantManager;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.excellentenchants.util.SlimefunCompat;
import su.nightexpress.nightcore.util.Players;

import java.nio.file.Path;

@NullMarked
public class TelekinesisEnchant extends GameEnchantment implements BlockDropEnchant {

    public TelekinesisEnchant(EnchantsPlugin plugin, EnchantManager manager, Path file, EnchantContext context) {
        super(plugin, manager, file, context);
        this.addComponent(EnchantComponent.PROBABILITY, Probability.oneHundred());
    }

    @Override
    protected void loadAdditional(FileConfig config) {

    }

    @Override

    public EnchantPriority getDropPriority() {
        return EnchantPriority.MONITOR;
    }

    @Override
    public boolean onDrop(BlockDropItemEvent event, LivingEntity entity, ItemStack item, int level) {
        if (!(entity instanceof Player player)) return false;

        return event.getItems().removeIf(drop -> {
            ItemStack itemStack = drop.getItemStack();
            // Slimefun reemplaza el drop vanilla por su propio item mas adelante en el evento.
            // Si lo quitamos de la lista, no le queda nada que reemplazar y el item deja de
            // existir: asi se perdieron plantas de Cultivation y panales con NBT en DrakesCraft.
            if (SlimefunCompat.isSlimefunItem(itemStack)) return false;
            if (Players.countItemSpace(player, itemStack) > 0) {
                Players.addItem(player, itemStack);
                return true;
            }
            return false;
        });
    }
}
