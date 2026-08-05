# Compilar este fork

## El bloqueo actual

El HEAD de upstream **no compila para DrakesCraft**. El modulo `API` depende de:

```xml
<artifactId>paper-api</artifactId>
<version>26.1.2.build.51-beta</version>
```

Paper para **Minecraft 26.1**, que exige **Java 25**. El servidor corre **Java 21**, de ahi el
`cannot access org.bukkit.NamespacedKey` al compilar: el jar de paper-api tiene un class file
mas nuevo del que entiende el compilador.

Es la misma trampa que ya costo dos incidentes: **BentoBox 3.22** y **FastAsyncWorldEdit 2.15.3**
quedaron deshabilitados por Java 25.

Ademas, el pom pide `nightcore:2.15.3`, version que el repo de NightExpress **ya purgo**. La que
corre en produccion es **2.16.4**, que si esta publicada.

## Como desbloquearlo

Dos caminos, y conviene decidirlo antes de invertir tiempo:

1. **Buscar el tag de 5.4.3 que apunte a Paper 1.21.x.** El repo es multi-modulo y tiene un
   modulo `spigot-1.21.11`; probablemente exista una rama o tag anterior al salto a 26.1.
2. **Compilar solo con Java 25** y comprobar que el jar resultante siga siendo class file 65.
   Poco probable: si la API es de 26.1, el bytecode saldra mas nuevo.

**Antes de subir cualquier jar, verificar la version de class file.** Un jar de Java 25 en este
servidor no falla al compilar: falla en silencio al arrancar.

```bash
unzip -p ExcellentEnchants.jar su/nightexpress/.../TelekinesisEnchant.class | head -c 8 | xxd
# los bytes 7 y 8 son la version: 0x41 = 65 = Java 21 · 0x45 = 69 = Java 25
```

## Estado del parche

El arreglo de Telekinesis y `util/SlimefunCompat` **ya estan escritos y commiteados**. Solo falta
poder compilar.

Mientras tanto, en produccion el encantamiento esta desactivado moviendo su archivo a
`plugins/ExcellentEnchants/enchants/_disabled_/telekinesis.yml`, que frena la perdida de items
sin necesidad de tocar el jar.
