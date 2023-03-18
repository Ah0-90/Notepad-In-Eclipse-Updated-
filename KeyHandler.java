import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
GUI gui;
	
	public KeyHandler(GUI gui) {
		
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.Save();
		}
		
		if((e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)) {
			gui.file.SaveAs();
		}
		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			gui.file.newFile();
		}
		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.file.open();
		}
		
		if((e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_C)) {
			gui.file.Exit();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
