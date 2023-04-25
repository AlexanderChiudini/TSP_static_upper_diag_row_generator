package TSP;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixColumns {

	List<List<String>> matrix = new ArrayList<List<String>>();
	String pathname;

	public MatrixColumns(String pathname) {
		try {
			this.setPathname(pathname);
			File myObj = new File("./col/" + this.getPathname());
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] parts = data.split("\t");
				matrix.add(new ArrayList<String>());
				for (int i = 0; i < parts.length; i++) {
					matrix.get(matrix.size() - 1).add(parts[i]);
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<List<String>> getMatrix() {
		return matrix;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}
}
