public class Agente {

  static final Object lock = new Object();
  static boolean hayTarea = false;

  public static void main(String[] args) {
    HiloPsAux hiloPsAux = new HiloPsAux();
    HiloTarea hiloTarea = new HiloTarea();
    Thread threadPsAux = new Thread(hiloPsAux);
    Thread threadTarea = new Thread(hiloTarea);
    HiloHttpRequest hiloHttpRequest = new HiloHttpRequest();
    Thread threadHttpRequest = new Thread(hiloHttpRequest);
    threadHttpRequest.start();
    

    threadPsAux.start();
    threadTarea.start();

        //SendToAPI AnAPI = new SendToAPI("Yes!Test=" + i);

    }
}
