package top.greatxiaozou.arithmeticQuestion.CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NewSolution {
    private Queue<PetEntry> dogQ = new LinkedList<>();
    private Queue<PetEntry> catQ = new LinkedList<>();
    int count=0;
    //     private static int count=0;

    //整个一main方法都是根据输入来进行操作
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        NewSolution queue = new NewSolution();
        int times = Integer.parseInt(sc.nextLine());


        for(;times>0;times--){
            String[] strs = sc.nextLine().split(" ");
            if(strs[0].equals("pollAll")){
                while(true){
                    try{
                        System.out.println(queue.pollAll());
                    }catch(RuntimeException e){
                        break;
                    }
                }
            }else if(strs[0].equals("isEmpty")){
                System.out.println(queue.isEmpty());
            }else if(strs[0].equals("isDogEmpty")){
                System.out.println(queue.isDogEmpty());
            }else if(strs[0].equals("isCatEmpty")){
                System.out.println(queue.isCatEmpty());
            }else if(strs[0].equals("pollCat")){
                while(true){
                    try{
                        System.out.println(queue.pollCat());
                    }catch(RuntimeException e){
                        break;
                    }
                }
            }else if(strs[0].equals("pollDog")){
                while(true){
                    try{
                        System.out.println(queue.pollDog());
                    }catch(RuntimeException e){
                        break;
                    }
                }
            }else{
                queue.add(strs[1]+" "+strs[2],queue.count++);
            }
        }
    }
    public void add(String pet,int num){
        if(pet.split(" ")[0].equals("dog")){
            dogQ.add(new PetEntry(pet,num));
        }else{
            catQ.add(new PetEntry(pet,num));
        }
    }
    public String pollAll(){
        if(!dogQ.isEmpty() && !catQ.isEmpty()){
            if(dogQ.peek().getCount()>catQ.peek().getCount()){
                PetEntry p = catQ.poll();
                return p.getPet();
            }
            PetEntry p = dogQ.poll();
            return p.getPet();
        }
        if(dogQ.isEmpty() && catQ.isEmpty()){
            throw new RuntimeException("队列已空");
        }
        if(!dogQ.isEmpty()){
            PetEntry p = dogQ.poll();
            return p.getPet();
        }
        PetEntry p = catQ.poll();
        return p.getPet();
    }

    public String pollDog(){
        if(!dogQ.isEmpty()){
            PetEntry p = dogQ.poll();
            return p.getPet();
        }
        throw new RuntimeException("狗狗队列为空");
    }
    public String pollCat(){
        if(!catQ.isEmpty()){
            PetEntry p = catQ.poll();
            return p.getPet();
        }
        throw new RuntimeException("猫猫队列为空");
    }

    public String isEmpty(){
        if(dogQ.isEmpty() && catQ.isEmpty()){
            return "yes";
        }
        return "no";
    }

    public String isDogEmpty(){
        if(dogQ.isEmpty()){
            return "yes";
        }
        return "no";
    }
    public String isCatEmpty(){
        if(catQ.isEmpty()){
            return "yes";
        }
        return "no";
    }
}
class PetEntry {
    private String pet;
    private int count;

    public PetEntry(String pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPet() {
        return this.pet;
    }

    public int getCount() {
        return this.count;
    }
}
