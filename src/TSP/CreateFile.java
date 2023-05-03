package TSP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	File file;

	public CreateFile(String pathname) {
		this.file = new File(pathname);
	}

	public void createHeader(FileWriter writer, int dimension) {
		try {
			writer.write("NAME : portmgen-10-1\n" + "COMMENT : portmgen N=10, seed=1\n" + "TYPE : TSP\n"
					+ "DIMENSION : " + dimension +"\n" + "EDGE_WEIGHT_TYPE : EXPLICIT\n" + "EDGE_WEIGHT_FORMAT : UPPER_DIAG_ROW\n"
					+ "EDGE_WEIGHT_SECTION");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}