package Activities;

public class Activity5 {

    public static void main(String[] args) {
        MyBook listOfBooks= new MyBook();

        listOfBooks.setTitle("SECRET");
        System.out.println(listOfBooks.getTitle());
    }

}

abstract class Book{

    String title;

    abstract void setTitle(String str);

    public String getTitle(){
      return title;
    }


}

class MyBook extends Book{
    public void setTitle(String str){
        title=str;

    }

        }