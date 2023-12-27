FROM openjdk:11 as build

WORKDIR organization-service

COPY target/*.jar application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:11

WORKDIR organization-service

COPY --from=build organization-service/dependencies/ ./
COPY --from=build organization-service/spring-boot-loader/ ./
COPY --from=build organization-service/snapshot-dependencies/ ./
COPY --from=build organization-service/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]