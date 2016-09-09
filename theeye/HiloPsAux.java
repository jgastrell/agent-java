import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.io.*;

// CORREGIR ESTE HILO, TIENE QUE PARSEAR /PROC/MEMINFO
public class HiloPsAux implements Runnable{

  public void parseoPsAux(){
    synchronized(Agente.lock){
      if(Agente.hayTarea == true){
          try{
            System.out.println("hiloPsAux, bloqueada, hay tarea del supervisor, punto de log");
            Agente.lock.wait();
          } catch (Exception e){
            e.printStackTrace();
          }
      }
      try{
        File archivo = new File("log.txt");
        FileWriter arch = new FileWriter(archivo,false);
        String line;
        Process p = Runtime.getRuntime().exec("ps aux");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
          arch.write(line);
          //System.out.println(line); //<-- Parse data here.
        }
        input.close();
        System.out.println("hiloPsAux, en ejecucion, sin tarea del supervisor, punto de log");
        Agente.lock.notifyAll();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
  }
  public void run(){
    while(true){
      parseoPsAux();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException err) {
        err.printStackTrace();
      }
    }
  }

}
