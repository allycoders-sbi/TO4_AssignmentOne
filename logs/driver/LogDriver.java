package logs.driver;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;

import logs.model.LogWriter;

class LogDriver {
    public static void main(String[] args) {
        System.out.println("LogSystemsUsingArrayList");

        MyFrame m1 = new MyFrame("List Cabs Service",400,500,100,200,25,75);
        MyFrame m2 = new MyFrame("Book Cab Service",400,500,800,200,750,2000);
        MyFrame m3 = new MyFrame("Track Cab Service",400,500,1400,200,2001,10000);

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);

        t1.start();
        t2.start();
        t3.start();

        try{
        t1.join();
        t2.join();
        t3.join();
        }
        catch(InterruptedException e){
            System.out.println("microServices are down!!");
        }

        m1.lw.dumpLog();
        m2.lw.dumpLog();
        m3.lw.dumpLog();

    }
}

class MyFrame extends JFrame implements Runnable{
    JTextField jtf1 = new JTextField(200);
    int fromWhere,toWhere;String microServiceName;
    LogWriter lw = new LogWriter();

    public MyFrame(String title,int h,int w,int x,int y,int from,int to)
    {
        this.microServiceName = title;
        this.setTitle(title);
        this.setVisible(true);
        this.setSize(w,h);
        this.setLocation(x,y);
        jtf1.setFont(new Font("Times New Roman",1,22));
        this.add(jtf1);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.fromWhere = from;
        this.toWhere = to;
    }

    @Override
    public void run() {
        for(int i=fromWhere;i<=toWhere;i++){
            //System.out.println(microServiceName + " running....and C="+i);
            jtf1.setText(microServiceName + " is running");

            if(isPrime(i)){
                if(isEven(i)){
                    lw.log(microServiceName+" WAS PRIME AND EVEN", 1, "Warning");
                }
                else{
                    lw.log(microServiceName+" WAS PRIME AND ODD", 1, "Info");
                }
            }
            else {
                if(isEven(i)){
                    lw.log(microServiceName+" WAS NON-PRIME AND EVEN", 1, "Debug");
                }
                else{
                    lw.log(microServiceName+" WAS NON-PRIME AND ODD", 1, "Error");
                }
            }

        }
        
    }

    private boolean isEven(int i){
        return (i%2==0)?true:false;
    }

    private boolean isPrime(int theNum)
    {
       for(int i=2;i<theNum/2;i++)
       {
           if((theNum%i)==0)
               return  false;
       }
       return true;
    }
}