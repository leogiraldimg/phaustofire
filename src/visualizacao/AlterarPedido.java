package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import bean.Pedido;
import negocio.GerenciadorRegrasNegocio;
import negocio.NegocioException;
import negocio.GerenciadorRegrasNegocio.BaseDados;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class AlterarPedido {

	private JFrame frame;
	private JFormattedTextField fieldCodigoPedido;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarPedido window = new AlterarPedido();
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
	public void exibirAlterarPedido(){
		frame.setVisible(true);
	}
	
	public AlterarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 493, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAlterarPedido = new JLabel("Alterar pedido");
		lblAlterarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarPedido.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAlterarPedido.setBounds(10, 11, 457, 58);
		frame.getContentPane().add(lblAlterarPedido);
		
		fieldCodigoPedido = new JFormattedTextField();
		fieldCodigoPedido.setBounds(165, 96, 86, 20);
		frame.getContentPane().add(fieldCodigoPedido);
		fieldCodigoPedido.setColumns(10);
		try {
			new MaskFormatter("###").install(fieldCodigoPedido);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(78, 155, 98, 14);
		frame.getContentPane().add(lblStatus);
		
		JComboBox cbxStatus = new JComboBox();
		cbxStatus.setModel(new DefaultComboBoxModel(new String[] {"", "Em andamento", "Finalizado"}));
		cbxStatus.setBounds(78, 180, 145, 20);
		frame.getContentPane().add(cbxStatus);
		
		JButton btnConsultarStatus = new JButton("Consultar Status");
		btnConsultarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(fieldCodigoPedido.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Insira o código do pedido.");
						return;
					}
					GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
					Pedido pedido= gerenciadorRegrasNegocio.consultaPedido(Integer.parseInt(fieldCodigoPedido.getText()));
					if(pedido!=null){
						if(pedido.getFinalizado() == true){
							cbxStatus.setSelectedIndex(2);
						} else if(pedido.getFinalizado() == false){
							cbxStatus.setSelectedIndex(1);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Insira um pedido válido!");
					}
				} catch (NegocioException e) {
					e.printStackTrace();
				}
			}
		});
		btnConsultarStatus.setBounds(275, 105, 171, 23);
		frame.getContentPane().add(btnConsultarStatus);
		
		JButton btnConfirmarAlteraes = new JButton("Confirmar Altera\u00E7\u00F5es");
		btnConfirmarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
					if(cbxStatus.getSelectedIndex()==0){
						JOptionPane.showMessageDialog(null, "Insira um status válido!");
						return;
					} else if(cbxStatus.getSelectedIndex()==1){
						gerenciadorRegrasNegocio.updatePedido(false, Integer.parseInt(fieldCodigoPedido.getText()));
					} else if(cbxStatus.getSelectedIndex()==2){
						gerenciadorRegrasNegocio.updatePedido(true, Integer.parseInt(fieldCodigoPedido.getText()));
					}
				} catch (NegocioException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConfirmarAlteraes.setBounds(78, 225, 196, 23);
		frame.getContentPane().add(btnConfirmarAlteraes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(284, 225, 120, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldCodigoPedido.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Insira o código do pedido.");
					return;
				}
				try{
					GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
					Pedido pedido = new Pedido(Integer.parseInt(fieldCodigoPedido.getText()));
					gerenciadorRegrasNegocio.deletePedido(pedido);
					JOptionPane.showMessageDialog(null, "Pedido cancelado");
				} catch (NegocioException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnCancelarPedido.setBounds(233, 179, 171, 23);
		frame.getContentPane().add(btnCancelarPedido);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 78, 255, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsiraOCdigo = new JLabel("Insira o c\u00F3digo do pedido");
		lblInsiraOCdigo.setBounds(10, 22, 145, 14);
		panel.add(lblInsiraOCdigo);
		lblInsiraOCdigo.setForeground(Color.WHITE);
		
		JLabel lblPrimeiroConsulteO = new JLabel("Primeiro, consulte o status do pedido");
		lblPrimeiroConsulteO.setBounds(275, 80, 202, 14);
		frame.getContentPane().add(lblPrimeiroConsulteO);
	}
}
