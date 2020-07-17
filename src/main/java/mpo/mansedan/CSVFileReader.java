package mpo.mansedan;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import mpo.mansedan.model.FillUp;

public class CSVFileReader {

    public static Path toyotaCorrolaFile() throws URISyntaxException {
	URI uri = ClassLoader.getSystemResource("1998-Toyota-Corolla-Gas-History.csv")
		.toURI();
	return Paths.get(uri);
    }

    // TODO: totes not using
    public static String oneByOneExample() {
	Reader reader = null;

	try {
	    reader = Files.newBufferedReader(toyotaCorrolaFile());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
//	System.out.println(oneByOne(reader).toString());
	return oneByOneString(reader).toString();
    }

    public static List<FillUp> oneByOnePOJO() {
	Reader reader = null;

	try {
	    reader = Files.newBufferedReader(toyotaCorrolaFile());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return oneByOneBean(reader);
    }

    public static List<String[]> oneByOneString(Reader reader) {

	List<String[]> list = new ArrayList<>();

	try {
	    CSVParser parser = new CSVParserBuilder().withSeparator(',')
		    .withIgnoreQuotations(true)
		    .build();

	    CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0)
		    .withCSVParser(parser)
		    .build();

	    String[] line;
	    while ((line = csvReader.readNext()) != null) {
		for (String index : line) {
		    System.out.print(index + " ");
		}
		System.out.println("");
		list.add(line);
	    }
	    reader.close();
	    csvReader.close();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return list;
    }

    public static List<FillUp> oneByOneBean(Reader reader) {

	HeaderColumnNameMappingStrategy<FillUp> strategy = new HeaderColumnNameMappingStrategy<>();
	strategy.setType(FillUp.class);

	CsvToBean<FillUp> csvToBean = new CsvToBeanBuilder<FillUp>(reader).withMappingStrategy(strategy)
		.withIgnoreLeadingWhiteSpace(true)
		.build();

	List<FillUp> fillUps = csvToBean.parse();

	for (FillUp fill : fillUps) {
	    System.out.println(fill.toString());
	}

	return fillUps;
    }
}
