/**
 * Created by MurphySL on 2017/7/2.
 */
public class Client {
    public static void main(String[] args){
        JavaNutritionFacts facts = new JavaNutritionFacts.Builder(10, 20)
                .calories(20)
                .carbohydrate(50)
                .fat(40)
                .build();

        System.out.println(facts.toString());

    }
}
