import java.awt.Font;

public class function_format {

	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String selectedFont; 
	
	public function_format(GUI gui) {
		this.gui=gui;
	}
	
	public void wordwrap() {
		
		if(gui.wordwrapOn==false) {
			gui.wordwrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
		} else if(gui.wordwrapOn==true) {
			gui.wordwrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
		}
		
	}
	
	public void createFont(int FontSize) {
		
		arial = new Font("Arial", Font.PLAIN, FontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, FontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, FontSize);
		
setFont(selectedFont);		
		
	}
	public void setFont(String font) {
		
		selectedFont = font;
		
		switch(selectedFont) {
		case "Arial":
		gui.textArea.setFont(arial);
		break;
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;
		
		}
		
	}
}
