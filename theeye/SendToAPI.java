import java.lang.Thread;
import java.util.Date;
import java.text.*;
import java.io.*;

public class SendToAPI extends Thread {
  public SendToAPI(String SensorLoc) throws InterruptedException
  {

 	R r = new R(SensorLoc);


  Thread t = new Thread(r);
  t.setDaemon(true);
  t.start();
	System.out.println(SensorLoc + "--> Done in thread");
  }


}

class R implements Runnable{
  public String myData;

  public R (String SendData){
    myData = SendData;
  }
  public void run(){
    try {
  String mystatus = HttpRequest.sendPost();
  System.out.println(mystatus);
} catch (Exception e){}
	}
}
