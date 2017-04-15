Taller de Facturación Electrónica para Programadores Java

Instalación de librerías que no se encuentran en repositorios maven públicos. Ubicarse en la carpeta lib

mvn install:install-file -DgroupId=com.paic.maven -DartifactId=tplconfig-maven-plugin -Dversion=1.0 -Dpackaging=jar -Dfile=tplconfig-maven-plugin-1.0.jar -DgeneratePom=true