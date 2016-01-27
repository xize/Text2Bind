package me.xize.text2bind;

import javax.swing.SwingUtilities;

public class Main {
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Gui screen = new Gui("Text2Bind v1.0");
				screen.createLayout();
				screen.buildContainer();
				screen.startListeners();
			}
    		
    	});
    	
    }
}
