FROM openjdk:8-jre-alpine

COPY target/player-service1-0.0.1-SNAPSHOT.jar /player-service1.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

EXPOSE 8081

ENTRYPOINT java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /player-service1.jar