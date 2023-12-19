package codigo.modelos;

import javax.swing.JOptionPane;

public class OrdemServico {
      // Declaração de atributos
    private String mecanico, dataEmissao, dataPrevista;
    static float valorTotal = 0;
    static int flag = 0, flag1 = 0, 
               qtditem = 0;  // Quantidade de itens cadastrados para controle

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
        resposta += "VALOR TOTAL: R$ " + valorTotal + "\n";

        return resposta;
    }

      // Métodos get/set
    public float getValorTotal() {
        return valorTotal;
    }

    public static void setFlag(int i) {
        flag = i;
    }

    public static int getQtditem() {
        return qtditem;
    }

    public static String getItem(int i) {
        return item[i].relatorio();
    }

      // Cadastro de Itens
    static Item[] item = new Item[0];
    
    public static void cadastrarItens() {

          // Valores constantes
        final int PECA = 0;
        final int SERVICO = 1;
        
        int opcao = 0;
        String[] tiposDeItem = new String[] {"Peça", "Serviço"};

          // Loop para cadastrar mais de um item
        do {

              // Obter dados genéricos de Item
            String descricao = JOptionPane.showInputDialog("Insira a descrição do item: ");
            String codigo = JOptionPane.showInputDialog("Informe o código do item: ");
            float preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do item: ")); // String --> float

            valorTotal += preco;  // Somar o preço ao valor total da ordem de serviço

              // Perguntar ao usuário se o item é uma peça ou serviço
            int tipoItem = JOptionPane.showOptionDialog(null, 
                                                    "Selecione se deseja cadastrar uma peça ou serviço",
                                                    "Cadastro de Item",
                                                    JOptionPane.DEFAULT_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    tiposDeItem,
                                                    null);
                
            Item tempItem;  // Referencia temporária para referenciar uma peça ou um serviço

              // Obter dados caso seja uma peça ou serviço
            if (tipoItem == PECA) {
                String marca = JOptionPane.showInputDialog("Informe a marca da peça");
                String unidade = JOptionPane.showInputDialog("Informe a unidade da peça (ex: kg, ml, l)");
                tempItem = new Peca(descricao, codigo, preco, marca, unidade);  // tempItem está referenciando uma peça

            } else if (tipoItem == SERVICO) {
                float horas = Float.parseFloat(JOptionPane.showInputDialog("Informe o tempo, em horas, necessário para realizar o serviço: ")); // String --> float
                tempItem = new Servico(descricao, codigo, preco, horas);  // tempItem está referenciando um serviço

            } else {
                JOptionPane.showMessageDialog(null, "Erro tipoItem...");  // mensagem de erro
                break;
            }

              // Adicionar novo item no array de itens
            Item tempI[] = new Item[item.length+1];
            for (int i = 0; i < item.length; i++) {
            tempI[i] = item[i];
            }
      
            tempI[item.length] = tempItem;
            item = tempI;

            qtditem++;  // controle da quantidade de itens por OS

              // Verificar se o usuário deseja cadastrar mais um item
            opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais um item?");

        } while (opcao == JOptionPane.YES_OPTION);  // Inicia novo cadastro caso o usuário selecione YES

        flag1++;
    }

}
