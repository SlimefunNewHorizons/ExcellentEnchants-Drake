# Como compilar ExcellentEnchants-Drake (para quien agarre este repo)

El CI de GitHub lo omite (`.github/ci-skip`) porque los modulos NMS piden `org.spigotmc:spigot:*:remapped-mojang`, que solo
existe tras ejecutar **BuildTools** en tu maquina. Se compila local o en Star.

## 1. Una sola vez: instalar los Spigot remapeados
```bash
bash scripts/instalar-spigot-buildtools.sh          # 1.21.8, 1.21.10 y 1.21.11 (~10 min cada una)
```
En Star (carga controlada, un build a la vez): `~/ai-hub/scripts/build_seguro.sh 21 ~/buildtools bash scripts/instalar-spigot-buildtools.sh`

## 2. Compilar
- `main` (linea 26.x, Paper API 26.x = bytecode 69): **JDK 25** — `mvn -B package -DskipTests`
  (Star: `~/ai-hub/scripts/build_seguro.sh 25 <repo> mvn -B package -DskipTests`)
- Solo 1.21.11 con JDK 21 (ver `NOTAS_BUILD.md`): `mvn package -DskipTests -Dmaven.compiler.release=21 -pl API,spigot-1.21.11,Core`
  (requiere que el pom apunte a `paper-api 1.21.11`).

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
