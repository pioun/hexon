FROM openjdk:10.0.1-10-jre-slim

MAINTAINER pioun <pioun@protonmail.com>

ARG JAR_FILE
ARG ARTIFACT_NAME

ENV JAR_PATH=${ARTIFACT_NAME}/${JAR_FILE}

ADD ${JAR_FILE} /opt/${ARTIFACT_NAME}/${JAR_FILE}

ENTRYPOINT /usr/bin/java -jar /opt/$JAR_PATH