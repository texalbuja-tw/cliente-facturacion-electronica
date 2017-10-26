FROM jboss/wildfly
RUN pwd
RUN touch target/cliente-facturacion-electronica.war
ADD target/cliente-facturacion-electronica.war /opt/wildfly/standalone/deployments/
RUN mvn clean install
