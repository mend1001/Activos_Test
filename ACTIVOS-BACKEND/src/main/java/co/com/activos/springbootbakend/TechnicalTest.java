package co.com.activos.springbootbakend;
/*
Para la construccioin dee la aplicacion se utilizo java 17, el framework springboot  3.1 y
las librerias de framework  de hibernate para la conexion a la BD y el pool de conexiones, se utilizaron
la dependencias jpa para crear e interactuar con las tablas de las BD.

- En la carpeta de recursos se encuentra el modelo de ela BDD y la coleccion de postman
- Se utilizo arquitectura RESTfull
- En la carpeta de resurces se encuentra el sql para el procedimiento almacenado sp_get_all_information_by_id
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechnicalTest {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTest.class, args);
	}


}
