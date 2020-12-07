package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bean.Usuario;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaPrincipalPedido {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalPedido window = new TelaPrincipalPedido();
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
	public void exibirTelaPrincipalPedido(){
		frame.setVisible(true);
	}
	
	public TelaPrincipalPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrarPedido = new JButton("Cadastrar Pedido");
		btnCadastrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarPedido cadPed = new CadastrarPedido();
				cadPed.exibirCadastrarPedido();
			}
		});
		btnCadastrarPedido.setBounds(114, 66, 207, 23);
		frame.getContentPane().add(btnCadastrarPedido);
		
		JButton btnConsultarPedido = new JButton("Consultar Pedido");
		btnConsultarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPedido cp = new ConsultarPedido();
				cp.exibirPedido();
			}
		});
		btnConsultarPedido.setBounds(114, 112, 207, 23);
		frame.getContentPane().add(btnConsultarPedido);
		
		JButton btnAlterarPedido = new JButton("Alterar Pedido");
		btnAlterarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarPedido alterar = new AlterarPedido();
				alterar.exibirAlterarPedido();
			}
		});
		btnAlterarPedido.setBounds(114, 160, 207, 23);
		frame.getContentPane().add(btnAlterarPedido);
		
		JButton btnVoltarParaA = new JButton("Voltar para a Tela Principal");
		btnVoltarParaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Principal prin = new Principal();
				prin.habilitarFrame();
			}
		});
		btnVoltarParaA.setBounds(114, 216, 207, 23);
		frame.getContentPane().add(btnVoltarParaA);
		
		JLabel lblControleDePedidos = new JLabel("Controle de pedidos");
		lblControleDePedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblControleDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDePedidos.setBounds(10, 11, 414, 23);
		frame.getContentPane().add(lblControleDePedidos);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(83, 44, 270, 161);
		frame.getContentPane().add(panel);
		
		if(Usuario.getCargo().equals("Motorista")){
			btnCadastrarPedido.setVisible(false);
			btnAlterarPedido.setVisible(false);
		}
	}

}
