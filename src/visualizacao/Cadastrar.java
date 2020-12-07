package visualizacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import basedados.GerenciadorBaseDados;
import bean.Usuario;
import negocio.GerenciadorRegrasNegocio;
import negocio.GerenciadorRegrasNegocio.BaseDados;
import negocio.NegocioException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Cadastrar extends JFrame {

	protected JPanel contentPane;
	protected JTextField fieldNome;
	protected JTextField fieldEndereco;
	protected JTextField fieldCidade;
	protected JTextField fieldComplemento;
	protected JFormattedTextField fieldCep;
	protected JFormattedTextField fieldCnpj;
	protected JFormattedTextField fieldCpf;
	protected JPasswordField fieldSenha;
	protected JLabel lblNome;
	protected JLabel lblCnpj;
	protected JLabel lblEndereo;
	protected JLabel lblCidade;
	protected JLabel lblEstado;
	protected JLabel lblCep;
	protected JLabel lblComplemento;
	protected JLabel lblSenha;
	protected JLabel lblCpf;
	protected JLabel lblCargo;
	protected JComboBox cbxEstado;
	protected JComboBox cbxCargo;
	protected JButton btnConfirmar;
	protected JButton btnCancelar;
	protected JButton btnCliente;
	protected JButton btnFuncionario;
	protected JLabel lblLogin;
	protected JTextField txtLogin;
	protected JLabel lblCdigo;
	protected JFormattedTextField fieldCodigo;
	protected JTextField fieldCarta;
	protected JLabel lblCarta;
	protected JTextField fieldMarca;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JTextField fieldModelo;
	protected JLabel lblPesoMximokg;
	protected JTextField fieldPesoMax;
	protected JLabel lblTipoVeculo;
	protected JComboBox cbxTipoVeiculo;
	protected JLabel lblPlacaDoVeculo;
	protected JFormattedTextField fieldPlaca;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Cadastrar() throws ParseException {
		
		setTitle("Cadastros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		String[] estados = {"AC","AL","AP","AM","BA","CE","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
		String[] cargos = {"Gerente","Recursos Humanos","Atendimento ao Cliente","Motorista"};
		
		
		fieldPlaca = new JFormattedTextField();
		fieldPlaca.setBounds(346, 349, 144, 20);
		contentPane.add(fieldPlaca);
		fieldPlaca.setColumns(10);
		
		
		fieldNome = new JTextField();
		fieldEndereco = new JTextField();
		fieldComplemento = new JTextField();
		fieldCidade = new JTextField();
		fieldCep = new JFormattedTextField();
		fieldCnpj = new JFormattedTextField();
		fieldCpf = new JFormattedTextField();
		fieldSenha = new JPasswordField();
		lblNome = new JLabel("Nome");
		lblCnpj = new JLabel("CNPJ");
		lblEndereo = new JLabel("Endere\u00E7o");
		lblCidade = new JLabel("Cidade");
		lblEstado = new JLabel("Estado");
		lblCep = new JLabel("CEP");
		lblComplemento = new JLabel("Complemento");
		lblCpf = new JLabel("CPF");
		lblCargo = new JLabel("Cargo");
		lblSenha = new JLabel("Senha");
		cbxEstado = new JComboBox(estados);
		cbxCargo = new JComboBox(cargos);
		btnConfirmar = new JButton("Confirmar");
		btnCancelar = new JButton("Cancelar");
		btnCliente = new JButton("Cliente");
		btnFuncionario = new JButton("Funcion\u00E1rio");
		fieldCodigo = new JFormattedTextField();
		fieldCodigo.setBounds(38, 125, 144, 20);
		contentPane.add(fieldCodigo);
		fieldCodigo.setColumns(10);
		new MaskFormatter("#####-###").install(fieldCep);
		new MaskFormatter("###.###.###/####-##").install(fieldCnpj);
		new MaskFormatter("###.###.###-##").install(fieldCpf);
		new MaskFormatter("UUU-####").install(fieldPlaca);
		new MaskFormatter("###").install(fieldCodigo);
		
		
		fieldNome.setBounds(38, 181, 144, 20);
		fieldEndereco.setBounds(192, 293, 144, 20);
		fieldCidade.setBounds(38, 349, 144, 20);
		fieldComplemento.setBounds(38, 293, 144, 20);
		fieldCep.setBounds(192, 349, 144, 20);
		fieldCnpj.setBounds(38, 237, 144, 20);
		fieldCpf.setBounds(192, 237, 144, 20);
		fieldSenha.setBounds(346, 405, 144, 20);
		lblNome.setBounds(38, 156, 46, 14);
		lblCnpj.setBounds(38, 212, 46, 14);
		lblEndereo.setBounds(192, 268, 144, 14);
		lblCidade.setBounds(38, 324, 46, 14);
		lblEstado.setBounds(38, 380, 46, 14);
		lblCep.setBounds(192, 324, 46, 14);
		lblComplemento.setBounds(38, 268, 144, 14);
		lblCpf.setBounds(192, 212, 46, 14);
		lblCargo.setBounds(192, 100, 46, 14);
		lblSenha.setBounds(346, 380, 46, 14);
		cbxEstado.setBounds(38, 405, 144, 20);
		cbxCargo.setBounds(192, 125, 144, 20);
		btnCliente.setBounds(38, 66, 144, 23);
		btnFuncionario.setBounds(192, 66, 144, 23);
		btnConfirmar.setBounds(110, 447, 144, 23);
		btnCancelar.setBounds(264, 447, 144, 23);
		
		
		contentPane.add(fieldNome);
		contentPane.add(fieldEndereco);
		contentPane.add(fieldCidade);
		contentPane.add(fieldComplemento);
		contentPane.add(fieldCep);
		contentPane.add(fieldCnpj);
		contentPane.add(fieldCpf);
		contentPane.add(fieldSenha);
		contentPane.add(lblNome);
		contentPane.add(lblCnpj);
		contentPane.add(lblEndereo);
		contentPane.add(lblCidade);
		contentPane.add(lblEstado);
		contentPane.add(lblCep);
		contentPane.add(lblComplemento);
		contentPane.add(lblCpf);
		contentPane.add(lblCargo);
		contentPane.add(lblSenha);
		contentPane.add(cbxEstado);
		contentPane.add(cbxCargo);
		contentPane.add(btnCliente);
		contentPane.add(btnFuncionario);
		contentPane.add(btnConfirmar);
		contentPane.add(btnCancelar);
		
		
		fieldNome.setColumns(10);
		fieldEndereco.setColumns(10);
		fieldCidade.setColumns(10);
		fieldComplemento.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(192, 380, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(192, 405, 144, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(38, 102, 46, 14);
		contentPane.add(lblCdigo);
		
		fieldCarta = new JTextField();
		fieldCarta.setBounds(192, 181, 144, 20);
		contentPane.add(fieldCarta);
		fieldCarta.setColumns(10);
		
		lblCarta = new JLabel("Carta");
		lblCarta.setBounds(192, 156, 46, 14);
		contentPane.add(lblCarta);
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastros.setBounds(0, 11, 522, 44);
		contentPane.add(lblCadastros);
		
		JButton btnVeculo = new JButton("Ve\u00EDculo");
		
		btnVeculo.setBounds(346, 66, 144, 23);
		contentPane.add(btnVeculo);
		
		fieldMarca = new JTextField();
		fieldMarca.setBounds(346, 125, 144, 20);
		contentPane.add(fieldMarca);
		fieldMarca.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(346, 100, 144, 14);
		contentPane.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(346, 156, 144, 14);
		contentPane.add(lblModelo);
		
		fieldModelo = new JTextField();
		fieldModelo.setBounds(346, 181, 144, 20);
		contentPane.add(fieldModelo);
		fieldModelo.setColumns(10);
		
		lblPesoMximokg = new JLabel("Peso M\u00E1ximo (kg)");
		lblPesoMximokg.setBounds(346, 212, 144, 14);
		contentPane.add(lblPesoMximokg);
		
		fieldPesoMax = new JTextField();
		fieldPesoMax.setBounds(346, 237, 144, 20);
		contentPane.add(fieldPesoMax);
		fieldPesoMax.setColumns(10);
		
		lblTipoVeculo = new JLabel("Tipo Ve\u00EDculo");
		lblTipoVeculo.setBounds(346, 268, 144, 14);
		contentPane.add(lblTipoVeculo);
		
		cbxTipoVeiculo = new JComboBox();
		cbxTipoVeiculo.setModel(new DefaultComboBoxModel(new String[] {"", "Van", "Caminh\u00E3o 2 eixos", "Caminh\u00E3o 4 eixos"}));
		cbxTipoVeiculo.setBounds(346, 293, 144, 20);
		contentPane.add(cbxTipoVeiculo);
		
		lblPlacaDoVeculo = new JLabel("Placa do Ve\u00EDculo");
		lblPlacaDoVeculo.setBounds(346, 324, 144, 14);
		contentPane.add(lblPlacaDoVeculo);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(98, 436, 323, 46);
		contentPane.add(panel);
				
		ativarCampos(false, false, false);
		cbxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(cbxCargo.getSelectedIndex() == 3){
					lblCarta.setVisible(true);
					fieldCarta.setVisible(true);
				}
				else{
					lblCarta.setVisible(false);
					fieldCarta.setVisible(false);
				}
			}
		});
		
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
					if(lblCpf.isVisible()) { //CADASTRO DE FUNCIONARIOS
						if(!lblCarta.isVisible()){ //NAO É MOTORISTA
							if(gerenciadorRegrasNegocio.cadastraFuncionario(
									fieldNome.getText(), 
									fieldEndereco.getText(),
									fieldComplemento.getText(),
									fieldCep.getText().replace("-", ""),
									cbxEstado.getSelectedItem().toString(), 
									fieldCidade.getText(), 
									Integer.parseInt(fieldCodigo.getText()),
									fieldCpf.getText().replace("/", "").replace(".", "").replace("-", ""),
									cbxCargo.getSelectedItem().toString(), 									
									txtLogin.getText(), 
									fieldSenha.getText()
									)){
								JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!",  "Cadastro", JOptionPane.INFORMATION_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "Erro no cadastro!",  "Cadastro", JOptionPane.ERROR_MESSAGE);
							}
							fieldNome.setText(""); 
							fieldEndereco.setText(""); 
							fieldComplemento.setText(""); 
							fieldCep.setText(""); 
							cbxEstado.setSelectedIndex(0); 
							fieldCidade.setText(""); 
							fieldCodigo.setText(""); 
							fieldCpf.setText(""); 
							cbxCargo.setSelectedIndex(0); 									
							txtLogin.setText("");  
							fieldSenha.setText(""); 
						}
						else{ //É MOTORISTA
							if(gerenciadorRegrasNegocio.cadastraMotorista(fieldNome.getText(), fieldEndereco.getText(), fieldComplemento.getText(),
									fieldCep.getText().replace("-", ""), cbxEstado.getSelectedItem().toString(), fieldCidade.getText(), 
									fieldCpf.getText().replace("/", "").replace(".", "").replace("-", ""),
									cbxCargo.getSelectedItem().toString(), Integer.parseInt(fieldCodigo.getText()), txtLogin.getText(), 
									fieldSenha.getText(), fieldCarta.getText())){
								JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!",  "Cadastro", JOptionPane.INFORMATION_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "Erro no cadastro!",  "Cadastro", JOptionPane.ERROR_MESSAGE);
							}
							fieldNome.setText("");
							fieldEndereco.setText("");
							fieldComplemento.setText("");
							fieldCep.setText("");
							cbxEstado.setSelectedIndex(0);
							fieldCidade.setText("");
							fieldCpf.setText("");
							cbxCargo.setSelectedIndex(0);
							fieldCodigo.setText("");
							txtLogin.setText("");
							fieldSenha.setText("");
						}
					}else if(lblCnpj.isVisible()){ //CADASTRO DE CLIENTES
						if(gerenciadorRegrasNegocio.cadastraCliente(fieldNome.getText(), fieldEndereco.getText(), fieldComplemento.getText(), 
								fieldCep.getText().replace("-", ""), cbxEstado.getSelectedItem().toString(), 
								fieldCidade.getText(), Integer.parseInt(fieldCodigo.getText()), 
								fieldCnpj.getText().replace("/", "").replace(".", "").replace("-", ""))){
							JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",  "Cadastro", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Erro no cadastro!",  "Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						fieldNome.setText("");
						fieldEndereco.setText("");
						fieldComplemento.setText("");
						fieldCep.setText("");
						cbxEstado.setSelectedIndex(0);
						fieldCidade.setText("");
						fieldCodigo.setText("");
						fieldCnpj.setText("");
					} else if(cbxTipoVeiculo.isVisible()){ //CADASTRO DE VEICULOS
						if(gerenciadorRegrasNegocio.cadastraVeiculo(fieldMarca.getText(), fieldModelo.getText(), 
								Double.parseDouble(fieldPesoMax.getText()), cbxTipoVeiculo.getSelectedItem().toString(),
								Integer.parseInt(fieldCodigo.getText()), fieldPlaca.getText().replace("-", ""))){
							JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!",  "Cadastro", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Erro no cadastro!",  "Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						fieldMarca.setText("");
						fieldModelo.setText("");
						fieldPesoMax.setText("");
						fieldCodigo.setText("");
						fieldPlaca.setText("");
						cbxTipoVeiculo.setSelectedIndex(0);
					} else {
						JOptionPane.showMessageDialog(null, "Escolha uma entidade a ser cadastrada e preencha os dados corretamente.");
					}
				} catch (NegocioException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ativar opções de cliente*******************************************
				ativarCampos(false, true, false);
				
			}
		});
		
		
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ativar opções de funcionario*******************************************
				ativarCampos(true, false, false);
				
			}
		});
		
		btnVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ativar opções de veiculo*******************************************
				ativarCampos(false, false, true);
			}
		});
		
	}
	protected void ativarCampos(boolean funcionario, boolean cliente, boolean veiculo) {
		boolean geral = true;
		if(!funcionario && !cliente && !veiculo)
			geral = false;
		if(!funcionario && !cliente && veiculo){
			fieldNome.setVisible(geral);
			fieldEndereco.setVisible(geral);
			fieldCidade.setVisible(geral);
			fieldComplemento.setVisible(geral);
			fieldCep.setVisible(geral);
			fieldCnpj.setVisible(cliente);
			fieldCpf.setVisible(funcionario);
			fieldSenha.setVisible(funcionario);
			lblNome.setVisible(geral);
			lblCnpj.setVisible(cliente);
			lblEndereo.setVisible(geral);
			lblCidade.setVisible(geral);
			lblEstado.setVisible(geral);
			lblCep.setVisible(geral);
			lblComplemento.setVisible(geral);
			lblCpf.setVisible(funcionario);
			lblCargo.setVisible(funcionario);
			lblSenha.setVisible(funcionario);
			cbxEstado.setVisible(geral);
			cbxCargo.setVisible(funcionario);
			btnConfirmar.setVisible(true);
			btnCancelar.setVisible(true);
			lblLogin.setVisible(funcionario);
			txtLogin.setVisible(funcionario);
			fieldCodigo.setVisible(geral);
			lblCdigo.setVisible(geral);
			fieldCarta.setVisible(false);
			lblCarta.setVisible(false);	

			fieldNome.setVisible(false);
			fieldEndereco.setVisible(false);
			fieldCidade.setVisible(false);
			fieldComplemento.setVisible(false);
			fieldCep.setVisible(false);
			lblNome.setVisible(false);
			lblEndereo.setVisible(false);
			lblCidade.setVisible(false);
			lblEstado.setVisible(false);
			lblCep.setVisible(false);
			lblComplemento.setVisible(false);
			cbxEstado.setVisible(false);
			fieldMarca.setVisible(veiculo);
			lblMarca.setVisible(veiculo);
			lblModelo.setVisible(veiculo);
			fieldModelo.setVisible(veiculo);
			lblPesoMximokg.setVisible(veiculo);
			fieldPesoMax.setVisible(veiculo);
			cbxTipoVeiculo.setVisible(veiculo);
			lblPlacaDoVeculo.setVisible(veiculo);
			fieldPlaca.setVisible(veiculo);
			lblTipoVeculo.setVisible(veiculo);
			btnConfirmar.setVisible(true);
			btnCancelar.setVisible(true);			
			return;
		}
			
		fieldNome.setVisible(geral);
		fieldEndereco.setVisible(geral);
		fieldCidade.setVisible(geral);
		fieldComplemento.setVisible(geral);
		fieldCep.setVisible(geral);
		fieldCnpj.setVisible(cliente);
		fieldCpf.setVisible(funcionario);
		fieldSenha.setVisible(funcionario);
		lblNome.setVisible(geral);
		lblCnpj.setVisible(cliente);
		lblEndereo.setVisible(geral);
		lblCidade.setVisible(geral);
		lblEstado.setVisible(geral);
		lblCep.setVisible(geral);
		lblComplemento.setVisible(geral);
		lblCpf.setVisible(funcionario);
		lblCargo.setVisible(funcionario);
		lblSenha.setVisible(funcionario);
		cbxEstado.setVisible(geral);
		cbxCargo.setVisible(funcionario);
		btnConfirmar.setVisible(true);
		btnCancelar.setVisible(true);
		lblLogin.setVisible(funcionario);
		txtLogin.setVisible(funcionario);
		fieldCodigo.setVisible(geral);
		lblCdigo.setVisible(geral);
		fieldCarta.setVisible(false);
		lblCarta.setVisible(false);
		fieldMarca.setVisible(veiculo);
		lblMarca.setVisible(veiculo);
		lblModelo.setVisible(veiculo);
		fieldModelo.setVisible(veiculo);
		lblPesoMximokg.setVisible(veiculo);
		fieldPesoMax.setVisible(veiculo);
		cbxTipoVeiculo.setVisible(veiculo);
		lblPlacaDoVeculo.setVisible(veiculo);
		fieldPlaca.setVisible(veiculo);
		lblTipoVeculo.setVisible(veiculo);
		
		if(Usuario.getCargo().equals("Recursos Humanos") || Usuario.getCargo().equals("Gerente")){
			btnFuncionario.setVisible(true);
		} else{
			btnFuncionario.setVisible(false);
		}
	}
	
}