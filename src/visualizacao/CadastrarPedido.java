package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import negocio.GerenciadorRegrasNegocio;
import negocio.GerenciadorRegrasNegocio.BaseDados;
import negocio.NegocioException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class CadastrarPedido {

	private JFrame frame;
	private JFormattedTextField fieldCodigoPedido;
	private JTextField fieldPeso;
	private JTextField fieldDistancia;
	private JTextField fieldCodigoCliente;
	private JTextField fieldCodigoFuncionario;
	private JTextField fieldCodigoVeiculo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPedido window = new CadastrarPedido();
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
	public void exibirCadastrarPedido(){
		frame.setVisible(true);
	}
	
	public CadastrarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 648, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroDePedidos = new JLabel("Cadastro de Pedidos");
		lblCadastroDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDePedidos.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCadastroDePedidos.setBounds(10, 0, 622, 59);
		frame.getContentPane().add(lblCadastroDePedidos);
		
		JLabel lblCdigoDoPedido = new JLabel("C\u00F3digo do pedido:");
		lblCdigoDoPedido.setForeground(Color.WHITE);
		lblCdigoDoPedido.setBounds(21, 73, 113, 14);
		frame.getContentPane().add(lblCdigoDoPedido);
		
		fieldCodigoPedido = new JFormattedTextField();
		fieldCodigoPedido.setBounds(144, 70, 86, 20);
		frame.getContentPane().add(fieldCodigoPedido);
		fieldCodigoPedido.setColumns(10);
		try {
			new MaskFormatter("###").install(fieldCodigoPedido);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setBounds(21, 114, 113, 14);
		frame.getContentPane().add(lblPeso);
		
		fieldPeso = new JTextField();
		fieldPeso.setBounds(144, 111, 86, 20);
		frame.getContentPane().add(fieldPeso);
		fieldPeso.setColumns(10);
		
		JLabel lblTipoCarga = new JLabel("Tipo Carga:");
		lblTipoCarga.setForeground(Color.WHITE);
		lblTipoCarga.setBounds(21, 161, 113, 14);
		frame.getContentPane().add(lblTipoCarga);
		
		JComboBox cbxRiscoCarga = new JComboBox();
		cbxRiscoCarga.setModel(new DefaultComboBoxModel(new String[] {"", "0 - n\u00E3o oferece risco", "1 - explosivos", "2 - inflam\u00E1veis", "3 - t\u00F3xicos/infectantes", "4 - oxidantes", "5 - corrisivos", ""}));
		cbxRiscoCarga.setBounds(144, 203, 86, 20);
		frame.getContentPane().add(cbxRiscoCarga);
		
		JLabel lblRiscoCarga = new JLabel("Risco Carga:");
		lblRiscoCarga.setForeground(Color.WHITE);
		lblRiscoCarga.setBounds(21, 206, 113, 14);
		frame.getContentPane().add(lblRiscoCarga);
		
		JLabel lblDistncia = new JLabel("Dist\u00E2ncia:");
		lblDistncia.setForeground(Color.WHITE);
		lblDistncia.setBounds(21, 257, 113, 14);
		frame.getContentPane().add(lblDistncia);
		
		fieldDistancia = new JTextField();
		fieldDistancia.setBounds(144, 254, 86, 20);
		frame.getContentPane().add(fieldDistancia);
		fieldDistancia.setColumns(10);
		
		JLabel lblCdigoCliente = new JLabel("C\u00F3digo Cliente:");
		lblCdigoCliente.setForeground(Color.WHITE);
		lblCdigoCliente.setBounds(21, 311, 113, 14);
		frame.getContentPane().add(lblCdigoCliente);
		
		fieldCodigoCliente = new JTextField();
		fieldCodigoCliente.setBounds(144, 308, 86, 20);
		frame.getContentPane().add(fieldCodigoCliente);
		fieldCodigoCliente.setColumns(10);
		
		JLabel lblCdigoFuncionrio = new JLabel("C\u00F3digo Funcion\u00E1rio:");
		lblCdigoFuncionrio.setForeground(Color.WHITE);
		lblCdigoFuncionrio.setBounds(298, 73, 113, 14);
		frame.getContentPane().add(lblCdigoFuncionrio);
		
		fieldCodigoFuncionario = new JTextField();
		fieldCodigoFuncionario.setBounds(421, 70, 86, 20);
		frame.getContentPane().add(fieldCodigoFuncionario);
		fieldCodigoFuncionario.setColumns(10);
		
		JLabel lblCdigoVeculo = new JLabel("C\u00F3digo Ve\u00EDculo:");
		lblCdigoVeculo.setForeground(Color.WHITE);
		lblCdigoVeculo.setBounds(298, 111, 113, 14);
		frame.getContentPane().add(lblCdigoVeculo);
		
		fieldCodigoVeiculo = new JTextField();
		fieldCodigoVeiculo.setBounds(421, 108, 86, 20);
		frame.getContentPane().add(fieldCodigoVeiculo);
		fieldCodigoVeiculo.setColumns(10);
		
		JLabel lblDataDeEntrega = new JLabel("Data de Entrega:");
		lblDataDeEntrega.setForeground(Color.WHITE);
		lblDataDeEntrega.setBounds(298, 161, 113, 14);
		frame.getContentPane().add(lblDataDeEntrega);
		
		JFormattedTextField ftfDataEntrega = new JFormattedTextField();
		ftfDataEntrega.setBounds(421, 158, 194, 20);
		frame.getContentPane().add(ftfDataEntrega);
		try {
			new MaskFormatter("##/##/####").install(ftfDataEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setBounds(298, 206, 113, 14);
		frame.getContentPane().add(lblDescrio);
		
		JTextArea fieldDescricao = new JTextArea();
		fieldDescricao.setBounds(421, 201, 194, 67);
		frame.getContentPane().add(fieldDescricao);
		
		
		JComboBox cbxTipoCarga = new JComboBox();
		cbxTipoCarga.setModel(new DefaultComboBoxModel(new String[] {"", "S\u00F3lida - Gr\u00E3os", "S\u00F3lida - Maci\u00E7a", "S\u00F3lida - Fr\u00E1gil", "L\u00EDquida"}));
		cbxTipoCarga.setBounds(144, 158, 86, 20);
		frame.getContentPane().add(cbxTipoCarga);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
					if(gerenciadorRegrasNegocio.cadastrarPedido(
							Integer.parseInt(fieldCodigoCliente.getText()),
							Integer.parseInt(fieldCodigoFuncionario.getText()),
							Integer.parseInt(fieldCodigoPedido.getText()),
							Integer.parseInt(fieldCodigoVeiculo.getText()),
							Double.parseDouble(fieldPeso.getText()),
							cbxTipoCarga.getSelectedItem().toString(),
							cbxRiscoCarga.getSelectedIndex()-1,
							Double.parseDouble(fieldDistancia.getText()),
							false,
							ftfDataEntrega.getText().replace("/",""),
							fieldDescricao.getText()
							)){
						JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!",  "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Erro no cadastro!",  "Cadastro", JOptionPane.ERROR_MESSAGE);
					}
					fieldCodigoCliente.setText("");
					fieldCodigoFuncionario.setText("");
					fieldCodigoPedido.setText("");
					fieldCodigoVeiculo.setText("");
					fieldPeso.setText("");
					cbxTipoCarga.setSelectedIndex(0);
					cbxRiscoCarga.setSelectedIndex(0);
					fieldDistancia.setText("");
					ftfDataEntrega.setText("");
					fieldDescricao.setText("");
				} catch (NegocioException e){
					e.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(298, 307, 113, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(421, 307, 113, 23);
		frame.getContentPane().add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 57, 233, 283);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(287, 57, 343, 283);
		frame.getContentPane().add(panel_1);

	}
}
