package codigo;

import javax.swing.JOptionPane;

import codigo.modelos.Cliente;
import codigo.modelos.OrdemServico;


public class Cadastro {

      // Cadastro do cliente
    static Cliente[] cliente = new Cliente[0];

    private static void cadastrarCliente(Cliente temp) {  // Adicionar no array de clientes
        Cliente tempC[] = new Cliente[cliente.length+1];
        for (int i = 0; i < cliente.length; i++) {
            tempC[i] = cliente[i];
        }

        tempC[cliente.length] = temp;
        cliente = tempC;
    }

      // Cadastro da Ordem de Serviço
    static OrdemServico[] ordemServico = new OrdemServico[0];

    private static void cadastrarOrdemServico(OrdemServico temp) {  // adicionar no array de OS
        OrdemServico tempO[] = new OrdemServico[ordemServico.length+1];
        for (int i = 0; i < ordemServico.length; i++) {
            tempO[i] = ordemServico[i];
        }

        tempO[ordemServico.length] = temp;
        ordemServico = tempO;

    }

    public static void main(String[] args) {
        int opcao = 0;
        do {

              // Obter dados do cliente
            String nome = JOptionPane.showInputDialog("Informe o nome do cliente: ");
            String contato = JOptionPane.showInputDialog("Informe o contato do cliente (email/telefone): ");
            String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente: ");

            Cliente tempCliente = new Cliente(nome, contato, cpf);  // Referencia temporária para referenciar um cliente
            cadastrarCliente(tempCliente);

              // Cadastrar veículo do cliente
            Cliente.cadastrarVeiculo();

              // Obter dados sobre a Ordem de Serviço
            String mecanico = JOptionPane.showInputDialog("Informe o mecânico responsável pela ordem de serviço: ");
            String dataEmissao = JOptionPane.showInputDialog("Informe a data de emissão da ordem de serviço: ");
            String dataPrevista = JOptionPane.showInputDialog("Informe a data prevista para o final do serviço: ");

            OrdemServico tempOrdemServico = new OrdemServico(mecanico, dataEmissao, dataPrevista);  // Referencia temporaria para segurar dados da OS
            cadastrarOrdemServico(tempOrdemServico);

              // Iniciar cadastro dos itens
            OrdemServico.cadastrarItens();

              // Verificar se o usuário deseja cadastrar mais uma OS
            opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais uma ordem de serviço?");
            
        } while (opcao == JOptionPane.YES_OPTION);  // Cadastrar nova OS caso o usuário selecione YES

          // Verificar se o usuário deseja ver os dados cadastrados
        int verDetalhes = JOptionPane.showConfirmDialog(null, "Deseja revisar os detalhes da(s) ordem de serviço(s) cadastrada(s)?");
        if (verDetalhes == JOptionPane.YES_OPTION) {
            
              // Mostrar na tela os detalhes dos cadastros realizados
            for (int i = 0; i < cliente.length; i++) {
                JOptionPane.showMessageDialog(null, "DADOS DA ORDEM DE SERVIÇO #" + (i+1));
                JOptionPane.showMessageDialog(null, cliente[i].relatorio());  // Mostrar informações do cliente
                JOptionPane.showMessageDialog(null, Cliente.getVeiculo(i));  // Mostrar info do veiculo
                JOptionPane.showMessageDialog(null, ordemServico[i].relatorio());  // Mostrar info da OS

            }

            JOptionPane.showMessageDialog(null, "DADOS DOS ITENS CADASTRADOS");
            for (int i = 0; i < OrdemServico.getQtditem(); i++) {
                JOptionPane.showMessageDialog(null, OrdemServico.getItem(i));  // Mostrar info de cada Item
            }

        }
    }
}
