package me.xize.text2bind.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.xize.text2bind.GuiApi;

public class ResetEvent implements ActionListener {

	private final GuiApi gui;
	
	public ResetEvent(GuiApi gui) {
		this.gui = gui;
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.getTextArea().setText(null);
		gui.getConvertedText().setText(null);
	}

}
