package org.example.Request;

public class RequestBody {

    public static String createTransactionRequest()
    {
       return "{\n" +
                "    \"transferBase\": {\n" +
                "        \"requestId\": \"1f378367-a2a0-424c-ab73-57f28a6e14e4\",\n" +
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
                "            \"name\": \"Apple 20 W USB-C Guc Adaptoru Beyaz Standart\",\n" +
                "            \"sku\": \"SA00885\",\n" +
                "            \"barcode\": \"8806092114388\",\n" +
                "            \"offerType\": \"CAMPAIGN\",\n" +
                "            \"requiredQuantity\": 1,\n" +
                "            \"imei\": \"105747267732647\",\n" +
                "            \"segmentName\": \"YNA&IOT\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }


}
