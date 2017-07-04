package lio;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class OKHTTP {
    
    int post(String mesa, float valorTotal,int qtdGoiaba, int qtdUva, int qtdLaranja, int qtdManga, float valorGoiaba, float valorUva, float valorLaranja, float valorManga) throws IOException {
        
        int mesaOcupado = 0;
        mesaOcupado = verificarMesa(mesa);
        
        if(mesaOcupado==1){
            return mesaOcupado;
        }
        
        String Goiaba="",Uva="",Laranja="",Manga="", todos="";

        if (qtdGoiaba!=0){
            valorGoiaba = valorGoiaba*100;
            Goiaba = "{\n            \"name\":\"Suco Goiaba\",\n            \"sku\":\"0000001\",\n            \"unit_price\":"+(int)valorGoiaba+",\n            \"quantity\":"+qtdGoiaba+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
        }
        if (qtdUva!=0){
            valorUva = valorUva*100;
            Uva = "{\n            \"name\":\"Suco de Uva\",\n            \"sku\":\"0000010\",\n            \"unit_price\":"+(int)valorUva+",\n            \"quantity\":"+qtdUva+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
        }
        if (qtdLaranja!=0){
            valorLaranja = valorLaranja*100;
            Laranja = "{\n            \"name\":\"Suco de Laranja\",\n            \"sku\":\"0000011\",\n            \"unit_price\":"+(int)valorLaranja+",\n            \"quantity\":"+qtdLaranja+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
        }
        if (qtdManga!=0){
            valorManga = valorManga*100;
            Manga = "{\n            \"name\":\"Suco de Manga\",\n            \"sku\":\"0000100\",\n            \"unit_price\":"+(int)valorManga+",\n            \"quantity\":"+qtdManga+",\n            \"unit_of_measure\":\"EACH\"\n        },\n";
        }

        todos = Goiaba + Uva + Laranja + Manga;

        if (!todos.isEmpty()) todos = todos.substring (0, todos.length() - 2);

        valorTotal = valorTotal*100;
        
     
        gerarAleatorio casa = new gerarAleatorio();
        String casa1 = casa.gerarNumero(8);
        String casa2 = casa.gerarNumero(4);
        String casa3 = casa.gerarNumero(4);
        String casa4 = casa.gerarNumero(4);
        String casa5 = casa.gerarNumero(12);
        
        String corpo = "{\n    \"number\":\""+casa1+"-"+casa2+"-"+casa3+"-"+casa4+"-"+casa5+"\",\n    \"reference\":\"Mesa#"+mesa+"\",\n    \"status\":\"ENTERED\",\n    \"items\":[\n        "+todos+"\n    ],\n    \"notes\":\"Mesa "+mesa+"\",\n    \"price\":"+(int)valorTotal+"\n}";
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, corpo);

        Request request = new Request.Builder()
          .url("https://api.cielo.com.br/order-management/v1/orders")
          .post(body)
          .addHeader("client-id","hmFVzxImJ3r5")
          .addHeader("access-token", "hW0vNhWHvLQd")
          .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
          .addHeader("content-type", "application/json")
          .addHeader("cache-control", "no-cache")
          .addHeader("postman-token", "dfe8fe39-2c24-d825-4096-332ab99178c5")
          .build();

        Response response = client.newCall(request).execute();
        put(response);
        return mesaOcupado;
    }
    
    int verificarMesa(String mesa) throws IOException{
        
        int ocupado=0;
        
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.cielo.com.br/order-management/v1/orders")
        .get()
        .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
        .addHeader("client-id","hmFVzxImJ3r5")
        .addHeader("access-token", "hW0vNhWHvLQd")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "5d156cf1-448c-d4a1-f8fd-ae507e1546e8")
        .build();

        Response response = client.newCall(request).execute();

        String resposta = response.body().string();

        JSONArray ja = new JSONArray(resposta);  
        int n = ja.length();

            for (int i = 0; i < n; i++) {

                    JSONObject jo = ja.getJSONObject(i);
                    String status = jo.getString("status");

                    if("ENTERED".equals(status) || "PAID".equals(status) || "RE_ENTERED".equals(status)){
                        String reference = jo.getString("reference");
                        if (reference == null ? "Mesa#"+mesa == null : reference.equals("Mesa#"+mesa)){
                            ocupado=1;
                        }   
                    }   
            }
        
        return ocupado;
    }


    void put(Response responsePost) throws IOException {

        OkHttpClient client = new OkHttpClient();

        String resposta = responsePost.body().string();

        if (!resposta.isEmpty()) resposta = resposta.substring (7, resposta.length() - 2);

        String urlPut = "https://api.cielo.com.br/order-management/v1"+resposta+"?operation=PLACE";

        MediaType mediaType = MediaType.parse("");
        RequestBody body = RequestBody.create(mediaType, "");

        Request request = new Request.Builder()
        .url(urlPut)
        .put(body)
        .addHeader("client-id","hmFVzxImJ3r5")
        .addHeader("access-token", "hW0vNhWHvLQd")
        .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
        .addHeader("content-type", "application/json")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "dfe8fe39-2c24-d825-4096-332ab99178c5")
        .build();

        Response response = client.newCall(request).execute();
    }

    List<String> getOrders() throws IOException{

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.cielo.com.br/order-management/v1/orders")
        .get()
        .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
        .addHeader("client-id","hmFVzxImJ3r5")
        .addHeader("access-token", "hW0vNhWHvLQd")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "5d156cf1-448c-d4a1-f8fd-ae507e1546e8")
        .build();

        Response response = client.newCall(request).execute();

        String resposta = response.body().string();

        JSONArray ja = new JSONArray(resposta);  
        int n = ja.length();

        List<String> lista = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                    //System.out.println(ja);
                    JSONObject jo = ja.getJSONObject(i);
                    String status = jo.getString("status");

                    if("ENTERED".equals(status) || "RE_ENTERED".equals(status)){
                        String reference = jo.getString("reference");
                    //    reference = reference.substring (5, reference.length());
                     //   reference = ("Mesa "+reference);
                        lista.add(reference);
                    }   
            }
        return lista;  
    }
    
    List<pedidoAberto> getOrders2() throws IOException{

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.cielo.com.br/order-management/v1/orders")
        .get()
        .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
        .addHeader("client-id","hmFVzxImJ3r5")
        .addHeader("access-token", "hW0vNhWHvLQd")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "5d156cf1-448c-d4a1-f8fd-ae507e1546e8")
        .build();

        Response response = client.newCall(request).execute();

        String resposta = response.body().string();

        JSONArray ja = new JSONArray(resposta);  
        int n = ja.length();

        List<pedidoAberto> lista = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                    JSONObject jo = ja.getJSONObject(i);
                    String status = jo.getString("status");

                    if("ENTERED".equals(status) || "RE_ENTERED".equals(status)){
                        int price = jo.getInt("price");
                        String reference = jo.getString("reference");
                        String id = jo.getString("id");
                        String number = jo.getString("number");
                        JSONArray transactions = jo.getJSONArray("transactions");
                        pedidoAberto p = new pedidoAberto(status ,price, reference, id, number,transactions);
                        lista.add(p);
                    }   
            }
        return lista;  
    }
    
/*    void delete(String id) throws IOException{
              
        OkHttpClient client = new OkHttpClient();
        System.out.println(id);

        Request request = new Request.Builder()
        .url("https://cielo-order-manager.m4u.com.br/api/v2/orders/"+id)
        .delete()
        .addHeader("merchant-id", "26069f94-c2d1-4813-81cb-649ab934833d")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "1e5b3aeb-411e-5af6-52a9-90a7333d097a")
        .build();

        Response response = client.newCall(request).execute();
    }
*/
    
    List<transacao1> get() throws IOException{
    
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://api.cielo.com.br/sandbox/extrato/v1/transacoes?codigoEstabelecimento=12345678&dataInicio=2016-11-20T13:13&dataFim=2016-12-20T13:13")
        .get()
        .addHeader("client_id", "yaBHuxSIjZtW")
        .addHeader("access_token","f9lL6RcLxjJ5")
        .addHeader("codigoEstabelecimento", "12345678")
        .addHeader("dataInicio", "2016-11-20T13:13")
        .addHeader("dataFim", "2016-12-20T13:13")
        .build();

        Response response = client.newCall(request).execute();
        String resposta = response.body().string();
        JSONObject jsonObj = new JSONObject(resposta);
        JSONArray jsonMainArr = jsonObj.getJSONArray("transacoes");
        List<transacao1> lista = new ArrayList<>();
        for (int i = 0; i < jsonMainArr.length(); i++) {
            
            boolean eventoPagamento=false;
            boolean eventoCancelamento=false;
            boolean eventoOperacaoARV=false;
            boolean eventoContestacao=false;
            
            JSONObject jo = jsonMainArr.getJSONObject(i);
                    
            Set keys = jo.keySet();
            Iterator a = keys.iterator();
            
                while(a.hasNext()) {
                    String key = (String)a.next();
                    if("eventoPagamento".equals(key)){
                        eventoPagamento=true;
                    }
                    if("eventoCancelamento".equals(key)){
                        eventoCancelamento=true;
                    }
                    if("eventoOperacaoARV".equals(key)){
                        eventoOperacaoARV=true;
                    }
                    if("eventoContestacao".equals(key)){
                        eventoContestacao=true;
                    }  
                }
                
                    JSONArray eventoPagamentoAry = new JSONArray();
                    JSONArray eventoCancelamentoAry = new JSONArray();
                    JSONArray eventoOperacaoARVAry = new JSONArray();
                    JSONArray eventoContestacaoAry = new JSONArray();
                    
                    if(eventoPagamento==true)
                        eventoPagamentoAry = jo.getJSONArray("eventoPagamento");
                    if(eventoCancelamento==true)
                        eventoCancelamentoAry = jo.getJSONArray("eventoCancelamento");
                    if(eventoOperacaoARV==true)
                        eventoOperacaoARVAry = jo.getJSONArray("eventoOperacaoARV");
                    if(eventoContestacao==true)
                        eventoContestacaoAry = jo.getJSONArray("eventoContestacao");
  
                    JSONObject eventoOBJ = jo.getJSONObject("evento");
                    String nsu = jo.getString("nsu");
                    double valorBruto = jo.getDouble("valorBruto");
                    double valorDescontado = jo.getDouble("valorDescontado");
                    double valorLiquido = jo.getDouble("valorLiquido");
                    String data = jo.getString("dataCaptura");
                    String tipoPagamento = jo.getString("tipoPagamento");
                    String formaPagamento = jo.getString("formaPagamento");
                    String bandeira = jo.getString("codigoBandeira");

                    transacao1 transcaoAtual = new transacao1 (nsu,data,valorBruto,valorDescontado,valorLiquido,tipoPagamento,formaPagamento,bandeira,eventoPagamento,eventoCancelamento,eventoOperacaoARV,eventoContestacao,eventoOBJ,eventoPagamentoAry,eventoCancelamentoAry,eventoOperacaoARVAry,eventoContestacaoAry);
                    lista.add(transcaoAtual);
            }
        return lista; 
    }

    
}