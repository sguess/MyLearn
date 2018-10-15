cd server
mvn clean package
pause
start java -jar target/server.jar --spring.profiles.active=s1
pause
start java -jar target/server.jar --spring.profiles.active=s2
cd ..
