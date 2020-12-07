package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.GerenciadorRegrasNegocio;
import negocio.GerenciadorRegrasNegocio.BaseDados;
import basedados.GerenciadorBaseDados;
import bean.Cliente;
import bean.Funcionario;
import bean.Veiculo;
import negocio.NegocioException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Consultar {

	private JFrame frame;
	private JTable table;
	private JTable tblConsultaFuncionario;
	private JTable tblConsultaCliente;
	private JTable tblConsultaVeiculo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar window = new Consultar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public void exibirConsultar(){
		frame.setVisible(true);
	}
	
	public Consultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void clearTabela(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	
	private void montaTabelaVeiculos(List<Veiculo> veiculos) {
		DefaultTableModel model = (DefaultTableModel) tblConsultaVeiculo.getModel();
		clearTabela(model);

		for (Veiculo veiculo : veiculos) {
			model.addRow(new Object[] { veiculo.getPlaca(), veiculo.getTipoVeiculo(), veiculo.getModelo()});
		}
	}
	
	private void montaTabelaClientes(List<Cliente> clientes) {
		DefaultTableModel model = (DefaultTableModel) tblConsultaCliente.getModel();
		clearTabela(model);

		for (Cliente cliente : clientes) {
			model.addRow(new Object[] { cliente.getCodigopessoa(), cliente.getNome(), cliente.getCnpj()});
		}
	}
	
	private void montaTabelaFuncionarios(List<Funcionario> funcionarios) {
		DefaultTableModel model = (DefaultTableModel) tblConsultaFuncionario.getModel();
		clearTabela(model);

		for (Funcionario funcionario : funcionarios) {
			model.addRow(new Object[] { funcionario.getCodigopessoa(), funcionario.getNome(), funcionario.getCargo()});
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setBackground(Color.LIGHT_GRAY);
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsulta.setBounds(10, 11, 414, 58);
		frame.getContentPane().add(lblConsulta);
		
		JComboBox cmbEscolha = new JComboBox();
		cmbEscolha.setModel(new DefaultComboBoxModel(new String[] {"", "Funcionario", "Cliente", "Veiculo"}));
		cmbEscolha.setBounds(118, 112, 191, 20);
		frame.getContentPane().add(cmbEscolha);
		
		JLabel lblSelecioneOQue = new JLabel("Selecione o que deseja consultar");
		lblSelecioneOQue.setForeground(Color.WHITE);
		lblSelecioneOQue.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOQue.setBounds(118, 87, 191, 14);
		frame.getContentPane().add(lblSelecioneOQue);
		
		tblConsultaFuncionario = new JTable(new DefaultTableModel(new Object[] { "Código", "Nome", "cargo"},0));
		tblConsultaFuncionario.setVisible(false);
		tblConsultaFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tblConsultaFuncionario.setBounds(0, 90, 700, 0);
		frame.getContentPane().add(tblConsultaFuncionario);
		JScrollPane scrollPaneFuncionario = new JScrollPane(tblConsultaFuncionario);
		scrollPaneFuncionario.setForeground(Color.WHITE);
		scrollPaneFuncionario.setBackground(Color.DARK_GRAY);
		scrollPaneFuncionario.setBounds(10, 163, 414, 265);
		frame.getContentPane().add(scrollPaneFuncionario);
		scrollPaneFuncionario.setVisible(false);
		
		tblConsultaCliente = new JTable(new DefaultTableModel(new Object[] { "Código", "Nome", "CNPJ"},0));
		tblConsultaCliente.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tblConsultaCliente.setBounds(0, 90, 700, 0);
		frame.getContentPane().add(tblConsultaCliente);
		JScrollPane scrollPaneCliente = new JScrollPane(tblConsultaCliente);
		scrollPaneCliente.setBounds(10, 163, 414, 265);
		frame.getContentPane().add(scrollPaneCliente);
		scrollPaneCliente.setVisible(false);
		tblConsultaCliente.setVisible(false);
		
		tblConsultaVeiculo = new JTable(new DefaultTableModel(new Object[] { "Placa", "Tipo", "Modelo"},0));
		tblConsultaVeiculo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tblConsultaVeiculo.setBounds(0, 90, 700, 0);
		frame.getContentPane().add(tblConsultaVeiculo);
		JScrollPane scrollPaneVeiculo = new JScrollPane(tblConsultaVeiculo);
		scrollPaneVeiculo.setBounds(10, 163, 414, 265);
		frame.getContentPane().add(scrollPaneVeiculo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 439, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(87, 80, 245, 72);
		frame.getContentPane().add(panel);
		scrollPaneVeiculo.setVisible(false);
		tblConsultaVeiculo.setVisible(false);
		
		cmbEscolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){	
				scrollPaneFuncionario.setVisible(false);
				tblConsultaFuncionario.setVisible(false);
				scrollPaneCliente.setVisible(false);
				tblConsultaCliente.setVisible(false);
				scrollPaneVeiculo.setVisible(false);
				tblConsultaVeiculo.setVisible(false);
				if(cmbEscolha.getSelectedIndex()==1){ //escolheu funcionário
					scrollPaneFuncionario.setVisible(true);
					tblConsultaFuncionario.setVisible(true);
					List<Funcionario> funcionarios;
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						funcionarios = gerenciadorRegrasNegocio.listaFuncionarios();
						montaTabelaFuncionarios(funcionarios);
					} catch (NegocioException e){
						JOptionPane.showMessageDialog(null,"Não foi possível listar os usuários. \n" + e.getMessage());
					}
				} else if(cmbEscolha.getSelectedIndex()==2){
					scrollPaneCliente.setVisible(true);
					tblConsultaCliente.setVisible(true);
					List<Cliente> clientes;
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						clientes = gerenciadorRegrasNegocio.listaClientes();
						montaTabelaClientes(clientes);
					} catch (NegocioException e){
						JOptionPane.showMessageDialog(null,"Não foi possível listar os usuários. \n" + e.getMessage());
					}
				} else if(cmbEscolha.getSelectedIndex()==3){
					scrollPaneVeiculo.setVisible(true);
					tblConsultaVeiculo.setVisible(true);
					List<Veiculo> veiculos;
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						veiculos = gerenciadorRegrasNegocio.listaVeiculos();
						montaTabelaVeiculos(veiculos);
					} catch (NegocioException e){
						JOptionPane.showMessageDialog(null,"Não foi possível listar os usuários. \n" + e.getMessage());
					}
				}
			}
		});
	}
}
