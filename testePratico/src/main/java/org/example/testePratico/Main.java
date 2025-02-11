package org.example.testePratico;

import org.example.testePratico.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Configuração do formatador de salário
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,###.00", symbols);

        // Adicionar todos funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Remover João
        funcionarios.removeIf(func -> func.getNome().equals("João"));

        // Exibir todos os funcionários
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Data Nascimento: " + f.getDataNascimento().format(formatter));
            System.out.println("Salário: R$ " + df.format(f.getSalario().setScale(2, RoundingMode.HALF_UP)));
            System.out.println("Função: " + f.getFuncao());
            System.out.println("============================");
        }

        // Aumentar o salário em 10%
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
        }

        System.out.println("\nAUMENTO DE 10%\n");

        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Salário: R$ " + df.format(f.getSalario().setScale(2, RoundingMode.HALF_UP)));
            System.out.println("============================");
        }

        // Agrupar com MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Exibir funcionarios agrupados         
        System.out.println("\nFUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println("  - " + f.getNome() + " | Salário: R$ " + df.format(f.getSalario()));
            }
        }
        
        
        System.out.println("\nFUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO EM OUTUBRO OU DEZEMBRO:");

        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();  
            if (mes == 10 || mes == 12) {
                System.out.println("Nome: " + f.getNome() + " | Data Nascimento: " + f.getDataNascimento().format(formatter));
            }
        }

        System.out.println("\nFUNCIONÁRIO COM MAIOR IDADE:");

        // Encontrar o funcionário com a maior idade
        Funcionario funcionarioMaisVelho = funcionarios.stream()
            .max((f1, f2) -> {
                int idadeF1 = Period.between(f1.getDataNascimento(), LocalDate.now()).getYears();
                int idadeF2 = Period.between(f2.getDataNascimento(), LocalDate.now()).getYears();
                return Integer.compare(idadeF1, idadeF2);
            })
            .orElse(null);

        if (funcionarioMaisVelho != null) {
            int idade = Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " | Idade: " + idade);
        }

        System.out.println("\nFUNCIONÁRIO EM ORDEM ALFABETICA:");


        //Ordem alfabetica 
        funcionarios.stream()
            .sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome())) 
            .forEach(f -> System.out.println("Nome: " + f.getNome() + " | Data Nascimento: " + f.getDataNascimento().format(formatter) + 
                                    " | Salário: R$ " + df.format(f.getSalario()) + " | Função: " + f.getFuncao()));


        System.out.println("\nTOTAL DOS SALARIOS:");

        // Calcular o total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
        .map(Funcionario::getSalario) 
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total dos Salários: R$ " + df.format(totalSalarios));

    }
}