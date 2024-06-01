import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Peticion {
    //La api con el metodo http clinte
    public ConvercionDePeticio buscadorMonedas(String idDeMoneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/36977fdd71968f6a56c1d669/latest/" + idDeMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        /*
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), VolverResultado.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al realizar la solicitud HTTP", e);
        }

         */
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Verificar si la respuesta contiene un mensaje de error
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            if (jsonResponse.has("error")) {
                throw new RuntimeException("Error en la respuesta de la API: " + jsonResponse.get("error").getAsString());
            }
            return new Gson().fromJson(response.body(), ConvercionDePeticio.class);
        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al realizar la solicitud HTTP", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al procesar la respuesta JSON", e);
        }
    }
}

