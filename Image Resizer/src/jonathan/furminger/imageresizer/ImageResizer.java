package jonathan.furminger.imageresizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import jonathan.furminger.mycomponents.TitleLabel;

public class ImageResizer extends JFrame {

	private static final long serialVersionUID = 1L;

	public ImageResizer() {
		initGUI();
		setTitle("Image Resizer");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch (Exception e) {
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ImageResizer();
			}
		});

	}
	
	private void initGUI() {
		TitleLabel titleLabel = new TitleLabel("Image Resizer");
		add (titleLabel, BorderLayout.PAGE_START);
		
	}

}
