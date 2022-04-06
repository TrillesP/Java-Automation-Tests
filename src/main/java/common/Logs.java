package common;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logs {
    String dataLog;

    public void registrarCabecalho(String dataLog) throws IOException{
        String[] cabecalho = {"data e hora", "caso de teste", "mensagem"};
        this.dataLog = dataLog;
        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log - "+dataLog+".csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);


        escritorCSV.flush();
        escritor.close();
    }
    public void registrarCSV(String casoDeTeste, String mensagem) throws IOException{
        String dataHoraLog = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
        String[] linha = new String[]{dataHoraLog, casoDeTeste, mensagem};

        FileWriter escritor = new FileWriter("target/logs/log - "+dataLog+".csv", true);

        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(linha);

        escritorCSV.flush();
        escritor.close();

    }
}
