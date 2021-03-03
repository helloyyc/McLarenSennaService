FROM openjdk:8-jre
COPY spider-host/target/mclaren-senna.jar /opt/mclaren-senna/mclaren-senna.jar
RUN mkdir -p /data/fota \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone
WORKDIR /opt/mclaren-senna/
ENTRYPOINT ["java", "-jar", "mclaren-senna.jar"]