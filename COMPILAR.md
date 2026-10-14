# Como compilar ExcellentEnchants-Drake (para quien agarre este repo)

El CI de GitHub lo omite (`.github/ci-skip`) porque los modulos NMS piden `org.spigotmc:spigot:*:remapped-mojang`, que solo
existe tras ejecutar **BuildTools** en tu maquina.

**Donde compilar (regla de DrakesCraft):** primero tu PC / Nexus. Star es el VPS de produccion: solo si Nexus y Nova estan
apagados, y siempre con `~/ai-hub/scripts/build_seguro.sh` (un build a la vez, baja prioridad).

## 1. Una sola vez: instalar los Spigot remapeados en tu `~/.m2`
```bash
bash scripts/instalar-spigot-buildtools.sh          # 1.21.8, 1.21.10 y 1.21.11 (~10 min cada una, ~3 GB)
```
Funciona en Linux/macOS y en Git Bash de Windows (necesita JDK 21 y git).

## 2. Compilar
- `main` (linea 26.x, Paper API 26.x = bytecode 69): **JDK 25** — `mvn -B package -DskipTests`
- Solo 1.21.11 con JDK 21 (ver `NOTAS_BUILD.md`): `mvn package -DskipTests -Dmaven.compiler.release=21 -pl API,spigot-1.21.11,Core`
  (requiere que el pom apunte a `paper-api 1.21.11`; en `main` apunta a 26.x y con JDK 21 da "cannot access org.bukkit.plugin.Plugin").

El jar final queda en `target/ExcellentEnchants-5.4.3.jar` (raiz), NO en `Core/target/`.

## 3. Verificar antes de subir
```bash
python3 - <<'PY'
import zipfile
z = zipfile.ZipFile('target/ExcellentEnchants-5.4.3.jar'); n = z.namelist()
assert any('RegistryHack_1_21_11' in x for x in n), 'falta el NMS de 1.21.11'
print('clase', {int.from_bytes(z.read(x)[6:8],'big') for x in n if x.endswith('.class')}, '(65=Java 21, 69=Java 25)')
PY
```
