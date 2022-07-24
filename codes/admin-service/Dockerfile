FROM openjdk:8-jre-alpine

COPY target/admin-service-0.0.1-SNAPSHOT.jar /admin-service.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

EXPOSE 8090

ENTRYPOINT java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /admin-service.jar