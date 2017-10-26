FROM jboss/wildfly
RUN pwd
RUN mvn clean install
ADD target/cliente-facturacion-electronica.war /opt/wildfly/standalone/deployments/
