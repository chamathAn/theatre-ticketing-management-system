public class Ticket {
    private int row;
    private int seat;
    private int price;
    Person person;

    public Ticket(int row,int seat,int price,String name,String surname,String email){
        this.price=price;
        this.row=row;
        this.seat=seat;
        this.person= new Person(name,surname,email);
    }

    public int getRow(){
        return this.row;
    }

    public int getSeat(){
        return this.seat;
    }

    public void print (){
        System.out.println("Name :"+this.person.getName());
        System.out.println("Surname :"+this.person.getSurname());
        System.out.println("Email :"+this.person.getEmail());
        System.out.println("Row Number :"+this.row);
        System.out.println("Seat Number :"+this.seat);
        System.out.println("Price :"+this.price);
    }

    public int getPrice(){
        return this.price;
    }

}
