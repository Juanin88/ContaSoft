import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom.Document;         // |
import org.jdom.Element;          // |\ Librerías
import org.jdom.JDOMException;    // |/ JDOM
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder; // |

/**
 * 
 * @author LenovoY50
 *
 */
public class LeerXML {
	public void cargarXml() throws IOException
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
	    
	     File miDir = new File (".");
	     try {
	       System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
	       }
	     catch(Exception e) {
	       e.printStackTrace();
	       }
		//String path = "C:/Users/LenovoY50/Google Drive/Facturas Juan Garfias/2016/Octubre 2016" ;
		String path = miDir.getCanonicalPath();
	    
	    
	    
	    
	    
	    File directorio = new File( path );
	    
	    BufferedWriter bw;
	    String ruta = directorio+"/datos.xls";
        bw = new BufferedWriter(new FileWriter(ruta));
        bw.write("Nombre emisor"+ "	");
        bw.write("RFC"+ "	");
        bw.write("Total"+ "	");
        bw.write("Sub-Total"+ "	");
        bw.write("Forma de Pago"+ "	");
        bw.newLine();


	    
	    File[] ficheros = directorio.listFiles();
	    
	    for (File fichero : ficheros){
	    	if (fichero.getName().endsWith(".xml")){	
		    	System.out.println("---->"+fichero.getName());
	
				    try
				    {
				        //Se crea el documento a traves del archivo
				        Document document = (Document) builder.build( fichero );
				        Namespace ns = Namespace.getNamespace("cfdi","http://www.sat.gob.mx/cfd/3");	        
				        //Se obtiene la raiz 'tables'
				        Element emisor = document.getRootElement().getChild("Emisor", ns);

				        bw.write(emisor.getAttribute("nombre").getValue() + "	");
				        bw.write(emisor.getAttribute("rfc").getValue() + "	");
				        
				        //Se obtiene la raiz 'tables'
				        Element comprobante = document.getRootElement();
				        bw.write(comprobante.getAttributeValue("total") + "	");
				        bw.write(comprobante.getAttributeValue("subTotal") + "	");
				        bw.write(comprobante.getAttributeValue("formaDePago") + "	");

				        bw.newLine();
				       
				    }catch ( IOException io ) {
				        System.out.println( io.getMessage() );
				    }catch ( JDOMException jdomex ) {
				        System.out.println( jdomex.getMessage() );
				    }
		    	}
	    	}
	    bw.close(); 
	}
}
