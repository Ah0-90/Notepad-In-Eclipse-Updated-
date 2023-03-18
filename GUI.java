import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{
	
	JFrame window;
	JTextArea textArea;
	boolean wordwrapOn = false;
	// TEXT AREA
	JScrollPane scrollPane;
	JMenuBar menuBar;
	// TOP MENU BAR
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	//EDIT MENU
	JMenuItem iUndo, iRedo;
	// FILE MENU
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28, iFontSize32, iFontSize36, iFontSize40, iFontSize50, iFontSize75, iFontSize100, iFontSize200, iFontSize500;
	JMenu menuFont, menuFontSize;
	// COLOR MENU
	JMenuItem iColor1, iColor2, iColor3;
	
	FunctionFile file = new FunctionFile(this);
	function_format format = new function_format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	
	KeyHandler kHandler = new KeyHandler(this);
	
	UndoManager um = new UndoManager();

	public static void main(String[] args) {

new GUI();

	}
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
	    createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordwrap();
		window.setVisible(true);
		
	}
	
	public void createWindow() {
		
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		
		textArea = new JTextArea();
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	}
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}
	public void createFileMenu() {
		
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void createEditMenu() {
		
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
	}
	
	public void createFormatMenu() {
		
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
		iFontSize32 = new JMenuItem("32");
		iFontSize32.addActionListener(this);
		iFontSize32.setActionCommand("size32");
		menuFontSize.add(iFontSize32);
		
		iFontSize36 = new JMenuItem("36");
		iFontSize36.addActionListener(this);
		iFontSize36.setActionCommand("size36");
		menuFontSize.add(iFontSize36);
		
		iFontSize40 = new JMenuItem("40");
		iFontSize40.addActionListener(this);
		iFontSize40.setActionCommand("size40");
		menuFontSize.add(iFontSize40);
		
		iFontSize50 = new JMenuItem("50");
		iFontSize50.addActionListener(this);
		iFontSize50.setActionCommand("size50");
		menuFontSize.add(iFontSize50);
		
		iFontSize75 = new JMenuItem("75");
		iFontSize75.addActionListener(this);
		iFontSize75.setActionCommand("size75");
		menuFontSize.add(iFontSize75);
		
		iFontSize100 = new JMenuItem("100");
		iFontSize100.addActionListener(this);
		iFontSize100.setActionCommand("size100");
		menuFontSize.add(iFontSize100);
		
		iFontSize200 = new JMenuItem("200");
		iFontSize200.addActionListener(this);
		iFontSize200.setActionCommand("size200");
		menuFontSize.add(iFontSize200);
		
		iFontSize500 = new JMenuItem("500");
		iFontSize500.addActionListener(this);
		iFontSize500.setActionCommand("size500");
		menuFontSize.add(iFontSize500);
	}
	public void createColorMenu() {
		
		iColor1 = new JMenuItem("white");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("white");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("blue");
		menuColor.add(iColor3);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "Save": file.Save(); break;
		case "SaveAs": file.SaveAs(); break;
		case "Exit": file.Exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "Word Wrap": format.wordwrap(); break;
		case "Arial": format.setFont(command); break;
		case "Comic Sans MS": format.setFont(command); break;
		case "Times New Roman": format.setFont(command); break;
		case "size8": format.createFont(8); break;
		case "size12": format.createFont(12); break;
		case "size16": format.createFont(16); break;
		case "size20": format.createFont(20); break;
		case "size24": format.createFont(24); break;
		case "size28": format.createFont(28); break;
		case "size32": format.createFont(32); break;
		case "size36": format.createFont(36); break;
		case "size40": format.createFont(40); break;
		case "size50": format.createFont(50); break;
		case "size75": format.createFont(75); break;
		case "size100": format.createFont(100); break;
		case "size200": format.createFont(200); break;
		case "size500": format.createFont(500); break;
		case "white": color.changeColor(command); break;
		case "black": color.changeColor(command); break;
		case "blue": color.changeColor(command); break;
		
				
		}
	}
	

}
