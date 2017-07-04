package lio;

public class eventoCancelamento {
    
    String codigoCancelamento, dataSolicitacaoCancelamento, motivoCancelamento, dataEvento;
    
    eventoCancelamento(String codigoCancelamento, String dataSolicitacaoCancelamento, String motivoCancelamento, String dataEvento){
        this.codigoCancelamento=codigoCancelamento;
        this.dataSolicitacaoCancelamento=dataSolicitacaoCancelamento;
        this.motivoCancelamento=motivoCancelamento;
        this.dataEvento=dataEvento;
    }
}
