package me.xize.text2bind.decoder;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import me.xize.text2bind.GuiApi;

public class DecodeFactory {

	private static DecodeFactory factory; //make the field private

	protected DecodeFactory() {} //allow DecodeFactory only be instanced by its own.

	public static DecodeFactory getFactory() {
		if(!(factory instanceof DecodeFactory)) {
			factory = new DecodeFactory();
		}
		return factory;
	}

	public Iterator<String> convert(String data, GuiApi gui) {
		Set<String> order = new TreeSet<String>();
		String[] args = serializeEnters(data);
		for(String site : args) {
			if(validate(site)) {
				String extr = extractParamsFromGui(gui);
				String custom = "zone \""+ site +"\" IN {"+ extr + "};\r\n";
				custom += "zone \"*."+ site +"\" IN {"+ extr +"};\r\n";
				order.add(custom);
			}
		}
		return order.iterator();
	}

	private String[] serializeEnters(String data) {
		return data.split("\n");
	}
	
	private String extractParamsFromGui(GuiApi api) {
		String newdata = "";
		String[] elements = serializeEnters(api.getZoneOutputData().getText());
		newdata = "\r\n    "+elements[0]+"\r\n    "+elements[1]+"\r\n    " + elements[2] + "\r\n";
		return newdata;
	}

	public boolean validate(String element) {
		if(Pattern.matches("^[a-zA-Z0-9\\.]+\\.[a-zA-Z]{2,6}$", element)) {
			return true;
		}
		return false;
	}

}
