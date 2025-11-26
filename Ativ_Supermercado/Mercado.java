import java.util.Scanner;
import java.util.ArrayList;

enum Pagamento{
    DINHEIRO("Dinheiro"),
    CHEQUE("Cheque"),
    CARTAO("Cartao");

    private final String nome;

    Pagamento(String nome){
        this.nome = nome;
    }
    public String getPagamento(){
        return this.nome;
    }
}

enum Pedido{
    ARROZ("Arroz"),
    FEIJAO("Feijao"),
    FARINHA("Farinha"),
    LEITE("Leite quente que dói os dente");
    private final String nome;
    Pedido(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
}

class Cliente{

    String nome, CPF;

    public Cliente(String nome, String CPF){
    this.nome = nome;
    this.CPF = CPF;
    }

}

class Produto{

    Pedido desc;
    double preco;
    int qntd;

    public Produto(Pedido desc, double preco, int qntd){
    this.desc = desc;
    this.preco = preco;
    this.qntd = qntd;
    }
}

public class Mercado{

    static ArrayList<Cliente> Pessoas = new ArrayList<>();
    static ArrayList<Produto> Itens = new ArrayList<>();

    static void imprimeInfo(Produto product, int numbOfPeople, Cliente user){

        Cliente first = null;

        System.out.println("Nome:    CPF:    Produto:    Qntd:    Preco:");
        for (int i = 0; i < numbOfPeople; i++){

            Cliente pessoazita = Pessoas.get(i);
            Produto produtito = Itens.get(i);

            System.out.println(pessoazita.nome + "\t" + pessoazita.CPF + "\t" + produtito.desc + "\t" + produtito.qntd + "\t" + produtito.preco);
            //System.out.println(user.nome + "\t" +user.CPF+ "\t" +product.desc.getNome()+ "\t" +product.qntd+ "\t" +product.preco);
        }
    }

    public static void main(String[] args){

        int opt = -1, qntd = 0;
        double preco = 0, total = 0;
        String nome = null, CPF = null;
        int select, numbOfPeople = 0;
        Produto product = null;
        Cliente user = null;

        Scanner input = new Scanner(System.in);

        System.out.println("Seja bem-vindo, Usuário!");

        do{
            System.out.println("================");
            System.out.println("1. Novo pedido");
            System.out.println("2. Realizar pagamento");
            System.out.println("3. Mostrar pedidos");
            System.out.println("0. Sair");
            opt = input.nextInt();
            switch(opt){

                case 0:
                System.out.println("Saindo...");
                break;

                case 1:
                System.out.println("Qual seu nome?");
                nome = input.next();
                System.out.println("Qual seu CPF?");
                CPF = input.next();
                user = new Cliente(nome,CPF);
                System.out.println("1. ARROZ");
                System.out.println("2. FEIJAO");
                System.out.println("3. FARINHA");                   //make a prettier menu later
                System.out.println("4. LEITE");
                System.out.print(":");
                select = input.nextInt();
                Pedido selection = null;
                switch (select){

                    default:
                    System.out.println("Erro!");
                    break;

                    case 1:
                    selection = Pedido.ARROZ;
                    break;

                    case 2:
                    selection = Pedido.FEIJAO;
                    break;

                    case 3:
                    selection = Pedido.FARINHA;
                    break;

                    case 4:
                    selection = Pedido.LEITE;
                    break;
                }
                System.out.println("Qual o preço?");
                preco = input.nextDouble();
                System.out.println("Qual a quantidade?");
                qntd = input.nextInt();                             //probably will have to change something here
                product = new Produto(selection,preco,qntd);
                System.out.println(product.desc.getNome() + " / " + product.preco + " / " + product.qntd);
                Pessoas.add(user);
                Itens.add(product);
                numbOfPeople++;
                break;

                case 2:
                for (int i = 0; i < numbOfPeople; i++){
                    Produto calc = Itens.get(i);

                    total = total+(calc.preco*calc.qntd);
                }
                System.out.println("TOTAL: " + total);
                System.out.println("Qual a forma de pagamento?");
                System.out.println("1. Dinheiro");
                System.out.println("2. Cheque");
                System.out.println("3. Cartao");
                select = input.nextInt();
                Pagamento option = null;
                switch(select){

                    default:
                    System.out.println("Erro!");
                    break;

                    case 1:
                    option = Pagamento.DINHEIRO;
                    break;

                    case 2:
                    option = Pagamento.CHEQUE;
                    break;

                    case 3:
                    option = Pagamento.CARTAO;
                    break;
                }
                System.out.println("Pagamento selecionado: " + option.getPagamento());
                System.out.println("PAGAMENTO REALIZADO COM SUCESSO!");
                total = 0;
                break;

                case 3:
                imprimeInfo(product,numbOfPeople,user);
                break;

                default:
                System.out.println("Erro!");
                break;

            }

        }while(opt != 0);
    }
}
