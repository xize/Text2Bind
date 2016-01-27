package me.xize.text2bind;

import javax.swing.JButton;
import javax.swing.JTextArea;

public interface GuiApi {
	
	/**
	 * returns the sent button
	 * 
	 * @author xize
	 * @return JButton
	 */
	public JButton getButton();
	
	/**
	 * returns the clear button
	 * 
	 * @author xize
	 * @return JButton
	 */
	public JButton getClearButton();
	
	/**
	 * returns the copy button
	 * 
	 * @author xize
	 * @return JButton
	 */
	public JButton getCopyButton();
	
	/**
	 * returns the field where you put the malicious url in
	 * 
	 * @author xize
	 * @return JTextField
	 */
	public JTextArea getTextArea();
	
	/**
	 * the non editable text area where the converted bind list will appear
	 * 
	 * @author xize
	 * @return JTextArea
	 */
	public JTextArea getConvertedText();
	
	/**
	 * returns the zone output data
	 * 
	 * @author xize
	 * @return JTextField
	 */
	public JTextArea getZoneOutputData();

}
