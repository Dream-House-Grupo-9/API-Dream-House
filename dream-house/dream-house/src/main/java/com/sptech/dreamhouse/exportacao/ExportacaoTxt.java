package com.sptech.dreamhouse.exportacao;

import com.sptech.dreamhouse.entidade.Anuncio;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExportacaoTxt {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir arquivo" + erro);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo" + erro);
        }

    }

    public static void gravaArquivoTxt(List<Anuncio> lista, String nomeArq) {
        int contaRegCorpo = 0;
        String header = "Anuncio";
        header += LocalDateTime.now().format
                (DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        String corpo;

        for (Anuncio a : lista) {
            corpo = "02";
            corpo += String.format("%04d", a.getIdAnuncio());
            corpo += String.format("%-19.19s", a.getDtPublicacao());
            corpo += String.format("%-300.300s", a.getDescricao());
            corpo += String.format("%-19.19s", a.getInicioDisponibilidade());
            corpo += String.format("%-19.19s", a.getFinalDisponibilidade());
            corpo += String.format("%-40.40s", a.getCidade());
            corpo += String.format("%-40.40s", a.getBairro());
            corpo += String.format("%-70.70s", a.getLogradouro());
            corpo += String.format("%04d", a.getNumero());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);

        }

        String trailer = "01";
        trailer += String.format("%05d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);
    }


    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String dtPublicacao, descricao, inicioDisponibilidade, finalDisponibilidade;
        String cidade, bairro, logradouro;
        Integer idAnuncio, numero;
        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;

        List<Anuncio> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Falha ao abrir arquivo" + erro);
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo" + registro.substring(2, 9));
                    System.out.println("Data e hora de gravação" + registro.substring(9, 28));
                    System.out.println("Versão do documento" + registro.substring(28, 30));

                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2, 6));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lidos é compátivel " +
                                "com a quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos não é compátivel " +
                                "com a quantidade de registros gravados");
                    }

                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo");
                    idAnuncio = Integer.valueOf(registro.substring(3, 6).trim());
                    dtPublicacao = registro.substring(6, 25).trim();
                    descricao = registro.substring(25, 325).trim();
                    inicioDisponibilidade = registro.substring(325, 344).trim();
                    finalDisponibilidade = registro.substring(344, 363).trim();
                    cidade = registro.substring(363, 403).trim();
                    bairro = registro.substring(404, 443).trim();
                    logradouro = registro.substring(443, 513);
                    numero = Integer.valueOf(registro.substring(513, 517));
                    contaRegCorpoLido++;

                    Anuncio a = new Anuncio(idAnuncio, dtPublicacao, descricao, inicioDisponibilidade, finalDisponibilidade, cidade, bairro, logradouro, numero);
                    listaLida.add(a);
                } else {
                    System.out.println("Tipo de resgitro inválido");
                }
                registro = entrada.readLine();
            }

            entrada.close();

        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo" + erro);
        }
        System.out.println("\nConteúdo da lista lida");
        for (Anuncio a : listaLida) {
            System.out.println(a);
        }
    }


}
