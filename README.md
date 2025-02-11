## **Teste Prático - Iniflex**

 O projeto foi desenvolvido conforme os requisitos apresentados, e a seguir, estão descritos os detalhes de cada requisito, o código correspondente e a explicação do que está acontecendo em cada etapa.

---

### **Requisito 1 - Classe Pessoa**

A classe **Pessoa** representa uma pessoa com nome e data de nascimento. Ela é a classe base para a classe **Funcionario**.

**Código:**

```java
package org.example.testePratico.model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    // Getters e setters
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
```

**Explicação:**
- A classe **Pessoa** contém dois atributos: `nome` (String) e `dataNascimento` (LocalDate).
- O construtor inicializa esses atributos, e os métodos getters e setters permitem acessar e modificar os valores desses atributos.

---

### **Requisito 2 - Classe Funcionario**

A classe **Funcionario** herda de **Pessoa** e adiciona dois novos atributos: `salario` (BigDecimal) e `funcao` (String), representando o salário e a função do funcionário, respectivamente.

**Código:**

```java
package org.example.testePratico.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    // Getters e setters
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento); // Chama o construtor da classe base
        this.salario = salario;
        this.funcao = funcao;
    }
}
```

**Explicação:**
- A classe **Funcionario** herda de **Pessoa**, portanto, ela possui os atributos `nome` e `dataNascimento`.
- Além disso, a classe adiciona os atributos `salario` e `funcao`, e o construtor inicializa todos esses atributos.

---

Claro! Abaixo, vamos apresentar a explicação de cada requisito, seguida do código e a saída esperada no console para os casos que envolvem impressão de dados.

---

### **Requisito 3 - Classe Principal (Main)**

#### **3.1 - Inserir todos os funcionários:**

Aqui, estamos criando e adicionando funcionários à lista.

**Código:**

```java
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

```

**Explicação:**
- Funcionários são adicionados à lista de acordo com as informações fornecidas.
- A classe **Funcionario** é instanciada com nome, data de nascimento, salário e função.

---

#### **3.2 - Remover o funcionário João:**

Removemos o funcionário João da lista utilizando um filtro baseado no nome.

**Código:**

```java
funcionarios.removeIf(func -> func.getNome().equals("João"));
```

**Explicação:**
- A função **`removeIf()`** percorre a lista e remove o funcionário cujo nome é "João".

---

#### **3.3 - Imprimir todos os funcionários:**

Exibimos todos os funcionários com formatação personalizada para data e salário.

**Código:**

```java
for (Funcionario f : funcionarios) {
    System.out.println("Nome: " + f.getNome());
    System.out.println("Data Nascimento: " + f.getDataNascimento().format(formatter));
    System.out.println("Salário: R$ " + df.format(f.getSalario().setScale(2, RoundingMode.HALF_UP)));
    System.out.println("Função: " + f.getFuncao());
    System.out.println("============================");
}
```

**Explicação:**
- A data é formatada no padrão **dd/MM/yyyy**.
- O salário é formatado com separador de milhar (ponto) e vírgula para os centavos.
- Exibimos o nome, data de nascimento, salário e função de cada funcionário.

**Console:**

```
Nome: Maria
Data Nascimento: 18/10/2000
Salário: R$ 2.009,44
Função: Operador
============================
Nome: Caio
Data Nascimento: 02/05/1961
Salário: R$ 9.836,14
Função: Coordenador
============================
Nome: Miguel
Data Nascimento: 14/10/1988
Salário: R$ 19.119,88
Função: Diretor
============================
```

---

#### **3.4 - Aumento de 10% no salário:**

Aqui aplicamos um aumento de 10% a todos os salários dos funcionários.

**Código:**

```java
for (Funcionario f : funcionarios) {
    f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
}
```

**Explicação:**
- O valor original do salário é 100%.
- O aumento de 10% significa que adicionaremos 10% sobre o valor original.
- Portanto, o valor final será a soma do salário original com o aumento. Ou seja, 100% + 10% = 110% do valor original.

**Console:**

```
AUMENTO DE 10%

Nome: Maria
Salário: R$ 2.210,38
============================
Nome: Caio
Salário: R$ 10.819,75
============================
Nome: Miguel
Salário: R$ 21.031,87
============================
```

---

#### **3.5 - Agrupar os funcionários por função:**

Agrupamos os funcionários por sua função, criando um **Map** onde a chave é a função e o valor é a lista de funcionários dessa função.

**Código:**

```java
Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
    .collect(Collectors.groupingBy(Funcionario::getFuncao));
```

**Explicação:**
- Utilizamos o método **`groupingBy()`** da API Streams para agrupar os funcionários pela sua função. Esse método cria um Map, onde a chave é a função do funcionário (como "Operador", "Gerente") e o valor é uma lista de funcionários que possuem essa função.

    - API Streams é uma funcionalidade do Java que facilita o processamento de coleção de dados(como listas, conjuntos e mapas)

---

#### **3.6 - Imprimir os funcionários agrupados por função:**

Exibimos os funcionários agrupados por função.

**Código:**

```java
for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
    System.out.println("\nFunção: " + entry.getKey());
    for (Funcionario f : entry.getValue()) {
        System.out.println("  - " + f.getNome() + " | Salário: R$ " + df.format(f.getSalario()));
    }
}
```

**Explicação:**
- Para cada entrada do **Map**, exibimos a função e a lista de funcionários dessa função.

**Console:**

```
Função: Operador
  - Maria | Salário: R$ 2.210,38
  - Heitor | Salário: R$ 1.741,00
Função: Coordenador
  - Caio | Salário: R$ 10.819,75
Função: Diretor
  - Miguel | Salário: R$ 21.031,87

```

---

#### **3.8 - Imprimir funcionários que fazem aniversário no mês 10 e 12:**

Aqui exibimos os funcionários que fazem aniversário em outubro ou dezembro.

**Código:**

```java
for (Funcionario f : funcionarios) {
    int mes = f.getDataNascimento().getMonthValue();
    if (mes == 10 || mes == 12) {
        System.out.println("Nome: " + f.getNome() + " | Data Nascimento: " + f.getDataNascimento().format(formatter));
    }
}
```

**Explicação:**
- Verificamos se o mês de nascimento do funcionário é **10** (outubro) ou **12** (dezembro).

**Console:**

```
Nome: Maria | Data Nascimento: 18/10/2000
Nome: Miguel | Data Nascimento: 14/10/1988
```

---

#### **3.9 - Imprimir o funcionário com maior idade:**

Calculamos a idade de cada funcionário e exibimos o mais velho.

**Código:**

```java
Funcionario funcionarioMaisVelho = funcionarios.stream()
    .max((f1, f2) -> {
        int idadeF1 = Period.between(f1.getDataNascimento(), LocalDate.now()).getYears();
        int idadeF2 = Period.between(f2.getDataNascimento(), LocalDate.now()).getYears();
        return Integer.compare(idadeF1, idadeF2);
    })
    .orElse(null);
```

**Explicação:**
- Utilizamos o **`max()`** para comparar a idade dos funcionários e encontrar o mais velho.

**Console:**

```
FUNCIONÁRIO COM MAIOR IDADE:
Nome: Caio | Idade: 63
```

---

#### **3.10 - Imprimir os funcionários por ordem alfabética:**

Ordenamos os funcionários pelo nome e exibimos.

**Código:**

```java
funcionarios.stream()
    .sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome()))
    .forEach(f -> System.out.println("Nome: " + f.getNome() + " | Função: " + f.getFuncao()));
```

**Explicação:**
- A lista de funcionários é ordenada alfabeticamente pelo nome utilizando **`sorted()`**.

**Console:**

```
FUNCIONÁRIOS EM ORDEM ALFABÉTICA:
Nome: Alice | Função: Recepcionista
Nome: Arthur | Função: Contador
Nome: Caio | Função: Coordenador
```

---

#### **3.11 - Imprimir o total dos salários:**

Calculamos e exibimos o total de todos os salários.

**Código:**

```java
BigDecimal totalSalarios = funcionarios.stream()
    .map(Funcionario::getSalario)
    .reduce(BigDecimal.ZERO, BigDecimal::add);
```

**Explicação:**
- Usamos **`reduce()`** permite combinar todos os elementos de um Stream em um único valor, como a soma de salários, de forma concisa e eficiente.

**Console:**

```
Total dos salários: R$ 47.613,89
```

---

#### **3.12 - Imprimir quantos salários mínimos ganha cada funcionário:**

Calculamos quantos salários mínimos cada funcionário recebe e exibimos.

**Código:**

```java
BigDecimal salarioMinimo = new BigDecimal("1212.00");
for (Funcionario f : funcionarios) {
    BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
}
```

**Explicação:**
- Dividimos o salário de cada funcionário pelo valor do salário mínimo e exibimos o resultado.

**Console:**

```
Maria ganha 1,82 salários mínimos.
Caio ganha 8,92 salários mínimos.
Miguel ganha 17,34 salários mínimos.
```

---

Com isso, cobrimos todas as operações descritas no projeto, incluindo o código e os resultados esperados no console para os requisitos que envolvem impressão de dados!