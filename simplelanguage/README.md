# SimpleLanguage

A simple demonstration language built using Truffle for GraalVM.

SimpleLanguage is heavily documented to explain the how and why of writing a
Truffle language. A good way to find out more is to read the source with
comments. Start reading [here](https://github.com/graalvm/simplelanguage/blob/master/language/src/main/java/com/oracle/truffle/sl/SLLanguage.java).
We also like to encourage people to clone the repository and start hacking.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

For instructions on how to get started please refer to [our website](http://www.graalvm.org/docs/graalvm-as-a-platform/implement-language/)

## Building
1. Download  https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.0/graalvm-ce-java11-linux-amd64-22.3.0.tar.gz
2. Extract the tar file
3. Find the java path 
4. Run ```mvn clean package -DskipTests=true -Dgraalvm.home=/path/to/graalvm-ce-java11-22.3.0/```
5. This will generate **sl-component.jar** inside /simplelanguag/component/ , move this .jar into /sprint-boot/sl-component.jar
6. Run ```cd spring-boot```
7. Run ```mvn clean package```
8. There is **Dockerfile** inside spring-boot root directory , will build that image first and deploy on docker container
9. Run ```docker build -t spring-boot-simplelanguage:beta .```