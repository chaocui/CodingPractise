package leetcode.Pinterest;

import java.util.*;

/**
 * Created by cc on 2017/7/3.
 */
public class DesignInMemoryFileSystem {

    /***
     *  Pretty simple idea,
     *  Create a Object Directory,
     *  it has two hash maps.
     *  1. Directory, hold dir name and Directories.
     *  2. File, hold file name and file content.
     */
    public class Directory{
        Map<String, Directory> dirs;
        Map<String, String> files;
        public Directory(){
            dirs = new HashMap<>();
            files = new HashMap<>();
        }
    }

    Directory root;
    public DesignInMemoryFileSystem() {
        root = new Directory();
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if(path.length() == 1) {
            result.addAll(root.dirs.keySet());
            result.addAll(root.files.keySet());
            Collections.sort(result);
            return result;
        }
        String[] sl = path.split("/");
        Directory dir = root;
        for(int i = 1; i < sl.length - 1; i++)
            dir = dir.dirs.get(sl[i]);
        String last = sl[sl.length-1];
        //dir
        if(path.charAt(path.length()-1) == '/' || dir.dirs.containsKey(last)) {
            dir = dir.dirs.get(last);
            result.addAll(dir.files.keySet());
            result.addAll(dir.dirs.keySet());
        }
        else
            result.add(last);
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        Directory dir = root;
        String[] sl = path.split("/");
        for(int i = 1; i < sl.length; i++){
            if(!dir.dirs.containsKey(sl[i]))
                dir.dirs.put(sl[i], new Directory());
            dir = dir.dirs.get(sl[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Directory dir = root;
        String[] sl = filePath.split("/");
        for(int i = 1; i < sl.length - 1; i++)
            dir = dir.dirs.get(sl[i]);
        String fileName = sl[sl.length-1];
        if(!dir.files.containsKey(fileName))
            dir.files.put(fileName, "");
        dir.files.put(fileName, dir.files.get(fileName) + content);
    }

    public String readContentFromFile(String filePath) {
        Directory dir = root;
        String[] sl = filePath.split("/");
        for(int i = 1; i < sl.length - 1; i++)
            dir = dir.dirs.get(sl[i]);
        String fileName = sl[sl.length-1];
        return dir.files.get(fileName);
    }

    public static void main(String[] args) {
        DesignInMemoryFileSystem simfs = new DesignInMemoryFileSystem();
        System.out.println(simfs.ls("/"));
        simfs.mkdir("/a/b/c");
        System.out.println(simfs.ls("/a/b"));
        simfs.addContentToFile("/a/b/c/d", "hello");
        System.out.println(simfs.ls("/"));
        System.out.println(simfs.readContentFromFile("/a/b/c/d"));
    }

}
