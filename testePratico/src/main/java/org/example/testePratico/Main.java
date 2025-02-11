package org.example.testePratico;
import org.example.testePratico.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Add todos funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"),"Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),"Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"),"Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"),"Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"),"Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Remover João
        funcionarios.removeIf(func -> func.getNome().equals("João"));

        // Exibir todos
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Data Nascimento: " + f.getDataNascimento().format(formatter));
            System.out.println("Salário: R$ " + f.getSalario().setScale(2, RoundingMode.HALF_UP).toString().replace('.', ','));
            System.out.println("Função: " + f.getFuncao());
            System.out.println("============================");
        }

    }
}
