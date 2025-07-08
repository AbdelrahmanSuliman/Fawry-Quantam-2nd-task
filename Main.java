import Classes.Inventory;
import Classes.PaperBook;

public class Main {

    public static void testAddBook(){
        final Inventory inv = new Inventory();
        try{
            //No errors
            inv.addBook(new PaperBook("123-321", "Example title", 2022, 19.95, 3));
        } catch(Exception e){
            e.printStackTrace();
        }

        try{
            //Duplicate isbn error
            inv.addBook(new PaperBook("123-321", "Example of a title", 2010, 20.50, 2));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void testBuyBook(){
        final Inventory inv = new Inventory();
        inv.addBook(new PaperBook("123-321", "Example title", 2022, 19.95, 3));
        try{
            //No errors
            inv.buyBook("123-321", 3,"example@gmail.com", "egypt");
        } catch(Exception e){
            e.printStackTrace();
        }

        try{
            //Out of stock error
            inv.buyBook("123-321", 1,"example@gmail.com", "egypt");
        } catch(Exception e){
            e.printStackTrace();
        }

        try{
            //Book doesnt exist error
            inv.buyBook("999-999", 1,"example@gmail.com", "egypt");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void testRemoveBook(){
        final Inventory inv = new Inventory();
        inv.addBook(new PaperBook("123-321", "Example title", 2000, 19.95, 3));
        inv.addBook(new PaperBook("444-444", "Example title", 2004, 19.95, 3));
        inv.addBook(new PaperBook("111-111", "Example title", 2001, 19.95, 3));
        try{
            //No errors (books are not older than given time which is years)
            inv.removeOutdatedBooks(30);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            //Books older than specified years
            inv.removeOutdatedBooks(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("Testing addBook");
        testAddBook();
        System.out.println("Testing buyBook");
        testBuyBook();
        System.out.println("Testing removeBook");
        testRemoveBook();
    }
}
