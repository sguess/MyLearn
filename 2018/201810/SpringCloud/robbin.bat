cd robbin
mvn clean package
pause
start java -jar target/robbin.jar --spring.profiles.active=r1
pause
start java -jar target/robbin.jar --spring.profiles.active=r2
cd ..
