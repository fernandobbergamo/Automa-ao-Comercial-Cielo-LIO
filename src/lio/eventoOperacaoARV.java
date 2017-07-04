package lio;

public class eventoOperacaoARV {           

    String codigoOperacaoARV, dataOperacaoARV, dataPagamentoCreditoOperacaoARV, dataEvento;
    double valorBrutoOperacaoARV,taxaOperacaoARV,valorDescontoOperacaoARV, valorLiquidoOperacaoARV;
    
    eventoOperacaoARV(String codigoOperacaoARV, String dataOperacaoARV, String dataPagamentoCreditoOperacaoARV, String dataEvento, double valorBrutoOperacaoARV, double taxaOperacaoARV,double valorDescontoOperacaoARV, double valorLiquidoOperacaoARV){
        this.codigoOperacaoARV=codigoOperacaoARV;
        this.dataOperacaoARV=dataOperacaoARV;
        this.dataPagamentoCreditoOperacaoARV=dataPagamentoCreditoOperacaoARV;
        this.dataEvento=dataEvento;
        this.valorBrutoOperacaoARV=valorBrutoOperacaoARV;
        this.taxaOperacaoARV=taxaOperacaoARV;
        this.valorDescontoOperacaoARV=valorDescontoOperacaoARV;
        this.valorLiquidoOperacaoARV=valorLiquidoOperacaoARV;
    }
}
