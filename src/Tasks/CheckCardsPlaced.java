package Tasks;

import Controllers.LogicController;
import Utils.Coords;
import Utils.ImageSearcher;
import Utils.Resource;

public class CheckCardsPlaced extends BaseTask {

	private long[] lastUsed = new long[8];
	
	public CheckCardsPlaced(LogicController controller) {
		super(controller);
	}

	@Override
	public void run() {
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FIRST_CARD), 0xFF99FF) != null && lastUsed[0] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(1);
			lastUsed[0] = System.currentTimeMillis();
			
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SECOND_CARD), 0xFF99FF) != null && lastUsed[1] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(2);
			lastUsed[1] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_THIRD_CARD), 0xFF99FF) != null && lastUsed[2] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(3);
			lastUsed[2] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FOURTH_CARD), 0xFF99FF) != null && lastUsed[3] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(4);
			lastUsed[3] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FIFTH_CARD), 0xFF99FF) != null && lastUsed[4] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(5);
			lastUsed[4] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SIXTH_CARD), 0xFF99FF) != null&& lastUsed[5] + 2000  < System.currentTimeMillis()  ) {
			this.controller.onNewCardPlaced(6);
			lastUsed[5] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SEVENTH_CARD), 0xFF99FF) != null && lastUsed[6] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(7);
			lastUsed[6] = System.currentTimeMillis();
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_EIGHTH_CARD), 0xFF99FF) != null && lastUsed[7] + 2000  < System.currentTimeMillis() ) {
			this.controller.onNewCardPlaced(8);
			lastUsed[7] = System.currentTimeMillis();
		}
	}

}
