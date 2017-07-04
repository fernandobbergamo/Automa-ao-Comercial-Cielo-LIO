package lio;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class tela5 extends JFrame {
    
    private JPanel pnlPrincipal;
    private JLabel ImagemTopoMeio;
    private JTable tabela2;
    private JScrollPane sp2;
    private JTable tabelaEvento;
    private JScrollPane spEvento;
    private JTable tabelaEventoPagamento;
    private JScrollPane spEventoPagamento;
    private JTable tabelaEventoCancelamento;
    private JScrollPane spEventoCancelamento;
    private JTable tabelaEventoOperacaoARV;
    private JScrollPane spEventoOperacaoARV;
    private JTable tabelaEventoContestacao;
    private JScrollPane spEventoContestacao;
    List<transacao1> lista;
    private JButton btnSair;
    int posicaoLista;
    private JLabel titulo;
    private JLabel tituloEvento;
    private JLabel tituloEventoPagamento;
    private JLabel tituloEventoCancelamento;
    private JLabel tituloEventoOperacaoARV;
    private JLabel tituloEventoContestacao;
    private JLabel ImagemBaixo;
    
    tela5(List<transacao1> lista, int posicaoLista) throws IOException {
        super("Cielo Labs - Inovação");
        this.lista = lista;
        this.posicaoLista = posicaoLista;
        initialize();   
    }
 
    private void initialize() throws IOException { 
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(getPnlPrincipal());
        setLayout(null);  
        setResizable(false);
        ImageIcon icone = new ImageIcon("imagens/cielo.png");
        setIconImage(icone.getImage());
    }
 
    private JPanel getPnlPrincipal() throws IOException {
        if (pnlPrincipal == null) {
            pnlPrincipal = new JPanel();
            pnlPrincipal.add(getBtnSair());
            pnlPrincipal.add(getSp2());
            pnlPrincipal.add(getTitulo());
            
            pnlPrincipal.add(getTituloEvento());
            pnlPrincipal.add(getSpEvento());
                       
            if(lista.get(posicaoLista).eventoPagamento==true){
                pnlPrincipal.add(getTituloEventoPagamento());
                pnlPrincipal.add(getSpEventoPagamento());
            }
            if(lista.get(posicaoLista).eventoCancelamento==true){
                pnlPrincipal.add(getTituloEventoCancelamento());
                pnlPrincipal.add(getSpEventoCancelamento());
            }
            if(lista.get(posicaoLista).eventoOperacaoARV==true){
                pnlPrincipal.add(getTituloEventoOperacaoARV());
                pnlPrincipal.add(getSpEventoOperacaoARV());
            }
            if(lista.get(posicaoLista).eventoContestacao==true){
                pnlPrincipal.add(getTituloEventoContestacao());
                pnlPrincipal.add(getSpEventoContestacao());
            }
            pnlPrincipal.add(getImagemBaixo());
            pnlPrincipal.add(getImagemTopoMeio());        
        }
        return pnlPrincipal;
    }
    
        private JLabel getTituloEventoPagamento(){
            if(tituloEventoPagamento == null){
                if(lista.get(posicaoLista).tamanhoEventoPagamento==1)
                    tituloEventoPagamento = new JLabel("Evento Pagamento: "+lista.get(posicaoLista).tamanhoEventoPagamento + " caso");
                else
                    tituloEventoPagamento = new JLabel("Evento Pagamento: "+lista.get(posicaoLista).tamanhoEventoPagamento + " casos");
                tituloEventoPagamento.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
                tituloEventoPagamento.setForeground(BLACK);
                tituloEventoPagamento.setBounds(25, 210,500,200);
            }
        return tituloEventoPagamento;
    }
        
    private JLabel getTituloEventoCancelamento(){
            if(tituloEventoCancelamento == null){
                if(lista.get(posicaoLista).tamanhoEventoCancelamento==1)
                    tituloEventoCancelamento = new JLabel("Evento Cancelamento: "+lista.get(posicaoLista).tamanhoEventoCancelamento + " caso");
                else
                    tituloEventoCancelamento = new JLabel("Evento Cancelamento: "+lista.get(posicaoLista).tamanhoEventoCancelamento + " casos");
                tituloEventoCancelamento.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
                tituloEventoCancelamento.setForeground(BLACK);
                tituloEventoCancelamento.setBounds(25, 390,500,200);
            }
        return tituloEventoCancelamento;
    }
            
    private JLabel getTituloEventoOperacaoARV(){
            if(tituloEventoOperacaoARV == null){
                if(lista.get(posicaoLista).tamanhoEventoOperacaoARV==1)
                    tituloEventoOperacaoARV = new JLabel("Evento Operação ARV: "+lista.get(posicaoLista).tamanhoEventoOperacaoARV + " caso");
                else
                   tituloEventoOperacaoARV = new JLabel("Evento Operação ARV: "+lista.get(posicaoLista).tamanhoEventoOperacaoARV + " casos"); 
                tituloEventoOperacaoARV.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
                tituloEventoOperacaoARV.setForeground(BLACK);
                tituloEventoOperacaoARV.setBounds(25, 300,500,200);
            }
        return tituloEventoOperacaoARV;
    }
                
    private JLabel getTituloEventoContestacao(){
            if(tituloEventoContestacao == null){
                if(lista.get(posicaoLista).tamanhoEventoContestacao==1)
                    tituloEventoContestacao = new JLabel("Evento Contestação: "+lista.get(posicaoLista).tamanhoEventoContestacao + " caso");
                else
                    tituloEventoContestacao = new JLabel("Evento Contestação: "+lista.get(posicaoLista).tamanhoEventoContestacao + " casos");
                tituloEventoContestacao.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
                tituloEventoContestacao.setForeground(BLACK);
                tituloEventoContestacao.setBounds(25, 480,500,200);
            }
        return tituloEventoContestacao;
    }
    
    private JLabel getTituloEvento(){
            if(tituloEvento == null){
                tituloEvento = new JLabel("Evento Autorização");
                tituloEvento.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 30));
                tituloEvento.setForeground(BLACK);
                tituloEvento.setBounds(25, 110,500,200);
        }
        return tituloEvento;
    }
    
    private JLabel getTitulo(){
            if(titulo == null){
                titulo = new JLabel("NSU: "+lista.get(posicaoLista).NSU);
                titulo.setFont(new Font("Exo",Font.ITALIC + Font.BOLD, 45));
                titulo.setForeground(WHITE);
                titulo.setBounds(25, 0,500,200);
        }
        return titulo;
    }
    
    private JButton getBtnSair() {
        if (btnSair == null) {
            ImageIcon ImgSair = new ImageIcon("imagens/voltar.png");
            btnSair = new JButton(ImgSair);
            btnSair.setBounds(1225, 600,135,175);
            btnSair.setContentAreaFilled(false);
            btnSair.setBorderPainted(false);
            btnSair.addActionListener((ActionEvent arg0) -> {
                    dispose();
            });
        }
        return btnSair;
    }
      
    private JScrollPane getSp2() throws IOException {
        if (sp2 == null) {
            sp2 = new JScrollPane(getTbl2());
            sp2.setBounds(tabela2.getBounds());
         }
        return sp2;
    }
    
    private JTable getTbl2() throws IOException {
        if (tabela2 == null) {
            String [] colunas = {"NSU", "VALOR BRUTO","VALOR DESCONTADO","VALOR LIQUIDO","TIPO DE PAGAMENTO", "BANDEIRA", "FORMA DE PAGAMENTO","DATA"};
            Object [][] dados = new Object[1][8];          
            
            String valorBruto = String.format("%.2f", lista.get(posicaoLista).valorBruto);
            String valorDescontado = String.format("%.2f", lista.get(posicaoLista).valorDescontado);
            String valorLiquido = String.format("%.2f", lista.get(posicaoLista).valorLiquido);
            

            dados[0][0]=lista.get(posicaoLista).NSU;
            dados[0][1]=("R$"+valorBruto);
            dados[0][2]=("R$"+valorDescontado);
            dados[0][3]=("R$"+valorLiquido);
            dados[0][4]=lista.get(posicaoLista).tipoPagamento;
            dados[0][5]=lista.get(posicaoLista).bandeira;
            dados[0][6]=lista.get(posicaoLista).formaPagamento;
            dados[0][7]=lista.get(posicaoLista).data.substring(0, lista.get(posicaoLista).data.length() - 14);
               
            tabela2 = new JTable(dados,colunas);
            tabela2.setEnabled(false);
            tabela2.setBounds(0, 150, 1362, 39);
        }
        return tabela2;
    }
    
    private JScrollPane getSpEvento() throws IOException {
        if (spEvento == null) {
            spEvento = new JScrollPane(getTblEvento());
            spEvento.setBounds(tabelaEvento.getBounds());
         }
        return spEvento;
    }
    
    private JTable getTblEvento() throws IOException {
        if (tabelaEvento == null) {
            String [] colunas = {"CÓDIGO","TIPO DE MOVIMENTO","CÓDIGO DO TIPO DE MOVIMENTO","DATA"};
            Object [][] dados = new Object[1][4];                  

            dados[0][0]=lista.get(posicaoLista).codigoEvento;
            dados[0][1]=lista.get(posicaoLista).tipoMovimento;
            dados[0][2]=lista.get(posicaoLista).codigoTipoMovimento;
            dados[0][3]=lista.get(posicaoLista).dataEvento.substring(0, lista.get(posicaoLista).dataEvento.length() - 14);;

               
            tabelaEvento = new JTable(dados,colunas);
            tabelaEvento.setEnabled(false);
            tabelaEvento.setBounds(0, 230, 1362, 39);
        }
        return tabelaEvento;
    }
        private JScrollPane getSpEventoPagamento() throws IOException {
        if (spEventoPagamento == null) {
            spEventoPagamento = new JScrollPane(getTblEventoPagamento());
            spEventoPagamento.setBounds(tabelaEventoPagamento.getBounds());
         }
        return spEventoPagamento;
    }
    
    private JTable getTblEventoPagamento() throws IOException {
        if (tabelaEventoPagamento == null) {
            String [] colunas = {"STATUS", "BANCO","CONTA CORRENTE","AGÊNCIA","DATA"};
            Object [][] dados = new Object[lista.get(posicaoLista).tamanhoEventoPagamento][5];                  
            
            for(int i=0;i<+lista.get(posicaoLista).tamanhoEventoPagamento;i++){ 
                dados[i][0]=lista.get(posicaoLista).listaEventoPagamento.get(i).statusPagamento;
                dados[i][1]=lista.get(posicaoLista).listaEventoPagamento.get(i).banco;
                dados[i][2]=lista.get(posicaoLista).listaEventoPagamento.get(i).contaCorrente;
                dados[i][3]=lista.get(posicaoLista).listaEventoPagamento.get(i).agencia;
                dados[i][4]=lista.get(posicaoLista).listaEventoPagamento.get(i).dataEvento.substring(0, lista.get(posicaoLista).listaEventoPagamento.get(i).dataEvento.length() - 14);
            }
            tabelaEventoPagamento = new JTable(dados,colunas);
            tabelaEventoPagamento.setEnabled(false);
            tabelaEventoPagamento.setBounds(0, 330, 1362, 39);
        }
         return tabelaEventoPagamento;
    }
    
    private JScrollPane getSpEventoCancelamento() throws IOException {
        if (spEventoCancelamento == null) {
            spEventoCancelamento = new JScrollPane(getTblEventoCancelamento());
            spEventoCancelamento.setBounds(tabelaEventoCancelamento.getBounds());
         }
        return spEventoCancelamento;
    }
    
    private JTable getTblEventoCancelamento() throws IOException {
        if (tabelaEventoCancelamento == null) {              
            
            String [] colunas = {"CÓDIGO", "DATA DE SOLICITAÇÃO","MOTIVO","DATA"};
            Object [][] dados = new Object[lista.get(posicaoLista).tamanhoEventoCancelamento][4];                  
            
            for(int i=0;i<+lista.get(posicaoLista).tamanhoEventoCancelamento;i++){ 
                dados[i][0]=lista.get(posicaoLista).listaEventoCancelamento.get(i).codigoCancelamento;
                dados[i][2]=lista.get(posicaoLista).listaEventoCancelamento.get(i).motivoCancelamento;
                dados[i][3]=lista.get(posicaoLista).listaEventoCancelamento.get(i).dataEvento.substring(0, lista.get(posicaoLista).listaEventoCancelamento.get(i).dataEvento.length() - 14);
                dados[i][1]=lista.get(posicaoLista).listaEventoCancelamento.get(i).dataSolicitacaoCancelamento.substring(0, lista.get(posicaoLista).listaEventoCancelamento.get(i).dataSolicitacaoCancelamento.length() - 14);
            }
            tabelaEventoCancelamento = new JTable(dados,colunas);
            tabelaEventoCancelamento.setEnabled(false);
            tabelaEventoCancelamento.setBounds(0, 510, 1362, 39);
        }
        return tabelaEventoCancelamento;
    }
    
    private JScrollPane getSpEventoOperacaoARV() throws IOException {
        if (spEventoOperacaoARV == null) {
            spEventoOperacaoARV = new JScrollPane(getTblEventoOperacaoARV());
            spEventoOperacaoARV.setBounds(tabelaEventoOperacaoARV.getBounds());
         }
        return spEventoOperacaoARV;
    }
    
    private JTable getTblEventoOperacaoARV() throws IOException {
        if (tabelaEventoOperacaoARV == null) {
            String [] colunas = {"CÓDIGO", "DATA DE OPERAÇÃO ARV","DATA DE PAGAMENTO DE CRÉDITO","VALOR BRUTO","TAXA","VALOR DESCONTO","VALOR LÍQUIDO"};
            Object [][] dados = new Object[lista.get(posicaoLista).tamanhoEventoOperacaoARV][7];                  
            
            for(int i=0;i<+lista.get(posicaoLista).tamanhoEventoOperacaoARV;i++){ 
                dados[i][0]=lista.get(posicaoLista).listaEventoOperacaoARV.get(i).codigoOperacaoARV;
                dados[i][1]=lista.get(posicaoLista).listaEventoOperacaoARV.get(i).dataOperacaoARV.substring(0, lista.get(posicaoLista).listaEventoOperacaoARV.get(i).dataOperacaoARV.length() - 14);
                dados[i][2]=lista.get(posicaoLista).listaEventoOperacaoARV.get(i).dataPagamentoCreditoOperacaoARV.substring(0, lista.get(posicaoLista).listaEventoOperacaoARV.get(i).dataPagamentoCreditoOperacaoARV.length() - 14);
                String valorBruto = String.format("%.2f", lista.get(posicaoLista).listaEventoOperacaoARV.get(i).valorBrutoOperacaoARV);
                dados[i][3]=("R$"+valorBruto);
                String taxa = String.format("%.2f", lista.get(posicaoLista).listaEventoOperacaoARV.get(i).taxaOperacaoARV);
                dados[i][4]=(taxa+"%");
                String valorDesconto = String.format("%.2f", lista.get(posicaoLista).listaEventoOperacaoARV.get(i).valorDescontoOperacaoARV);
                dados[i][5]=("R$"+valorDesconto);
                String valorLiquido = String.format("%.2f", lista.get(posicaoLista).listaEventoOperacaoARV.get(i).valorLiquidoOperacaoARV);
                dados[i][6]=("R$"+valorLiquido);
            }
            tabelaEventoOperacaoARV = new JTable(dados,colunas);
            tabelaEventoOperacaoARV.setEnabled(false);
            tabelaEventoOperacaoARV.setBounds(0, 420, 1362, 39);
        }
        return tabelaEventoOperacaoARV;
    }
    
    private JScrollPane getSpEventoContestacao() throws IOException {
        if (spEventoContestacao == null) {
            spEventoContestacao = new JScrollPane(getTblEventoContestacao());
            spEventoContestacao.setBounds(tabelaEventoContestacao.getBounds());
         }
        return spEventoContestacao;
    }
    
    private JTable getTblEventoContestacao() throws IOException {
        if (tabelaEventoContestacao == null) {
            String [] colunas = {"CÓDIGO", "CÓDIGO MOTIVO","MOTIVO","DATA"};
            Object [][] dados = new Object[lista.get(posicaoLista).tamanhoEventoContestacao][4];                  
            
            for(int i=0;i<+lista.get(posicaoLista).tamanhoEventoContestacao;i++){ 
                dados[i][0]=lista.get(posicaoLista).listaEventoContestacao.get(i).codigoContestacao;
                dados[i][3]=lista.get(posicaoLista).listaEventoContestacao.get(i).dataContestacao.substring(0, lista.get(posicaoLista).listaEventoContestacao.get(i).dataContestacao.length() - 14);
                dados[i][1]=lista.get(posicaoLista).listaEventoContestacao.get(i).codigoMotivoContestacao;
                dados[i][2]=lista.get(posicaoLista).listaEventoContestacao.get(i).motivoContestacao;
            }
               
            tabelaEventoContestacao = new JTable(dados,colunas);
            tabelaEventoContestacao.setEnabled(false);
            tabelaEventoContestacao.setBounds(0, 600, 1362, 39);
        }
        return tabelaEventoContestacao;
    }
          
    private JLabel getImagemTopoMeio(){
        if(ImagemTopoMeio == null){
            ImagemTopoMeio = new JLabel(new ImageIcon("imagens/tela5.png"));
            ImagemTopoMeio.setBounds(0, 0, 1366, 768);
        }
        return ImagemTopoMeio;
    }
    
    private JLabel getImagemBaixo(){
        if(ImagemBaixo == null){
            ImagemBaixo = new JLabel(new ImageIcon("imagens/baixotela4.png"));
            ImagemBaixo.setBounds(0, 607, 1360, 138);
        }
        return ImagemBaixo;
    }
}
