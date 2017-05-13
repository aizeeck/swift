package lesson11_Generics_Enums_Annotations.Task2_CardsAnnotation;

import lesson11_Generics_Enums_Annotations.Task0_Cards.CardRank;
import lesson11_Generics_Enums_Annotations.Task1_Deck.Card;

import java.lang.annotation.Annotation;

/**
 * Created by aizeeck on 11.05.17.
 */
public class Task2_CardsAnnotation {
    public static void main(String[] args) {

        Package p = Card.class.getPackage();
        System.out.println(p.getName());
        java.lang.Class<CardRank> clazz = CardRank.class;
        String a = clazz.getSimpleName();
        System.out.println(a);
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(annotations);
        for (Annotation annotation : annotations) {
            System.out.println(annotation.getClass());
        }


//        for (java.lang.Class c : p.getClass().getClasses()) {
//            System.out.println(c.getClasses().length);
////            for (Class clazz : c) {
////
////            }
//        }
    }
}
