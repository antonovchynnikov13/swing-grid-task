package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class MyContainer extends JPanel {

	public static final int PANELS_COUNT = 16;
	int highlightIndex=6;
	JLabel[] panels=new JLabel[PANELS_COUNT];
	SwingTemplate st;
	public MyContainer(int windowWidth, int windowHeight, SwingTemplate st) {
		this.setSize(windowWidth, windowHeight);
		this.st = st;

		this.setLayout(new GridLayout(4, 4));

		Font labelFont = this.getFont();
		Font myFont = new Font(labelFont.getName(), Font.PLAIN, 30);

		for (int i = 0; i < PANELS_COUNT; i++) {
			panels[i] = new JLabel();
			panels[i].setFont(myFont);
			panels[i].setText(String.valueOf(i));
			panels[i].setHorizontalAlignment(SwingConstants.CENTER);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
			panels[i].addMouseListener(createClickListener(i));
			this.add(panels[i]);
		}

		updateView();
	}

	private MouseAdapter createClickListener(int i) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					highlightIndex = i;
					updateView();
				}
			}
		};
	}

	private void updateView() {
		for (int i=0;i<PANELS_COUNT;i++) {
			if (i==highlightIndex) {
				panels[i].setBorder(BorderFactory.createLineBorder(Color.green, 3));
			}else {
				panels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
			}
		}
		st.setTitle("Selected index is " + String.valueOf(highlightIndex));
	}


	public void keyLeft() {
		if (highlightIndex>0)
			highlightIndex--;

		updateView();
	}


	public void keyRight() {
		if (highlightIndex<PANELS_COUNT-1)
			highlightIndex++;

		updateView();
	}

}
