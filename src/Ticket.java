public class Ticket {
    public static Ticket ticket;
    public int row_num;
    public int seat_num;
    public double price;
    public Person person;

    // Define a constructor for the ticket class that takes in a row, seat, price and person

    public Ticket(int row_num, int seat_num, double price, Person person){
        this.row_num = row_num;
        this.seat_num = seat_num;
        this.price = price;
        this.person = person;
    }

    public int getRow(){
        return row_num;
    }

    public int getSeat(){
        return seat_num;
    }

    public double getPrice(){
        return price;
    }


    public Person getPerson() {
        return person;
    }


    // creating print method
    public void print(){
        System.out.println("-".repeat(50));
        System.out.println("          Ticket Information. ");
        System.out.println("Person name:" +person.getName());
        System.out.println("Person surname: " + person.getSurname());
        System.out.println("Person email: " +person.getEmail());
        System.out.println("Row number: " + row_num);
        System.out.println("Seat number: " + seat_num);
        System.out.println("Ticket price: " + price);
    }
}
