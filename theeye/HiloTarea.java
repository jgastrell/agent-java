import java.lang.Thread;
public class HiloTarea implements Runnable{

  public void ejecutarTarea(){
    synchronized(Agente.lock){
      if(Agente.hayTarea == false){
        try{
          System.out.println("hiloTarea, bloqeado, no hay tarea, punto de log");
          Agente.lock.wait();
        } catch(InterruptedException ie) {
          ie.printStackTrace();
        }
      } else {
      System.out.println("hiloTarea, en ejecucion, hay tarea, punto de log");
      /*
      aca tengo que poner la tarea q me mandan a realizar
      */
      Agente.lock.notifyAll();
      }
    }
  }
  public void run(){
    while(true){
      ejecutarTarea();
    }
  }
}
