package Tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import Controllers.LogicController;
import Utils.Coords;
import Utils.Resource;
import net.semanticmetadata.lire.builders.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.searchers.GenericFastImageSearcher;
import net.semanticmetadata.lire.searchers.ImageSearchHits;
import net.semanticmetadata.lire.searchers.ImageSearcher;

public class GetCardInfo extends BaseTask {

	private static int amount = 0;
	private int index;

	public GetCardInfo(LogicController controller, int index) {
		super(controller);
		this.index = index;
	}

	@Override
	public void run() {
		try {
			BufferedImage img = new Robot().createScreenCapture(Resource.getLocation(getCoords()));
			ImageIO.write(img, "png", new File(++amount + ".png"));
			IndexReader ir = DirectoryReader.open(FSDirectory.open(Paths.get("cards")));
			ImageSearcher searcher = new GenericFastImageSearcher(30, CEDD.class);

			// searching with a image file ...
			ImageSearchHits hits = searcher.search(img, ir);
			// searching with a Lucene document instance ...

			String fileName = ir.document(hits.documentID(0)).getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];

			Resource.getCards().forEach(card -> {
				if (fileName.equals(card.getFilename())) {

					controller.onCardIdentified(card, index);
				}
			});
		} catch (IOException | AWTException e) {
			e.printStackTrace();
		}

	}

	private Coords getCoords() {
		switch (index) {
		case 1: {
			return Coords.FIRST_CARD;
		}
		case 2: {
			return Coords.SECOND_CARD;
		}
		case 3: {
			return Coords.THIRD_CARD;
		}
		case 4: {
			return Coords.FOURTH_CARD;
		}
		case 5: {
			return Coords.FIFTH_CARD;
		}
		case 6: {
			return Coords.SIXTH_CARD;
		}
		case 7: {
			return Coords.SEVENTH_CARD;
		}
		case 8: {
			return Coords.EIGHTH_CARD;
		}
		}

		return null;
	}
}
