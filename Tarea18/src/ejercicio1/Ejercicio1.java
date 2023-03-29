/**
 * 
 */
package ejercicio1;

import connection.Connector;

/**
 * @author camila
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector c = new Connector("root", "Pa$$w0rd");

		c.createDB("tienda_informatica");
		c.createTable("tienda_informatica", "fabricantes",
				"(CODIGO int NOT NULL," + "NOMBRE varchar(255) NOT NULL," + "PRIMARY KEY (CODIGO));");
		
		c.createTable("tienda_informatica", "articulos",
				"(CODIGO int NOT NULL," + " NOMBRE varchar(255) NOT NULL,"
				+ "PRECIO decimal(10,0) NOT NULL," + "FABRICANTE int NOT NULL,"
				+ "PRIMARY KEY (CODIGO)," + "  KEY FABRICANTE (`FABRICANTE`),"
				+ "CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (FABRICANTE) REFERENCES fabricantes (CODIGO));");

		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "1, 'Aitor Iglesias'");
		c.closeConnection();
	}

}