public class EX0505 {
    public static void main(String[] args) {
        C v=new C1();
        System.out.println(v.executa(5));
    }
}

// 1. Instância de C1 é criada e passada para a variável v, de tipo C
// 2. Construtor de C1 é acionado, que aciona o construtor de sua superclasse (C)
// 3. Variáveis v1, v2 e s1 são inicializadas com 10, 20 e 30.
// 4. Construtor de C é executado, v1, v2 e s1 passam a ter valor 20, 40 e 40
// 5. Construtor de C1 é executado, v1, v2 e s1 passam a ter valor 10, 10 e 50
// 6. Método executa, da classe C1, é executado passando 5 como parâmetro.
// 7. Método ms1, da classe C1, é executado passando 5 como parâmetro (não há sobrescrita de método estático)
// 8. s1 passa a ter valor 60
// 9. Método retorna, da classe C, é executado passando 5 como parâmetro
// 10. Como o objeto corrente (this) é da classe C1, o método calcula sobrescrito na classe C1 é executado
// 11. Calcula retorna 15, que é somado a v1, v2 e s1 no retorno do método retorna
// 12. O método executa, da classe C1, retorna 10 + 10 + 60 + 15 = 95
// 13. Valor 95 é exibido no console