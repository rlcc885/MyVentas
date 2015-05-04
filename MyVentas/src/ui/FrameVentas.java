package ui;

import hbm.dto.Customer;
import hbm.dto.DebtDetailByCustomer;
import hbm.dto.Product;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.VentaController;

public class FrameVentas {

	private JFrame frmGestionDeVentas;
	private JPanel panelMain;
	private JPanel panelClientes;
	private JPanel panelProductos;
	private JTextField textFieldCorreoCliente;
	private JComboBox<ComboItem> comboBoxCliente;
	private JComboBox<ComboItem> comboBoxProducto;
	private JTextField textFieldPrecioProducto;
	private JTextField textFieldPrecioOfertaProducto;
	private JMenuItem mntmAgregarCompra;
	private JPanel panelCompra;
	private JLabel lblCliente_1;
	private JComboBox<ComboItem> comboBoxClienteCompra;
	private JTextField textFieldCorreoClienteCompra;
	private JLabel lblProducto;
	private JComboBox<ComboItem> comboBoxProductoCompra;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidadProducto;
	private JComboBox<ComboItem> comboBoxPrecioProducto;
	private JTextField textFieldTotalCompra;
	private JMenuItem mntmSalir;
	private JButton btnAgregar;
	private JLabel lblComentarios;
	private JScrollPane scrollPaneComment;
	private JTextArea textAreaCommentVenta;
	private JLabel labelResultadoCompra;
	private JLabel lblDeuda;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FrameVentas window = new FrameVentas();
					window.frmGestionDeVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameVentas() {
		initialize();
		updateComponents();
	}

	private void updateComponents(){
		updateComboCliente(comboBoxCliente);
		updateComboCliente(comboBoxClienteCompra);
		updateComboProducto(comboBoxProducto);
		updateComboProducto(comboBoxProductoCompra);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeVentas = new JFrame();
		frmGestionDeVentas.setTitle("Gestion de Ventas");
		frmGestionDeVentas.setBounds(100, 100, 450, 300);
		frmGestionDeVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestionDeVentas.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmVerClientes = new JMenuItem("Ver Clientes");
		mntmVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmVerClientesActionPerformed(e);
			}
		});
		
		mntmAgregarCompra = new JMenuItem("Agregar Compra");
		mntmAgregarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmAgregarCompraActionPerformed(e);
			}
		});
		mnArchivo.add(mntmAgregarCompra);
		mnArchivo.add(mntmVerClientes);
		
		JMenuItem mntmVerProductos = new JMenuItem("Ver Productos");
		mntmVerProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmVerProductosActionPerformed(e);
			}
		});
		mnArchivo.add(mntmVerProductos);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		panelMain = new JPanel();
		frmGestionDeVentas.getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new CardLayout(0, 0));
		
		panelCompra = new JPanel();
		panelMain.add(panelCompra, "panelCompra");
		GridBagLayout gbl_panelCompra = new GridBagLayout();
		gbl_panelCompra.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCompra.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCompra.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCompra.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCompra.setLayout(gbl_panelCompra);
		
		lblCliente_1 = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente_1 = new GridBagConstraints();
		gbc_lblCliente_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente_1.anchor = GridBagConstraints.EAST;
		gbc_lblCliente_1.gridx = 1;
		gbc_lblCliente_1.gridy = 1;
		panelCompra.add(lblCliente_1, gbc_lblCliente_1);
		
		comboBoxClienteCompra = new JComboBox<ComboItem>();
		comboBoxClienteCompra.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxClienteCompraItemStateChanged(e);
			}
		});
		GridBagConstraints gbc_comboBoxClienteCompra = new GridBagConstraints();
		gbc_comboBoxClienteCompra.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClienteCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClienteCompra.gridx = 2;
		gbc_comboBoxClienteCompra.gridy = 1;
		panelCompra.add(comboBoxClienteCompra, gbc_comboBoxClienteCompra);
		
		textFieldCorreoClienteCompra = new JTextField();
		textFieldCorreoClienteCompra.setEditable(false);
		GridBagConstraints gbc_textFieldCorreoClienteCompra = new GridBagConstraints();
		gbc_textFieldCorreoClienteCompra.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCorreoClienteCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCorreoClienteCompra.gridx = 3;
		gbc_textFieldCorreoClienteCompra.gridy = 1;
		panelCompra.add(textFieldCorreoClienteCompra, gbc_textFieldCorreoClienteCompra);
		textFieldCorreoClienteCompra.setColumns(10);
		
		lblProducto = new JLabel("Producto:");
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.anchor = GridBagConstraints.EAST;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 1;
		gbc_lblProducto.gridy = 2;
		panelCompra.add(lblProducto, gbc_lblProducto);
		
		comboBoxProductoCompra = new JComboBox<ComboItem>();
		comboBoxProductoCompra.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxProductoCompraItemStateChanged(e);
			}
		});
		GridBagConstraints gbc_comboBoxProductoCompra = new GridBagConstraints();
		gbc_comboBoxProductoCompra.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProductoCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProductoCompra.gridx = 2;
		gbc_comboBoxProductoCompra.gridy = 2;
		panelCompra.add(comboBoxProductoCompra, gbc_comboBoxProductoCompra);
		
		comboBoxPrecioProducto = new JComboBox<ComboItem>();
		comboBoxPrecioProducto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxPrecioProductoItemStateChanged(e);
			}
		});
		GridBagConstraints gbc_comboBoxPrecioProducto = new GridBagConstraints();
		gbc_comboBoxPrecioProducto.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPrecioProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPrecioProducto.gridx = 3;
		gbc_comboBoxPrecioProducto.gridy = 2;
		panelCompra.add(comboBoxPrecioProducto, gbc_comboBoxPrecioProducto);
		
		spinnerCantidadProducto = new JSpinner();
		spinnerCantidadProducto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerCantidadProductoStateChanged(e);
			}
		});
		
		lblCantidad = new JLabel("Cantidad:");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 1;
		gbc_lblCantidad.gridy = 3;
		panelCompra.add(lblCantidad, gbc_lblCantidad);
		spinnerCantidadProducto.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spinnerCantidadProducto = new GridBagConstraints();
		gbc_spinnerCantidadProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerCantidadProducto.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerCantidadProducto.gridx = 2;
		gbc_spinnerCantidadProducto.gridy = 3;
		panelCompra.add(spinnerCantidadProducto, gbc_spinnerCantidadProducto);
		
		textFieldTotalCompra = new JTextField();
		textFieldTotalCompra.setEditable(false);
		GridBagConstraints gbc_textFieldTotalCompra = new GridBagConstraints();
		gbc_textFieldTotalCompra.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalCompra.gridx = 3;
		gbc_textFieldTotalCompra.gridy = 3;
		panelCompra.add(textFieldTotalCompra, gbc_textFieldTotalCompra);
		textFieldTotalCompra.setColumns(10);
		
		lblComentarios = new JLabel("Comentarios:");
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 1;
		gbc_lblComentarios.gridy = 4;
		panelCompra.add(lblComentarios, gbc_lblComentarios);
		
		scrollPaneComment = new JScrollPane();
		GridBagConstraints gbc_scrollPaneComment = new GridBagConstraints();
		gbc_scrollPaneComment.gridheight = 2;
		gbc_scrollPaneComment.gridwidth = 2;
		gbc_scrollPaneComment.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneComment.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneComment.gridx = 2;
		gbc_scrollPaneComment.gridy = 4;
		panelCompra.add(scrollPaneComment, gbc_scrollPaneComment);
		
		textAreaCommentVenta = new JTextArea();
		textAreaCommentVenta.setFont(new Font("Calibri", Font.PLAIN, 12));
		scrollPaneComment.setViewportView(textAreaCommentVenta);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.anchor = GridBagConstraints.EAST;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 6;
		panelCompra.add(btnAgregar, gbc_btnAgregar);
		
		labelResultadoCompra = new JLabel("-");
		GridBagConstraints gbc_labelResultadoCompra = new GridBagConstraints();
		gbc_labelResultadoCompra.anchor = GridBagConstraints.WEST;
		gbc_labelResultadoCompra.gridwidth = 5;
		gbc_labelResultadoCompra.insets = new Insets(0, 0, 0, 5);
		gbc_labelResultadoCompra.gridx = 0;
		gbc_labelResultadoCompra.gridy = 8;
		panelCompra.add(labelResultadoCompra, gbc_labelResultadoCompra);
		
		panelClientes = new JPanel();
		panelMain.add(panelClientes, "panelClientes");
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{0, 0, 168, 0, 0};
		gbl_panelClientes.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelClientes.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 1;
		panelClientes.add(lblCliente, gbc_lblCliente);
		
		comboBoxCliente = new JComboBox<ComboItem>();
		comboBoxCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxClienteItemStateChanged(e);
			}
		});
		comboBoxCliente.setModel(new DefaultComboBoxModel<ComboItem>());
		GridBagConstraints gbc_comboBoxCliente = new GridBagConstraints();
		gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCliente.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCliente.gridx = 2;
		gbc_comboBoxCliente.gridy = 1;
		panelClientes.add(comboBoxCliente, gbc_comboBoxCliente);
		
		JLabel lblCorreo = new JLabel("Correo:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 2;
		panelClientes.add(lblCorreo, gbc_lblCorreo);
		
		textFieldCorreoCliente = new JTextField();
		textFieldCorreoCliente.setEditable(false);
		GridBagConstraints gbc_textFieldCorreoCliente = new GridBagConstraints();
		gbc_textFieldCorreoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCorreoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCorreoCliente.gridx = 2;
		gbc_textFieldCorreoCliente.gridy = 2;
		panelClientes.add(textFieldCorreoCliente, gbc_textFieldCorreoCliente);
		textFieldCorreoCliente.setColumns(10);
		
		lblDeuda = new JLabel("Deuda:");
		GridBagConstraints gbc_lblDeuda = new GridBagConstraints();
		gbc_lblDeuda.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeuda.gridx = 1;
		gbc_lblDeuda.gridy = 3;
		panelClientes.add(lblDeuda, gbc_lblDeuda);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		panelClientes.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Cantidad", "Precio", "Fecha", "Subtotal"  
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Double.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		panelProductos = new JPanel();
		panelMain.add(panelProductos, "panelProductos");
		GridBagLayout gbl_panelProductos = new GridBagLayout();
		gbl_panelProductos.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelProductos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelProductos.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelProductos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelProductos.setLayout(gbl_panelProductos);
		
		JLabel lblProductos = new JLabel("Productos");
		GridBagConstraints gbc_lblProductos = new GridBagConstraints();
		gbc_lblProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductos.anchor = GridBagConstraints.EAST;
		gbc_lblProductos.gridx = 1;
		gbc_lblProductos.gridy = 1;
		panelProductos.add(lblProductos, gbc_lblProductos);
		
		comboBoxProducto = new JComboBox<ComboItem>();
		comboBoxProducto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxProductosItemStateChanged(e);
			}
		});
		comboBoxProducto.setModel(new DefaultComboBoxModel<ComboItem>());
		GridBagConstraints gbc_comboBoxProducto = new GridBagConstraints();
		gbc_comboBoxProducto.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProducto.gridx = 2;
		gbc_comboBoxProducto.gridy = 1;
		panelProductos.add(comboBoxProducto, gbc_comboBoxProducto);
		JLabel lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 3;
		panelProductos.add(lblPrecio, gbc_lblPrecio);
		
		textFieldPrecioProducto = new JTextField();
		textFieldPrecioProducto.setEditable(false);
		GridBagConstraints gbc_textFieldPrecioProducto = new GridBagConstraints();
		gbc_textFieldPrecioProducto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrecioProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecioProducto.gridx = 2;
		gbc_textFieldPrecioProducto.gridy = 3;
		panelProductos.add(textFieldPrecioProducto, gbc_textFieldPrecioProducto);
		textFieldPrecioProducto.setColumns(10);
		
		JLabel lblOferta = new JLabel("Oferta:");
		GridBagConstraints gbc_lblOferta = new GridBagConstraints();
		gbc_lblOferta.anchor = GridBagConstraints.EAST;
		gbc_lblOferta.insets = new Insets(0, 0, 0, 5);
		gbc_lblOferta.gridx = 1;
		gbc_lblOferta.gridy = 5;
		panelProductos.add(lblOferta, gbc_lblOferta);
		
		textFieldPrecioOfertaProducto = new JTextField();
		textFieldPrecioOfertaProducto.setEditable(false);
		GridBagConstraints gbc_textFieldPrecioOfertaProducto = new GridBagConstraints();
		gbc_textFieldPrecioOfertaProducto.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPrecioOfertaProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecioOfertaProducto.gridx = 2;
		gbc_textFieldPrecioOfertaProducto.gridy = 5;
		panelProductos.add(textFieldPrecioOfertaProducto, gbc_textFieldPrecioOfertaProducto);
		textFieldPrecioOfertaProducto.setColumns(10);
	}

	protected void btnAgregarActionPerformed(ActionEvent e) {
		Integer idCliente = new Integer (((ComboItem)comboBoxClienteCompra.getSelectedItem()).getValue());
		Integer idProducto = new Integer (((ComboItem)comboBoxProductoCompra.getSelectedItem()).getValue());
		Double precio = new Double(((ComboItem)comboBoxPrecioProducto.getSelectedItem()).getValue());
		Integer cantidad = new Integer(""+spinnerCantidadProducto.getValue());
		String comentario = textAreaCommentVenta.getText();
		labelResultadoCompra.setText(VentaController.addSale(idCliente, idProducto, precio, cantidad, comentario));
	}

	protected void spinnerCantidadProductoStateChanged(ChangeEvent e) {
		Integer cantidad = new Integer(""+spinnerCantidadProducto.getValue());
		Double precio = new Double(""+((ComboItem)comboBoxPrecioProducto.getSelectedItem()).getValue());
		textFieldTotalCompra.setText(""+(cantidad*precio));
	}

	protected void comboBoxPrecioProductoItemStateChanged(ItemEvent e) {
		if(comboBoxPrecioProducto.getSelectedItem()!=null){
			Integer cantidad = new Integer(""+spinnerCantidadProducto.getValue());
			Double precio = new Double(""+((ComboItem)comboBoxPrecioProducto.getSelectedItem()).getValue());
			textFieldTotalCompra.setText(""+(cantidad*precio));
		}
	}

	protected void comboBoxProductoCompraItemStateChanged(ItemEvent e) {
		Integer id = new Integer(((ComboItem)comboBoxProductoCompra.getSelectedItem()).getValue());
		Product product = VentaController.getProduct(id);
		updateComboPrecio(comboBoxPrecioProducto, product);
	}

	private void updateComboPrecio(JComboBox<ComboItem> comboBox, Product product) {
		comboBox.removeAllItems();
		ComboItem priceProduct = new ComboItem(""+product.getPrice(), ""+product.getPrice());
		comboBox.addItem(priceProduct);
		priceProduct = new ComboItem(""+product.getLowPrice(), ""+product.getLowPrice());
		comboBox.addItem(priceProduct);
	}

	protected void comboBoxClienteCompraItemStateChanged(ItemEvent e) {
		Integer id = new Integer(((ComboItem)comboBoxClienteCompra.getSelectedItem()).getValue());
		Customer customer = VentaController.getCustomer(id);
		textFieldCorreoClienteCompra.setText(customer.getEmail());
	}

	protected void mntmAgregarCompraActionPerformed(ActionEvent e) {
		((CardLayout)panelMain.getLayout()).show(panelMain, "panelCompra");
	}

	protected void comboBoxProductosItemStateChanged(ItemEvent e) {
		Integer id = new Integer(((ComboItem)comboBoxProducto.getSelectedItem()).getValue());
		Product product = VentaController.getProduct(id);
		textFieldPrecioProducto.setText(""+product.getPrice());
		textFieldPrecioOfertaProducto.setText(""+product.getLowPrice());
	}

	protected void comboBoxClienteItemStateChanged(ItemEvent e) {
		Integer id = new Integer(((ComboItem)comboBoxCliente.getSelectedItem()).getValue());
		Customer customer = VentaController.getCustomer(id);
		textFieldCorreoCliente.setText(customer.getEmail());
		List<DebtDetailByCustomer> debtDetail = VentaController.getDebByCustomer(id);
		if(debtDetail != null)
			for (DebtDetailByCustomer debtDetailByCustomer : debtDetail)
				if(debtDetailByCustomer!=null && debtDetailByCustomer.getId()!=null)
					System.out.println(debtDetailByCustomer.getId().getProductName());
	}

	private void updateComboProducto(JComboBox<ComboItem> comboBox) {
		comboBox.removeAllItems();
		for (Product product : VentaController.getProducts()) {
			ComboItem comboProduct = new ComboItem(""+product.getId(), product.getName());
			comboBox.addItem(comboProduct);
		}
	}

	private void updateComboCliente(JComboBox<ComboItem> comboBox) {
		comboBox.removeAllItems();
		for (Customer customer : VentaController.getCustomers()) {
			ComboItem comboCustomer = new ComboItem(""+customer.getId(), customer.getName());
			comboBox.addItem(comboCustomer);
		}
	}

	protected void mntmVerProductosActionPerformed(ActionEvent e) {
		((CardLayout)panelMain.getLayout()).show(panelMain, "panelProductos");
	}

	protected void mntmVerClientesActionPerformed(ActionEvent e) {
		((CardLayout)panelMain.getLayout()).show(panelMain, "panelClientes");
	}

}
