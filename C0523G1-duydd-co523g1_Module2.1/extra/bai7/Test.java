package extra.bai7;

public class Test {
    public static void main(String[] args) {
        Book natural1 = new NaturalBook("Natural Chapter 1","05/10/1950","NSB. Kim Đồng",100);
        Book natural2 = new NaturalBook("Natural Chapter 2","02/09/1945","NSB. Kim Đồng",200);
        Book natural3 = new NaturalBook("Natural Chapter 3","22/12/2022","NSB. Kim Đồng",300);
        Book social1 = new SocialBook("Đắc Nhân Tâm","1936","Duy","Dale Carnegie");
        Book social2 = new SocialBook("Truyện Kiều","1234","Keem Đồng","Tố Hữu");
        Book[] bookList = {natural1,natural2,natural3,social1,social2};
        for (Book book: bookList){
            book.display();
        }
    }
}
