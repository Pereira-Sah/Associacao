package br.edu.fatecpg.associacao.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.associacao.model.Cliente;
import br.edu.fatecpg.associacao.model.Empresa;
import br.edu.fatecpg.associacao.model.Funcionario;
import java.awt.Color;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		Empresa empresa = new Empresa("FATEC");
        setTitle("Sistema da Empresa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(5, 1));

        // Botão para adicionar cliente
        JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
        btnAdicionarCliente.setBackground(new Color(255, 204, 255));
        btnAdicionarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Cliente cli = new Cliente("Carlos", "carlos@email.com");
     		   Cliente cli1 = new Cliente("Maria", "maria@email.com");
     		   Cliente cli2 = new Cliente("Luana", "luana@email.com");
     		   empresa.adicionarCliente(cli);
    	       empresa.adicionarCliente(cli1);
    	       empresa.adicionarCliente(cli2);
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
            }
        });
        getContentPane().add(btnAdicionarCliente);

        // Botão para exibir clientes
        JButton btnExibirClientes = new JButton("Exibir Clientes");
        btnExibirClientes.setBackground(new Color(255, 204, 204));
        btnExibirClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa.exibirClientes();
            }
        });
        getContentPane().add(btnExibirClientes);

        // Botão para adicionar funcionário
        JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
        btnAdicionarFuncionario.setBackground(new Color(255, 204, 255));
        btnAdicionarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Funcionario fun1 = new Funcionario("Marcos", "Gerente", 4000);
      		   Funcionario fun2 = new Funcionario("Paulo", "Analista", 2000);
      		   empresa.adicionarFuncionario(fun1);
    	       empresa.adicionarFuncionario(fun2);
                JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
            }
        });
        getContentPane().add(btnAdicionarFuncionario);

        // Botão para exibir funcionários
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        btnExibirFuncionarios.setBackground(new Color(255, 204, 204));
        btnExibirFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa.exibirFuncionarios();
            }
        });
        getContentPane().add(btnExibirFuncionarios);

        // Botão para exibir média salarial
        JButton btnExibirMediaSalarial = new JButton("Exibir Média Salarial");
        btnExibirMediaSalarial.setBackground(new Color(255, 204, 255));
        btnExibirMediaSalarial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa.exibirMediaSalarial();
            }
        });
        getContentPane().add(btnExibirMediaSalarial);
    
    }
}
