/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exist_probar_proxecto;

import java.io.File;
import java.util.Iterator;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author oracle
 */
public class Exist_Probar_Proxecto {

    /**
     * @param args the command line arguments
     */
    public static String driver = "org.exist.xmldb.DatabaseImpl";

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {

        Class<?> cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        DatabaseManager.registerDatabase((org.xmldb.api.base.Database) database);
        String coleccion = "/db/cousas";
        Collection col;
        String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
        col = DatabaseManager.getCollection(uri + coleccion, "admin", "oracle");

        //Una vez creado ponemos /cousas en ek string coleccion para que lo que pongamos ahora se guarde ahí
        //CollectionManagementService mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
        //mgtService.createCollection("cousas");
                //Añadimos los xml dentro de la coleccion
//        File archivo = new File("/home/oracle/Downloads/empleados.xml");
//        Resource nuevoRecurso = col.createResource(archivo.getName(), "XMLResource");
//        nuevoRecurso.setContent(archivo);
//        col.storeResource(nuevoRecurso);
//        
//        File archivo2 = new File("/home/oracle/Downloads/proba.xml");
//        Resource nuevoRecurso2 = col.createResource(archivo2.getName(), "XMLResource");
//        nuevoRecurso2.setContent(archivo2);
//        col.storeResource(nuevoRecurso2);
//        
//        File archivo3 = new File("/home/oracle/Downloads/proba2.xml");
//        Resource nuevoRecurso3 = col.createResource(archivo3.getName(), "XMLResource");
//        nuevoRecurso3.setContent(archivo3);
//        col.storeResource(nuevoRecurso3);
                    //Modificar apellido de empleado con su EMP_NO
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons2="update value /EMPLEADOS/EMP_ROW[EMP_NO=7521]/APELLIDO with 'BIEITEZ'";
//        servicioXPQS.queryResource("empleados.xml",cons2);
                    //Añadiendo persona con nombre alexia en proba
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons4 = "update insert <PERSONA>alexia</PERSONA> into /PLAY/PERSONAE";
//        servicioXPQS.queryResource("proba.xml",cons4);
                    //Borrado de un una fila PERSONAJE QUE CREE SIN QUERER
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons3 ="update delete /EMPLEADOS/TITULO[PERSONA='sara']";
//        servicioXPQS.queryResource("empleados.xml",cons3);
                //Insertamos Sara a la vez en los 2 archivos prueba
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons4 = "update insert <PERSONA>sara</PERSONA> into /PLAY/PERSONAE";
//        servicioXPQS.query(cons4);  //al ser .query va a todo lo que pille, con .queryResource podemos seleccionar el xml
        
                    //BORRAR EMPLEADO CON UN DETERMINADO EMP_NO
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons3 = "update delete /EMPLEADOS/EMP_ROW[EMP_NO=7698]";
//        servicioXPQS.queryResource("empleados.xml", cons3);
        
                   //MODIFICAR NOMBRE DE UNA PERSONA
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons6="update value /PLAY/PERSONAE/PERSONA[text()='pedro'] with 'xoan'";
//        servicioXPQS.queryResource("proba2.xml",cons6);
        
                    //VOLVER A MODIFICAR NOMBRE DE UNA PERSONA
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons6="update value /PLAY/PERSONAE/PERSONA[text()='luis'] with 'xulio'";
//        servicioXPQS.queryResource("proba.xml",cons6);
        
                    //TODOS LOS XOAN POR SARAS
//        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//        String cons6="update value /PLAY/PERSONAE/PERSONA[text()='xoan'] with 'sara'";
//        servicioXPQS.query(cons6);
        
        
        XPathQueryService servicioXPQS = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        String cons6="update value /PLAY/fm/p[@id=2]/nome[text()='ana'] with 'xulia'"; // ACORDARSE QUE ID ES ATRIBUTO Y LLEVA @!!
        servicioXPQS.queryResource("proba.xml",cons6);
    }

}
