package bingo;

public enum JogoTiposEnum {
	LINHA("Linha"), COLUNA("Coluna"), JANELA("Janelão"), CHEIA("Cartela cheia");
	
	private String str;
	JogoTiposEnum(String s){
		this.str = s;
	}
	
	@Override
	public String toString() {
		return this.str;
	}
}
