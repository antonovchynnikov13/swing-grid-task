package test;

import java.awt.*;
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

	private SelectionMode selectionMode = SelectionMode.HOVER;
	public static final int PANELS_COUNT = 16;
	private JLabel modeLabel;
	int highlightIndex=6;
	JLabel[] panels=new JLabel[PANELS_COUNT];
	SwingTemplate st;

	public MyContainer(int windowWidth, int windowHeight, SwingTemplate st) {
		this.setSize(windowWidth, windowHeight);
		this.st = st;
		this.setLayout(new BorderLayout());
		modeLabel = new JLabel("Mode: " + selectionMode, SwingConstants.CENTER);
		this.add(modeLabel, BorderLayout.NORTH);

		JPanel gridPanel = new JPanel(new GridLayout(4, 4));

		Font labelFont = this.getFont();
		Font myFont = new Font(labelFont.getName(), Font.PLAIN, 30);

		for (int i = 0; i < PANELS_COUNT; i++) {
			panels[i] = new JLabel();
			panels[i].setFont(myFont);
			panels[i].setText(String.valueOf(i));
			panels[i].setHorizontalAlignment(SwingConstants.CENTER);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
			panels[i].addMouseListener(createSelectionListener(i));
			gridPanel.add(panels[i]);

		}
		this.add(gridPanel, BorderLayout.CENTER);
		updateView();
	}
  
	private MouseAdapter createSelectionListener(int i) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectionMode == SelectionMode.CLICK && SwingUtilities.isLeftMouseButton(e)) {
					highlightIndex = i;
					updateView();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (selectionMode == SelectionMode.HOVER) {
					highlightIndex = i;
					updateView();
				}
			}
		};
	}

	public void setSelectionMode(SelectionMode mode) {
		this.selectionMode = mode;
		modeLabel.setText("Mode: " + mode);
	}

	public SelectionMode getSelectionMode() {
		return selectionMode;

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
