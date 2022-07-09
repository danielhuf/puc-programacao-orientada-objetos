public class EX0401 {
    public static void main(String[] args) {
        C o=new C(5);
        o.exibe();
    }
}

// 1. Instancia de C é criada e referenciada pela variável o
// 2. Construtor de C é acionado, que chama o construtor da superclasse B
// 3. Construtor de B é acionado, que chama o construtor da superclasse A
// 4. Variáeis de instância x e y são inicializadas com 0 por default
// 5. Bloco de inicialização é executado, x e y assumem valor 10
// 6. Construtor de A é executado, x e y assumem valor 100 (10 * 10)
// 7. Construtor de B é executado, x e y assumem valor 200 (2 * 100)
// 8. Construtor de C é executado, x asssume valor 205 e y assume valor 1000
// 9. Controle volta ao método main e o método exibe da classe A é executado
// 10. Valores 205 e 1000 são exibidos no console

// Colocando o bloco de inicialização na classe C, o passo 5 passa a ser feito
// dentro do passo 8, antes do construtor de C. Então x e y terão valor 0, depois 10, e depois
// 15 e 50, respectivamente.

// DÚVIDA: como x e y são as mesmas variáveis em A, B e C, 
// se elas foram definidas como default e não estão no mesmo pacote?
// Resp: Elas estão todas no mesmo pacote, o pacote default