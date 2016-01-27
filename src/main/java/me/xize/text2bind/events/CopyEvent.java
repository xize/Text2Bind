package me.xize.text2bind.events;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.xize.text2bind.GuiApi;

public class CopyEvent implements ActionListener {

	private final GuiApi gui;
	
	public CopyEvent(GuiApi gui) {
		this.gui = gui;
	}
	
	public void actionPerformed(ActionEvent e) {
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 StringSelection select = new StringSelection(gui.getConvertedText().getText());
		 clipboard.setContents(select, select);
	}

}
