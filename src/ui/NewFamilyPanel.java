package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Data;
import bean.Family;

public class NewFamilyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JFrame f;
	private Data data;
	private Family famille;
	private JTextField nomFamille;
	private JPanel newFamilyPanel = this;
	public JPanel panelMember = new JPanel();
	
	public NewFamilyPanel(Data data, JFrame f) {
		this.f=f;
		this.setData(data);
		this.setLayout(new BorderLayout());
		panelMember.setLayout(new BoxLayout(panelMember, BoxLayout.Y_AXIS));
		famille = new Family();
		JButton add = new JButton("+");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = JOptionPane.showInputDialog(null, "Nom de la personne", "Entrez le nom de la personne");
				if(nom != null && !nom.equals("")) {
					famille.getMembers().add(nom);
					// repaint
					JPanel jp = new JPanel();
					jp.setLayout(new FlowLayout());
					jp.add(new JLabel(nom));
					JButton butt = new JButton("Supprimer");
					butt.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							famille.getMembers().remove(nom);
							panelMember.remove(jp);
							newFamilyPanel.revalidate();
							newFamilyPanel.repaint();
							f.pack();
							f.setLocationRelativeTo(null);
						}
					});
					jp.add(butt);
					panelMember.add(jp);
					newFamilyPanel.add(panelMember, BorderLayout.CENTER);
					newFamilyPanel.revalidate();
					newFamilyPanel.repaint();
					f.pack();
					f.setLocationRelativeTo(null);
				}
			}
		});
		JButton valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				famille.setNomFamille(nomFamille.getText());
				data.getFamilies().add(famille);
				f.setContentPane(new RecapFamilyPanel(f, data));
				f.revalidate();
				f.repaint();
				f.pack();
				f.setLocationRelativeTo(null);
			}
		});
		JPanel south = new JPanel();
		south.add(add);
		south.add(valider);
		this.add(south, BorderLayout.SOUTH);
		JPanel north = new JPanel();
		north.add(new JLabel("Nom de la famille"));
		nomFamille = new JTextField();
		nomFamille.setPreferredSize(new Dimension(150, 25));
		north.add(nomFamille);
		this.add(north, BorderLayout.NORTH);
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
