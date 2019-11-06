## Setting up the server
Download ubuntu server image https://help.ubuntu.com/community/Installation/MinimalCD
For ex. 18.04 Bionic Beaver

Install with defaults.

Username: **ubuntu**

Password: **password**

```
sudo apt-get update
sudo apt-get install mysql-server
sudo apt-get install openjdk-11-jdk
```

Log into mysql and create user and database
```
mysql -uroot -p
create database pharma_db;
create user 'pharma_user'@'%' identified by 'password';
grant all privileges on pharma_db.* to 'pharma_user'@'%';
exit;
```

By default mysql-server only allows connections from localhost. We need to change this if we wish to connect remotely (ex. for development purposes)
```
nano /etc/mysql/mysql.conf.d/mysqld.cnf
# Find the option bind-address and change to 0.0.0.0
bind-address = 0.0.0.0
# Save and exit then restart mysql-server
sudo service mysql restart
```

Configure application.properties under /src/main/resources to ensure database connection is setup correctly.
```
spring.datasource.url=jdbc:mysql://localhost:3306/pharma_db
spring.datasource.username=pharma_user
spring.datasource.password=password
```

Usually we would deploy the jar file directly to the server but for demo purposes lets have the server compile the jar as well so it can always be up to date.

Lets clone the project:
```
sudo apt-get install git
# Create code directory under home and clone project
mkdir -p ~/code
cd ~/code
git clone https://github.com/peter-yhc/pharma.git
cd pharma
```

Now lets build it using a local installation of gradle:
```
# First make the gradle wrapper executable
chmod +x ./gradlew

# Then we can download the latest version
./gradlew wrapper

# Finally build the project using the wrapper
./gradlew clean bootjar
```

Run the server
```
java -jar build/lib/pharma-0.0.1-SNAPSHOT.jar
```

## Code tutorials
Setting up JWTs in Spring: https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

## Tips
- Use shift+pgup/pgdown to scroll on the commandline for the server
- Only one instance of the server can connect to the database at a time
- Make sure to port forward 8080 to be able to reach the application if running it inside a virtual machine