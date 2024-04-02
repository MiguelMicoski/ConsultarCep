package br.com.consultaCEP.main;

import br.com.consultaCEP.models.ConsomeApi;
import br.com.consultaCEP.models.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        Scanner leitor = new Scanner(System.in);
        List<Endereco> enderecoList = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        ConsomeApi consomeApi = new ConsomeApi();
        Endereco endereco;

        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite o CEP que quer pesquisar: ");
            String cep = leitor.nextLine();
            endereco = consomeApi.buscaCep(cep);
            enderecoList.add(endereco);


            System.out.println("Digite 'sair' para ver a listagem de CEPs ou tecle enter para inserir outro CEP: ");
            busca = leitor.nextLine();

            if ( busca.equalsIgnoreCase("sair")){
                break;
            }
        }


        System.out.println(enderecoList);

        FileWriter escreve = new FileWriter("enderecos.json");
        escreve.write(gson.toJson(enderecoList));
        escreve.close();













    }
}