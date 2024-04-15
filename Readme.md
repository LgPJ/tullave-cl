# Ejecutar el proyecto tullave-cl con Docker

Este proyecto utiliza Docker para su ejecución. Asegúrate de tener Docker instalado en tu máquina antes de comenzar.

## Pasos para ejecutar el proyecto

1. Clona el repositorio:

   ```sh
   git clone https://github.com/LgPJ/tullave-cl.git
   
2. Navega al directorio del proyecto:

   ```sh
   cd tullave-cl

3. Construye el proyecto con Maven:

   ```sh
    mvn clean package

4. Construye las imágenes de Docker

   ```sh
   docker-compose build

5. Levanta los contenedores:

   ```sh
   docker-compose up

6. Accede al proyecto en tu navegador:

   ```sh
    http://localhost:8080/api/cl/card/information?cardNumber=tu-numero-de-tarjeta


7. Detén los contenedores cuando hayas terminado:

   ```sh
    docker-compose down