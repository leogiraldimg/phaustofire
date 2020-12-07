package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import negocio.GerenciadorRegrasNegocio;
import negocio.GerenciadorRegrasNegocio.BaseDados;
import negocio.NegocioException;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class TelaLogin {

	private JFrame frame;
	private JTextField txtLogin;
	GerenciadorRegrasNegocio gerenciadorRegrasNegocio;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void exibirLogin(){
		frame.setVisible(true);
	}
	
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(GerenciadorRegrasNegocio.BaseDados.JDBC);
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblPhaustofireTransportes = new JLabel("PhaustoFire Transportes");
		lblPhaustofireTransportes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhaustofireTransportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhaustofireTransportes.setBounds(10, 30, 414, 44);
		frame.getContentPane().add(lblPhaustofireTransportes);
		
		txtLogin = new JTextField();
		txtLogin.setBackground(Color.DARK_GRAY);
		txtLogin.setForeground(Color.WHITE);
		txtLogin.setBounds(209, 108, 86, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setBounds(153, 111, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(153, 152, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String login = txtLogin.getText();
				try {
					if(gerenciadorRegrasNegocio.existeUsuario(login) == false){
						JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
						txtLogin.grabFocus();
					}
					else{
						String senha = txtPassword.getText();
						if(gerenciadorRegrasNegocio.existeSenha(senha, txtLogin.getText()) == false){
							JOptionPane.showMessageDialog(null, "Senha incorreta!", "ERRO", JOptionPane.ERROR_MESSAGE);
							txtPassword.setText("");
							txtPassword.grabFocus();
						}
						else{
							frame.setVisible(false);
							Principal princ = new Principal();
							princ.habilitarFrame();
						}
					}
				} catch (NegocioException e) {
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(153, 197, 142, 23);
		frame.getContentPane().add(btnEntrar);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBackground(Color.DARK_GRAY);
		txtPassword.setBounds(209, 149, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(10, 85, 424, 165);
		frame.getContentPane().add(panel);
		
	}
}
