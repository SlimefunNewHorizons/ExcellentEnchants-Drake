#!/usr/bin/env bash
# Instala en ~/.m2 los Spigot "remapped-mojang" que necesitan los modulos NMS (MC_1_21_8, MC_1_21_10, spigot-1.21.11).
# GitHub Actions no puede hacerlo (BuildTools tarda ~10 min por version y necesita ~2 GB), por eso este repo usa .github/ci-skip.
#
#   bash scripts/instalar-spigot-buildtools.sh            # 1.21.8 1.21.10 1.21.11
#   bash scripts/instalar-spigot-buildtools.sh 1.21.11    # solo una
#
# Requisitos: JDK 21, git, ~3 GB libres. En Star usa el envoltorio de carga controlada:
#   ~/ai-hub/scripts/build_seguro.sh 21 ~/buildtools bash scripts/instalar-spigot-buildtools.sh
set -euo pipefail
VERSIONES=("${@:-1.21.8 1.21.10 1.21.11}")
mkdir -p "${HOME}/buildtools" && cd "${HOME}/buildtools"
[ -f BuildTools.jar ] || curl -fsSL -o BuildTools.jar https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
for v in ${VERSIONES[@]}; do
  echo "== BuildTools $v"
  java -jar BuildTools.jar --rev "$v" --remapped --output-dir "${HOME}/buildtools/out"
done
echo "Listo. Compila con: mvn -B package -DskipTests   (JDK 25 para el reactor completo)"
