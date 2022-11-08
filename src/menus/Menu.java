package menus;

import java.util.Scanner;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);
	private String menuNome;
	private String[] options;
	
	public Menu(String menuNome, String[] options) {
		this.options = options;
		this.menuNome = menuNome;
	}
	
	public void mostrarOpcoesMenu() {
		String[] options = this.getOptions();
		
		System.out.println(this.getNome());
		for(String s:options) {
			if(s == null) continue;
			System.out.println(s);
		}
	}
	
	public String[] getOptions() {
		return this.options;
	}
	public String getNome() {
		return this.menuNome;
	}
	
	public int nextInt() {
		int escolha;
		do {
			escolha = scanner.nextInt();
		}while(escolha < 1 || escolha > options.length);
		
		return escolha;
	}
	
	public String nextString() {
		String s;
		do {
			s = scanner.next();
		}while(s == null);
		
		return s;
	}
	
}

