FROM jboss/wildfly

USER root

RUN pwd \
    && cd /opt \
    && curl -O http://www-eu.apache.org/dist/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz \
    && tar xzf apache-maven-3.5.0-bin.tar.gz \
    && ln -s apache-maven-3.5.0  maven 
RUN export M2_HOME=/opt/maven \
    && export PATH=${M2_HOME}/bin:${PATH} \
    && chown -R jboss:0 ${M2_HOME} \
    && chmod -R g+rw ${M2_HOME} \
    && mvn -version \
    && mvn clean install
