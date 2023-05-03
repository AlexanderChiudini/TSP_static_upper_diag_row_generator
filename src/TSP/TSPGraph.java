package TSP;

import java.util.ArrayList;
import java.util.List;

public class TSPGraph {

	private List<List<String>> adjMatrix;
	private List<List<Double>> graphMatrix;

	public TSPGraph(List<List<String>> adjMatrix) {
		this.setAdjMatrix(adjMatrix);
	}

	public void mountGraph(double velocidade, double troca) {
		int linhas = this.getAdjMatrix().size();
	    int colunas = this.getAdjMatrix().get(0).size();
	    this.graphMatrix = new ArrayList<>();
	    for (int i = 0; i < linhas*colunas; i++) {
	    	this.graphMatrix.add(new ArrayList<>());
	        for (int j = 0; j < linhas*colunas; j++) {
	            if (i == j) {
	            	this.graphMatrix.get(i).add(0.0);
	            } else {
	                int i1 = i / colunas;
	                int j1 = i % colunas;
	                int i2 = j / colunas;
	                int j2 = j % colunas;
	                double distancia = (Math.sqrt(Math.pow(i1 - i2, 2) + Math.pow(j1 - j2, 2))) * velocidade;
	                if (!this.getAdjMatrix().get(i1).get(j1).equals(this.getAdjMatrix().get(i2).get(j2))) {
	                    distancia += troca;
	                }
	                this.graphMatrix.get(i).add(distancia);
	            }
	        }
	    }
	}

	public List<List<String>> getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(List<List<String>> adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public List<List<Double>> getGraphMatrix() {
		return graphMatrix;
	}
}