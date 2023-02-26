    public class MyThread extends Thread {
        private boolean shouldExit = false;

        public void setShouldExit(boolean shouldExit) {
            this.shouldExit = shouldExit;
        }

        Biblioteca biblioteca = Biblioteca.getInstance();

        @Override
        public void run() {
            while (!shouldExit) {
                biblioteca.afisareCartiDisponibile();
                try {
                    Thread.sleep(120000); 
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }
}
