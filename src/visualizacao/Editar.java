package visualizacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bean.Cliente;
import bean.Motorista;
import bean.Usuario;
import bean.Veiculo;
import negocio.GerenciadorRegrasNegocio;
import negocio.GerenciadorRegrasNegocio.BaseDados;
import negocio.NegocioException;
import java.awt.Color;

public class Editar extends JFrame {

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
	private JTextField fieldCodigoPesquisa;
	private JButton btnAlterar;
	private JLabel lblApsFazerAs;
	private JLabel lblCliqueEmalterar;
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
	public Editar() throws ParseException {
		setResizable(false);
		
		setTitle("Cadastros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] estados = {"AC","AL","AP","AM","BA","CE","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
		String[] cargos = {"Gerente","Recursos Humanos","Atendimento ao Cliente","Motorista"};
		
		
		fieldPlaca = new JFormattedTextField();
		fieldPlaca.setBounds(578, 406, 144, 20);
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
		lblNome.setForeground(Color.WHITE);
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.WHITE);
		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.WHITE);
		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.WHITE);
		lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(Color.WHITE);
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCargo = new JLabel("Cargo");
		lblCargo.setForeground(Color.WHITE);
		lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		cbxEstado = new JComboBox(estados);
		cbxCargo = new JComboBox(cargos);
		btnCancelar = new JButton("Cancelar");
		btnCliente = new JButton("Cliente");
		btnFuncionario = new JButton("Funcion\u00E1rio");
		fieldCodigo = new JFormattedTextField();
		fieldCodigo.setEditable(false);
		fieldCodigo.setEnabled(false);
		fieldCodigo.setBounds(270, 182, 144, 20);
		contentPane.add(fieldCodigo);
		fieldCodigo.setColumns(10);
		new MaskFormatter("#####-###").install(fieldCep);
		new MaskFormatter("###.###.###/####-##").install(fieldCnpj);
		new MaskFormatter("###.###.###-##").install(fieldCpf);
		new MaskFormatter("UUU-####").install(fieldPlaca);
		new MaskFormatter("###").install(fieldCodigo);
		
		
		fieldNome.setBounds(270, 294, 144, 20);
		fieldEndereco.setBounds(424, 350, 144, 20);
		fieldCidade.setBounds(424, 462, 144, 20);
		fieldComplemento.setBounds(270, 406, 144, 20);
		fieldCep.setBounds(424, 406, 144, 20);
		fieldCnpj.setBounds(270, 350, 144, 20);
		fieldCpf.setBounds(424, 294, 144, 20);
		fieldSenha.setBounds(578, 518, 144, 20);
		lblNome.setBounds(270, 269, 46, 14);
		lblCnpj.setBounds(270, 325, 46, 14);
		lblEndereo.setBounds(424, 325, 144, 14);
		lblCidade.setBounds(424, 437, 46, 14);
		lblEstado.setBounds(424, 493, 46, 14);
		lblCep.setBounds(424, 381, 46, 14);
		lblComplemento.setBounds(270, 381, 144, 14);
		lblCpf.setBounds(424, 269, 46, 14);
		lblCargo.setBounds(424, 157, 46, 14);
		lblSenha.setBounds(578, 493, 46, 14);
		cbxEstado.setBounds(424, 518, 144, 20);
		cbxCargo.setBounds(424, 182, 144, 20);
		btnCliente.setBounds(270, 76, 144, 23);
		btnFuncionario.setBounds(424, 76, 144, 23);
		btnCancelar.setBounds(109, 283, 107, 23);
		
		
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
		contentPane.add(btnCancelar);
		
		
		fieldNome.setColumns(10);
		fieldEndereco.setColumns(10);
		fieldCidade.setColumns(10);
		fieldComplemento.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(578, 437, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(578, 462, 144, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setBounds(270, 157, 46, 14);
		contentPane.add(lblCdigo);
		
		fieldCarta = new JTextField();
		fieldCarta.setBounds(424, 238, 144, 20);
		contentPane.add(fieldCarta);
		fieldCarta.setColumns(10);
		
		lblCarta = new JLabel("Carta");
		lblCarta.setForeground(Color.WHITE);
		lblCarta.setBounds(424, 213, 46, 14);
		contentPane.add(lblCarta);
		
		JLabel lblCadastros = new JLabel("Altera\u00E7\u00F5es");
		lblCadastros.setForeground(Color.WHITE);
		lblCadastros.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastros.setBounds(270, 21, 452, 44);
		contentPane.add(lblCadastros);
		
		JButton btnVeculo = new JButton("Ve\u00EDculo");
		
		btnVeculo.setBounds(578, 76, 144, 23);
		contentPane.add(btnVeculo);
		
		fieldMarca = new JTextField();
		fieldMarca.setBounds(578, 182, 144, 20);
		contentPane.add(fieldMarca);
		fieldMarca.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setBounds(578, 157, 144, 14);
		contentPane.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setBounds(578, 213, 144, 14);
		contentPane.add(lblModelo);
		
		fieldModelo = new JTextField();
		fieldModelo.setBounds(578, 238, 144, 20);
		contentPane.add(fieldModelo);
		fieldModelo.setColumns(10);
		
		lblPesoMximokg = new JLabel("Peso M\u00E1ximo (kg)");
		lblPesoMximokg.setForeground(Color.WHITE);
		lblPesoMximokg.setBounds(578, 269, 144, 14);
		contentPane.add(lblPesoMximokg);
		
		fieldPesoMax = new JTextField();
		fieldPesoMax.setBounds(578, 294, 144, 20);
		contentPane.add(fieldPesoMax);
		fieldPesoMax.setColumns(10);
		
		lblTipoVeculo = new JLabel("Tipo Ve\u00EDculo");
		lblTipoVeculo.setForeground(Color.WHITE);
		lblTipoVeculo.setBounds(578, 325, 144, 14);
		contentPane.add(lblTipoVeculo);
		
		cbxTipoVeiculo = new JComboBox();
		cbxTipoVeiculo.setModel(new DefaultComboBoxModel(new String[] {"", "Van", "Caminh\u00E3o 2 eixos", "Caminh\u00E3o 4 eixos"}));
		cbxTipoVeiculo.setBounds(578, 350, 144, 20);
		contentPane.add(cbxTipoVeiculo);
		
		lblPlacaDoVeculo = new JLabel("Placa do Ve\u00EDculo");
		lblPlacaDoVeculo.setForeground(Color.WHITE);
		lblPlacaDoVeculo.setBounds(578, 381, 144, 14);
		contentPane.add(lblPlacaDoVeculo);
		
		fieldCodigoPesquisa = new JTextField();
		fieldCodigoPesquisa.setBounds(10, 256, 89, 20);
		contentPane.add(fieldCodigoPesquisa);
		fieldCodigoPesquisa.setColumns(10);
		
		JButton btnDesligar = new JButton("Desligar");
		btnDesligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblCpf.isVisible()) { 					
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						int codigo = Integer.parseInt(fieldCodigoPesquisa.getText());
						gerenciadorRegrasNegocio.deleteMotorista(codigo);
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
					
				}else if(lblCnpj.isVisible()){ 
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						int codigo = Integer.parseInt(fieldCodigoPesquisa.getText());
						gerenciadorRegrasNegocio.deleteCliente(codigo);
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
				} else if(lblPlacaDoVeculo.isVisible()){ 
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						int codigo = Integer.parseInt(fieldCodigoPesquisa.getText());
						gerenciadorRegrasNegocio.deleteVeiculo(codigo);
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
				} else{
					JOptionPane.showMessageDialog(null, "Selecione um item para pesquisa primeiro!");
				}
			}
		});
		btnDesligar.setBounds(10, 283, 89, 23);
		contentPane.add(btnDesligar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//edição funcionario
				if(fieldCodigoPesquisa.getText()==""){
					JOptionPane.showMessageDialog(null, "Insira um código");
					return;
				}
				if(lblCpf.isVisible()) { 
					btnDesligar.setVisible(true);					
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						Motorista motorista = gerenciadorRegrasNegocio.consultaFuncionario(Integer.parseInt(fieldCodigoPesquisa.getText()));
						if(motorista != null){
							fieldCodigo.setText(motorista.getCodigopessoa()+"");
							fieldNome.setText(motorista.getNome());
							txtLogin.setText(motorista.getLogin());
							fieldSenha.setText(motorista.getSenha());
							fieldEndereco.setText(motorista.getEndereco());
							fieldComplemento.setText(motorista.getComplemento());
							fieldCep.setText(motorista.getCep());
							cbxEstado.setSelectedItem(motorista.getEstado());
							fieldCidade.setText(motorista.getCidade());
							fieldCpf.setText(motorista.getCpf());
							cbxCargo.setSelectedItem(motorista.getCargo());
							fieldCarta.setText(motorista.getTipoCarta());
							
						} else {
							JOptionPane.showMessageDialog(null, "Registro inexistente!");
						}
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
					
				}else if(lblCnpj.isVisible()){ //edição cliente
					btnDesligar.setVisible(true);
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						Cliente cliente = gerenciadorRegrasNegocio.consultaCliente(Integer.parseInt(fieldCodigoPesquisa.getText()));
						if(cliente != null){
							fieldCodigo.setText(cliente.getCodigopessoa()+"");
							fieldNome.setText(cliente.getNome());
							fieldEndereco.setText(cliente.getEndereco());
							fieldComplemento.setText(cliente.getComplemento());
							fieldCep.setText(cliente.getCep());
							cbxEstado.setSelectedItem(cliente.getEstado());
							fieldCidade.setText(cliente.getCidade());
							fieldCnpj.setText(cliente.getCnpj());
						} else {
							JOptionPane.showMessageDialog(null, "Registro inexistente!");
						}
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
				} else if(lblPlacaDoVeculo.isVisible()){ //edição veiculo
					btnDesligar.setVisible(true);
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						Veiculo veiculo = gerenciadorRegrasNegocio.consultaVeiculo(Integer.parseInt(fieldCodigoPesquisa.getText()));
						if(veiculo != null){
							fieldCodigo.setText(veiculo.getCodigoVeiculo()+"");
							fieldMarca.setText(veiculo.getMarca());
							fieldModelo.setText(veiculo.getModelo());
							fieldPesoMax.setText(veiculo.getPesoMax()+"");
							cbxTipoVeiculo.setSelectedItem(veiculo.getTipoVeiculo());
							fieldPlaca.setText(veiculo.getPlaca());
							
						} else {
							JOptionPane.showMessageDialog(null, "Registro inexistente!");
						}
					} catch (NegocioException e1){
						e1.printStackTrace();
					}
				} else{
					JOptionPane.showMessageDialog(null, "Selecione um item para pesquisa!");
				}
			}
		});
		btnPesquisar.setBounds(109, 255, 107, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo desejado");
		lblDigiteOCdigo.setBounds(10, 231, 206, 14);
		contentPane.add(lblDigiteOCdigo);
		
		JLabel lblSelecioneUmaEntidade = new JLabel("Selecione uma entidade a ser alterada");
		lblSelecioneUmaEntidade.setBounds(10, 70, 234, 29);
		contentPane.add(lblSelecioneUmaEntidade);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblCpf.isVisible()) {
					try {
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						gerenciadorRegrasNegocio.updateFuncionario(fieldNome.getText(), fieldEndereco.getText(), fieldComplemento.getText(),
								fieldCep.getText().replace("-", ""), cbxEstado.getSelectedItem().toString(), fieldCidade.getText(), 
								fieldCpf.getText().replace("/", "").replace(".", "").replace("-", ""),
								cbxCargo.getSelectedItem().toString(), Integer.parseInt(fieldCodigoPesquisa.getText()), txtLogin.getText(), 
								fieldSenha.getText(), fieldCarta.getText());
						JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(lblCnpj.isVisible()){
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						gerenciadorRegrasNegocio.updateCliente(fieldNome.getText(), fieldEndereco.getText(), fieldComplemento.getText(), 
								fieldCep.getText().replace("-", ""), cbxEstado.getSelectedItem().toString(), 
								fieldCidade.getText(), Integer.parseInt(fieldCodigoPesquisa.getText()), 
								fieldCnpj.getText().replace("/", "").replace(".", "").replace("-", ""));
						JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(lblPlacaDoVeculo.isVisible()){
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						gerenciadorRegrasNegocio.updateVeiculo(fieldMarca.getText(), fieldModelo.getText(), 
								Double.parseDouble(fieldPesoMax.getText()), cbxTipoVeiculo.getSelectedItem().toString(),
								Integer.parseInt(fieldCodigoPesquisa.getText()), fieldPlaca.getText().replace("-", ""));
						JOptionPane.showMessageDialog(null, "Veiculo alterado com sucesso!");
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnAlterar.setBounds(10, 355, 89, 23);
		contentPane.add(btnAlterar);
		
		lblApsFazerAs = new JLabel("Ap\u00F3s fazer as altera\u00E7\u00F5es desejadas");
		lblApsFazerAs.setBounds(10, 315, 206, 14);
		contentPane.add(lblApsFazerAs);
		
		lblCliqueEmalterar = new JLabel("clique em \"alterar\" ");
		lblCliqueEmalterar.setBounds(10, 330, 206, 14);
		contentPane.add(lblCliqueEmalterar);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(242, 11, 505, 567);
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
			btnCancelar.setVisible(geral);
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