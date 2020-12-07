package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bean.Usuario;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class Principal {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}
	public void habilitarFrame(){
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar consultar = new Consultar();
				consultar.exibirConsultar();
			}
		});
		btnConsultar.setBounds(32, 109, 145, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnCadastrar = new JButton("Cadastrar ");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cadastrar cadastrar = new Cadastrar();
					cadastrar.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
							
			}
		});
		btnCadastrar.setBounds(32, 75, 145, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					Editar editar;
					editar = new Editar();
					editar.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(32, 143, 145, 23);
		frame.getContentPane().add(btnEditar);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalPedido telapedido = new TelaPrincipalPedido();
				telapedido.exibirTelaPrincipalPedido();
			}
		});
		btnPedidos.setBounds(270, 109, 145, 23);
		frame.getContentPane().add(btnPedidos);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario.setCargo("");
				frame.setVisible(false);
				TelaLogin telalogin = new TelaLogin();
				telalogin.exibirLogin();
			}
		});
		btnDeslogar.setBounds(137, 227, 145, 23);
		frame.getContentPane().add(btnDeslogar);
		
		JLabel lblDadosCadastrais = new JLabel("Dados cadastrais");
		lblDadosCadastrais.setForeground(Color.WHITE);
		lblDadosCadastrais.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDadosCadastrais.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCadastrais.setBounds(32, 50, 145, 14);
		frame.getContentPane().add(lblDadosCadastrais);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 39, 189, 145);
		frame.getContentPane().add(panel);
		
		JLabel lblControleDePedidos = new JLabel("Controle de Pedidos");
		lblControleDePedidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblControleDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDePedidos.setForeground(Color.WHITE);
		lblControleDePedidos.setBounds(245, 50, 189, 14);
		frame.getContentPane().add(lblControleDePedidos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(245, 39, 189, 145);
		frame.getContentPane().add(panel_1);
				
		if(Usuario.getCargo().equals("Gerente")){
						
		}else if(Usuario.getCargo().equals("Recursos Humanos")){
			btnPedidos.setVisible(false);
		}else if(Usuario.getCargo().equals("Motorista")){
			btnEditar.setVisible(false);
			btnCadastrar.setVisible(false);
			btnConsultar.setVisible(false);
		}
	}
}
