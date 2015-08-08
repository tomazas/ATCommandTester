import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JLabel;

public class URLLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private String url;

	public URLLabel() {
		this("", "");
	}

	public URLLabel(String label, String url) {
		super(label);

		this.url = url;
		setForeground(Color.BLUE.darker());
		setCursor(new Cursor(12));
		addMouseListener(new URLLabel.URLOpenAdapter());
	}

	public void setURL(String url) {
		this.url = url;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.blue);

		Insets insets = getInsets();

		int left = insets.left;
		if (getIcon() != null) {
			left += getIcon().getIconWidth() + getIconTextGap();
		}
		g.drawLine(left, getHeight() - 1 - insets.bottom,
				(int) getPreferredSize().getWidth() - insets.right, getHeight()
						- 1 - insets.bottom);
	}

	private class URLOpenAdapter extends MouseAdapter {
		private URLOpenAdapter() {
		}

		public void mouseClicked(MouseEvent e) {
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().browse(new URI(URLLabel.this.url));
				} catch (Throwable localThrowable) {
				}
			}
		}
	}
}