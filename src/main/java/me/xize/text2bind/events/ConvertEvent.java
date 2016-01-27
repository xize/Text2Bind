package me.xize.text2bind.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import me.xize.text2bind.GuiApi;
import me.xize.text2bind.decoder.DecodeFactory;

public class ConvertEvent implements ActionListener {

	private final GuiApi gui;
	
	public ConvertEvent(GuiApi gui) {
		this.gui = gui;
	}
	
	public void actionPerformed(ActionEvent e) {
		Iterator<String> it = DecodeFactory.getFactory().convert(gui.getTextArea().getText(), gui);
		String text = "";
		while(it.hasNext()) {
			text += it.next();
		}
		gui.getConvertedText().setText(text);
	}

}
