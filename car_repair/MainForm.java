import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainForm {

	 private Frame mainFrame;
	 private Label headerLabel;
	 private TextArea resultText;
	 private Panel controlPanel;
	 private TextField capacityText;

	 public MainForm(){
			prepareGUI();
	 }

	 public static void main(String[] args){
			MainForm  awtControlDemo = new MainForm();
			awtControlDemo.showTextAreaDemo();
	 }

	 private void prepareGUI(){
			mainFrame = new Frame("Car Repair");
			mainFrame.setSize(500,600);
			mainFrame.setLayout(new GridLayout(3, 1));
			mainFrame.addWindowListener(new WindowAdapter() {
				 public void windowClosing(WindowEvent windowEvent){
						System.exit(0);
				 }        
			});

			capacityText = new TextField("8", 6);
			capacityText.setSize(30, 80);

			resultText = new TextArea();        
			resultText.setSize(350,100);

			controlPanel = new Panel();
			controlPanel.setLayout(new FlowLayout());

			mainFrame.add(capacityText);
			mainFrame.add(controlPanel);
			mainFrame.add(resultText);
			mainFrame.setVisible(true);  
	 }

	 private void showTextAreaDemo(){

	 		resultText.setText("Cars chosen to repair: \n");
			final TextArea CarsTextArea = new TextArea("ABC-123 3 100\nDEF-456 5 120\nGHI-789 4 80\nZZZ-999 1 50",10,40);

			Button showButton = new Button("Calculate");

			showButton.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
				 		int capacity = Integer.parseInt(capacityText.getText());
						Garage garage = new Garage(CarsTextArea.getText(), capacity);
						String result = garage.repair();
						resultText.setText(result);
				 }
			}); 

			controlPanel.add(CarsTextArea);        
			controlPanel.add(showButton);
			mainFrame.setVisible(true);  
	 }
}