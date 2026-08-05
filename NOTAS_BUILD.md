# Compilar este fork

## Como compilar (resuelto el 2026-08-05)

```bash
# 1. Una sola vez: instalar el Spigot remapeado en el Maven local.
#    Sin esto el modulo spigot-1.21.11 no resuelve y el jar sale SIN las clases NMS,
#    lo que hace que el plugin no registre ningun encantamiento al arrancar.
java -jar BuildTools.jar --rev 1.21.11 --remapped

# 2. Compilar solo los modulos que aplican a 1.21.11.
#    Los modulos MC_1_21_10 y spigot-26.1.2 piden artefactos que no tenemos y no hacen falta.
mvn package -DskipTests -pl API,spigot-1.21.11,Core
```

El jar final se ensambla en **`target/ExcellentEnchants-5.4.3.jar`** (raiz del proyecto), no en
`Core/target/`. El de Core no lleva las clases NMS: si se sube ese, el plugin arranca sin
encantamientos.

## Verificacion obligatoria antes de subir

```bash
python3 - <<'EOF'
import zipfile
z = zipfile.ZipFile('target/ExcellentEnchants-5.4.3.jar'); n = z.namelist()
assert any('RegistryHack_1_21_11' in x for x in n), 'falta el NMS de 1.21.11'
vs = {int.from_bytes(z.read(x)[6:8], 'big') for x in n if x.endswith('.class')}
assert vs == {65}, f'class file incorrecto: {vs} (65 = Java 21)'
print('jar OK')
EOF
```

**Class file 65 = Java 21.** Un jar de Java 25 no falla al compilar: falla en silencio al
arrancar. Ya paso con BentoBox 3.22 y FastAsyncWorldEdit 2.15.3.

## Cambios respecto al upstream

| Que | De | A | Por que |
|---|---|---|---|
| `paper-api` (API y Core) | `26.1.2.build.51-beta` | `1.21.11-R0.1-SNAPSHOT` | El upstream apunta a MC 26.1, que exige Java 25 |
| `nightcore` | `2.15.3` | `2.16.4` | La 2.15.3 fue purgada del repo; la 2.16.4 es la que corre en produccion |
| modulo `spigot-26.1.2` | presente | quitado de Core | No aplica y su artefacto no existe |
| `SpigotEnchantsBootstrap` | referenciaba `mc_26_1_2` | quitado | Su modulo NMS ya no se compila |

## Estado del parche

Telekinesis y `util/SlimefunCompat` estan aplicados y compilados.

## Dependencias ancladas

`libs/` guarda `nightcore-2.16.4.jar`, la misma version que corre en produccion. Existe porque
NightExpress **purgo la 2.15.3** que pedia el pom original y el proyecto dejo de compilar solo.
Si el repositorio remoto vuelve a fallar:

```bash
mvn install:install-file -Dfile=libs/nightcore-2.16.4.jar \
  -DgroupId=su.nightexpress.nightcore -DartifactId=main -Dversion=2.16.4 -Dpackaging=jar
```
