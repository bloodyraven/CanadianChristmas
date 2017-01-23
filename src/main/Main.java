package main;

import javax.swing.JFrame;

import bean.Data;
import ui.RecapFamilyPanel;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Canadian Christmas");
		Data data = new Data();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new RecapFamilyPanel(f, data));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
