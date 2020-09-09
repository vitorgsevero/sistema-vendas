package com.vitorgsevero.io.sistemavendas.csv;

import java.io.*;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 * Essa classe serve para fazer a leitura do arquivo .csv com os dados
 */
public class LeitorCSV {

    public File file = new File("\\dados.csv");
    private BufferedReader reader = null;
    private String line = "";
    private String csvSeparator = "ç";

    public String readCSV() throws IOException {

        try {

            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null){

                //TODO - Utilizar a model criada e passar o objeto para que os seus atributos possam receber o valores separados por "ç"
                String[] dados = line.split(csvSeparator);

            }
        } catch (FileNotFoundException e){ //TODO - Fazer o tratamento de outros possíveis erros
            e.getLocalizedMessage();
        }

        return null;
    }

    //TODO - Criação de método para exportar o arquivo após lido e alterado

}
