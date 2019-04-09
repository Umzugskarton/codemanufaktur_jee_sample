# Jee_sample

Ein Code Beispiel zu JavaEE mit Java Server Faces 

# Build .war
Um das Projekt zu erstellen muss lediglich die .war-Datei mittels der build.gradle generiert werden.


# Docker Server 

Im Projektordner befindet sich zusätzlich ein Dockerfile und ein Docker-compose .yml welche einen schon für das Projekt konfigurierten Payara Server aufsetzen. 

Hierfür per docker build den Docker-Container erstellen
```
docker build --tag=my-payara-project .
```


Per docker-compose den Server starten

```
docker-compose up
```

Der Server ist nun unter der Docker-Container IP erreichbar auf dem `Port: 4848` befindet sich der Admin-Bereich des Servers. Standardmäßig ist ein Adminbenutzer bereits angelegt `Benutzername: admin , Passwort: admin`. 
Auf dem `Port: 8080` ist die JEE Applikation zu finden.
