package org.example.Transaction;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.Request.RequestBody;

import java.io.Console;
import java.io.PrintWriter;


public class TransactionCrate {

    public static void Crated(){
        // Transfer oluşturmak için kullanılacak URL
        String url = "http://stock-rsmnsaddev.apps.mbt.vodafone.local/services/transfer/create/";

        // JSON gövdesi
        String jsonBody = RequestBody.createTransactionRequest();

        // Token
        String token= TransactionLogin.getToken();
        //String token =  "eyJhbGciOiJIUzUxMiJ9.QmVhcmVyIGV5SmxibU1pT2lKQk1qVTJRMEpETFVoVE5URXlJaXdpWVd4bklqb2laR2x5SW4wLi54bFk3Zi1MclpqS2tsOVE5MXdtY253LnFSVmgtbVhvbThBZXlGb28xbGN4T3dZQXVlb3o3RkVla1RaNVZzaXdPZDBtZ24wMkFDaDZyaHpIY3Y3LXIxeUFaZmN4UFBvTjNnRnpvSVJhbEJRR1ZNSkdIa2F3Z0lmejBJZDhpaV9aY1RHVzVTSUdNX0RtZnlVY2dURDFIcmpha3BLdmJHNUVsUjVoV00tanNuSEk4LUVIekh4X2pwS01zbU5fNDVHZFM5N1JtektVWWpmOHB3Qk1qQXJ4N2hoYjFNa0V4WnZXVU5CWUtzOXhFa2NjOHhqT2xYUHViM0E5d2dYdE5SRUFUVVlETlVuN2RyLVpSM2U2dWctUjVWemNjQkFOT2ZacS1PR0lIcTdOVmZ4QWZWUENobFZzb29zTHNieUN0ZmRZYllDaWRfT0VXd2ItbzVRdTFBb2dDeG5nU2dudVlxYjBUcVRQT2EzMmFuZVE2dUYyc2hkQVNUV0ptTFRvcDdJRzdrbWFPbmhYVmxSdVVPQWFWdGJMc2otOEVXM1d4bThvRVFMX2ZoSFNuYUhzTENBQnFjRktvSG1Vb1NEaWpVaXN1dXBiSTR0eHlHWktMYTQ4SXJFdlRlMVFWVTZLamdSb3duc2tJNGlGdVB6UE1lYUs5UWJxSWlhYXpfNHdGVm12eklCNlpUdTd1andsbzlDNUtKbUQwTmZtOEZiTkxuWmhHSlp5c184cDQ1WHktQUpGTE9pU3g4VWptUm02RjNrNnVVdFVkeWt2amswWVRtYmd1QlhSdXl5aG9HY1RZSFFkOGVhcG5MS2NVbGt0cEhGdUFXeHowYlE5ZVJoMFZVRFR2S1ZtREp2bFFEN0RrSmJQY2lDem5kdmZtbUp3Mk56WUJRQUdRajhqRWM0Z3d4N3lVRHJZUmpqWC1zVnYzTlljdTZ4Rm5qaG1VdDctNFNWX0M5VlJIalZyb0ZJMVNJYWcyR1Y1b3k5dVVSUlVlOWpJWmNiSDFIT2RzXzh4OGxyUFk2TDlaZF9rVkIwUURqZmlkY1VwVEZ0OHQwS0N2d2V5aDNMU1VTNmprSDFVZDhmY1J2Qk4yWmwzbUsxckNBeDc1M0RTdnpZbjFXR3lzZTBGSURzNWI3cnRMTVpLTEJwb2p0NklNbXpJTzJGSWVDZlR3dFFXd21CR0JJSmY2WFVRT0V6Zk9hTGYwa05LWThsZFktcnQ2OWxoX29GLVk2X1ppcG9wZ0MzNjJlWjJRUGMwUmFQc3g1bkhGb25YcDF2Y3lIRURRYUtCczhvakF0TnZOdWlEMHd0Sk9XcWxmeTk3dl9HSmtiTmR0dF9hV2hMaGI3R1RNVU95WmhMZnVjczJQQXJlclFRLTYyX2MxT0h4ekswNkk4Rm02a2F1Y3ZBdmZxRThFU2xIS2V3Y3BYMkpFQzJTTjJPR3RIdkxrU1VieHBIb3ZjWkZxQ3JnZU84bnlObTBMQXpwZTQyVFgxRU1YM051dmlKVWN5V3lvOW9sWXBzTjZoVld1c1d2bFd0SWFtaXE5TDQ5bG1iT1FTdXBMY2pKZk5ZeUdiYW1ueEZORzYwbWVmY1F3NU53SWcudWxselpZU0xxcmZBQy1OR0k3am52VzE4dHJfbHNPR3RGNEdlVVFhVjAwUQ.LShRnWdz9GAlx_HFWJ7O9LZxwhchmzHcUCCpeDzLg3FY2gDuGVADCm_SFOA5h5ZjjPSBqhLkRtZLbDN9EUvVsg";


        // Kaç transfer göndermek istediğinizi burada belirlenir
        int numberOfTransfers = 5;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            for (int i = 0; i < numberOfTransfers; i++) {
                // HTTP POST isteği oluştur
                HttpPost httpPost = new HttpPost(url);

                // JSON verisini ekleyin
                StringEntity entity = new StringEntity(jsonBody);
                httpPost.setEntity(entity);

                // Content-Type ve Authorization başlıklarını ekleyin
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setHeader("Authorization", "Bearer " + token);

                // İstek gönder
                HttpResponse response = httpClient.execute(httpPost);

                // Yanıtı işle
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println("Transfer #" + (i + 1) + " - HTTP Status Code: " + response.getStatusLine().getStatusCode());
                System.out.println("Transfer #" + (i + 1) + " - Response Body: " + responseString);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("İstisna yönetimi.");
        }
    }
}
