package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArquivosUtils {
	private static final String diretorioArquivos = "src/resources/";
	private static Path path;
	private static Scanner leitor;
	private static FileWriter escritor;
	
	public static void escreveArquivo(String nomeArquivo, String conteudo, boolean sobrescrever) throws IOException{
		path = Paths.get(diretorioArquivos+nomeArquivo);
		escritor = new FileWriter(path.toFile(), !sobrescrever);
		
		escritor.write(conteudo);
		escritor.close();
	}
	
	public static String lerArquivo(String nomeArquivo) throws IOException{
		String dados = "";
		path = Paths.get(diretorioArquivos+nomeArquivo);
		leitor = new Scanner(path);
		
		do{
			dados = dados.concat(leitor.nextLine()+"\n");
		}while(leitor.hasNextLine());
		
		return dados;
	}
	
	public static void resetarDiretorio() {
		path = Paths.get(diretorioArquivos);
		File dir = path.toFile();
		
		for(File f:dir.listFiles()) {
			if(!f.isDirectory())
				f.delete();
		}
	
	}
}
