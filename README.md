> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.cl` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rR7FbfCt9Y)
> * 🌐 **Web & Guía**: [web.drakescraft.cl](https://web.drakescraft.cl) — 🛒 **Tienda**: [web.drakescraft.cl/store](https://web.drakescraft.cl/store.html)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

<p align="center">
  <img src=".github/assets/banner.svg" alt="ExcellentEnchants · Drake Edition" width="760">
</p>

<p align="center">
  <img alt="Licencia" src="https://img.shields.io/badge/licencia-GPL--3.0-6fe3a2?style=flat-square">
  <img alt="Base" src="https://img.shields.io/badge/base-5.4.3-ffb347?style=flat-square">
  <img alt="Adoptado" src="https://img.shields.io/badge/adoptado%20por-DrakesCraft-ffe289?style=flat-square">
</p>

> ### Adoptado por DrakesCraft
>
> Este fork lo mantiene **DrakesCraft** y va a seguir recibiendo cambios propios. El objetivo es
> que los encantamientos convivan bien con **Slimefun**, que es el corazon del servidor.
>
> **Primer cambio · Telekinesis dejaba de destruir items de Slimefun.** El encantamiento quitaba
> el drop de la lista de `BlockDropItemEvent` antes de que Slimefun lo reemplazara por su propio
> item. Al no quedar nada que reemplazar, el item dejaba de existir: se perdieron plantas de
> Cultivation y panales con NBT, y el jugador no recibia nada a cambio. Ahora los drops que
> pertenecen a Slimefun se dejan pasar intactos.
>
> La deteccion va por reflexion (`util/SlimefunCompat`), asi que el plugin sigue funcionando
> igual en servidores sin Slimefun.
>
> **Pendiente:** auditar los otros doce encantamientos que tocan bloques. Los que rompen varios
> (`veinminer`, `treefeller`, `tunnel`, `blast_mining`) usan `player.breakBlock()`, que dispara
> un `BlockBreakEvent` real y Slimefun lo recibe bien. Faltan por revisar `smelter` y `silk_chest`.
>
> Gracias a **nulli0n** por el trabajo original.

---

<p align="center">
  <img src="https://nightexpressdev.com/excellentenchants/banner.png">
</p>

<p align="center">
<b>ExcellentEnchants</b> is a lightweight and modern enchantments plugin that adds <b>80+ vanilla-like</b>, fully customizable enchantments to your server.
</p>

<p align="center">
<b>ExcellentEnchants</b> does <b>not</b> modify loot tables, villager trades, or enchanting tables - enchantments are seamlessly integrated into your server in the same way as vanilla or datapack enchantments.
</p>

<p align="center">
<b>ExcellentEnchants</b> leaves <b>no permanent</b> impact on your server after uninstallation, as if the plugin had never been installed - no errors, bugs, or crashes. Ever.
</p>

<p align="center">
<a href="https://nightexpressdev.com/excellentenchants/enchantments/list/"><b>Click here to view all new enchantments!</b></a>
</p>

<p align="center">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/enchants_ghast.gif">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/enchants_flamewalker.gif">
</p>
<p align="center">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/enchants_thunder.gif">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/enchants_tunnel.gif">
</p>

## Features

### Integration & Compatibility
- [**Seamless Integration**](https://nightexpressdev.com/excellentenchants/enchantments/integration/). Fully compatible with vanilla mechanics, commands, and other plugins.
- **Anvil & Grindstone Support**. Combine or remove custom enchantments just like vanilla ones.
- **Enchanted Books Support**. Access custom enchanted books directly from the Creative menu.
- [**PlaceholderAPI**](https://nightexpressdev.com/excellentenchants/placeholders/papi/) support.

<p align="center">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/anvil.gif">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/books.gif">
</p>

### Enchantment Distribution
- [**Enchanting Table**](https://nightexpressdev.com/excellentenchants/enchantments/distribution/) & **Villager Trades**. Obtain custom enchantments through standard progression.
- [**Random Loot**](https://nightexpressdev.com/excellentenchants/enchantments/distribution/). Find enchanted items in dungeon chests.
- [**Fishing**](https://nightexpressdev.com/excellentenchants/enchantments/distribution/). Fish enchanted books with custom enchantments.
- [**Mob Equipment**](https://nightexpressdev.com/excellentenchants/enchantments/distribution/). Mobs can spawn with custom-enchanted gear.

<p align="center">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/enchanting.gif">
<img src="https://nightexpressdev.com/excellentenchants/img/gif/loot.gif">
</p>

### Customization & Control
- **Highly Customizable**. Modify attributes of any enchantment.
- **Overpowering Enchantments**. Allow enchantments to scale beyond max levels.
- **Exclusives**. Define incompatible enchantments per enchantment.
- [**Disable Enchantments**](https://nightexpressdev.com/excellentenchants/enchantments/disabling/). Disable enchantments globally or per world.

### Item & Equipment Support
- **Axes Support**. Apply sword enchantments to axes.
- **Crossbows Support**. Apply bow enchantments to crossbows by default.
- **Elytra Support**. Apply chestplate enchantments to elytras by default.
- [**Item Lists**](https://nightexpressdev.com/excellentenchants/enchantments/item-sets/). Create custom primary & supported item lists for enchantments.

### User Interface & Presentation
- **Enchantments GUI**. Customizable GUI for browsing all custom enchantments.
- **Colored Tooltips**. Customize tooltip colors for custom enchantments.
- [**Description Tooltip**](https://nightexpressdev.com/excellentenchants/features/tooltips/). Display enchantment summaries in item tooltips.
- **Visual Effects**. Enchantments include particles and sound effects.

### Advanced Mechanics
- [**Enchant Charges**](https://nightexpressdev.com/excellentenchants/features/charges/). Introduce charge-based mechanics for enchantments.
- [**New Curses**](https://nightexpressdev.com/excellentenchants/enchantments/list/). Additional curse enchantments beyond vanilla.

## Requirements

You **must** have [NightCore](https://nightexpressdev.com/nightcore/) plugin installed to run **ExcellentEnchants**. Minecraft 26.1.2 support requires NightCore 2.15.2 or newer.

The following versions and platforms are supported:

| **Server Version** | **Paper** | **Spigot** | **Folia** | **Java Version** |
|:------------------:|:---------:|:----------:|:---------:|:----------------:|
|       26.1.2       |    Yes    |    Yes     |    No     |        25        |
|      1.21.11       |    Yes    |    Yes     |    No     |        21        |
|      1.21.10       |    Yes    |    Yes     |    No     |        21        |
|       1.21.9       |    Yes    |     No     |    No     |        21        |
|       1.21.8       |    Yes    |    Yes     |    No     |        21        |

- Anything not listed in the compatibility table is **NOT** supported.
- Make sure to check out all known issues and incompatibilities [here](https://nightexpressdev.com/excellentenchants/common-issues/).

**Optional Plugins:**
- [PacketEvents](https://spigotmc.org/resources/80279/) - For enchantment descriptions in item tooltip (you need only one).
- [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib/) - For enchantment descriptions in item tooltip (you need only one).

## Links
- [**Website**](https://nightexpressdev.com/) - Check out my other plugins.
- [**Wiki**](https://nightexpressdev.com/excellentenchants/) - Learn how to configure the plugin.
- [**Discord**](https://discord.gg/EwNFGsnGaW) - Get support, ask questions.
- [**Github**](https://github.com/nulli0n/ExcellentEnchants-spigot) - Check out the source code.
- [**Donate**](https://ko-fi.com/nightexpress) - Support me and my work.

## ⚖️ Upstream Attribution & License / Licencia y Créditos

- **Original Project / Upstream**: Slimefun4 Community Addon.
- **Port & Maintenance**: DrakesCraft Labs team (Compatibility for Paper / Purpur 1.21.11).
- **License**: GPL-3.0 / MIT.
- **Source Code**: [GitHub Repository](https://github.com/DrakesCraft-Labs/ExcellentEnchants-Drake)
- **Support & Issues**: [GitHub Issues](https://github.com/DrakesCraft-Labs/ExcellentEnchants-Drake/issues) | [Discord](https://discord.gg/rR7FbfCt9Y)

*This project is an open-source derivative work maintained by DrakesCraft Labs under the terms of its original license. All original assets and concepts belong to their respective creators.*
