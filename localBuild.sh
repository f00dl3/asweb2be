rm ./build/libs/*.jar
./gradlew build jar --refresh-dependencies
java -jar ./build/libs/backend-SNAPSHOT.jar
