package lio;

public class eventoPagamento {
    
    String statusPagamento, banco, contaCorrente, agencia, dataEvento;
    
    eventoPagamento(String statusPagamento, String banco, String contaCorrente, String agencia, String dataEvento ){
    
        this.statusPagamento=statusPagamento;
        this.banco=banco;
        this.contaCorrente=contaCorrente;
        this.agencia=agencia;
        this.dataEvento=dataEvento;
    }
}
