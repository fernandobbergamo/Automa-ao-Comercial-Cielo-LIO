package lio;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class transacao1 { 
    
    String NSU, data, tipoPagamento, formaPagamento, bandeira;
    double valorBruto, valorDescontado, valorLiquido;
    
    String nomeEvento, codigoEvento, tipoMovimento, dataEvento;
    int codigoTipoMovimento;
    
    boolean eventoPagamento, eventoCancelamento, eventoOperacaoARV, eventoContestacao; 
    JSONObject eventoObj;  
    JSONArray eventoPagamentoAry, eventoCancelamentoAry, eventoOperacaoARVAry, eventoContestacaoAry;
    
    int tamanhoEventoPagamento, tamanhoEventoCancelamento, tamanhoEventoOperacaoARV, tamanhoEventoContestacao;
    
    List<eventoPagamento> listaEventoPagamento;
    List<eventoCancelamento> listaEventoCancelamento;
    List<eventoOperacaoARV> listaEventoOperacaoARV;
    List<eventoContestacao> listaEventoContestacao;
    
    
    transacao1(String NSU, String data, double valorBruto, double valorDescontado, double valorLiquido, String tipoPagamento, String formaPagamento, String bandeira, boolean eventoPagamento, boolean eventoCancelamento, boolean eventoOperacaoARV, boolean eventoContestacao,JSONObject eventoObj, JSONArray eventoPagamentoAry, JSONArray eventoCancelamentoAry, JSONArray eventoOperacaoARVAry, JSONArray eventoContestacaoAry) {
        this.NSU=NSU;
        this.data=data;
        this.valorDescontado=valorDescontado;
        this.valorLiquido=valorLiquido;
        this.valorBruto=valorBruto;
        this.formaPagamento=formaPagamento;
        this.tipoPagamento=tipoPagamento;
        this.bandeira=bandeira;
        
        this.eventoPagamento=eventoPagamento;
        this.eventoCancelamento=eventoCancelamento;
        this.eventoOperacaoARV=eventoOperacaoARV;
        this.eventoContestacao=eventoContestacao;
        
        this.eventoObj=eventoObj;

        tamanhoEventoPagamento=tamanhoEventoCancelamento=tamanhoEventoOperacaoARV=tamanhoEventoContestacao=0;

        abrirEvento();
        
        if(eventoPagamento==true){
            this.eventoPagamentoAry=eventoPagamentoAry;
            tamanhoEventoPagamento = getTamanhoJSONArray(eventoPagamentoAry);
            listaEventoPagamento = new ArrayList<>();
            abrirEventoPagamento();
        }
        if(eventoCancelamento==true){
            this.eventoCancelamentoAry=eventoCancelamentoAry;
            tamanhoEventoCancelamento = getTamanhoJSONArray(eventoCancelamentoAry);
            listaEventoCancelamento = new ArrayList<>();
            abrirEventoCancelamento();
        }
        if(eventoOperacaoARV==true){
            this.eventoOperacaoARVAry=eventoOperacaoARVAry;
            tamanhoEventoOperacaoARV = getTamanhoJSONArray(eventoOperacaoARVAry);
            listaEventoOperacaoARV = new ArrayList<>();
            abrirEventoOperacaoARV();
        }
        if(eventoContestacao==true){
            this.eventoContestacaoAry=eventoContestacaoAry;     
            tamanhoEventoContestacao = getTamanhoJSONArray(eventoContestacaoAry);
            listaEventoContestacao = new ArrayList<>();
            abrirEventoContestacao();
        }

    }
    
    void abrirEvento(){
        nomeEvento=eventoObj.getString("nomeEvento");
        codigoEvento=eventoObj.getString("codigoEvento");
        tipoMovimento=eventoObj.getString("tipoMovimento");
        codigoTipoMovimento=eventoObj.getInt("codigoTipoMovimento");
        dataEvento=eventoObj.getString("dataEvento");
    }
    
    int getTamanhoJSONArray(JSONArray evento){
        int tamanho = evento.length();
        return tamanho;
    }
    
    void abrirEventoPagamento(){
        for (int i = 0; i < tamanhoEventoPagamento; i++) {
            
            JSONObject jo = eventoPagamentoAry.getJSONObject(i);

            String statusPagamento = jo.getString("statusPagamento");
            String banco = jo.getString("banco");
            String contaCorrente = jo.getString("contaCorrente");
            String agencia = jo.getString("agencia");
            String dataEventoPagamento = jo.getString("dataEvento");

            eventoPagamento eventoAtual = new eventoPagamento (statusPagamento, banco, contaCorrente, agencia, dataEventoPagamento);
            listaEventoPagamento.add(eventoAtual);
        }
    }
    
    void abrirEventoCancelamento(){
        for (int i = 0; i < tamanhoEventoCancelamento; i++) {
            
            JSONObject jo = eventoCancelamentoAry.getJSONObject(i);

            String codigoCancelamento = jo.getString("codigoCancelamento");
            String dataSolicitacaoCancelamento = jo.getString("dataSolicitacaoCancelamento");
            String motivoCancelamento = jo.getString("motivoCancelamento");
            String dataEventoCancelamento = jo.getString("dataEvento");

            eventoCancelamento eventoAtual = new eventoCancelamento (codigoCancelamento, dataSolicitacaoCancelamento, motivoCancelamento, dataEventoCancelamento);
            listaEventoCancelamento.add(eventoAtual);
        }
    }
    
    void abrirEventoOperacaoARV(){
        for (int i = 0; i < tamanhoEventoOperacaoARV; i++) {
            
            JSONObject jo = eventoOperacaoARVAry.getJSONObject(i);

            String codigoOperacaoARV = jo.getString("codigoOperacaoARV");
            String dataOperacaoARV = jo.getString("dataOperacaoARV");
            String dataPagamentoCreditoOperacaoARV = jo.getString("dataPagamentoCreditoOperacaoARV");
            String dataEvento = jo.getString("dataEvento");
            Double valorBrutoOperacaoARV = jo.getDouble("valorBrutoOperacaoARV");
            Double taxaOperacaoARV = jo.getDouble("taxaOperacaoARV");
            Double valorDescontoOperacaoARV = jo.getDouble("valorDescontoOperacaoARV");
            Double valorLiquidoOperacaoARV = jo.getDouble("valorLiquidoOperacaoARV");

            eventoOperacaoARV eventoAtual = new eventoOperacaoARV (codigoOperacaoARV, dataOperacaoARV, dataPagamentoCreditoOperacaoARV, dataEvento,valorBrutoOperacaoARV,taxaOperacaoARV,valorDescontoOperacaoARV,valorLiquidoOperacaoARV);
            listaEventoOperacaoARV.add(eventoAtual);
        }
    }
   
    void abrirEventoContestacao(){
        for (int i = 0; i < tamanhoEventoContestacao; i++) {
            
            JSONObject jo = eventoContestacaoAry.getJSONObject(i);

            String codigoContestacao = jo.getString("codigoContestacao");
            String dataContestacao = jo.getString("dataContestacao");
            String codigoMotivoContestacao = jo.getString("codigoMotivoContestacao");
            String motivoContestacao = jo.getString("motivoContestacao");

            eventoContestacao eventoAtual = new eventoContestacao (codigoContestacao, dataContestacao, codigoMotivoContestacao, motivoContestacao);
            listaEventoContestacao.add(eventoAtual);
        }
    }

}