## build the java
```
mvn clean install
```

## graalvm to build native executable

Graalvm can be found here
```
https://github.com/graalvm/graalvm-ce-builds/releases
```

add bin directory of your graalvm installation to the path, then
```
gu install native-image
```

then compile
```
native-image --no-fallback --initialize-at-build-time=io.ktor,kotlinx,kotlin,org.slf4j -H:ReflectionConfigurationFiles=graalvm-reflection.conf -cp target/telealerts.jar com.lemmsh.telealerts.AlertSender telealerts
```


## useful links

https://stackoverflow.com/questions/61487173/is-there-a-way-to-use-kotlin-random-random-inside-graalvm-native-image
https://github.com/HewlettPackard/kraal/issues/5
