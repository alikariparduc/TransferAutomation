package org.example.Request;
import org.example.Methods.RandomIMEI;

import java.util.UUID;

public class RequestBody {

    public static String createTransactionRequest()
    {
        String randomRequestId = UUID.randomUUID().toString(); // Rastgele requestId oluştur
        //String randomIMEI = RandomIMEI.generateRandomIMEI();

       return "{\n" +
                "    \"transferBase\": {\n" +
                "        \"requestId\": \"11111111111\",\n" +
                "        \"note\": \"\",\n" +
                "        \"sourceStore\": {\n" +
                "            \"storeCode\": \"S349900-01\",\n" +
                "            \"isVirtualStore\": false,\n" +
                "            \"storeName\": \"sabahattin karafırtınalar\",\n" +
                "            \"realStoreCode\": \"S349900-01\"\n" +
                "        },\n" +
                "        \"targetStore\": {\n" +
                "            \"storeCode\": \"S349900-10\",\n" +
                "            \"isVirtualStore\": false,\n" +
                "            \"storeName\": \"Brn İletişim İnşaat Sanayi Ve Ticaret Ltd. Şti.\",\n" +
                "            \"realStoreCode\": \"S349900-03\"\n" +
                "        },\n" +
                "        \"senderEmployeeNo\": \"17063970744\",\n" +
                "        \"senderEmployeeProfileCode\": \"VP121122\"\n" +
                "    },\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"name\": \"Samsung Galaxy S21 128GB Beyaz\",\n" +
                "            \"sku\": \"SA00885\",\n" +
                "            \"barcode\": \"8806092114388\",\n" +
                "            \"offerType\": \"CAMPAIGN\",\n" +
                "            \"requiredQuantity\": 1,\n" +
                "            \"imei\": \"105698503895187\",\n" +
                "            \"segmentName\": \"YNA&IOT\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }


}
