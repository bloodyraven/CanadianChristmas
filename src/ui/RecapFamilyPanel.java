package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calcul.Calcul;
import bean.Data;
import bean.Family;

public class RecapFamilyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JButton finish, create;
	public JPanel recapPanel = this;
	private Data data;
	
	public RecapFamilyPanel(JFrame f, Data d) {
		this.setF(f);
		this.data=d;
		setFinish(new JButton("Fini"));
		setCreate(new JButton("Créer une famille"));
		this.setLayout(new BorderLayout());
		JPanel south = new JPanel();
		south.add(create);
		south.add(finish);
		this.add(south, BorderLayout.SOUTH);
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.setContentPane(new NewFamilyPanel(data, f));
				f.revalidate();
				f.repaint();
				f.pack();
				f.setLocationRelativeTo(null);
			}
		});
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		for (Family family : data.getFamilies()) {
			JPanel jp = new JPanel();
			jp.add(new JLabel(family.getNomFamille()));
			JButton jb = new JButton("Supprimer");
			jb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					data.getFamilies().remove(family);
					center.remove(jp);
					f.revalidate();
					f.repaint();
					f.pack();
					f.setLocationRelativeTo(null);
				}
			});
			jp.add(jb);
			center.add(jp);
		}
		this.add(center, BorderLayout.CENTER);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Calcul(data);
			}
		});
	}
	
	public void addFamily(Family fam) {
		data.getFamilies().add(fam);
	}

	public JButton getFinish() {
		return finish;
	}

	public void setFinish(JButton finish) {
		this.finish = finish;
	}

	public JButton getCreate() {
		return create;
	}

	public void setCreate(JButton create) {
		this.create = create;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

}
