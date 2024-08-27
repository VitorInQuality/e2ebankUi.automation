package projeto.bankautomatizado.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MassaDeDados {

	// Caminho para o arquivo Excel que contém os CPFs
	String caminhoArquivoExcel = "src/test/resources/testData/massaTeste.xlsx";

	/**
	 * Obtém um CPF da planilha e o remove após o uso.
	 *
	 * @return O CPF que foi obtido e removido, ou null se não houver CPFs
	 *         disponíveis.
	 */
	public String obterEExcluirCpf() {
		Workbook planilha = null; // Instância do Workbook para manipular a planilha
		FileOutputStream outFile = null; // Stream para salvar as alterações no arquivo

		try {
			// Abre o arquivo Excel para leitura
			FileInputStream arquivo = new FileInputStream(new File(caminhoArquivoExcel));
			// Cria uma instância do Workbook para manipular a planilha Excel
			planilha = new XSSFWorkbook(arquivo);
			// Seleciona a primeira planilha do Workbook
			Sheet abaPlanilha = planilha.getSheetAt(0);

			// Itera sobre as linhas da planilha
			for (int i = 0; i <= abaPlanilha.getLastRowNum(); i++) {
				// Obtém a linha atual da planilha
				Row linha = abaPlanilha.getRow(i);

				if (linha != null) {
					// Obtém a primeira célula da linha
					Cell celula = linha.getCell(0);

					if (celula != null) {
						String cpf = null;

						// Verifica o tipo da célula e obtém o CPF conforme o tipo
						switch (celula.getCellType()) {
						case STRING:
							cpf = celula.getStringCellValue(); // Obtém o valor da célula como String
							break;
						case NUMERIC:
							// Converte o valor numérico da célula para String
							cpf = String.valueOf((long) celula.getNumericCellValue());
							break;
						}

						if (cpf != null) {
							// Remove a linha que contém o CPF da planilha
							abaPlanilha.removeRow(linha);
							// Reorganiza as linhas para remover lacunas deixadas pela remoção
							reorganizarLinhas(abaPlanilha, i);

							// Salva as alterações no arquivo Excel
							outFile = new FileOutputStream(new File(caminhoArquivoExcel));
							planilha.write(outFile);

							// Retorna o CPF que foi obtido e removido
							return cpf;
						}
					}
				}
			}
		} catch (IOException e) {
			// Trata exceções relacionadas à leitura e escrita do arquivo Excel
			System.err.println("Erro ao manipular planilha: " + e.getMessage());
		} finally {
			try {
				// Fecha o Workbook e o FileOutputStream para liberar recursos
				if (planilha != null) {
					planilha.close();
				}
				if (outFile != null) {
					outFile.close();
				}
			} catch (IOException e) {
				// Trata exceções relacionadas ao fechamento de recursos
				System.err.println("Erro ao fechar recursos: " + e.getMessage());
			}
		}

		// Retorna null se não encontrar um CPF na planilha
		return null;
	}

	/**
	 * Reorganiza as linhas da planilha após a remoção de uma linha para evitar
	 * lacunas.
	 *
	 * @param abaPlanilha   A planilha onde as linhas serão reorganizadas.
	 * @param linhaRemovida O índice da linha que foi removida.
	 */
	private void reorganizarLinhas(Sheet abaPlanilha, int linhaRemovida) {
		int ultimaLinha = abaPlanilha.getLastRowNum(); // Obtém o índice da última linha
		// Se a linha removida não for a última, move as linhas abaixo para cima
		if (linhaRemovida < ultimaLinha) {
			abaPlanilha.shiftRows(linhaRemovida + 1, ultimaLinha, -1);
		}
	}
}
