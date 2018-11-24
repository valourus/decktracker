package Tasks;

import Controllers.LogicController;
import Utils.Coords;
import Utils.ImageSearcher;
import Utils.Resource;

public class CheckCardsPlaced extends BaseTask {

	public CheckCardsPlaced(LogicController controller) {
		super(controller);
	}

	@Override
	public void run() {
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FIRST_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(1);
		}

		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SECOND_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(2);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_THIRD_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(3);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FOURTH_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(4);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_FIFTH_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(5);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SIXTH_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(6);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_SEVENTH_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(7);
		}
		if (ImageSearcher.searchForColor(Resource.getLocation(Coords.ABOVE_EIGHTH_CARD), 0xFF99FF) != null) {
			this.controller.onNewCardPlaced(8);
		}
	}

}
