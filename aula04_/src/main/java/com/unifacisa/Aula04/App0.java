package com.unifacisa.Aula04;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//atributos criados
import java.io.FileWriter;

public class App0
{
	public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);
        
        //atributos criados
        try (FileWriter fileWriter = new FileWriter("output.json")) {
            String jsonString = mapper.writeValueAsString(getPessoas());
            fileWriter.write(jsonString);
            System.out.println("Dados salvos em 'output.json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // Deserialize
        String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p);

    }
    private static List<Pessoa> getPessoas() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
      //atributos criados
        p1.setIdade(12);
        p1.setSobrenome("Ribeiro");
        p1.setNacionalidade("Pernambuco");

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
      //atributos criados
        p2.setIdade(20);
        p2.setSobrenome("Antônia");
        p2.setNacionalidade("Pará");

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
      //atributos criados
        p3.setIdade(68);
        p3.setSobrenome("Algusto");
        p3.setNacionalidade("Paraíba");

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;

    }
}
