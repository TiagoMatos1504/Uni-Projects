public class Status {
    //Attributes
    private double energy;
    private double hunger;
    private double happiness;
    private boolean hungerB;
    //constructor
    public Status(){
        energy = 100;
        hunger = 100;
        happiness = 100;
        hungerB = false;
    }
    //methods
    public double getEnergy() {
        return energy;
    }
    public double getHappiness() {
        return happiness;
    }
    public double getHunger() {
        return hunger;
    }
    public boolean isHungerB() {
        return hungerB;
    }
    public void feed(){
        if(hunger < 80) {
            hunger = 100;
            hungerB = false;
            System.out.println("O seu Pet foi alimentado");
        }
        else{
            System.out.println("O seu Pet não têm fome");
        }
        if(energy <= 80){
            energy += 20;
        }
        else{
            energy = 100;
        }
    }
    public void play(){
        if(energy<=20){
            System.out.println("O seu animal está demasiado cansado!");
        } else if (hunger<=20) {
            System.out.println("O seu animal está com demasiada fome!");
        } else{
            energy = energy-20;
            hunger = hunger-20;
            hungerB = true;
            if(happiness <= 80){
                happiness += 20;
            }
            else{
                happiness = 100;
            }
            System.out.println("Brincou com o seu Pet");
        }
    }
    public void sleep(){
        if(energy>80){
            System.out.println("O seu Pet ainda não precisa de dormir");
        }
        else{
            energy = 100;
            System.out.println("O seu animal dormiu");
        }
    }
    public void showStatus(){
        System.out.println("***ESTATISTICAS DO SEU PET***");
        System.out.println("Energia: "+energy);
        System.out.println("Fome: "+(hungerB ? "Com fome" : "Sem fome"));
        System.out.println("Felicidade: "+happiness);
    }
    public void cicle(){
        if(energy>=5 && happiness>=5 && hunger>=5) {
            energy -= 5;
            happiness -= 5;
            hunger -= 5;
            if(hunger <= 80){
            hungerB = true;
            }
            else{
            hungerB = false;
            }
        }
        else{
            System.out.println("Precisa de executar alguma ação!");
        }
    }
}