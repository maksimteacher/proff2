package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ControlPanel {
	private String[] btnNames = {"F1 - HELP", "F7 - NEW", "F8 - Remove"};
	private String[] nameFunctions = {"help", "add", "remove"};
	
	private Button[] btns;
	private int countFields;
	private TemplatePage template;
	
	public ControlPanel(TemplatePage template,int countFields){
		btns = new Button[btnNames.length];
		for(int i = 0; i< btns.length;i++){
			btns[i] = new Button(btnNames[i]);
		}
		this.template = template;
		this.countFields = countFields;
	}
	public GridPane getPanel(){
		GridPane panel = new GridPane();
		
		TextField[] texts = new TextField[countFields];
		for(int i = 0; i < texts.length; i++){
			texts[i] = new TextField();
			panel.add(texts[i],i,0);
		}
		for(int i = 0; i<btns.length;i++){
			btns[i] = new Button(btnNames[i]);
			if(nameFunctions[i].equals("help")){
				btns[i].setOnAction(event->template.help());
			}
			if(nameFunctions[i].equals("add")){
				btns[i].setOnAction(event->template.add(texts));
			}
			if(nameFunctions[i].equals("remove")){
				btns[i].setOnAction(event->template.remove());
			}
		}
		for(int i = 0; i < btns.length; i++){
			panel.add(btns[i], i, 1);
		}
		return panel;
	}
}
