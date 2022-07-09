public class EX0501 {
    public static void main(String[] args) {
        A o=new B();
        o.ma3(2);
        o.exibe();
    }
}

// 1. Instância de B é criada e passada para a variável o, do tipo A
// 2. Método m3 da classe A (foi herdado) é chamado passando 2 como parâmetro
// 3. Método ma1 da classe B é chamado (sobrescrita do método), passando 2 como parâmetro
// 4. A variável protected y, de valor 20, é incrementada em 10*2, resultando em 40
// 5. Método ma2 da classe B é chamado
// 6. A variável protected x passa a ter o valor 10*40 = 400
// 7. Método exibe, herdado da classe A, é chamado e executado
// 8. São printados na tela os valores 400 e 40

// Alterando o modificador de A.ma2() para private, os passos 1 a 4 são iguais.
// Até este ponto, temos x = 10 e y = 40.
// No passo 5, o método ma2 é chamado, mas como ele foi definido como private em A, ocorre a amarração
// estática, portanto o método ma2 da classe A é chamado.
// a variável y passa a ser 40 * 10 = 400 (e x permanece inalterado)
// .
// .
// .
// São printados na tela os valores 10 e 400