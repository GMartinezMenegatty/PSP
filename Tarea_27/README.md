# Comunicación cliente-servidor UDP

### Gabriela Martínez Menegatty

## 1. Descripción

Esta práctica consiste en desarrollar una aplicación
cliente-servidor utilizando el protocolo UDP.

El cliente enviará varias palabras al servidor y este
devuelve la palabra más larga junto con su longitud.

## 2. Formato de los mensajes

Para recibir las palabras, se escribirán con comas de por medio.

**Ejemplo de envío:**

```
hola,programacion,java,ordenador
```

El servidor utiliza `split(",")` para separar las
palabras y `length()` para comprobar sus longitudes.

**Ejemplo de respuesta:**

```
Palabra más larga: programacion
Longitud: 12
```

En caso de empate, se devuelve la primera palabra.

## 3. Funcionamiento del servidor

- Escucha las peticiones en el puerto `5555`.
- Recibe las palabras mediante `DatagramPacket`.
- Busca la palabra más larga.
- Calcula su longitud.
- Obtiene la dirección IP y el puerto del cliente
  mediante `getAddress()` y `getPort()`.
- Envía la respuesta al cliente.

## 4. Funcionamiento del cliente

- Solicita varias palabras separadas por comas.
- Envía las palabras al servidor mediante UDP.
- Espera un máximo de 2 segundos.
- Realiza hasta 3 intentos si no recibe respuesta.
- Si no recibe respuesta, muestra el mensaje
  **Servidor_tcp no disponible** y finaliza.

Para controlar el tiempo de espera se utiliza:

```
socket.setSoTimeout(2000);
```

La excepción `SocketTimeoutException` permite
detectar que el servidor no ha respondido.

## 5. Pruebas de funcionamiento

### Prueba 1: Servidor_tcp disponible

**Entrada:**

```
hola,programacion,java
```

**Salida esperada:**

```
Intento 1
Palabra más larga: programacion
Longitud: 12
```

### Prueba 2: Servidor_tcp no disponible

Se ejecuta el cliente sin arrancar el servidor.

**Salida esperada:**

```
Intento 1
Tiempo de espera agotado.
Intento 2
Tiempo de espera agotado.
Intento 3
Tiempo de espera agotado.
Servidor_tcp no disponible
```

Se realiza un envío inicial y tres reintentos.

## 6. Instrucciones de ejecución

1. Ejecutar `Servidor_tcp`.
2. Ejecutar `Cliente`.
3. Introducir las palabras separadas por comas.
4. Comprobar la respuesta del servidor.
5. Detener el servidor.
6. Ejecutar nuevamente el cliente para comprobar
   los reintentos.

### 7. Uso de IA

Se usó ChatGPT para la organización del README.