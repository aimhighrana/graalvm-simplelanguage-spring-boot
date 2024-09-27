### Custom language inside spring boot using graalVm simplelanguage


#### Prerequisite
1. mvn 3.x
2. java 11

#### How I can build this ?
Run ```cd simplelanguag```

Run ```mvn clean package -DskipTests=true```
This will generate **sl-component.jar** inside /simplelanguag/component/ , move this .jar into /sprint-boot/sl-component.jar

Run ```cd spring-boot```

Run ```mvn clean package```

#### How I can deploy this ?
There is **Dockerfile** inside spring-boot root directory , will build that image first and deploy on docker container

Run ```cd spring-boot```

Run ```docker build -t spring-boot-simplelanguage:beta .```

Run ```docker run -d -p 9893:8080 -e=server.port=8080 --name=spring-boot-simplelanguage spring-boot-simplelanguage:beta```





