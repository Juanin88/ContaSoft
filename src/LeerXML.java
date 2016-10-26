import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;         // |
import org.jdom.Element;          // |\ Librerías
import org.jdom.JDOMException;    // |/ JDOM
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder; // |

public class LeerXML {
	public void cargarXml()
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "C:/Users/LenovoY50/Google Drive/Facturas Juan Garfias/2016/Octubre 2016/161003.AQUV.1698213.DSA130408AM2.GAVJ880413HP5.xml" );
	    try
	    {
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	        Namespace ns = Namespace.getNamespace("cfdi","http://www.sat.gob.mx/cfd/3");	        
	        //Se obtiene la raiz 'tables'
	        Element rootNode = document.getRootElement().getChild("Emisor", ns);
	        //Namespace ns = Namespace.getNamespace("cfdi","http://www.sat.gob.mx/cfd/3");

	        //rootNode.addNamespaceDeclaration(ns);
	        
	        List<?> lista = rootNode.getAttributes();

			for (Object valor : lista) {
	            // do some work here on intValue
				System.out.println(valor.toString());
	        }
	        String atributo = rootNode.getAttribute("nombre").getValue();
			System.out.println(atributo);
	        
	       
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	}
}
