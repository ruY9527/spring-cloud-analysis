FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
ADD eureka-server-1.0.0.jar  app.jar

ENV AP_ENV=$AP_ENV
VOLUME /tmp/logs/

EXPOSE 8761
#ENTRYPOINT [ "sh", "-c", "java -Denv=$AP_ENV -Xmx64m -Xss256k  -jar app.jar --apollo.meta=${CONFIG_SERVERS} --eureka.client.serviceUrl.defaultZone=${EK_CLUSTER_URL}" ]
ENTRYPOINT [ "sh", "-c","java -Xmx64m -Xss256k  -jar app.jar"]
