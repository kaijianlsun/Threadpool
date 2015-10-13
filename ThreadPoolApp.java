package Threadpool.Threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
/**
 * Returns an Image object that can then be painted on the screen. 
 * The url argument must specify an absolute {@link URL}. The name
 * argument is a specifier that is relative to the url argument. 
 * <p>
 * This method always returns immediately, whether or not the 
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives 
 * that draw the image will incrementally paint on the screen. 
 * @see         Job
 */
public class ThreadPoolApp{
    /**
 * sdfsdfsdf
 *
 * @param  args  an absolute URL giving the base location of the image
 * @return      the image at the specified URL

 */
    public static void main (String [] args){
        if (args.length<2)
            ThreadPoolApp.error();
        try{
            int numberJobs = Integer.parseInt(args[0]); //job numbers
            int numberThreads= Integer.parseInt(args[1]); //thread numbers
            if ((numberJobs <1 || numberThreads <1))
                ThreadPoolApp.error();
            ExecutorService pool = Executors.newFixedThreadPool(numberThreads); //Threads Pool
            Job [] jobs = new Job[numberJobs]; 
            for(int i=0; i<numberJobs; i++){
                jobs[i] = new Job(i);
                pool.execute(jobs[i]); //sdfsdfsdf
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
