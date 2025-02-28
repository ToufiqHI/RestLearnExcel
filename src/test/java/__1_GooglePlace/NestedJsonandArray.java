package __1_GooglePlace;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class NestedJsonandArray
{
    public static void main(String[] args)
    {
//        1. Print No of courses returned by API
//
//        2.Print Purchase Amount
//
//        3. Print Title of the first course
//
//        4. Print All course titles and their respective Prices
//
//        5. Print no of copies sold by RPA Course
//
//        6. Verify if Sum of all Course prices matches with Purchase Amount

        /**
         * 1 st case : 1. Print No of courses returned by API
          */
     JsonPath js =new JsonPath(ComplexJson.complex());
     int count=js.get("courses.size()");
        System.out.println(count);

        /**
         * Print Purchase Amount
         */
        int amount=js.get("dashboard.purchaseAmount");
        System.out.println(amount);

        /**
         * Print Title of the first course
         */
        String firstCourse=js.get("courses[0].title");
        System.out.println(firstCourse);

        /**
         * Print All course titles and their respective Prices
         */
        for (int i=0; i<count; i++)
        {
          String allCourseTitle= js.get("courses["+ i +"].title");
          int price=js.get("courses["+ i +"].price");
            System.out.println(price);
            System.out.println(allCourseTitle);
        }

        /**
         * Print no of copies sold by RPA Course
         */
        for (int i=0; i<count; i++)
        {
            String allCourseTitle= js.get("courses["+ i +"].title");
           if (allCourseTitle.equals("RPA"))
           {
               //copies sold
               int copies=js.get("courses["+ i +"].copies");
               System.out.println(copies);
               break;
           }
        }

        /**
         * Verify if Sum of all Course prices matches with Purchase Amount
         */
        int sum=0;
        for (int i=0; i<count; i++)
        {
            int price=js.get("courses["+ i +"].price");
            int copies=js.get("courses["+ i +"].copies");
            int Amount=price *copies;
            System.out.println(Amount);
            sum=sum+Amount;
        }
        System.out.println(sum);
        Assert.assertEquals(amount,sum);
        if (sum ==amount)
        {
            System.out.println("Same");
        }


    }
}
