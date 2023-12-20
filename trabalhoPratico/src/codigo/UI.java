package codigo;

import javax.swing.*;
import codigo.modelos.Cliente;
import codigo.modelos.OrdemServico;

public class UI {
    public static void main(String[] args) {
        String[] opcoes = {"Adicionar Ordem de serviço", "Listar Dados","Finalizar"};
        int aux = 0;
        
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

                        JPanel veiculoPanel = new JPanel();
                        veiculoPanel.setLayout(new BoxLayout(veiculoPanel, BoxLayout.Y_AXIS));
                          // Adicionar campos de entrada ao JPanel
                        JTextField marcaField = new JTextField(10);
                        JTextField modeloField = new JTextField(10);
                        JTextField corField = new JTextField(10);
                        JTextField anoMField = new JTextField(10);
                        JTextField anoFField= new JTextField(10);
                        JTextField combustivelField = new JTextField(10);
                        JTextField quilometrageField = new JTextField(10);

                        veiculoPanel.add(new JLabel("Marca do veículo:"));
                        veiculoPanel.add(marcaField);
                        veiculoPanel.add(new JLabel("Modelo:"));
                        veiculoPanel.add(modeloField);
                        veiculoPanel.add(new JLabel("Cor:"));
                        veiculoPanel.add(corField);
                        veiculoPanel.add(new JLabel("Ano do modelo:"));
                        veiculoPanel.add(anoMField);
                        veiculoPanel.add(new JLabel("Ano de Fabricação:"));
                        veiculoPanel.add(anoFField);
                        veiculoPanel.add(new JLabel("Combustivel em porcentagem (%):"));
                        veiculoPanel.add(combustivelField);
                        veiculoPanel.add(new JLabel("Quilometragem:"));
                        veiculoPanel.add(quilometrageField);
                        
                            // Exibir o JPanel para entrada de dados do cliente
                        int result2 = JOptionPane.showConfirmDialog(null, veiculoPanel, "Informe os dados do veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (result2 == JOptionPane.OK_OPTION) {
                            
                            String marca = marcaField.getText();
                            String modelo = modeloField.getText();
                            String cor = corField.getText();
                            int anoFabricacao = Integer.parseInt(anoFField.getText());
                            int anoModelo = Integer.parseInt(anoMField.getText());
                            int combustivel = Integer.parseInt(combustivelField.getText());
                            float quilometragem = Float.parseFloat(quilometrageField.getText());

                        Cliente.cadastrarVeiculo(marca, cor, modelo, anoModelo, anoFabricacao, combustivel, quilometragem);

                        JPanel OSPanel = new JPanel();
                        OSPanel.setLayout(new BoxLayout(OSPanel, BoxLayout.Y_AXIS));

                        // Adicionar campos de entrada ao JPanel
                        JTextField mecanicoField = new JTextField(10);
                        JTextField dataEField = new JTextField(10);
                        JTextField dataPField = new JTextField(10);

                        OSPanel.add(new JLabel("Mecanico Responsavel:"));
                        OSPanel.add(mecanicoField);
                        OSPanel.add(new JLabel("Data de Emissão:"));
                        OSPanel.add(dataEField);
                        OSPanel.add(new JLabel("Data Prevista"));
                        OSPanel.add(dataPField);

                        // Exibir o JPanel para entrada de dados do cliente
                        int result3 = JOptionPane.showConfirmDialog(null, OSPanel, "Informe os dados da Ordem de Serviço", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (result3 == JOptionPane.OK_OPTION){
                            String mecanico = mecanicoField.getText();
                            String dataEmissao = dataEField.getText();
                            String dataPrevista = dataPField.getText();
                            
                            OrdemServico tempOrdemServico = new OrdemServico(mecanico, dataEmissao, dataPrevista);

                            Cadastro.cadastrarOrdemServico(tempOrdemServico);
    
                            // Iniciar cadastro dos itens
                            Cadastro.ordemServico[aux++].cadastrarItens();          
                            
                        } 

                    
                    }
                    break;
                }
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
                    // Sair
                    // Opção 3
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
