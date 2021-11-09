# Vaadin-Flow-OLATAM
Proyecto de Ejemplo Oracle LATAM - Vaadin Flow CDI - Oracle Database
# Project Base for Vaadin Flow and CDI

# HERRAMEINTAS
1. Oracle Database
2. Maven
3. JDK 1.8 o Superior
4. Para Desarrollo (node.js)
This project can be used as a starting point to create your own Vaadin Flow application with CDI.
It contains all the necessary configuration and some placeholder files to get you started.

# TECNOLOGÍA
1. JPA
2. CDI
3. JTA
4. Vaadin Flow 14
5. TomEE


# Para ejecutar el Proyecto
1. Crear la Bases de Datos Oracle 11g o Superior.
2. Configurar las credenciales de conexión en resources.xml
3. mvn clean
4. mvn install
5. mvn tomee:run

## Running the Application

Import the project to the IDE of your choosing as a Maven project. 

El Aplicativo se lanzará en el Puerto 8080.
Run application using
```
mvn clean package tomee:run
```

localhost:8080/index
Open [http://localhost:8080/](http://localhost:8080/) in browser.

The best way to use it is via [vaadin.com/start](https://vaadin.com/start) 
