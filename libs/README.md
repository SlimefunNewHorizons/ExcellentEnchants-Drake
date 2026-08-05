# Dependencias ancladas

## Por que estan aqui

El `pom.xml` de upstream pedia `nightcore:2.15.3`, y **NightExpress ya purgo esa version de su
repositorio**. El proyecto dejo de compilar sin que nadie tocara una linea de codigo.

Para que este fork siga siendo compilable dentro de diez meses, la version que usamos vive aqui.

## Contenido

| Archivo | Version | Class file | Origen |
|---|---|---|---|
| `nightcore-2.16.4.jar` | 2.16.4 | 65 (Java 21) | `repo.nightexpressdev.com/releases` |

Es la misma version que corre en produccion en DrakesCraft, no una elegida al azar.

## Instalarla en el Maven local

Solo hace falta si el repositorio remoto no responde o vuelve a purgar la version:

```bash
mvn install:install-file \
  -Dfile=libs/nightcore-2.16.4.jar \
  -DgroupId=su.nightexpress.nightcore \
  -DartifactId=main \
  -Dversion=2.16.4 \
  -Dpackaging=jar
```

## Licencia

`nightcore` es obra de **NightExpress**. Se guarda aqui **sin modificar**, unicamente para poder
reproducir la compilacion. No forma parte de este fork ni se redistribuye como propio: el jar
que se despliega lo declara `provided`, o sea que en el servidor corre el plugin oficial de
NightExpress, no esta copia.
