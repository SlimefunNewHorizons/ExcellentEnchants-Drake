package su.nightexpress.excellentenchants.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;

/**
 * Deja en paz los items que pertenecen a Slimefun.
 *
 * Varios encantamientos intervienen el drop de un bloque antes de que Slimefun lo reemplace por
 * su propio item. Al quitarlo de la lista del evento, Slimefun se queda sin nada que reemplazar y
 * el item deja de existir. En DrakesCraft se perdieron asi plantas de Cultivation y panales con
 * NBT, y el jugador no recibia nada a cambio.
 *
 * Se resuelve por reflexion a proposito: el plugin sigue compilando y funcionando en servidores
 * sin Slimefun, y si la API cambia se degrada a "no es de Slimefun" en vez de romper el evento.
 */
public final class SlimefunCompat {

    private static Method getByItem;
    private static boolean revisado;

    private SlimefunCompat() {
    }

    /** True si el item pertenece a Slimefun y hay que dejar que el lo gestione. */
    public static boolean isSlimefunItem(ItemStack item) {
        if (item == null || item.getType().isAir()) return false;
        Method method = resolve();
        if (method == null) return false;
        try {
            return method.invoke(null, item) != null;
        } catch (ReflectiveOperationException | RuntimeException error) {
            return false;
        }
    }

    private static Method resolve() {
        if (revisado) return getByItem;
        revisado = true;
        if (Bukkit.getPluginManager().getPlugin("Slimefun") == null) return null;
        // El fork de DrakesCraft reubica el paquete; se prueban ambos.
        for (String clase : new String[]{
                "io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem",
                "com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem"}) {
            try {
                getByItem = Class.forName(clase).getMethod("getByItem", ItemStack.class);
                return getByItem;
            } catch (ReflectiveOperationException ignored) {
                // se prueba la siguiente
            }
        }
        return null;
    }
}
