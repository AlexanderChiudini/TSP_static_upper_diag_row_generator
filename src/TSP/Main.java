package TSP;

import java.io.File;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		double velocidade = getNumber("Digite um valor que represente o fator de movimentação do braço robótico:");
		double tempo_troca = getNumber("Digite um valor que represente o fator de mudança de cor do braço robótico:");

		File directoryPath = new File("./col");
		String contents[] = directoryPath.list();
		for (int i = 0; i < contents.length; i++) {
			MatrixColumns matrixColumns = new MatrixColumns(contents[i]);
			(new UpperDiagonalRowInstance(matrixColumns, velocidade, tempo_troca)).generateInstance();
		}
	}

	private static double getNumber(String message) {
		double numero = 0;
		boolean valorNumerico = false;

		while (!valorNumerico) {
			String entrada = JOptionPane.showInputDialog(null, message);

			try {
				numero = Double.parseDouble(entrada);
				valorNumerico = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número do tipo double, use ponto (.) para separar as casas decimais.");
			}
		}

		return numero;
	}
}
