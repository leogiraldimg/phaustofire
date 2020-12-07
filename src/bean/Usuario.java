package bean;

public class Usuario {
	private static String cargo;
	
	public Usuario(){
		
	}
	
	public Usuario(String cargo){
		Usuario.setCargo(cargo);
	}

	public static String getCargo() {
		return cargo;
	}

	public static void setCargo(String cargo) {
		Usuario.cargo = cargo;
	}
	
	
}
