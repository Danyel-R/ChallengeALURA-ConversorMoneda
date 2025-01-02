import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {

    // URL de la API de ExchangeRate. Reemplaza YOUR_API_KEY con tu clave de API.
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/8fcc1b2de3ec81936b3df37b/latest/USD";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de monedas y sus nombres
        String[] currencies = {"USD", "MXN", "BRL", "ARS", "CLP", "COP", "PEN", "VEF"};
        String[] currencyNames = {"Dólar Estadounidense", "Peso Mexicano", "Real Brasileño", "Peso Argentino", "Peso Chileno", "Peso Colombiano", "Sol Peruano", "Bolívar Venezolano"};

        while (true) {
            System.out.println("Seleccione la moneda de origen:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencyNames[i]);
            }
            System.out.println("9. Salir");

            int originChoice = scanner.nextInt();
            if (originChoice == 9) {
                break;
            }

            if (originChoice < 1 || originChoice > 8) {
                System.out.println("Opción no válida. Intente de nuevo.");
                continue;
            }

            String originCurrency = currencies[originChoice - 1];

            System.out.println("Seleccione la moneda de destino:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencyNames[i]);
            }

            int destChoice = scanner.nextInt();
            if (destChoice < 1 || destChoice > 8) {
                System.out.println("Opción no válida. Intente de nuevo.");
                continue;
            }

            String destCurrency = currencies[destChoice - 1];

            System.out.println("Ingrese la cantidad en " + currencyNames[originChoice - 1] + ":");
            double amount = scanner.nextDouble();

            try {
                double convertedAmount = convertCurrency(originCurrency, destCurrency, amount);
                System.out.println(amount + " " + currencyNames[originChoice - 1] + " es igual a " + convertedAmount + " " + currencyNames[destChoice - 1]);
            } catch (Exception e) {
                System.out.println("Error al convertir la divisa: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double convertCurrency(String originCurrency, String destCurrency, double amount) throws Exception {
        // Crear la URL para la solicitud a la API
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        // Parsear el JSON utilizando Gson
        JsonElement jsonElement = JsonParser.parseString(content.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Obtener las tasas de cambio para las monedas de origen y destino
        double originRate = rates.get(originCurrency).getAsDouble();
        double destRate = rates.get(destCurrency).getAsDouble();

        // Realizar la conversión
        return (amount / originRate) * destRate;
    }
}
