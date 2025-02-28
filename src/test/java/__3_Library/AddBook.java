package __3_Library;

public class AddBook
{
    public static String addBook(String isbn, String aisle) {
        String payload = "{\n" +
                "\"name\":\"Learn Automation with Java\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"John R\"\n" +
                "}";
        return payload;
    }


    /**
     *
     * there are three ways to pass the body
     * 1) use method name and pass the data
     * 2) pass value from test class and store it in method
     * 3) Use  data provider and pass the data
     */

}
