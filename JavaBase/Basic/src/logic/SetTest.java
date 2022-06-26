package logic;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {

        Set<Integer> _1 = new HashSet<>();
        Set<Integer> _2 = new HashSet<>();
        Set<Integer> _3 = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            _1.add(random.nextInt(100));
            _2.add(random.nextInt(100));
            _3.add(random.nextInt(100));

        }


        List<Set> nums = Arrays.asList(_1, _2, _3);
        Map<Integer, Integer> datas = new HashMap<>();
        long start = System.currentTimeMillis();
        loopAndCount(nums, datas);
        System.out.println(System.currentTimeMillis()-start);

        Map<Integer, Integer> datas2 = new HashMap<>();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < nums.size(); i++) {
            containsCheck(nums, datas2,i);
        }
        System.out.println(System.currentTimeMillis()-start2);


        System.out.println(datas2);



    }

    private static void loopAndCount(List<Set> nums, Map<Integer, Integer> datas) {

        nums.forEach(num -> {
           // System.out.println(num);
            num.forEach(s -> {
                if (datas.get(s) == null) {
                    datas.put((Integer) s, 1);
                } else {
                    datas.put((Integer) s, datas.get(s) + 1);
                }

            });
        });
        System.out.println(datas);
    }


    private static void containsCheck(List<Set> nums,  Map<Integer, Integer> datas, int num ) {
        nums.get(num).forEach(i -> {
            datas.put((Integer) i,1);
            for (int i1 = num+1; i1 < nums.size(); i1++) {
                if(nums.get(i1).remove(i)){
                    datas.put((Integer) i, datas.get(i) + 1);
                }

            }
        });



    }

}
