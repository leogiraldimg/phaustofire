package visualizacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import bean.Funcionario;
import bean.Pedido;
import negocio.GerenciadorRegrasNegocio;
import negocio.NegocioException;
import negocio.GerenciadorRegrasNegocio.BaseDados;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ConsultarPedido {

	private JFrame frame;
	private JFormattedTextField fieldCodMotorista;
	private JTable tblConsultaFuncionario;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPedido window = new ConsultarPedido();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @return 
	 */
	
	public void exibirPedido(){
		frame.setVisible(true);
	}
	
	public ConsultarPedido() {
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
	
	private void montaTabelaPedidos(List<Pedido> pedidos) {
		DefaultTableModel model = (DefaultTableModel) tblConsultaFuncionario.getModel();
		clearTabela(model);

		for (Pedido pedido : pedidos) {
			model.addRow(new Object[] { pedido.getCodigoPedido(), pedido.getFinalizado(), pedido.getCodigoCliente(), pedido.getCodigoVeiculo()});
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultarPedidos = new JLabel("Consultar Pedidos");
		lblConsultarPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPedidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarPedidos.setBounds(10, 11, 414, 35);
		frame.getContentPane().add(lblConsultarPedidos);
		
		JLabel lblCdigoMotorista = new JLabel("C\u00F3digo Motorista:");
		lblCdigoMotorista.setForeground(Color.WHITE);
		lblCdigoMotorista.setBounds(20, 77, 117, 14);
		frame.getContentPane().add(lblCdigoMotorista);
		
		fieldCodMotorista = new JFormattedTextField();
		fieldCodMotorista.setBounds(137, 73, 86, 20);
		frame.getContentPane().add(fieldCodMotorista);
		fieldCodMotorista.setColumns(10);
		try {
			new MaskFormatter("###").install(fieldCodMotorista);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		tblConsultaFuncionario = new JTable(new DefaultTableModel(new Object[] { "Código Pedido", "Finalizado", "Codigo Cliente", "Codigo Veiculo"},0));
		tblConsultaFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tblConsultaFuncionario.setBounds(0, 90, 700, 0);
		frame.getContentPane().add(tblConsultaFuncionario);
		JScrollPane scrollPaneFuncionario = new JScrollPane(tblConsultaFuncionario);
		scrollPaneFuncionario.setBounds(10, 122, 424, 265);
		frame.getContentPane().add(scrollPaneFuncionario);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					scrollPaneFuncionario.setVisible(true);
					tblConsultaFuncionario.setVisible(true);
					List<Pedido> pedidos;
					try{
						GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio(BaseDados.JDBC);
						pedidos = gerenciadorRegrasNegocio.listaPedidos(Integer.parseInt(fieldCodMotorista.getText()));
						montaTabelaPedidos(pedidos);
					} catch (NegocioException e1){
						JOptionPane.showMessageDialog(null,"Não foi possível listar os usuários. \n" + e1.getMessage());
					}
			}
		});
		btnConsultar.setBounds(248, 72, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(345, 72, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 56, 228, 55);
		frame.getContentPane().add(panel);
	}
}
