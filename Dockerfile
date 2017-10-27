FROM jboss/wildfly
RUN pwd \
    && cd /opt \
    && curl -O http://www-eu.apache.org/dist/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz \
    && tar apache-maven-3.5.0-bin.tar.gz \
    && rm apache-maven-3.5.0-bin.tar.gz \
    && sudo ln -s apache-maven-3.5.0  maven \
    && export M2_HOME=/opt/maven \
    && export PATH=${M2_HOME}/bin:${PATH} \
    && chown -R jboss:0 ${M2_HOME} \
    && chmod -R g+rw ${M2_HOME} \
    && mvn -version \
    && mvn clean install \
ADD target/cliente-facturacion-electronica-0.0.1-SNAPSHOT.jar /opt/wildfly/standalone/deployments/
