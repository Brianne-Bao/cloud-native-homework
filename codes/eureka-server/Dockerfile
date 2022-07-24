FROM openjdk:8-jre-alpine

ENV DIST_NAME = eureka-server \
    APP_VERSION = eureka-server-0.0.1-SNAPSHOT


COPY target/eureka-server-0.0.1-SNAPSHOT.jar /eureka-server.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone


EXPOSE 8085

ENTRYPOINT java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /eureka-server.jar
