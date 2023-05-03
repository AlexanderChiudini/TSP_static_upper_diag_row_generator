package TSP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UpperDiagonalRowInstance {

	private MatrixColumns matrix;
	private double velocidade;
	private double tempo_troca;

	public UpperDiagonalRowInstance(MatrixColumns matrix, double velocidade, double tempo_troca) {
		this.setMatrix(matrix);
		this.setVelocidade(velocidade);
		this.setTempo_troca(tempo_troca);
	}

	public void generateInstance() {
		try {
			String directoryName = "./instances/";

			File directory = new File(String.valueOf(directoryName));

			if (!directory.exists()) {
				directory.mkdir();
			}

			TSPGraph graph = new TSPGraph(matrix.getMatrix());

			graph.mountGraph(this.getVelocidade(), this.getTempo_troca());

			String[] name = matrix.getPathname().split(".col");
			CreateFile file = new CreateFile(directoryName + name[0] + ".tsp");
			FileWriter writer = new FileWriter(file.getFile());
			file.createHeader(writer, graph.getGraphMatrix().size());
			
			for (int i = 0; i < graph.getGraphMatrix().size(); i++) {
				for (int j = i; j < graph.getGraphMatrix().get(i).size(); j++) {
					writer.write("\n" + graph.getGraphMatrix().get(i).get(j));
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

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getTempo_troca() {
		return tempo_troca;
	}

	public void setTempo_troca(double tempo_troca) {
		this.tempo_troca = tempo_troca;
	}
}
