package com.epam.testspring;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanMain {
    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-test-spring.xml");

        PlayMusic playMusicOne = context.getBean("playMusic", PlayMusic.class);

//         //Scope = "prototype";

//        playMusicOne.setVol(10);
//        PlayMusic playMusicTwo = context.getBean("playMusic", PlayMusic.class);
//        playMusicTwo.setVol(20);
//        System.out.println("PlayMusicOne =:   " + playMusicOne.getVol());
//        System.out.println("PlayMusicTwo =:   " + playMusicTwo.getVol());

//        //get properties with file playMusic.properties

//        System.out.println(playMusicOne.getVol());
//        System.out.println(playMusicOne.getNamePlayer());

////        // constructor-arg, init and destroy method
//        ClassicalMusic classicalMusic = context.getBean("musicBean",ClassicalMusic.class);
//        System.out.println(classicalMusic.getName());
//        context.close();
    }
}
