package codigo.modelos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
      // Declaração de atributos
    private String mecanico, dataEmissao, dataPrevista;
    float valorTotal = 0;
    static int qtditem = 0;  // Quantidade de itens cadastrados para controle
      // Construtor
    public OrdemServico(String mecanico, String dataEmissao, String dataPrevista) {
        this.mecanico = mecanico;
        this.dataEmissao = dataEmissao;
        this.dataPrevista = dataPrevista;
    }

      // Métodos

      // Relatório para organizar informações da OS para mostrar ao usuário
    public String relatorio() {
        String resposta = "";
        resposta += "**** DADOS DA ORDEM DE SERVIÇO ****\n";
        resposta += "MECÂNICO RESPONSÁVEL: " + mecanico + "\n";
        resposta += "DATA DE EMISSÃO: " + dataEmissao + "\n";
        resposta += "DATA DE FINAL PREVISTA: " + dataPrevista + "\n";
        resposta += "VALOR TOTAL: R$ " + this.valorTotal + "\n";

        return resposta;
    }

      // Métodos get/set
    public float getValorTotal() {
        return this.valorTotal;
    }

    public static int getQtditem() {
        return qtditem;
    }

    public static String getItem(int i) {
        return item.get(i).relatorio();
    }

      // Cadastro de Itens
      static List<Item> item = new ArrayList<Item>();
    
    public void cadastrarItens() {

          // Valores constantes
        final int PECA = 0;
        final int SERVICO = 1;
        
        while(true){
        Item tempItem = null;

        boolean sair = false;
        String descricao, codigo, marca, unidade;
        float preco;
        String[] tiposDeItem = new String[] {"Peça", "Serviço", "Finalizar Cadastro"};
        int escolha = JOptionPane.showOptionDialog(null, "Selecione o tipo de Item: ", "Cadastro de Itens",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposDeItem, tiposDeItem[0]);

          // Loop para cadastrar mais de um item
        switch (escolha) {
          case PECA:
          // Obter dados genéricos de Item
              descricao = JOptionPane.showInputDialog("Insira a descrição do peça: ");
              codigo = JOptionPane.showInputDialog("Informe o código do peça: ");
              preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do peça: ")); // String --> float
              this.valorTotal += preco;  // Somar o preço ao valor total da ordem de serviço

              marca = JOptionPane.showInputDialog("Informe a marca da peça");
              unidade = JOptionPane.showInputDialog("Informe a unidade da peça (ex: kg, ml, l)");
              tempItem = new Peca(descricao, codigo, preco, marca, unidade);  // tempItem está referenciando uma peça
            break;
          case SERVICO:
            // Obter dados genéricos de um Item
            descricao = JOptionPane.showInputDialog("Insira a descrição do serviço: ");
            codigo = JOptionPane.showInputDialog("Informe o código do serviço: ");
            preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do serviço: ")); // String --> float

            this.valorTotal += preco;  // Somar o preço ao valor total da ordem de serviço 
            float horas = Float.parseFloat(JOptionPane.showInputDialog("Informe o tempo, em horas, necessário para realizar o serviço: ")); // String --> float
            tempItem = new Servico(descricao, codigo, preco, horas);  // tempItem está referenciando um serviço
            break;
          case 2:
            sair = true;
            break;
          default:
            sair = true;
            break;
        }
      
        if (sair == true) {
          break;
        }
        qtditem++;  // Incrementar a quantidade de itens cadastrados
        OrdemServico.item.add(tempItem);  // Adicionar o item à lista de itens
      }
    }
}
