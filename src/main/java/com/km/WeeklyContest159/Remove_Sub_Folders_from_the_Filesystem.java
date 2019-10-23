package com.km.WeeklyContest159;

import java.util.*;

public class Remove_Sub_Folders_from_the_Filesystem {
    class TreeNode {
        String foldname;
        boolean isEnd;
        Map<String, TreeNode> child = new HashMap<>();

        public TreeNode(String foldname, boolean isEnd) {
            this.foldname = foldname;
            this.isEnd = isEnd;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        if (folder.length == 1)
            return Arrays.asList(folder);
        List<String> ans = new ArrayList<>();
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String s : folder) {
            int count = calCount(s);
            List<String> list = map.getOrDefault(count, new ArrayList<>());
            list.add(s);
            map.put(count, list);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        List<String> sortfolder = new ArrayList<>();
        while (iterator.hasNext())
            sortfolder.addAll(map.get(iterator.next()));
        TreeNode root = new TreeNode("", false);
        for (String s : sortfolder) {
            String[] folds = s.split("/");
            TreeNode temp = root;
            for (int i = 1; i < folds.length; i++) {
                if (temp.child != null && temp.child.containsKey(folds[i])) {
                    temp = temp.child.get(folds[i]);
                    if(temp.isEnd)
                        break;
                } else {
                    buildTree(folds, i, temp);
                    ans.add(s);
                    break;
                }
            }
        }
        return ans;
    }

    private void buildTree(String[] folds, int start, TreeNode temp) {
        if(temp.child==null) temp.child = new HashMap<>();
        for(int i = start;i<folds.length;i++){
            if(i!=folds.length-1) {
                temp.child.put(folds[i], new TreeNode(folds[i], false));
                temp = temp.child.get(folds[i]);
            }
            else
                temp.child.put(folds[i],new TreeNode(folds[i],true));
        }
    }

    private int calCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Remove_Sub_Folders_from_the_Filesystem test = new Remove_Sub_Folders_from_the_Filesystem();
        String[] s = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(test.removeSubfolders(s));
    }
}
