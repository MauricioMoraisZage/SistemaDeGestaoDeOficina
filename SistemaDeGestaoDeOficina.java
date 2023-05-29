import java.util.Scanner;

public class SistemaDeGestaoDeOficina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op=0, TotalVeiculos=0;
        double PagInicial=1, ReceitaDaOficina = 0;
        Veiculo vcl = new Veiculo();
        
        try {
            System.out.println("\t******** SISTEMA DE GESTAÕ DE OFICINA *********");
            while (op != 4) {
                System.out.println("");
                System.out.println("1 - Registrar um veículo");
                System.out.println("2 - Verificar veículos registrados na oficina");
                System.out.println("3 - Acertar as contas e remover o veículo");
                System.out.println("4 - Sair do sistema");
                System.out.print("Escolha uma opção: ");
                op = scanner.nextInt();
                
                switch (op) {
                    case 1:   ////////Adicionar Veiculos na Oficina...
                        System.out.println("");  
                        System.out.print("\tDigite a placa do veículo: ");
                        String AnalsPlaca = scanner.next();
                        System.out.print("\tDigite o nome do proprietário: ");
                        String proprietario = scanner.next();
                        System.out.print("\tDigite o modelo do veículo: ");
                        String modelo = scanner.next();
                        
                        vcl = new Veiculo(AnalsPlaca, proprietario, modelo, PagInicial);
                        Veiculo.TodsVcs.add(vcl);
                        TotalVeiculos++;
                        System.out.println("\t\tVeículo registrado com sucesso!");
                        break;
                        
                    case 2:  /////Mostrar Todos os Veiculos Registrados na Oficina...
                        System.out.println("");  
                        System.out.println("\tLista de veículos registrados na oficina: ");
                        for (int i=0; i<TotalVeiculos; i++) {
                           System.out.println(i+1+".Placa: " + Veiculo.TodsVcs.get(i).getPlaca() +" - Marca: "+ Veiculo.TodsVcs.get(i).getModel() +" - Dono: "+Veiculo.TodsVcs.get(i).getDono());
                        }
                        break;
                        
                    case 3: //////Fazer os Acertos com o Dono do Veiculo e depois eliminar a Registro do Veículo...
                        System.out.println("");      
                        System.out.print("\tDigite a placa do veículo: ");
                        AnalsPlaca = scanner.next();
                        Veiculo VeiculoPagando = null;
                        
                        for (int i=0; i<TotalVeiculos; i++) {
                            if (Veiculo.TodsVcs.get(i).getPlaca().equals(AnalsPlaca)) { //vai analisar se existe uma placa igual a placa digitada... 
                                VeiculoPagando = Veiculo.TodsVcs.get(i);
                                break;
                            }
                        }
                        if (VeiculoPagando != null) { //Se é != null significa q encontrou o Veiculo com a placa digitada...
                            System.out.print("Digite o valor a Pagar pela Reparação: ");
                            double Pagamento = scanner.nextInt();

                            double ValorTotal = VeiculoPagando.getValor() * Pagamento; //Pegando o PagInicial=1 * com o Pagamento Final depois da Reparação
                            
                            System.out.println("");
                            System.out.println("\tValor Pago pela Reparação: "+ValorTotal+"Kz " +"-  Placa: "+VeiculoPagando.getPlaca());
                            System.out.println("\tModelo do Veículo: "+VeiculoPagando.getModel() +"-  Proprietario: " +VeiculoPagando.getDono());
                            ReceitaDaOficina += ValorTotal;
                            Veiculo.TodsVcs.remove(VeiculoPagando);
                            System.out.println("\t\t *** Veículo removido da lista ***");
                            TotalVeiculos--;
                        } 
                        else {
                            System.out.println("Veículo não encontrado.");
                        }
                        break;
                        
                    case 4:   //////// Encerrar o Sistema...
                        System.out.println("");  
                        System.out.println("\tSaindo do sistema...");
                        break;
                        
                    default:  ///////// Para Opcoes invalidas...
                        System.out.println("");   
                        System.out.println("\tOpção inválida.");
                        break;
                }
            }
            System.out.println("Total de receita da oficina de Hoje: " + ReceitaDaOficina);
        } 
        catch (Exception e) {
            System.out.println("Erro! "+e);
        }
    }
}
    