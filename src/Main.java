import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Status status;
        int petType;
        status = null;
        Pet pet = null;
        boolean petExists;
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        int feedCounter = 0;
        int playCounter = 0;
        int sleepCounter = 0;
        int nextCounter = 0;
        petExists = false;
        char confirm = '0';
        System.out.println("***BEM VINDO AO VIRTUAL PET***");
        while(opcao != 99 || (opcao == 99 && (confirm == 'n' || confirm == 'N'))){
            System.out.println("********MENU PRINCIPAL********");
            if(petExists == false){
                System.out.println("1- Criar Virtual Pet");
                System.out.println("99- Sair");
            }
            else{
                System.out.println("1- Criar Novo Virtual Pet");
                System.out.println("2- Ver Status do seu Pet");
                System.out.println("3- Alimentar o seu Pet");
                System.out.println("4- Brincar com o seu Pet");
                System.out.println("5- Adormecer o seu Pet");
                System.out.println("6- Passar jogada");
                System.out.println("99- Sair e ver relatório");
            }
            System.out.println("");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine(); //Limpeza de buffer
            switch (opcao){
                case 1:
                    System.out.print("Nome do seu novo Pet: ");
                    String petName = scan.nextLine();
                    do {
                        System.out.print("Tipo do seu novo Pet (1- Cão, 2- Gato, 3- Pássaro, 4- coelho, 5- Peixe): ");
                        petType = scan.nextInt();
                    }
                    while (petType < 1 || petType > 5);
                    pet = new Pet(petName, petType); 
                    status = pet.getStatus();
                    petExists = true;
                    break;
                case 2:
                    if(petExists == true) {
                        pet.showPetStatus();
                    }
                    else {
                        System.out.println("Aviso: Ainda não criou nenhum Pet!");
                    }
                    break;
                case 3:
                    if (petExists == true) {
                        status.feed();
                        status.cicle();
                        feedCounter += 1;
                    }
                    else {
                        System.out.println("Aviso: Ainda não criou nenhum Pet!");
                    }
                    break;
                case 4:
                    if(petExists == true){
                        status.play();
                        status.cicle();
                        playCounter += 1;
                    }
                    else {
                        System.out.println("Aviso: Ainda não criou nenhum Pet!");
                    }
                    break;
                case 5:
                    if(petExists == true){
                        status.sleep();
                        status.cicle();
                        sleepCounter += 1;
                    }
                    else {
                        System.out.println("Aviso: Ainda não criou nenhum Pet!");
                    }
                    break;
                case 6:
                    if(petExists == true){
                        status.cicle();
                        nextCounter++;
                    }
                    else {
                        System.out.println("Aviso: Ainda não criou nenhum Pet!");
                    }
                    break;
                case 99:
                    if(petExists == true) {
                        System.out.println("Deseja terminar o jogo e ver o relatório final? (Y/N)");
                        confirm = scan.next().charAt(0);
                        scan.nextLine(); //Limpeza de buffer
                        do{
                            if (confirm == 'Y' || confirm == 'y') {
                            System.out.println("***ESTATISTICAS FINAIS DO JOGO***");
                            status.showStatus();
                            System.out.println("Vezes que alimentou o Pet: " + feedCounter);
                            System.out.println("Vezes que brincou com o Pet: " + playCounter);
                            System.out.println("Vezes que adormeceu o Pet: " + sleepCounter);
                            System.out.println("Vezes que saltou a jogada: " + nextCounter);
                            System.out.println("Obrigado por Jogar!");
                            break;
                            }
                            else if (confirm == 'N' || confirm == 'n') {
                                System.out.println("Voltando ao menu principal...");
                                break;
                            }
                            else {
                                System.out.println("Introduza um valor válido!");
                                System.out.println("Deseja terminar o jogo e ver o relatório final? (Y/N)");
                                confirm = scan.next().charAt(0);
                                scan.nextLine(); //Limpeza de buffer
                                break;
                            }
                        } while (confirm != 'Y' && confirm != 'y' && confirm != 'N' && confirm != 'n');
                    }
                    else {
                        System.out.println("Deseja terminar o jogo e ver o relatório final? (Y/N)");
                        confirm = scan.next().charAt(0);
                        scan.nextLine(); //Limpeza de buffer
                        do{
                            if (confirm == 'Y' || confirm == 'y') {
                            System.out.println("Obrigado por Jogar!");
                            break;
                            }
                            else if (confirm == 'N' || confirm == 'n') {
                                System.out.println("Voltando ao menu principal...");

                                break;
                            }
                            else {
                                System.out.println("Introduza um valor válido!");
                                System.out.println("Deseja terminar o jogo e ver o relatório final? (Y/N)");
                                confirm = scan.next().charAt(0);
                                scan.nextLine(); //Limpeza de buffer
                                break;
                            }
                        } while (confirm != 'Y' && confirm != 'y' && confirm != 'N' && confirm != 'n');
                    }
                    break;
                default:
                    System.out.println("Introduza um valor válido!");
                    break;
            }
        } scan.close();
    }
}