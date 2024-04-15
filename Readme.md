# Ejecutar el proyecto tullave-cl con Docker

Este proyecto utiliza Docker para su ejecución. Asegúrate de tener Docker instalado en tu máquina antes de comenzar.

## Pasos para ejecutar el proyecto

1. Clona el repositorio:

   ```sh
   git clone https://github.com/LgPJ/tullave-cl.git
   
**Navega al directorio del proyecto:**

cd tullave-cl

**Construye el proyecto con Maven:**

mvn clean package

**Construye las imágenes de Docker:**

docker-compose build

**Levanta los contenedores:**

docker-compose up

**Accede al proyecto en tu navegador:**

http://localhost:8080/api/cl/card/information?cardNumber=tu-numero-de-tarjeta


**Detén los contenedores cuando hayas terminado:**

docker-compose down