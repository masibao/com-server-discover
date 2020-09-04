package com.mayi.user;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 17:37 2020/2/5
 */
public class So {
    public static List<Integer> spiralOrder(int[][] matrix) {
//在入口处判断是否传来的是空数组。
        if(matrix==null||matrix.length==0) {
            return new ArrayList<>();
        }
        int hang=matrix.length,lie=matrix[0].length; //行和列的大小
        int Max=lie*hang; //数组的最大值
        ArrayList<Integer>numbers= new ArrayList<>(Max);
        int count=0;//记录个数
        for(int i=0;count!=Max;i++) {//i是记录层数
            for(int j=i;j<lie-i-1&&count!=Max;j++,count++) {//顶部
                numbers.add(matrix[i][j]);
            }
            for(int j=i;j<hang-i-1&&count!=Max;j++,count++) {//右
                numbers.add(matrix[j][lie-i-1]);
            }
            for(int j=lie-1-i;j>i&&count!=Max;j--,count++) {//下
                numbers.add(matrix[hang-i-1][j]);
            }
            for(int j=hang-1-i;j>i&&count!=Max;j--,count++) {//左
                numbers.add(matrix[j][i]);
            }
            if(count==Max-1) {//对3×3，5×5，7×7，这种特殊处理，这种的中间无法被上面四个点
                //捕获到，所以我们单独拿出来判断/
                if(hang==lie&&hang%2==1) {
                    numbers.add(Max-1,matrix[hang/2][hang/2]);
                    count++;
                }
            }
        }
        return numbers ;
    }
}
