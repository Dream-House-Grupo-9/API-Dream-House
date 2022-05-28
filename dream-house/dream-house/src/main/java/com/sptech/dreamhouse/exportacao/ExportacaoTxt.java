package com.sptech.dreamhouse.exportacao;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.estrutura.PilhaObj;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExportacaoTxt {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        // try-catch para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }

    public static void gravaArquivoTxt(List<Anuncio> lista, String nomeArq) {
        int contaRegCorpo = 0;

        // Monta o registro de header
        String header = "00ANUNCIO";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo
        String corpo;
        for (Anuncio a : lista) {
            corpo = "01";
            corpo += String.format("%02d",a.getId());
            corpo += String.format("%-20.20s",a.getTelefoneLocatario());
            corpo += String.format("%-10.10s",a.getDtPublicacao());
            corpo += String.format("%-30.30s",a.getDescricao());
            corpo += String.format("%-10.10s",a.getInicioDisponibilidade());
            corpo += String.format("%-10.10s",a.getFinalDisponibilidade());
            corpo += String.format("%-40.40s",a.getCidade());
            corpo += String.format("%-40.40s",a.getBairro());
            corpo += String.format("%-40.40s",a.getLogradouro());
            corpo += String.format("%04.4d",a.getNumero());

            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        String corpo2;
        for (Anuncio a : lista) {
            corpo = "02";
            corpo += String.format("%02d",a.getDetalhe().getIdDetalhesAnuncio());
            corpo += String.format("%-5.5s",a.getDetalhe().isAtivoDiaria());
            corpo += String.format("%-5.5s",a.getDetalhe().isAtivoSemanal());
            corpo += String.format("%-5.5s",a.getDetalhe().isAtivoMensal());
            corpo += String.format("%10.2f",a.getDetalhe().getValorDiaria());
            corpo += String.format("%10.2f",a.getDetalhe().getValorSemanal());
            corpo += String.format("%10.2f",a.getDetalhe().getValorMensal());
            corpo += String.format("%03d",a.getDetalhe().getQtdDormitorios());
            corpo += String.format("%03d",a.getDetalhe().getQtdToaletes());
            corpo += String.format("%-5.5s",a.getDetalhe().isGaragem());
            corpo += String.format("%-5.5s",a.getDetalhe().isAreaDeTrabalho());
            corpo += String.format("%-5.5s",a.getDetalhe().isMobiliada());
            corpo += String.format("%-15.15s",a.getDetalhe().getCategoria());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);
    }



    public static PilhaObj<Anuncio> anunciarEmLote(MultipartFile file) {
        List<Anuncio> anuncios  = new ArrayList<>();
        List<DetalhesAnuncio> detalhes  = new ArrayList<>();
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        int controlador = 0;
        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;


        try {
            entrada = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));

        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Tipo de arquivo" + registro.substring(2, 9));
                    System.out.println("Data e hora de gravação" + registro.substring(9, 28));
                    System.out.println("Versão do documento" + registro.substring(28, 30));

                } else if (tipoRegistro.equals("04")) {
                    System.out.println("É um registro de trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2, 6));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lidos é compátivel " +
                                "com a quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos não é compátivel " +
                                "com a quantidade de registros gravados");
                    }

                } else if (tipoRegistro.equals("01")) {
                System.out.println("É um registro de corpo do tipo anuncio");

                Anuncio anuncio = new Anuncio();

                anuncio.setId(null);
                anuncio.setTelefoneLocatario(registro.substring(6, 26).trim());
                anuncio.setDtPublicacao(LocalDate.parse(registro.substring(26, 37).trim()));
                anuncio.setDescricao(registro.substring(37,67).trim());
                anuncio.setInicioDisponibilidade(LocalDate.parse(registro.substring(67,77).trim()));
                anuncio.setFinalDisponibilidade(LocalDate.parse(registro.substring(77, 87).trim()));
                anuncio.setCidade(registro.substring(87,127).trim());
                anuncio.setBairro(registro.substring(127, 168).trim());
                anuncio.setLogradouro(registro.substring(168,209));
                anuncio.setNumero(Integer.parseInt(registro.substring(209, 213)));
                contaRegCorpoLido++;

                anuncios.add(anuncio);

            }else if (tipoRegistro.equals("02")) {
                System.out.println("É um registro de corpo do tipo detalhe");

                DetalhesAnuncio detalhe = new DetalhesAnuncio();

                detalhe.setIdDetalhesAnuncio(null);
                detalhe.setAtivoDiaria(Boolean.parseBoolean(registro.substring(6, 11).trim()));
                detalhe.setAtivoSemanal(Boolean.parseBoolean(registro.substring(11, 17).trim()));
                detalhe.setAtivoMensal(Boolean.parseBoolean(registro.substring(17, 22).trim()));
                detalhe.setValorDiaria(Double.parseDouble(registro.substring(22, 32).trim()));
                detalhe.setValorSemanal(Double.parseDouble(registro.substring(32, 42).trim()));
                detalhe.setValorMensal(Double.parseDouble(registro.substring(42, 52).trim()));
                detalhe.setQtdDormitorios(Integer.parseInt(registro.substring(52, 55)));
                detalhe.setQtdToaletes(Integer.parseInt(registro.substring(55, 58)));
                detalhe.setGaragem(Boolean.parseBoolean(registro.substring(58, 63).trim()));
                detalhe.setAreaDeTrabalho(Boolean.parseBoolean(registro.substring(63, 68).trim()));
                detalhe.setMobiliada(Boolean.parseBoolean(registro.substring(25, 325).trim()));
                detalhe.setCategoria(registro.substring(25, 325).trim());
                contaRegCorpoLido++;

                detalhes.add(detalhe);

            } else {
                    System.out.println("Tipo de resgitro inválido");
                }
                registro = entrada.readLine();
            }

            entrada.close();

        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo" + erro);
        }

        PilhaObj<Anuncio> pilhaAnuncio = new PilhaObj<>(contaRegCorpoLido);

        while (!anuncios.isEmpty()){
            anuncios.get(0).setDetalhe(detalhes.get(controlador));
            pilhaAnuncio.push(anuncios.remove(controlador));
            controlador++;
        }

        return pilhaAnuncio;
    }
}
