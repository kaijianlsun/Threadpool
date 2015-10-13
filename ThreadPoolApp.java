package Threadpool.Threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolApp{
    public static void main (String [] args){
        if (args.length<2)
            ThreadPoolApp.error();
        try{
            int numberJobs = Integer.parseInt(args[0]); //job numbers
            int numberThreads= Integer.parseInt(args[1]); //thread numbers
            if ((numberJobs <1 || numberThreads <1))
                ThreadPoolApp.error();
            ExecutorService pool = Executors.newFixedThreadPool(numberThreads);
            Job [] jobs = new Job[numberJobs];
            for(int i=0; i<numberJobs; i++){
                jobs[i] = new Job(i);
                pool.execute(jobs[i]);
            }
            pool.shutdown();
            System.out.println ("Last line " + Thread.currentThread().getName());
        }catch (NumberFormatException e){
            ThreadPoolApp.error();}
    }

    private static void error(){

        System.out.println("ThreadPoolApp must be run with two positive valued " + 
            " integer arguments. The first detailing the number of jobs " +
            " the second the number of processing threads in the pool");
        System.exit(0); // exit program
    }
}
