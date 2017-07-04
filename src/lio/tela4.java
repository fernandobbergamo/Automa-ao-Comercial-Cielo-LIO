package lio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;

public class tela4 extends JFrame {

    private JPanel pnlPrincipal;
    private JLabel ImagemTopoMeio;
    private JLabel ImagemBaixo;
    private JTable tabela2;
    private JTable tabela1;
    private JScrollPane sp1;
    private JScrollPane sp2;
    List<transacao1> lista;
    private JButton btnSair;
    private JButton btnDetalhar;
    private JTextField busca;
    private JLabel nsu;
    String nsuFind;
    int posicaoLista;
    private JButton btnExtrato;

    public tela4() throws IOException {
        super("Cielo Labs - Inovação");
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
            pnlPrincipal.add(getBtnDetalhar());
            pnlPrincipal.add(getSp1());
            pnlPrincipal.add(getBtnExtrato());
            pnlPrincipal.add(getBuscar());
            pnlPrincipal.add(getNSU());
            pnlPrincipal.add(getImagemBaixo());
            pnlPrincipal.add(getImagemTopoMeio());

        }
        return pnlPrincipal;
    }

    private JTextField getBuscar() {

        if (busca == null) {

            Action acao = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    nsuFind = busca.getText();
                    int achou = 0;

                    if (sp2 == null) {
                        JOptionPane.showMessageDialog(tela4.this, "Carregue a tabela adquirrente para realizar a pesquisa!");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).NSU.equals(nsuFind)) {
                                posicaoLista = i;
                                achou = 1;
                                break;
                            }
                        }
                        if (achou == 1) {
                            try {
                                new tela5(lista, posicaoLista).setVisible(true);
                            } catch (IOException ex) {
                                Logger.getLogger(tela4.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(tela4.this, "NSU não encontrado!");
                        }
                    }
                }
            };

            busca = new JTextField();
            busca.setDocument(new DocumentoLimitado(6));
            busca.setFont(new Font("Exo", Font.ITALIC + Font.BOLD, 35));
            busca.setBounds(211, 684, 262, 46);
            busca.setBorder(BorderFactory.createLineBorder(Color.white));
            busca.addActionListener(acao);
        }
        return busca;
    }

    private JButton getBtnSair() {
        if (btnSair == null) {
            ImageIcon ImgSair = new ImageIcon("imagens/voltar.png");
            btnSair = new JButton(ImgSair);
            btnSair.setBounds(1225, 600, 135, 175);
            btnSair.setContentAreaFilled(false);
            btnSair.setBorderPainted(false);
            btnSair.addActionListener((ActionEvent arg0) -> {
                dispose();
            });
        }
        return btnSair;
    }

    private JButton getBtnDetalhar() {
        if (btnDetalhar == null) {
            btnDetalhar = new JButton();
            btnDetalhar.setBounds(480, 680, 70, 60);
            btnDetalhar.setContentAreaFilled(false);
            btnDetalhar.setBorderPainted(false);
            btnDetalhar.addActionListener((ActionEvent arg0) -> {
                if (sp2 == null) {
                    JOptionPane.showMessageDialog(tela4.this, "Carregue a tabela adquirrente para realizar a pesquisa!");
                } else {

                    nsuFind = busca.getText();
                    int achou = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).NSU.equals(nsuFind)) {
                            posicaoLista = i;
                            achou = 1;
                            break;
                        }
                    }
                    if (achou == 1) {
                        try {
                            new tela5(lista, posicaoLista).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(tela4.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(tela4.this, "NSU não encontrado!");
                    }
                }
            });
        }
        return btnDetalhar;
    }

    private JScrollPane getSp1() throws IOException {
        if (sp1 == null) {
            sp1 = new JScrollPane(getTbl1());
            sp1.setBounds(tabela1.getBounds());
        }
        return sp1;
    }

    private JScrollPane getSp2() throws IOException {
        if (sp2 == null) {
            sp2 = new JScrollPane(getTbl2());
            sp2.setBounds(tabela2.getBounds());
        }
        return sp2;
    }

    private JTable getTbl1() throws IOException {
        if (tabela1 == null) {
            gerarAleatorio aleatorio1 = new gerarAleatorio();
            String[] colunas = {"PEDIDO", "NSU", "VALOR", "DATA"};
            Object[][] dados = {
                {aleatorio1.gerarNumero(4), "137282", "R$15,50", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "888746", "R$13,70", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "987654", "R$23,90", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "235689", "R$9,90", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "135790", "R$16,40", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "246890", "R$35,90", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "864577", "R$22,20", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "986355", "R$25,50", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "597711", "R$16,00", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "993004", "R$19,90", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "750112", "R$18,50", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "981337", "R$16,00", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "689112", "R$15,50", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "653728", "R$11,10", "2016-12-11"},
                {aleatorio1.gerarNumero(4), "988873", "R$21,20", "2016-12-11"},};
            tabela1 = new JTable(dados, colunas);
            tabela1.setEnabled(false);
            tabela1.setBounds(0, 374, 689, 230);

        }
        return tabela1;
    }

    private JTable getTbl2() throws IOException {
        if (tabela2 == null) {
            OKHTTP conexao = new OKHTTP();
            lista = conexao.get();
            String[] colunas = {"NSU", "VALOR BRUTO", "VALOR DESCONTADO", "VALOR LIQUIDO", "TIPO DE PAGAMENTO", "BANDEIRA", "FORMA DE PAGAMENTO", "DATA"};
            Object[][] dados = new Object[lista.size()][8];
            for (int i = 0; i < lista.size(); i++) {
                dados[i][0] = lista.get(i).NSU;
                String valorBruto = String.format("%.2f", lista.get(i).valorBruto);
                dados[i][1] = ("R$" + valorBruto);
                String valorDescontado = String.format("%.2f", lista.get(i).valorDescontado);
                dados[i][2] = ("R$" + valorDescontado);
                String valorLiquido = String.format("%.2f", lista.get(i).valorLiquido);
                dados[i][3] = ("R$" + valorLiquido);
                dados[i][4] = lista.get(i).tipoPagamento;
                dados[i][5] = lista.get(i).bandeira;
                dados[i][6] = lista.get(i).formaPagamento;
                dados[i][7] = lista.get(i).data.substring(0, lista.get(i).data.length() - 14);
            }
            tabela2 = new JTable(dados, colunas);
            tabela2.setEnabled(false);
            tabela2.setBounds(693, 374, 667, 230);
        }
        return tabela2;
    }

    private JLabel getNSU() {
        if (nsu == null) {
            nsu = new JLabel(new ImageIcon("imagens/NSU.png"));
            nsu.setBounds(0, 680, 549, 60);
        }
        return nsu;
    }

    private JLabel getImagemTopoMeio() {
        if (ImagemTopoMeio == null) {
            ImagemTopoMeio = new JLabel(new ImageIcon("imagens/Cieloextratos.png"));
            ImagemTopoMeio.setBounds(0, 0, 1366, 768);
        }
        return ImagemTopoMeio;
    }

    private JLabel getImagemBaixo() {
        if (ImagemBaixo == null) {
            ImagemBaixo = new JLabel(new ImageIcon("imagens/baixotela4.png"));
            ImagemBaixo.setBounds(0, 607, 1360, 138);
        }
        return ImagemBaixo;
    }

    private JButton getBtnExtrato() {
        if (btnExtrato == null) {
            ImageIcon ImgSair = new ImageIcon("imagens/+.png");
            btnExtrato = new JButton(ImgSair);
            btnExtrato.setBounds(700, 280, 92, 92);
            btnExtrato.setContentAreaFilled(false);
            btnExtrato.setBorderPainted(false);
            btnExtrato.addActionListener((ActionEvent arg0) -> {
                try {
                    pnlPrincipal.add(getSp2());
                } catch (IOException ex) {
                    Logger.getLogger(tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return btnExtrato;
    }
}
