package webscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import jdk.jshell.spi.ExecutionControl;

public class Tester {

    public static List<TagCounter> runSequental() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }

    public static List<TagCounter> runParrallel() throws NotImplementedException, InterruptedException, ExecutionException {
        
         ExecutorService executor = Executors.newCachedThreadPool();
       List<Future<String>> futures = new ArrayList<>();
       
         List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
       
    for(TagCounter tc : urls){
      Future future = executor.submit(new PingURL(tc));
      futures.add(future);
    }
    
    for(Future<String> future : futures){
      future.get();
  
    }
    
        return urls;
       
    }

    
    
public static class PingURL implements Callable<TagCounter> {
  TagCounter tc;
 public PingURL(TagCounter tc) {
    this.tc = tc;
  }
  
  @Override
  public TagCounter call() throws Exception {
      tc.doWork();
    return tc;
      
  }
}
  
    public static void main(String[] args) throws Exception {
        long timeSequental;
        long start = System.nanoTime();

        List<TagCounter> fetchedData = new Tester().runSequental();
        long end = System.nanoTime();
        timeSequental = end - start;
        System.out.println("Time Sequential: " + ((timeSequental) / 1_000_000) + " ms.");

        for (TagCounter tc : fetchedData) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
        }

        /*
        
        start = System.nanoTime();
        //TODO Add your parrallel calculation here     
        long timeParallel = System.nanoTime() - start;
        System.out.println("Time Parallel: " + ((timeParallel) / 1_000_000) + " ms.");
        System.out.println("Paralle was " + timeSequental / timeParallel + " times faster");
       
         */
    }
}
