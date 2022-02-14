package jonathan.furminger.babybird;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import jonathan.furminger.mycomponents.ScorePanel;
import jonathan.furminger.mycomponents.TitleLabel;

public class BabyBird extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ScorePanel scorePanel = new ScorePanel(0, Color.GREEN);
	private FlightPanel flightPanel = new FlightPanel(this);

	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch (Exception e) {}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BabyBird();
			}
		});

	}
	
	public BabyBird() {
		initGUI();
		setTitle("Baby Bird");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		TitleLabel titleLabel = new TitleLabel("Baby Bird");
		add(titleLabel, BorderLayout.PAGE_START);
		
		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.GREEN);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		add(mainPanel, BorderLayout.CENTER);
		// score panel
		mainPanel.add(scorePanel);
		
		// flight panel
		mainPanel.add(flightPanel);
		
		// bottom panel
		
		// bird nest panel
		
	}

}