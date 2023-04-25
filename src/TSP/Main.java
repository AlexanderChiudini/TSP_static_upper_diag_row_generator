package TSP;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File directoryPath = new File("./col");
		String contents[] = directoryPath.list();
		for (int i = 0; i < contents.length; i++) {
			MatrixColumns matrixColumns = new MatrixColumns(contents[i]);
			(new UpperDiagonalRowInstance(matrixColumns)).generateInstance();
		}
	}

}
