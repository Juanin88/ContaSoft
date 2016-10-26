
public class Procesamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo!");
		
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
			@SuppressWarnings({ "null", "null", "deprecation" })
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
