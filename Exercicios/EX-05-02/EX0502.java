public class EX0502 {
    public static void main(String[] args) {
        Container c=new Container();
        Poligono p;
        p=new Quadrado();
        c.addPoligono(p);
    }
}

// A mensagem exibida no console será "Desenho de Quadrado", pois:
// 1. c é inicializado como uma instância da classe Container.
// 2. p, do tipo Poligono, é inicializado como uma instância da classe Quadrado
// 3. p é adicionado ao vetor de Poligonos de c 
// 4. Quando o método desenha() é chamado, pelo poliformismo, tal método é deixaod
// para as classes herdadas (no caso para a classe Retangulo), em seguida esse método é sobrescrito na 
// classe Quadrado, que é uma sub classe de Retangulo. 
