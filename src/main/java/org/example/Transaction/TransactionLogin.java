package org.example.Transaction;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TransactionLogin {
    public static String getToken() {
        // Token almak için kullanılacak URL
        String url = "http://stock-rsmnsaddev.apps.mbt.vodafone.local/services/auth/api/login";

        // JSON gövdesi
        String jsonBody = "{\n" +
                "    \"username\": \"DealerHAltuntas5\",\n" +
                "    \"password\": \"X089347\"\n" +
                "}";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // HTTP POST isteği oluştur
            HttpPost httpPost = new HttpPost(url);

            // JSON verisini ekleyin
            StringEntity entity = new StringEntity(jsonBody);
            httpPost.setEntity(entity);

            // Content-Type başlığını ekleyin
            httpPost.setHeader("Content-Type", "application/json");

            // İstek gönder
            HttpResponse response = httpClient.execute(httpPost);

            // Yanıtı işle
            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity);

            // JSON yanıtını işle
            JSONObject jsonResponse = new JSONObject(responseString);

            // Yanıtta dönen tokeni alın
            String accessToken = jsonResponse.getJSONObject("data").getString("accessToken");

            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
