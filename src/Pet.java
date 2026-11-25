public class Pet {
    //Attributes
    private String name;
    private int AnimalType;
    private Status status;
    //constructor
    public Pet(String name, int AnimalType){
        this.name = name;
        this.AnimalType = AnimalType;
        status = new Status();
    }
    //methods
    public String getName(){
        return name;
    }
    public Status getStatus(){
        return status;
    }
    public int getAnimalType(){
        System.out.println("Lista de animais: 1- Cão, 2- Gato, 3- Pássaro, 4- coelho, 5- Peixe");
        return AnimalType;
    }
    public void showPetStatus(){
        if(status != null) {
            status.showStatus();
        }
    }
}