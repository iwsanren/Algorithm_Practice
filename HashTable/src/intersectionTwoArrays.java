import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class intersectionTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> hashSet1 = new HashSet<Integer>();
        Set<Integer> hashRes = new HashSet<Integer>();
        //将nums1中的元素加入hashSet1
        for(int i : nums1){
            hashSet1.add(i);
        }
        //判断hashSet1中有没有nums2
        for (int i : nums2) {
            if(hashSet1.contains(i)){
                hashRes.add(i);
            }
        }
        //return hashRes.stream().mapToInt(x -> x).toArray();
        int[] arr = new int[hashRes.size()];
        int j = 0;
        for(int i : hashRes){
            arr[j++] = i;
        }
        return arr;
    }
//    public static int[] intersection1(int[] nums1, int[] nums2) {
////        int[] hashArr = new int[1005];
//////        int[] hashArr2 = new int[1005];
////        List<Integer> resList = new ArrayList<>();
////
////        for(int i : nums1){
////            hashArr[i]++;
////        }
////        for(int i : nums2){
////            if(hashArr[i] != 0){
////                resList.add(i);
////            }
////        }
////        return resList.stream().mapToInt(x -> x).toArray();
//
//    }
}

class intersectionTwoArraysTest{
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,4,4,6};
        int[] arr2 = {2,2,4,4,6,6};
        int[] res  = intersectionTwoArrays.intersection(arr1,arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

}
/*
Set API
1.size();
2.add(int);
3.contains()
4.将结果集合转为数组:
    (1)resSet.stream().mapToInt(x -> x).toArray();
    (2)另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }


 */