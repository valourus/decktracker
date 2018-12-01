package indexer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import net.semanticmetadata.lire.builders.GlobalDocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.imageanalysis.features.global.FCTH;
import net.semanticmetadata.lire.utils.FileUtils;

public class Indexer {

	public static void main(String[] args) throws IOException {
        // Getting all images from a directory and its sub directories.
        ArrayList<String> images = null;
		images = FileUtils.getAllImages(new File(System.getProperty("user.dir") + "/src/indexer/images"), true);
        // Creating a CEDD document builder and indexing all files.
        GlobalDocumentBuilder globalDocumentBuilder = new GlobalDocumentBuilder(false);
        /*
            If you want to use DocValues, which makes linear search much faster, then use.
            However, you then have to use a specific searcher!
         */
        // GlobalDocumentBuilder globalDocumentBuilder = new GlobalDocumentBuilder(false, true);

        /*
            Then add those features we want to extract in a single run:
         */
        globalDocumentBuilder.addExtractor(CEDD.class);
        globalDocumentBuilder.addExtractor(FCTH.class);

        // Creating an Lucene IndexWriter
        IndexWriterConfig conf = new IndexWriterConfig(new WhitespaceAnalyzer());
        IndexWriter iw = null;
		try {
			iw = new IndexWriter(FSDirectory.open(Paths.get("cards")), conf);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        // Iterating through images building the low level features
        for (Iterator<String> it = images.iterator(); it.hasNext(); ) {
            String imageFilePath = it.next();
            System.out.println("Indexing " + imageFilePath);
            try {
                BufferedImage img = ImageIO.read(new FileInputStream(imageFilePath));
                Document document = globalDocumentBuilder.createDocument(img, imageFilePath);
                iw.addDocument(document);
            } catch (Exception e) {
                System.err.println("Error reading image or indexing it.");
                e.printStackTrace();
            }
        }
        iw.close();
        System.out.println("Finished indexing.");
	}
	
}
