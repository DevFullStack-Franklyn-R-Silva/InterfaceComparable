package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String caminhoDoArquivo = "C:\\temp\\in.txt";
		String saidaDoArquivo = "C:\\temp\\out.csv";
		List<Funcionario> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
			String linha = br.readLine();
			while (linha != null) {
				String[] campo = linha.split(",");
				list.add(new Funcionario(campo[0], Double.parseDouble(campo[1])));
				linha = br.readLine();
			}

			Collections.sort(list);

			for (Funcionario func : list) {
				System.out.println(func.getNome()+ ", "+func.getSalario());
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(saidaDoArquivo))) {
				for (Funcionario bwEscrita : list) {
					bw.write(bwEscrita.getNome()+bwEscrita.getSalario());
					bw.newLine();
				}

			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
