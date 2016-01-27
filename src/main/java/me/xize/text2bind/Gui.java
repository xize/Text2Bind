package me.xize.text2bind;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import me.xize.text2bind.events.ConvertEvent;
import me.xize.text2bind.events.CopyEvent;
import me.xize.text2bind.events.ResetEvent;

public class Gui extends JFrame implements GuiApi {

	private static final long serialVersionUID = 4106630158776894887L;
	
	private JButton button;
	private JButton copy;
	private JButton clear;
	private JTextArea textfield;
	private JTextArea textarea;
	private JTextArea file;
	
	public Gui(String title) {
		super(title);
	}
	
	public void buildContainer() {
		setResizable(false);
		setPreferredSize(new Dimension(530, 400));
		setMaximumSize(new Dimension(530, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img = null;
		try {
			img = ImageIO.read(this.getClass().getResource("resources/scan.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(img);
		pack();
		setVisible(true);
	}
	
	
	public void createLayout() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		JPanel p1 = new JPanel();
		p1.setSize(getContentPane().getWidth(), 80);
		
		this.textfield = new JTextArea();
		textfield.setLineWrap(true);
		textfield.setWrapStyleWord(true);
		textfield.setSize(new Dimension(500, 400));
		textfield.setRows(8);
		JScrollPane scroll2 = new JScrollPane(textfield, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		p1.add(scroll2);
		add(p1);
	
		JPanel p2 = new JPanel();
		this.textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setSize(new Dimension(500, 400));
		textarea.setRows(8);
		textarea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p2.add(scroll);
		add(p2);
		
		JPanel p4 = new JPanel();
		this.file = new JTextArea("notify no;\r\ntype master;\r\nfile \"/etc/bind/blocked.db\";");
		this.file.setMargin(new Insets(3, 8, 3, 8));
		p4.add(file);
		add(p4);
		
		JPanel p5 = new JPanel();
		this.button = new JButton("convert!");
		this.copy = new JButton("copy");
		this.clear = new JButton("clear");
		p5.add(button);
		p5.add(copy);
		p5.add(clear);
		add(p5);
	}
	
	public void startListeners() {
		button.addActionListener(new ConvertEvent(this));
		copy.addActionListener(new CopyEvent(this));
		clear.addActionListener(new ResetEvent(this));
	}

	public JButton getButton() {
		return button;
	}
	
	public JButton getCopyButton() {
		return copy;
	}
	
	public JButton getClearButton() {
		return clear;
	}

	public JTextArea getTextArea() {
		return textfield;
	}

	public JTextArea getConvertedText() {
		return textarea;
	}

	public JTextArea getZoneOutputData() {
		return file;
	}
	
	
}
