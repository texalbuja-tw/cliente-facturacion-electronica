FROM jboss/wildfly
RUN apt-get update
RUN apt-get install -y maven
RUN mvn clean install
ADD target/cliente-facturacion-electronica.war /opt/wildfly/standalone/deployments/
