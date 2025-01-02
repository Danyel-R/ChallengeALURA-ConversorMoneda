# Conversor de Moneda

Esta aplicación permite a los usuarios convertir divisas entre las monedas más importantes de Latinoamérica, incluyendo Estados Unidos y Brasil. La aplicación consume datos de la API ExchangeRate y utiliza la biblioteca Gson para manejar el JSON.

## Características

- Selección de moneda de origen y moneda de destino.
- Ingreso de la cantidad a convertir.
- Conversión de divisas utilizando tasas de cambio actualizadas.
- Interfaz de usuario simple basada en consola.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- Biblioteca Gson.

## Configuración

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/tu-usuario/conversor-de-divisas.git
    cd conversor-de-divisas
    ```

2. **Agregar la biblioteca Gson**:
    - Si estás utilizando Maven, agrega la siguiente dependencia a tu archivo `pom.xml`:
        ```xml
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.8</version>
        </dependency>
        ```
    - Si estás utilizando Gradle, agrega la siguiente línea a tu archivo `build.gradle`:
        ```groovy
        implementation 'com.google.code.gson\:gson:2.8.8'
        ```

3. **Configurar la API Key**:
    - Reemplaza `YOUR_API_KEY` en el archivo `ConversorMonedas.java` con tu clave de API de ExchangeRate.

## Uso

1. **Compilar la aplicación**:
    ```sh
    javac ConversorMonedas.java
    ```

2. **Ejecutar la aplicación**:
    ```sh
    java ConversorMonedas
    ```

3. **Seleccionar las opciones**:
    - Selecciona la moneda de origen.
    - Selecciona la moneda de destino.
    - Ingresa la cantidad a convertir.
    - La aplicación mostrará el resultado de la conversión.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para sugerir mejoras o reportar problemas.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme:
- Email: krearte.app@gmail.com
- GitHub: [Danyel-R](https://github.com/Danyel-R)

---

¡Gracias por usar el Conversor de Divisas!
