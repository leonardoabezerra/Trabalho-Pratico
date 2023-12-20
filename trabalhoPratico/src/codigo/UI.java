package codigo;

import javax.swing.*;
import codigo.modelos.Cliente;
import codigo.modelos.OrdemServico;

public class UI {
    public static void main(String[] args) {
        String[] opcoes = {"Adicionar Ordem de serviço", "Listar Dados","Concluir Serviço","Finalizar"};
        while (true) {
            boolean sair = false;
            int escolha = JOptionPane.showOptionDialog(null, "Selecione a tarefa desejada: ", "Bem vindo!",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    // Criar um JPanel para agrupar os campos de entrada do cliente
                    // Opção 1
                    JPanel clientePanel = new JPanel();
                    clientePanel.setLayout(new BoxLayout(clientePanel, BoxLayout.Y_AXIS));

                    // Adicionar campos de entrada ao JPanel
                    JTextField nomeField = new JTextField(10);
                    JTextField contatoField = new JTextField(10);
                    JTextField cpfField = new JTextField(10);

                    clientePanel.add(new JLabel("Nome:"));
                    clientePanel.add(nomeField);
                    clientePanel.add(new JLabel("Contato (e-mail ou telefone):"));
                    clientePanel.add(contatoField);
                    clientePanel.add(new JLabel("CPF:"));
                    clientePanel.add(cpfField);

                    // Exibir o JPanel para entrada de dados do cliente
                    int result = JOptionPane.showConfirmDialog(null, clientePanel, "Informe os dados do cliente",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    // Se o usuário pressionar OK, obter os dados do cliente e cadastrar
                    if (result == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String contato = contatoField.getText();
                        String cpf = cpfField.getText();

                        // Parte do leo
                        Cliente tempCliente = new Cliente(nome, contato, cpf);
                        Cadastro.cadastrarCliente(tempCliente);


                        // Cadastrar veículo do cliente
                        Cliente.cadastrarVeiculo();

                        // Obter dados sobre a Ordem de Serviço
                        String mecanico = JOptionPane.showInputDialog("Informe o mecânico responsável pela ordem de serviço: ");
                        String dataEmissao = JOptionPane.showInputDialog("Informe a data de emissão da ordem de serviço: ");
                        String dataPrevista = JOptionPane.showInputDialog("Informe a data prevista para o final do serviço: ");

                        OrdemServico tempOrdemServico = new OrdemServico(mecanico, dataEmissao, dataPrevista);
                        Cadastro.cadastrarOrdemServico(tempOrdemServico);

                        // Iniciar cadastro dos itens
                        OrdemServico.cadastrarItens();
                    }
                    break;

                case 1:
                    // Verificar se o usuário deseja ver os dados cadastrados
                    // Opção 2
                    // Mostrar na tela os detalhes dos cadastros realizados
                        StringBuilder detalhesMessage = new StringBuilder();
                        for (int i = 0; i < Cadastro.cliente.length; i++) {
                            detalhesMessage.append("DADOS DA ORDEM DE SERVIÇO #").append(i + 1).append("\n");
                            detalhesMessage.append(Cadastro.cliente[i].relatorio()).append("\n");
                            detalhesMessage.append(Cliente.getVeiculo(i)).append("\n");
                            detalhesMessage.append(Cadastro.ordemServico[i].relatorio()).append("\n");
                        }

                        detalhesMessage.append("DADOS DOS ITENS CADASTRADOS\n");

                        for (int i = 0; i < OrdemServico.getQtditem(); i++) {
                        detalhesMessage.append(OrdemServico.getItem(i)).append("\n");
                        }

                    JOptionPane.showMessageDialog(null, detalhesMessage.toString());
                
                    break;
                case 2:
                    // Fechar conta

                    // Opção 3
                    break;
                case 3:
                    // Sair

                    // Opção 4
                    sair = true;
                    break;
                default:
                //JOptionPane.showMessageDialog(null, "Um erro inesperado aconteceu =(");
                    sair = true;
                    break;
            }
        if (sair == true) {
            break;
        }
    }
}
}
