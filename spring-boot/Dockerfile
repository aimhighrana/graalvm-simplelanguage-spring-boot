FROM maven:3.8-openjdk-8 as jardownloader
RUN mkdir /downloaded

RUN wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.0/graalvm-ce-java11-linux-amd64-22.3.0.tar.gz
RUN cp /graalvm-ce-java11-linux-amd64-22.3.0.tar.gz /downloaded/
RUN mkdir -p /opt/graalvm && tar -xzf /downloaded/graalvm-ce-java11-linux-amd64-22.3.0.tar.gz -C /opt/graalvm

FROM registry.access.redhat.com/ubi8/ubi-minimal

USER root

COPY --from=jardownloader /opt/graalvm /usr/lib/jvm

## Executable jars
COPY sl-component.jar /home/jboss/graalvm/component/
COPY target/*.jar app.jar

RUN /usr/lib/jvm/graalvm-ce-java11-22.3.0/bin/gu install native-image

RUN /usr/lib/jvm/graalvm-ce-java11-22.3.0/bin/gu install -L /home/jboss/graalvm/component/sl-component.jar

ENTRYPOINT ["/usr/lib/jvm/graalvm-ce-java11-22.3.0/bin/java","-Dfile.encoding=UTF-8" ,"-jar","-noverify","app.jar"]