package TSP;

import java.io.FileWriter;
import java.io.IOException;

public class UpperDiagonalRowInstance {

	private MatrixColumns matrix;

	static final int START_VALUE = 0;
	static final int DRIVE_FACTOR = 1;
	static final int COLOR_CHANGE = 3;

	public UpperDiagonalRowInstance(MatrixColumns matrix) {
		this.setMatrix(matrix);
	}

	public void generateInstance() {
		try {
			String[] name = matrix.getPathname().split(".col");
			CreateFile file = new CreateFile("./instance/" + name[0] + ".tsp");
			FileWriter writer = new FileWriter(file.getFile());
			file.createHeader(writer);
			String last = null;
			int value;

			for (int i = 0; i < this.getMatrix().getMatrix().size(); i++) {
				for (int j = i; j < this.getMatrix().getMatrix().get(i).size(); j++) {
					if (i == j) {
						value = START_VALUE;
					} else {
						value = DRIVE_FACTOR;
						if ((last == null || last.length() == 0)
								|| !last.equals(this.getMatrix().getMatrix().get(i).get(j))) {
							value *= COLOR_CHANGE;
						}
						last = this.getMatrix().getMatrix().get(i).get(j);
					}
					writer.write("\n" + value);
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MatrixColumns getMatrix() {
		return matrix;
	}

	public void setMatrix(MatrixColumns matrix) {
		this.matrix = matrix;
	}
}
