package jianzhioffer;


import jianzhioffer.utils.TreeNode;

import java.util.ArrayList;

// 二叉树的序列化与反序列化

public class Solution37 {

    String Serialize(TreeNode root) {
        //前序遍历进行序列化
        //1-结果值存入stringbuilder中，用，间隔
        StringBuilder sb=new StringBuilder();
        if (root==null){
            sb.append("#,");
            return sb.toString();
        }
            sb.append(root.val+",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));

        return sb.toString();
    }


    int index=-1;
    //反序列化
    TreeNode Deserialize(String str) {
        index++;
        String[] string=str.split(",");
        TreeNode node=null;
        if (!string[index].equals("#")){
            node=new TreeNode(Integer.valueOf(string[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }
}

