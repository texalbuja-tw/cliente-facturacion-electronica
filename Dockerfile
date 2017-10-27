FROM jboss/wildfly
RUN pwd
USER root

RUN pwd \
    && cd /opt \
    && curl -O http://www-eu.apache.org/dist/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz \
    && tar xzf apache-maven-3.5.0-bin.tar.gz \
    && ln -s apache-maven-3.5.0  maven \
    && chmod -R g+rw /opt/maven
USER jboss
RUN export M2_HOME=/opt/maven \
    && export PATH=${M2_HOME}/bin:${PATH} \
    && mvn -version \
    && mvn clean install -B -f taller-facturacion-electronica/pom.xml
