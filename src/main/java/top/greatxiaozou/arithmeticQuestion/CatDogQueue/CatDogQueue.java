package top.greatxiaozou.arithmeticQuestion.CatDogQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CatDogQueue {
    static int timestamp=0;
    public Queue<PetEnterQueue> catQ = new LinkedList<>();
    public Queue<PetEnterQueue> dogQ = new LinkedList<>();

    public void add(Pet pet){
        PetEnterQueue petEnter = new PetEnterQueue(pet, timestamp++);
        if (pet.getType().equals("cat")){
            catQ.add(petEnter);
        }else if (pet.getType().equals("dog")){
            dogQ.add(petEnter);
        }
    }

    public Pet pollAll(){
        if (!dogQ.isEmpty() && !catQ.isEmpty()){
            if (dogQ.peek().getCount()>catQ.peek().getCount()){
                return catQ.poll().getPet();
            }else {
                return dogQ.poll().getPet();
            }
        }
        if (dogQ.isEmpty() && catQ.isEmpty()){
            return null;
        }
        if (dogQ.isEmpty()){
            return catQ.poll().getPet();
        }
        return dogQ.poll().getPet();
    }

    public Cat pollCat(){
        if (catQ.isEmpty()){
            throw new RuntimeException("猫猫队列为空哦");
        }
        return (Cat)catQ.poll().getPet();
    }
    public Dog pollDog(){
        if (dogQ.isEmpty()){
            throw new RuntimeException("狗狗队列为空哦");
        }
        return (Dog) dogQ.poll().getPet();
    }

    public boolean isEmpty(){
        if (dogQ.isEmpty() && catQ.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isDogEmpty(){
        if (dogQ.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isCatEmpty(){
        if (catQ.isEmpty()){
            return true;
        }
        return false;
    }
}
