package mpo.mansedan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManSedanApplication {

    public static void main(String[] args) {
	SpringApplication.run(ManSedanApplication.class, args);
//	CSVFileReader.oneByOneExample();
	CSVFileReader.oneByOnePOJO();
    }

}
