import java.io.IOException;

public class Procesamiento {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		LeerXML leerXML = new LeerXML();
		
		leerXML.cargarXml();
		//Procesamiento procesamiento = new Procesamiento();
		//procesamiento.suma();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int suma(){
		System.out.println("Saludo");
		
		Object alInstante = new Object(){
			@SuppressWarnings({ })
			public String interno(){
				System.out.println("Clase al vuelo");
				return "Regresa la cadena";
			}
			
			public String toString(){
				return this.interno();
			}
		};
		
		alInstante.toString();
		
		return 0;
	}
}
