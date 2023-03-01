package and.codechallenge.challenge2.view;

import and.codechallenge.challenge2.Controller;

public class LangtonsAntPanel {
	
	private Controller app;
	
	private int boardSize = 6;
	
	public LangtonsAntPanel(Controller app, int initialSize) {
		super();
		this.app = app;
		this.boardSize = initialSize;
		
//		setupPanel();
//		setupBoard();
	}
	
//	private void setupPanel() {
//		this.setBackground(Color.GRAY);
//		this.setPreferredSize(new Dimension(400,300));
//		this.setLayout(new GridLayout(boardSize, boardSize));
//	}
//
//	private void setLayout() {
//		this.setLayout(new GridLayout(boardSize, boardSize));
//	}
//	public void repaintMe() {
//		boardSize += 2;
//		setLayout();
//		setupBoard();
//		this.revalidate();
//		this.repaint();
//	}
//
//	private void setupBoard() {
//		int numView = 1;
//		Color[] COLOR_ARRAY = {Color.decode("#FFFACD"), Color.decode("#593E1A")};
//		for (int i = 0; i < boardSize; i++)
//		{
//			numView = (numView == 0) ? 1:0;
//			for (int j = 0; j < boardSize; j++)
//			{
//				add(new TileView(COLOR_ARRAY[numView]));
//				numView = (numView == 0) ? 1:0;
//			}
//		}
//	}
}

//class TileView extends JLabel {
//
//	TileView(Color color) {
//		setPreferredSize(new Dimension(100,100));
//		setOpaque(true);
//		setBackground(color);
//	}
//}